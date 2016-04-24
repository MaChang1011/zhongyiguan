package com.zyt.base.shiro;

import com.zyt.base.BaseAction;
import com.zyt.cons.UserType;
import com.zyt.entity.system.UserEntity;
import com.zyt.kits.StrKit;
import com.zyt.service.system.IUserManager;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Author: @author ljw . <br>
 * Date: 2015-9-9 下午8:19:36 . <br>
 * Function: shiro验证
 */
public class MyRealm extends AuthorizingRealm {
  @Autowired
  private IUserManager userManager;

  /*
   * (non-Javadoc)
   *
   * @see
   * org.apache.shiro.realm.AuthenticatingRealm#doGetAuthenticationInfo(org
   * .apache.shiro.authc.AuthenticationToken)
   */
  @Override
  protected AuthenticationInfo doGetAuthenticationInfo(
          AuthenticationToken authcToken) throws AuthenticationException {
    UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
    String username = token.getUsername();
    String password = new String(token.getPassword());
    if (StrKit.isBlank(username, password)) {
      // 用户名密码不能为空
      throw new AuthenticationException("用户名或密码不能为空");
    }
    UserEntity entity = new UserEntity();
    entity.setNickname(username);
    entity.setPassword(password);
    UserEntity user = userManager.findUserLogin(entity);
    if (null == user) {
      // 用户名或密码错误
      throw new UnknownAccountException("用户名或密码错误");
    }
    if (user.getType() != UserType.ADMIN.getType()) {
      throw new UnknownAccountException("非管理员用户无法登陆");
    }
    SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(
            user.getNickname(), user.getPassword(), getName());
    Subject subject = SecurityUtils.getSubject();
    subject.getSession().setAttribute(BaseAction.USER, user);
    return info;
  }

  /*
   * (non-Javadoc)
   *
   * @see
   * org.apache.shiro.realm.AuthorizingRealm#doGetAuthorizationInfo(org.apache
   * .shiro.subject.PrincipalCollection)
   */
  @Override
  protected AuthorizationInfo doGetAuthorizationInfo(
          PrincipalCollection principal) {
    // 权限验证
    return null;
  }
}

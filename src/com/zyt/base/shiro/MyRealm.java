package com.zyt.base.shiro;

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
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

public class MyRealm
  extends AuthorizingRealm
{
  @Autowired
  private IUserManager userManager;
  
  protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken)
    throws AuthenticationException
  {
    UsernamePasswordToken token = (UsernamePasswordToken)authcToken;
    String username = token.getUsername();
    String password = new String(token.getPassword());
    if (StrKit.isBlank(username, new String[] { password })) {
      throw new AuthenticationException("�û��������벻��Ϊ��");
    }
    UserEntity entity = new UserEntity();
    entity.setNickname(username);
    entity.setPassword(password);
    UserEntity user = this.userManager.findUserLogin(entity);
    if (user == null) {
      throw new UnknownAccountException("�û������������");
    }
    if (user.getType() != UserType.ADMIN.getType()) {
      throw new UnknownAccountException("�ǹ����û��޷���½");
    }
    SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(
      user.getNickname(), user.getPassword(), getName());
    Subject subject = SecurityUtils.getSubject();
    subject.getSession().setAttribute("user", user);
    return info;
  }
  
  protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal)
  {
    return null;
  }
}

package com.zyt.service.system.impl;

import com.google.common.collect.Maps;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import com.zyt.base.ApiResult;
import com.zyt.base.PageQuery;
import com.zyt.cons.ApiStatus;
import com.zyt.cons.UserType;
import com.zyt.dao.system.IUserMapper;
import com.zyt.entity.system.UserEntity;
import com.zyt.kits.CollectionKit;
import com.zyt.kits.MD5Kit;
import com.zyt.kits.StrKit;
import com.zyt.service.chat.IChatManager;
import com.zyt.service.system.IUserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
class UserManagerImpl
  implements IUserManager
{
  @Autowired
  private IUserMapper userMapper;
  @Autowired
  private IChatManager chatManager;
  
  public ApiResult authUser(UserEntity user)
  {
    ApiResult apiResult = new ApiResult(ApiStatus.FAILED);
    UserEntity result = findUserLogin(user);
    if (result == null)
    {
      apiResult.setMsg("账号或密码错误");
      return apiResult;
    }
    if (result.getType() == UserType.ADMIN.getType())
    {
      apiResult.setMsg("管理员账户无法登陆");
      return apiResult;
    }
    apiResult.setResult(result.getId());
    apiResult.setMsg("登陆成功");
    return apiResult;
  }
  
  public ApiResult changePsw(String userid, String oldPwd, String newPwd)
  {
    ApiResult apiResult = new ApiResult();
    Map<String, Object> params = Maps.newHashMap();
    params.put("id", userid);
    params.put("oldPwd", MD5Kit.encrypt(oldPwd));
    params.put("newPwd", MD5Kit.encrypt(newPwd));
    if (this.userMapper.updatePwd(params) == 1)
    {
      apiResult.setResult(ApiStatus.SUCCESS);
      apiResult.setMsg("密码修改成功");
    }
    else
    {
      apiResult.setResult(ApiStatus.FAILED);
      apiResult.setMsg("旧密码错误");
    }
    return apiResult;
  }
  
  public void delete(String id) {}
  
  public List<UserEntity> findByCond(Map<String, Object> cond)
  {
    return this.userMapper.findByCond(cond);
  }
  
  public UserEntity findById(String id)
  {
    return (UserEntity)this.userMapper.findById(id);
  }
  
  public UserEntity findOneByCond(Map<String, Object> cond)
  {
    List<UserEntity> list = findByCond(cond);
    return CollectionKit.isNull(list) ? null : (UserEntity)list.get(0);
  }
  
  public PageQuery<UserEntity> findPage(PageQuery<UserEntity> page)
  {
    page.setList(this.userMapper.findAll(page.getCondition()));
    page.setTotal(this.userMapper.findAllCount(page.getCondition()));
    
    int size = (int)Math.ceil(page.getTotal() * 1.0F / page.getLimit());
    page.setSize(size);
    return page;
  }
  
  public UserEntity findUserLogin(UserEntity entity)
  {
    List<UserEntity> users = this.userMapper.findUserLogin(entity);
    return (users != null) && (users.size() > 0) ? (UserEntity)users.get(0) : null;
  }
  
  public int improve(UserEntity user)
  {
    return this.userMapper.update(user) > 0 ? ApiStatus.SUCCESS : 
      ApiStatus.FAILED;
  }
  
  public int saveOrUpdate(UserEntity entity)
  {
    if (entity.getId() > 0) {
      return this.userMapper.update(entity);
    }
    this.userMapper.save(entity);
    return entity.getId();
  }
  
  public ApiResult saveRegister(UserEntity entity)
  {
    ApiResult apiResult = new ApiResult();
    Map<String, Object> cond = Maps.newHashMap();
    cond.put("mobile", entity.getMobile());
    List<UserEntity> users = this.userMapper.findByCond(cond);
    if (!CollectionKit.isNull(users))
    {
      apiResult.setResult(ApiStatus.FAILED);
      apiResult.setMsg("手机号已存在");
      return apiResult;
    }
    entity.setPassword(MD5Kit.encrypt(entity.getPassword()));
    
    entity.setRegtime(new Timestamp(System.currentTimeMillis()));
    this.userMapper.save(entity);
    
    ApiResult result = this.chatManager.register(String.valueOf(entity.getId()), 
      entity.getMobile(), entity.getNickname());
    if (result.getResult() == ApiStatus.FAILED) {
      return result;
    }
    apiResult.setResult(entity.getId());
    apiResult.setMsg("注册成功");
    return apiResult;
  }
  
  public ApiResult update(UserEntity entity)
  {
    ApiResult apiResult = new ApiResult(ApiStatus.FAILED, "操作失败");
    if (this.userMapper.update(entity) > 0)
    {
      if (!StrKit.isBlank(entity.getNickname())) {
        this.chatManager.modifyNickname(String.valueOf(entity.getId()), 
          entity.getNickname());
      }
      this.userMapper.update(entity);
      apiResult.setResult(ApiStatus.SUCCESS);
      apiResult.setMsg("操作");
    }
    return apiResult;
  }
}

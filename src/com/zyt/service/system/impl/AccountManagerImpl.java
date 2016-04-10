package com.zyt.service.system.impl;

import com.google.common.collect.Maps;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import com.zyt.base.ApiResult;
import com.zyt.cons.ApiStatus;
import com.zyt.dao.system.IAccountMapper;
import com.zyt.entity.system.AccountEntity;
import com.zyt.entity.system.UserEntity;
import com.zyt.kits.CollectionKit;
import com.zyt.service.chat.IChatManager;
import com.zyt.service.system.IAccountManager;
import com.zyt.service.system.IUserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
class AccountManagerImpl
  implements IAccountManager
{
  @Autowired
  private IAccountMapper accountMapper;
  @Autowired
  private IUserManager userManager;
  @Autowired
  private IChatManager chatManager;
  
  public ApiResult checkAccount(String uid)
  {
    ApiResult apiResult = new ApiResult();
    List<String> list = this.accountMapper.findUserByUid(uid);
    if (CollectionKit.isNull(list))
    {
      apiResult.setResult(ApiStatus.SUCCESS);
      apiResult.setMsg("该用户未绑定手机");
    }
    else
    {
      apiResult.setResult(Integer.parseInt((String)list.get(0)));
      apiResult.setMsg("账户已经绑定手机");
    }
    return apiResult;
  }
  
  public ApiResult saveAccount(AccountEntity entity)
  {
    ApiResult apiResult = new ApiResult();
    Map<String, Object> cond = Maps.newHashMap();
    
    cond.put("mobile", entity.getMobile());
    if (this.userManager.findOneByCond(cond) != null)
    {
      apiResult.setResult(ApiStatus.FAILED);
      apiResult.setMsg("该手机号已经被占用");
      return apiResult;
    }
    this.accountMapper.saveAccount(entity);
    
    UserEntity user = new UserEntity();
    user.setNickname(entity.getNickname());
    user.setMobile(entity.getMobile());
    user.setType(entity.getType());
    user.setRegtime(new Timestamp(System.currentTimeMillis()));
    int userid = this.userManager.saveOrUpdate(user);
    
    UserEntity ue = this.userManager.findOneByCond(cond);
    ApiResult result = this.chatManager.register(String.valueOf(ue.getId()), 
      entity.getMobile(), entity.getNickname());
    if (result.getResult() == ApiStatus.FAILED) {
      return result;
    }
    apiResult.setResult(userid);
    apiResult.setMsg("手机号 ");
    return apiResult;
  }
}

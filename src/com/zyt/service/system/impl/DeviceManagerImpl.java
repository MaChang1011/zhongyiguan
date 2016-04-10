package com.zyt.service.system.impl;

import java.util.List;
import java.util.Map;
import com.zyt.base.ApiResult;
import com.zyt.cons.ApiStatus;
import com.zyt.dao.system.IDeviceTokenMapper;
import com.zyt.entity.system.DeviceTokenEntity;
import com.zyt.kits.ApnsKit;
import com.zyt.kits.CollectionKit;
import com.zyt.kits.StrKit;
import com.zyt.service.system.IDeviceTokenManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
class DeviceManagerImpl
  implements IDeviceTokenManager
{
  @Autowired
  private IDeviceTokenMapper deviceTokenMapper;
  
  public DeviceTokenEntity findByDeviceToken(String deviceToken)
  {
    return this.deviceTokenMapper.findByDeviceToken(deviceToken);
  }
  
  public void push(final String content, final Map<String, Object> params)
  {
    int total = this.deviceTokenMapper.findAllCount();
    final int page = (int)Math.ceil(total * 1.0F / 50.0F);
    final ApnsKit apsnKit = ApnsKit.getInstance();
    
    new Thread(new Runnable()
    {
      public void run()
      {
        for (int start = 0; start < page; start++)
        {
          List<String> deviceTokens = DeviceManagerImpl.this.deviceTokenMapper
            .findAll(start);
          if (!CollectionKit.isNull(deviceTokens)) {
            for (String deviceToken : deviceTokens) {
              apsnKit.push(deviceToken, content, params);
            }
          }
        }
      }
    })
    
      .start();
  }
  
  public ApiResult save(DeviceTokenEntity entity)
  {
    ApiResult apiResult = new ApiResult(ApiStatus.FAILED);
    if (StrKit.isBlank(entity.getDeviceToken()))
    {
      apiResult.setMsg("设备号不能为空");
      return apiResult;
    }
    if (this.deviceTokenMapper
      .findByDeviceToken(entity.getDeviceToken()) == null)
    {
      this.deviceTokenMapper.save(entity);
      apiResult.setResult(ApiStatus.SUCCESS);
      apiResult.setMsg("操作成功");
    }
    else
    {
      this.deviceTokenMapper.update(entity);
      apiResult.setResult(ApiStatus.SUCCESS);
      apiResult.setMsg("更新成功");
    }
    return apiResult;
  }
}

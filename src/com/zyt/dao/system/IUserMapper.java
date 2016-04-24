package com.zyt.dao.system;

import java.util.List;
import java.util.Map;
import com.zyt.base.IBaseMapper;
import com.zyt.entity.doctor.DoctorEntity;
import com.zyt.entity.system.UserEntity;


public abstract interface IUserMapper
  extends IBaseMapper<UserEntity>
{
  public abstract List<UserEntity> findUserLogin(UserEntity paramUserEntity);
  
  public abstract int updatePwd(Map<String, Object> paramMap);
  
  public abstract List<String> findPatientsId(int paramInt);
  
  public abstract int findPatientsIdCount();
  
  public abstract void updateDevice(String paramString);

  /**
   * @Title : findDoctorCheck
   * @Description : 检查是否审核
   */
  List<DoctorEntity> findDoctorCheck(String mobile);
}
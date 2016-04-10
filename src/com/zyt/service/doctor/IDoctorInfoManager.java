package com.zyt.service.doctor;

import com.zyt.entity.doctor.DoctorInfoEntity;

public abstract interface IDoctorInfoManager
{
  public abstract void saveOrUpdate(DoctorInfoEntity paramDoctorInfoEntity);
}

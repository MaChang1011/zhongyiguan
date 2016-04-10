package com.zyt.dao.doctor;

import com.zyt.entity.doctor.DoctorInfoEntity;

public abstract interface IDoctorInfoMapper
{
  public abstract int findInfo(int paramInt);
  
  public abstract void save(DoctorInfoEntity paramDoctorInfoEntity);
  
  public abstract void update(DoctorInfoEntity paramDoctorInfoEntity);
}
package com.zyt.service.doctor.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.zyt.dao.doctor.IDoctorInfoMapper;
import com.zyt.entity.doctor.DoctorInfoEntity;
import com.zyt.service.doctor.IDoctorInfoManager;

@Service
@Transactional
class DoctorInfoManagerImpl
  implements IDoctorInfoManager
{
  @Autowired
  private IDoctorInfoMapper mapper;
  
  public void saveOrUpdate(DoctorInfoEntity entity)
  {
    if (this.mapper.findInfo(entity.getDoctorId()) > 0) {
      this.mapper.update(entity);
    } else {
      this.mapper.save(entity);
    }
  }
}

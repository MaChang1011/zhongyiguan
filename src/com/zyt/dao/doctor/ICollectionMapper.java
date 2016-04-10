package com.zyt.dao.doctor;

import java.util.List;
import java.util.Map;

import com.zyt.bo.company.MessageBo;
import com.zyt.bo.company.ProductBo;
import com.zyt.bo.doctor.DoctorBo;
import com.zyt.entity.doctor.CollectionEntity;


public abstract interface ICollectionMapper
{
  public abstract int delete(int paramInt);
  
  public abstract int deleteByUnionKey(CollectionEntity paramCollectionEntity);
  
  public abstract int findByUnionKey(CollectionEntity paramCollectionEntity);
  
  public abstract void save(CollectionEntity paramCollectionEntity);
  
  public abstract List<DoctorBo> findDoctorPage(Map<String, Object> paramMap);
  
  public abstract int findDoctorPageCount(Map<String, Object> paramMap);
  
  public abstract List<MessageBo> findMessagePage(Map<String, Object> paramMap);
  
  public abstract int findMessagePageCount(Map<String, Object> paramMap);
  
  public abstract List<ProductBo> findProductPage(Map<String, Object> paramMap);
  
  public abstract int findProductPageCount(Map<String, Object> paramMap);
}
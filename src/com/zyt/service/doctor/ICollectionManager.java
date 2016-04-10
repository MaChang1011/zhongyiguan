package com.zyt.service.doctor;

import com.zyt.base.ApiResult;
import com.zyt.base.PageQuery;
import com.zyt.bo.company.MessageBo;
import com.zyt.bo.company.ProductBo;
import com.zyt.bo.doctor.DoctorBo;
import com.zyt.entity.doctor.CollectionEntity;

public abstract interface ICollectionManager
{
  public abstract ApiResult save(CollectionEntity paramCollectionEntity);
  
  public abstract ApiResult delete(int paramInt);
  
  public abstract ApiResult deleteByUnionKey(CollectionEntity paramCollectionEntity);
  
  public abstract PageQuery<ProductBo> findProductPage(PageQuery<ProductBo> paramPageQuery);
  
  public abstract PageQuery<MessageBo> findMessagePage(PageQuery<MessageBo> paramPageQuery);
  
  public abstract PageQuery<DoctorBo> findDoctorPage(PageQuery<DoctorBo> paramPageQuery);
}

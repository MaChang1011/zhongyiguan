package com.zyt.service.doctor;

import com.zyt.base.PageQuery;
import com.zyt.entity.doctor.AnswerEntity;

public abstract interface IAnswerManager
{
  public abstract int save(AnswerEntity paramAnswerEntity);
  
  public abstract PageQuery<AnswerEntity> findPage(PageQuery<AnswerEntity> paramPageQuery);
}

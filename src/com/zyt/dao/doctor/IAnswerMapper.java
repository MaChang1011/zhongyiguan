package com.zyt.dao.doctor;

import java.util.List;
import java.util.Map;
import com.zyt.entity.doctor.AnswerEntity;


public abstract interface IAnswerMapper
{
  public abstract void save(AnswerEntity paramAnswerEntity);
  
  public abstract int findPageCount(Map<String, Object> paramMap);
  
  public abstract List<AnswerEntity> findPage(Map<String, Object> paramMap);
}

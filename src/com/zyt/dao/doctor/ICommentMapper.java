package com.zyt.dao.doctor;

import java.util.List;
import java.util.Map;

import com.zyt.bo.doctor.CommentBo;
import com.zyt.entity.doctor.CommentEntity;


public abstract interface ICommentMapper
{
  public abstract void save(CommentEntity paramCommentEntity);
  
  public abstract int findPageCount(Map<String, Object> paramMap);
  
  public abstract List<CommentBo> findPage(Map<String, Object> paramMap);
}

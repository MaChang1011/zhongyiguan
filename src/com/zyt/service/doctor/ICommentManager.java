package com.zyt.service.doctor;

import com.zyt.base.ApiResult;
import com.zyt.base.PageQuery;
import com.zyt.bo.doctor.CommentBo;
import com.zyt.entity.doctor.CommentEntity;

public abstract interface ICommentManager
{
  public abstract ApiResult save(CommentEntity paramCommentEntity);
  
  public abstract PageQuery<CommentBo> findPage(PageQuery<CommentBo> paramPageQuery);
}

package com.zyt.service.doctor.impl;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zyt.base.ApiResult;
import com.zyt.base.PageQuery;
import com.zyt.bo.doctor.CommentBo;
import com.zyt.dao.doctor.ICommentMapper;
import com.zyt.dao.system.IUserMapper;
import com.zyt.entity.doctor.CommentEntity;
import com.zyt.entity.system.UserEntity;
import com.zyt.service.doctor.ICommentManager;

@Service
@Transactional
class CommentManagerImpl
  implements ICommentManager
{
  @Autowired
  private ICommentMapper commentMapper;
  @Autowired
  private IUserMapper userMapper;
  
  public PageQuery<CommentBo> findPage(PageQuery<CommentBo> page)
  {
    UserEntity userEntity = (UserEntity)this.userMapper.findById(String.valueOf(page
      .getCondition().get("userId")));
    if (userEntity == null) {
      return page;
    }
    Map<String, Object> condition = page.getCondition();
    condition.put("type", Integer.valueOf(userEntity.getType()));
    List<CommentBo> list = this.commentMapper.findPage(condition);
    page.setList(list);
    page.setTotal(this.commentMapper.findPageCount(condition));
    
    int size = (int)Math.ceil(page.getTotal() * 1.0F / page.getLimit());
    page.setSize(size);
    return page;
  }
  
  public ApiResult save(CommentEntity entity)
  {
    ApiResult apiResult = new ApiResult();
    entity.setCreateTime(new Timestamp(System.currentTimeMillis()));
    this.commentMapper.save(entity);
    apiResult.setResult(entity.getId());
    apiResult.setMsg("评论成功");
    return apiResult;
  }
}

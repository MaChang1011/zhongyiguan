package com.zyt.service.doctor.impl;

import java.util.List;
import java.util.Map;
import com.zyt.base.PageQuery;
import com.zyt.dao.doctor.IAnswerMapper;
import com.zyt.entity.doctor.AnswerEntity;
import com.zyt.service.doctor.IAnswerManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
class AnswerManagerImpl
  implements IAnswerManager
{
  @Autowired
  private IAnswerMapper answerMapper;
  
  public PageQuery<AnswerEntity> findPage(PageQuery<AnswerEntity> page)
  {
    Map<String, Object> condition = page.getCondition();
    List<AnswerEntity> list = this.answerMapper.findPage(condition);
    page.setList(list);
    page.setTotal(this.answerMapper.findPageCount(condition));
    
    int size = (int)Math.ceil(page.getTotal() * 1.0F / page.getLimit());
    page.setSize(size);
    return page;
  }
  
  public int save(AnswerEntity entity)
  {
    this.answerMapper.save(entity);
    return entity.getId();
  }
}

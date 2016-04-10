package com.zyt.service.resource.impl;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zyt.base.PageQuery;
import com.zyt.bo.resource.CaseBo;
import com.zyt.dao.resource.ICaseMapper;
import com.zyt.entity.resource.CaseEntity;
import com.zyt.kits.HtmlKit;
import com.zyt.service.resource.ICaseManager;

@Service
@Transactional
class CaseManagerImpl
  implements ICaseManager
{
  @Autowired
  private ICaseMapper caseMapper;
  
  public void delete(String id)
  {
    this.caseMapper.delete(id);
  }
  
  public List<CaseEntity> findByCond(Map<String, Object> cond)
  {
    return null;
  }
  
  public CaseEntity findById(String id)
  {
    return (CaseEntity)this.caseMapper.findById(id);
  }
  
  public PageQuery<CaseEntity> findPage(PageQuery<CaseEntity> page)
  {
    List<CaseEntity> list = this.caseMapper.findAll(page.getCondition());
    for (CaseEntity entity : list) {
      entity.setContent(HtmlKit.filterSubstring(entity.getContent(), 
        50));
    }
    page.setList(list);
    page.setTotal(this.caseMapper.findAllCount(page.getCondition()));
    
    int size = (int)Math.ceil(page.getTotal() * 1.0F / page.getLimit());
    page.setSize(size);
    return page;
  }
  
  public PageQuery<CaseBo> findPageBo(PageQuery<CaseBo> page)
  {
    List<CaseBo> list = this.caseMapper.findAllBo(page.getCondition());
    for (CaseBo entity : list) {
      entity.setContent(HtmlKit.filterSubstring(entity.getContent(), 50));
    }
    page.setList(list);
    page.setTotal(this.caseMapper.findAllCount(page.getCondition()));
    
    int size = (int)Math.ceil(page.getTotal() * 1.0F / page.getLimit());
    page.setSize(size);
    return page;
  }
  
  public int saveOrUpdate(CaseEntity entity)
  {
    if (entity.getId() > 0) {
      return this.caseMapper.update(entity);
    }
    entity.setPubtime(new Timestamp(System.currentTimeMillis()));
    this.caseMapper.save(entity);
    return entity.getId();
  }
}

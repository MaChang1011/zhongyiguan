package com.zyt.service.doctor.impl;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import com.zyt.base.PageQuery;
import com.zyt.bo.doctor.DiagnoseBo;
import com.zyt.dao.doctor.IDiagnoseMapper;
import com.zyt.entity.doctor.DiagnoseEntity;
import com.zyt.service.doctor.IDiagnoseManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
class DiagnoseManagerImpl
  implements IDiagnoseManager
{
  @Autowired
  private IDiagnoseMapper diagnoseMapper;
  
  public void delete(String id) {}
  
  public List<DiagnoseEntity> findByCond(Map<String, Object> cond)
  {
    return null;
  }
  
  public DiagnoseEntity findById(String id)
  {
    return null;
  }
  
  public PageQuery<DiagnoseEntity> findPage(PageQuery<DiagnoseEntity> page)
  {
    return null;
  }
  
  public PageQuery<DiagnoseBo> findPageBo(PageQuery<DiagnoseBo> page)
  {
    page.setList(this.diagnoseMapper.findAllBo(page.getCondition()));
    page.setTotal(this.diagnoseMapper.findAllBoCount(page.getCondition()));
    
    int size = (int)Math.ceil(page.getTotal() * 1.0F / page.getLimit());
    page.setSize(size);
    return page;
  }
  
  public int saveOrUpdate(DiagnoseEntity entity)
  {
    if (entity.getId() > 0) {
      return this.diagnoseMapper.update(entity);
    }
    entity.setCreateTime(new Timestamp(System.currentTimeMillis()));
    this.diagnoseMapper.save(entity);
    return entity.getId();
  }
}

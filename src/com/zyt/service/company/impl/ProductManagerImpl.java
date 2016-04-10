package com.zyt.service.company.impl;

import com.google.common.collect.Maps;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import com.zyt.base.PageQuery;
import com.zyt.dao.company.IProductMapper;
import com.zyt.entity.company.ProductEntity;
import com.zyt.service.company.IProductManager;
import com.zyt.service.system.IDeviceTokenManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
class ProductManagerImpl
  implements IProductManager
{
  @Autowired
  private IProductMapper productMapper;
  @Autowired
  private IDeviceTokenManager deviceTokenManager;
  
  public void delete(String id)
  {
    this.productMapper.delete(id);
  }
  
  public List<ProductEntity> findByCond(Map<String, Object> cond)
  {
    return null;
  }
  
  public ProductEntity findById(Map<String, Object> params)
  {
    return this.productMapper.findByParams(params);
  }
  
  public ProductEntity findById(String id)
  {
    return (ProductEntity)this.productMapper.findById(id);
  }
  
  public PageQuery<ProductEntity> findPage(PageQuery<ProductEntity> page)
  {
    page.setList(this.productMapper.findAll(page.getCondition()));
    page.setTotal(this.productMapper.findAllCount(page.getCondition()));
    
    int size = (int)Math.ceil(page.getTotal() * 1.0F / page.getLimit());
    page.setSize(size);
    return page;
  }
  
  public void push(String id)
  {
    ProductEntity entity = findById(id);
    if (entity != null)
    {
      Map<String, Object> params = Maps.newHashMap();
      params.put("id", id);
      params.put("type", "product");
      this.deviceTokenManager.push(entity.getTitle(), params);
    }
  }
  
  public int saveOrUpdate(ProductEntity entity)
  {
    if (entity.getId() > 0) {
      return this.productMapper.update(entity);
    }
    entity.setPubtime(new Timestamp(System.currentTimeMillis()));
    this.productMapper.save(entity);
    return entity.getId();
  }
}

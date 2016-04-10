package com.zyt.service.doctor.impl;


import java.sql.Timestamp;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.zyt.base.ApiResult;
import com.zyt.base.PageQuery;
import com.zyt.bo.company.MessageBo;
import com.zyt.bo.company.ProductBo;
import com.zyt.bo.doctor.DoctorBo;
import com.zyt.cons.ApiStatus;
import com.zyt.dao.doctor.ICollectionMapper;
import com.zyt.entity.doctor.CollectionEntity;
import com.zyt.kits.HtmlKit;
import com.zyt.service.doctor.ICollectionManager;

@Service
@Transactional
class CollectionManagerImpl
  implements ICollectionManager
{
  @Autowired
  private ICollectionMapper collectionMapper;
  
  public ApiResult delete(int id)
  {
    ApiResult apiResult = new ApiResult(ApiStatus.SUCCESS, "操作成功");
    if (this.collectionMapper.delete(id) == 0)
    {
      apiResult.setResult(ApiStatus.FAILED);
      apiResult.setMsg("记录不存在");
    }
    return apiResult;
  }
  
  public ApiResult deleteByUnionKey(CollectionEntity entity)
  {
    ApiResult apiResult = new ApiResult(ApiStatus.SUCCESS, "操作成功");
    if (this.collectionMapper.deleteByUnionKey(entity) == 0)
    {
      apiResult.setResult(ApiStatus.FAILED);
      apiResult.setMsg("记录不存在");
    }
    return apiResult;
  }
  
  public PageQuery<DoctorBo> findDoctorPage(PageQuery<DoctorBo> page)
  {
    page.setList(this.collectionMapper.findDoctorPage(page.getCondition()));
    page.setTotal(this.collectionMapper.findDoctorPageCount(page.getCondition()));
    
    int size = (int)Math.ceil(page.getTotal() * 1.0F / page.getLimit());
    page.setSize(size);
    return page;
  }
  
  public PageQuery<MessageBo> findMessagePage(PageQuery<MessageBo> page)
  {
    List<MessageBo> list = this.collectionMapper.findMessagePage(page
      .getCondition());
    for (MessageBo entity : list) {
      entity.setContent(HtmlKit.filterSubstring(entity.getContent(), 
        50));
    }
    page.setList(list);
    page.setTotal(this.collectionMapper.findMessagePageCount(page.getCondition()));
    
    int size = (int)Math.ceil(page.getTotal() * 1.0F / page.getLimit());
    page.setSize(size);
    return page;
  }
  
  public PageQuery<ProductBo> findProductPage(PageQuery<ProductBo> page)
  {
    page.setList(this.collectionMapper.findProductPage(page.getCondition()));
    page.setTotal(this.collectionMapper.findProductPageCount(page.getCondition()));
    
    int size = (int)Math.ceil(page.getTotal() * 1.0F / page.getLimit());
    page.setSize(size);
    return page;
  }
  
  public ApiResult save(CollectionEntity entity)
  {
    ApiResult apiResult = new ApiResult(ApiStatus.SUCCESS, "操作成功");
    if (this.collectionMapper.findByUnionKey(entity) == 0)
    {
      entity.setCreateTime(new Timestamp(System.currentTimeMillis()));
      this.collectionMapper.save(entity);
    }
    return apiResult;
  }
}

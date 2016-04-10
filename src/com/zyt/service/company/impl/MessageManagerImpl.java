package com.zyt.service.company.impl;

import com.google.common.collect.Maps;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import com.zyt.base.PageQuery;
import com.zyt.dao.company.IMessageMapper;
import com.zyt.entity.company.MessageEntity;
import com.zyt.kits.HtmlKit;
import com.zyt.kits.StrKit;
import com.zyt.service.company.IMessageManager;
import com.zyt.service.system.IDeviceTokenManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
class MessageManagerImpl
  implements IMessageManager
{
  @Autowired
  private IMessageMapper messageMapper;
  @Autowired
  private IDeviceTokenManager deviceTokenManager;
  
  public void delete(String id)
  {
    this.messageMapper.delete(id);
  }
  
  public List<MessageEntity> findByCond(Map<String, Object> cond)
  {
    return null;
  }
  
  public MessageEntity findById(Map<String, Object> params)
  {
    return this.messageMapper.findByParams(params);
  }
  
  public MessageEntity findById(String id)
  {
    return (MessageEntity)this.messageMapper.findById(id);
  }
  
  public PageQuery<MessageEntity> findPage(PageQuery<MessageEntity> page)
  {
    List<MessageEntity> list = this.messageMapper.findAll(page.getCondition());
    for (MessageEntity entity : list) {
      entity.setContent(HtmlKit.filterSubstring(entity.getContent(), 
        50));
    }
    page.setList(list);
    page.setTotal(this.messageMapper.findAllCount(page.getCondition()));
    
    int size = (int)Math.ceil(page.getTotal() * 1.0F / page.getLimit());
    page.setSize(size);
    return page;
  }
  
  public void push(String id)
  {
    MessageEntity entity = findById(id);
    if (entity != null)
    {
      Map<String, Object> params = Maps.newHashMap();
      params.put("id", id);
      params.put("type", "message");
      this.deviceTokenManager.push(entity.getTitle(), params);
    }
  }
  
  public int saveOrUpdate(MessageEntity entity)
  {
    String image = "";
    if ((StrKit.isBlank(entity.getImage())) && 
      (!StrKit.isBlank(entity.getContent()))) {
      image = HtmlKit.filterImage(entity.getContent());
    }
    if ((StrKit.isBlank(entity.getImage())) && (StrKit.isBlank(image))) {
      image = "uploads/default/001.png";
    }
    if (!StrKit.isBlank(image)) {
      entity.setImage(image);
    }
    if (entity.getId() > 0) {
      return this.messageMapper.update(entity);
    }
    entity.setPubtime(new Timestamp(System.currentTimeMillis()));
    this.messageMapper.save(entity);
    return entity.getId();
  }
}

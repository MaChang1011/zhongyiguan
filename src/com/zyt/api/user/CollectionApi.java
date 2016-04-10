package com.zyt.api.user;

import java.util.List;
import java.util.Map;
import com.zyt.api.BaseApi;
import com.zyt.base.ApiResult;
import com.zyt.base.PageQuery;
import com.zyt.bo.company.MessageBo;
import com.zyt.bo.company.ProductBo;
import com.zyt.bo.doctor.DoctorBo;
import com.zyt.entity.doctor.CollectionEntity;
import com.zyt.service.doctor.ICollectionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping({"/api/collection"})
public class CollectionApi
  extends BaseApi
{
  @Autowired
  private ICollectionManager collectionManager;
  
  @ResponseBody
  @RequestMapping(value={"/delete/{id}"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public ApiResult delete(@PathVariable int id)
  {
    return this.collectionManager.delete(id);
  }
  
  @ResponseBody
  @RequestMapping(value={"/delete"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public ApiResult deleteByUnionKey(@ModelAttribute CollectionEntity entity)
  {
    return this.collectionManager.deleteByUnionKey(entity);
  }
  
  @ResponseBody
  @RequestMapping(value={"/list/doctor/{userid}/{start}"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public List<DoctorBo> listDoctor(@PathVariable int userid, @PathVariable int start)
  {
    PageQuery<DoctorBo> page = getPageQuery(start);
    page.getCondition().put("userId", Integer.valueOf(userid));
    PageQuery<DoctorBo> result = this.collectionManager.findDoctorPage(page);
    return result.getList();
  }
  
  @ResponseBody
  @RequestMapping(value={"/list/message/{userid}/{start}"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public List<MessageBo> listMessage(@PathVariable int userid, @PathVariable int start)
  {
    PageQuery<MessageBo> page = getPageQuery(start);
    page.getCondition().put("userId", Integer.valueOf(userid));
    PageQuery<MessageBo> result = this.collectionManager.findMessagePage(page);
    return result.getList();
  }
  
  @ResponseBody
  @RequestMapping(value={"/list/product/{userid}/{start}"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public List<ProductBo> listProduct(@PathVariable int userid, @PathVariable int start)
  {
    PageQuery<ProductBo> page = getPageQuery(start);
    page.getCondition().put("userId", Integer.valueOf(userid));
    PageQuery<ProductBo> result = this.collectionManager.findProductPage(page);
    return result.getList();
  }
  
  @ResponseBody
  @RequestMapping(value={"/post"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public ApiResult post(@ModelAttribute CollectionEntity entity)
  {
    return this.collectionManager.save(entity);
  }
}

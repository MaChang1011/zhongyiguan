package com.zyt.api.resource;

import com.google.common.collect.Maps;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import com.zyt.api.BaseApi;
import com.zyt.base.ApiResult;
import com.zyt.base.PageQuery;
import com.zyt.bo.resource.CaseBo;
import com.zyt.cons.AduitStatus;
import com.zyt.cons.ApiStatus;
import com.zyt.cons.CaseType;
import com.zyt.entity.resource.CaseEntity;
import com.zyt.kits.StrKit;
import com.zyt.service.resource.ICaseManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping({"/api/case"})
public class CaseApi
  extends BaseApi
{
  @Autowired
  private ICaseManager caseManager;
  
  @RequestMapping(value={"/detail/{id}"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public ModelAndView detail(@PathVariable String id)
  {
    Map<String, Object> data = Maps.newHashMap();
    CaseEntity entity = (CaseEntity)this.caseManager.findById(id);
    data.put("entity", entity);
    if (!StrKit.isBlank(entity.getImages()))
    {
      String[] images = entity.getImages().split(",");
      data.put("images", images);
    }
    return new ModelAndView("/api/case", data);
  }
  
  @ResponseBody
  @RequestMapping(value={"/get/{id}"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public CaseEntity get(@PathVariable String id)
  {
    return (CaseEntity)this.caseManager.findById(id);
  }
  
  @ResponseBody
  @RequestMapping(value={"/list/{category}/{start}"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public List<CaseBo> list(@PathVariable int category, @PathVariable int start)
  {
    PageQuery<CaseBo> page = getPageQuery(start);
    page.getCondition().put("category", Integer.valueOf(category));
    page.getCondition().put("status", Integer.valueOf(AduitStatus.PASSED.getStatus()));
    PageQuery<CaseBo> result = this.caseManager.findPageBo(page);
    return result.getList();
  }
  
  @ResponseBody
  @RequestMapping(value={"/mylist/{userid}/{start}"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public List<CaseBo> mylist(HttpServletRequest request, @PathVariable String userid, @PathVariable int start)
  {
    PageQuery<CaseBo> page = getPageQuery(start);
    page.getCondition().put("pubuser", userid);
    String status = request.getParameter("status");
    if (!StrKit.isBlank(status)) {
      page.getCondition().put("status", status);
    }
    PageQuery<CaseBo> result = this.caseManager.findPageBo(page);
    return result.getList();
  }
  
  @ResponseBody
  @RequestMapping(value={"/post"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public ApiResult post(@RequestParam int userid, @ModelAttribute CaseEntity entity)
  {
    entity.setPubuser(userid);
    entity.setCategory(CaseType.JDAL.getType());
    this.caseManager.saveOrUpdate(entity);
    return new ApiResult(ApiStatus.SUCCESS, "操作成功");
  }
}

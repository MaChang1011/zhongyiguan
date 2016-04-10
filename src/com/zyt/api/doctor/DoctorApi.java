package com.zyt.api.doctor;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import com.zyt.api.BaseApi;
import com.zyt.base.ApiResult;
import com.zyt.base.PageQuery;
import com.zyt.bo.doctor.DoctorBo;
import com.zyt.bo.doctor.DoctorNearBo;
import com.zyt.entity.doctor.DoctorInfoEntity;
import com.zyt.service.doctor.IDoctorManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping({"/api/doctor"})
public class DoctorApi
  extends BaseApi
{
  @Autowired
  private IDoctorManager doctorManager;
  
  @ResponseBody
  @RequestMapping(value={"/list/{start}"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public List<DoctorBo> list(@PathVariable int start)
  {
    PageQuery<DoctorBo> page = getPageQuery(start);
    page.getCondition().put("userId", this.request.getParameter("userId"));
    PageQuery<DoctorBo> result = this.doctorManager.findPageBo(page);
    return result.getList();
  }
  
  @ResponseBody
  @RequestMapping(value={"/list/{userId}/{start}"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public List<DoctorBo> list(@PathVariable int userId, @PathVariable int start)
  {
    PageQuery<DoctorBo> page = getPageQuery(start);
    page.getCondition().put("userId", Integer.valueOf(userId));
    PageQuery<DoctorBo> result = this.doctorManager.findPageBo(page);
    return result.getList();
  }
  
  @ResponseBody
  @RequestMapping(value={"/list/near/{longitude}/{latitude}/{start}"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public List<DoctorNearBo> near(@PathVariable double longitude, @PathVariable double latitude, @PathVariable int start)
  {
    PageQuery<DoctorNearBo> page = getPageQuery(start);
    page.getCondition().put("longitude", Double.valueOf(longitude));
    page.getCondition().put("latitude", Double.valueOf(latitude));
    PageQuery<DoctorNearBo> result = this.doctorManager.findNearPageBo(page);
    return result.getList();
  }
  
  @ResponseBody
  @RequestMapping(value={"/list/online/{start}"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public List<DoctorBo> online(@PathVariable int start)
  {
    PageQuery<DoctorBo> page = getPageQuery(start);
    page.getCondition().put("online", "online");
    PageQuery<DoctorBo> result = this.doctorManager.findPageBo(page);
    return result.getList();
  }
  
  @ResponseBody
  @RequestMapping(value={"/post/status"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public ApiResult post(@ModelAttribute DoctorInfoEntity entity)
  {
    return this.doctorManager.doctorInfo(entity);
  }
  
  @ResponseBody
  @RequestMapping(value={"/post/status_test"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public ApiResult test(@ModelAttribute DoctorInfoEntity entity)
  {
    return this.doctorManager.doctorInfo(entity);
  }
}

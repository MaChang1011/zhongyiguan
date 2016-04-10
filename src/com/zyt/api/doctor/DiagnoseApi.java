package com.zyt.api.doctor;

import java.util.List;
import java.util.Map;
import com.zyt.api.BaseApi;
import com.zyt.base.ApiResult;
import com.zyt.base.PageQuery;
import com.zyt.bo.doctor.DiagnoseBo;
import com.zyt.cons.ApiStatus;
import com.zyt.entity.doctor.DiagnoseEntity;
import com.zyt.service.doctor.IDiagnoseManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping({"/api/diagnose"})
public class DiagnoseApi
  extends BaseApi
{
  @Autowired
  private IDiagnoseManager diagnoseManager;
  
  @ResponseBody
  @RequestMapping(value={"/list/{start}"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public List<DiagnoseBo> list(@PathVariable int start)
  {
    PageQuery<DiagnoseBo> page = getPageQuery(start);
    PageQuery<DiagnoseBo> result = this.diagnoseManager.findPageBo(page);
    return result.getList();
  }
  
  @ResponseBody
  @RequestMapping(value={"/list/{userid}/{start}"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public List<DiagnoseBo> mylist(@PathVariable String userid, @PathVariable int start)
  {
    PageQuery<DiagnoseBo> page = getPageQuery(start);
    page.getCondition().put("userid", userid);
    PageQuery<DiagnoseBo> result = this.diagnoseManager.findPageBo(page);
    return result.getList();
  }
  
  @ResponseBody
  @RequestMapping(value={"/post"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public ApiResult post(@ModelAttribute DiagnoseEntity entity)
  {
    this.diagnoseManager.saveOrUpdate(entity);
    return new ApiResult(ApiStatus.SUCCESS, "操作成功");
  }
}

package com.zyt.action.resource;

import java.util.Map;
import com.zyt.base.AjaxResult;
import com.zyt.base.BaseAction;
import com.zyt.base.PageQuery;
import com.zyt.bo.resource.CaseBo;
import com.zyt.entity.doctor.PatientEntity;
import com.zyt.entity.resource.CaseEntity;
import com.zyt.entity.system.UserEntity;
import com.zyt.service.doctor.IPatientManager;
import com.zyt.service.resource.ICaseManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping({"/patient"})
public class PatientAction
  extends BaseAction
{
  @Autowired
  private IPatientManager patientManager;

  public PatientAction()
  {
    setFlag(getClass().getSimpleName());
  }

  @RequestMapping({"/add"})
  public ModelAndView add()
  {
    Map<String, Object> data = getMap();
    data.put("entity", new PatientEntity());
    return new ModelAndView("/resource/patient_form", data);
  }

  @ResponseBody
  @RequestMapping({"/aduit"})
  public AjaxResult aduit(@ModelAttribute PatientEntity entity)
  {
    this.patientManager.saveOrUpdate(entity);
    return new AjaxResult();
  }

  @RequestMapping({"/del/{id}"})
  @ResponseBody
  public AjaxResult delete(@PathVariable String id)
  {
    this.patientManager.delete(id);
    return new AjaxResult();
  }

  @RequestMapping({"/detail/{id}"})
  public ModelAndView detail(@PathVariable String id)
  {
    Map<String, Object> data = getMap();
    data.put("entity", this.patientManager.findById(id));
    return new ModelAndView("/resource/patient_detail", data);
  }

  @RequestMapping({"/edit/{id}"})
  public ModelAndView edit(@PathVariable String id)
  {
    Map<String, Object> data = getMap();
    data.put("entity", this.patientManager.findById(id));
    return new ModelAndView("/resource/patient_form", data);
  }

  @RequestMapping({"/index"})
  public ModelAndView index()
  {
    Map<String, Object> data = getMap();
    PageQuery<PatientEntity> pageQuery = getPageQuery();
    data.put("data", this.patientManager.findPageBo(pageQuery));
    return new ModelAndView("/resource/patient", data);
  }

  @RequestMapping({"/save"})
  @ResponseBody
  public AjaxResult save(@ModelAttribute PatientEntity entity, @RequestHeader("referer") String url)
  {
    entity.setUserid(getUser().getId());
    this.patientManager.saveOrUpdate(entity);
    AjaxResult ajaxResult = new AjaxResult();
    ajaxResult.setMsg(url);
    return ajaxResult;
  }
}

package com.zyt.action.doctor;

import java.util.Map;

import com.zyt.base.AjaxResult;
import com.zyt.base.BaseAction;
import com.zyt.base.PageQuery;
import com.zyt.bo.doctor.DoctorBo;
import com.zyt.entity.doctor.DoctorEntity;
import com.zyt.service.doctor.IDoctorManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping({"/record"})
public class RecordAction
  extends BaseAction
{
  @Autowired
  private IDoctorManager doctorManager;
  
  public RecordAction()
  {
    setFlag(getClass().getSimpleName());
  }

  /**
   * @Title : add
   * @Description : 添加页面
   */
  @RequestMapping("/add")
  public ModelAndView add() {
    Map<String, Object> data = getMap();
    data.put("entity", new DoctorEntity());
    return new ModelAndView("/doctor/record_form", data);
  }

  /**
   * @Title : index
   * @Description : 医生档案列表
   */
  @RequestMapping("/index")
  public ModelAndView index() {
    Map<String, Object> data = getMap();
    PageQuery<DoctorBo> pageQuery = getPageQuery();
    data.put("data", doctorManager.findPageBoUncheck(pageQuery));
    return new ModelAndView("/doctor/record", data);
  }

  /**
   * @Title : aduit
   * @Description : 审核
   */
  @ResponseBody
  @RequestMapping("/aduit")
  public AjaxResult aduit(@ModelAttribute DoctorEntity entity) {
    doctorManager.updateCheck(entity);
    return new AjaxResult();
  }
}

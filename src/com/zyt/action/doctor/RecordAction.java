package com.zyt.action.doctor;

import java.util.Map;
import com.zyt.base.BaseAction;
import com.zyt.base.PageQuery;
import com.zyt.bo.doctor.DoctorBo;
import com.zyt.service.doctor.IDoctorManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
  
  @RequestMapping({"/index"})
  public ModelAndView index()
  {
    Map<String, Object> data = getMap();
    PageQuery<DoctorBo> pageQuery = getPageQuery();
    data.put("data", this.doctorManager.findPageBo(pageQuery));
    return new ModelAndView("/doctor/record", data);
  }
}

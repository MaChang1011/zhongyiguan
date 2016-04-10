package com.zyt.action.doctor;

import java.util.Map;
import com.zyt.base.BaseAction;
import com.zyt.base.PageQuery;
import com.zyt.bo.doctor.RvtUserBo;
import com.zyt.service.doctor.IReservationManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping({"/reservation"})
public class ReservationAction
  extends BaseAction
{
  @Autowired
  private IReservationManager reservationManager;
  
  public ReservationAction()
  {
    setFlag(getClass().getSimpleName());
  }
  
  @RequestMapping({"/index"})
  public ModelAndView index()
  {
    Map<String, Object> data = getMap();
    PageQuery<RvtUserBo> pageQuery = getPageQuery();
    data.put("data", this.reservationManager.findPage(pageQuery));
    return new ModelAndView("/doctor/reservation", data);
  }
}

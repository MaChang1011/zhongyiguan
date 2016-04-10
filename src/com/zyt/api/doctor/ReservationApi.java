package com.zyt.api.doctor;

import java.util.List;
import java.util.Map;
import com.zyt.api.BaseApi;
import com.zyt.base.ApiResult;
import com.zyt.base.PageQuery;
import com.zyt.bo.doctor.ReservationBo;
import com.zyt.bo.doctor.RvtUserBo;
import com.zyt.entity.doctor.ReservationEntity;
import com.zyt.service.doctor.IDoctorManager;
import com.zyt.service.doctor.IReservationManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping({"/api/rvt"})
public class ReservationApi
  extends BaseApi
{
  @Autowired
  private IDoctorManager doctorManager;
  @Autowired
  private IReservationManager reservationManager;
  
  @ResponseBody
  @RequestMapping(value={"/get_time/{userid}"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public ReservationBo getReservation(@PathVariable String userid)
  {
    return this.doctorManager.findReservation(userid);
  }
  
  @ResponseBody
  @RequestMapping(value={"/list/{history}/{userid}/{start}"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public List<RvtUserBo> list(@PathVariable String history, @PathVariable int userid, @PathVariable int start)
  {
    PageQuery<RvtUserBo> page = getPageQuery(start);
    page.getCondition().put("userid", Integer.valueOf(userid));
    page.getCondition().put("history", history);
    PageQuery<RvtUserBo> result = this.reservationManager.findPageBo(page);
    return result.getList();
  }
  
  @ResponseBody
  @RequestMapping(value={"/post"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public ApiResult post(@ModelAttribute ReservationEntity entity)
  {
    return this.reservationManager.saveOrUpdate(entity);
  }
  
  @ResponseBody
  @RequestMapping(value={"/post_time"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public ApiResult postReservation(@RequestParam int userid, @ModelAttribute ReservationBo reservation)
  {
    reservation.setUserid(userid);
    return this.doctorManager.updateReservation(reservation);
  }
  
  @ResponseBody
  @RequestMapping(value={"/post_status"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public ApiResult postStatus(@RequestParam int id, @RequestParam int status)
  {
    ReservationEntity entity = new ReservationEntity();
    entity.setId(id);
    entity.setStatus(status);
    return this.reservationManager.saveOrUpdate(entity);
  }
}

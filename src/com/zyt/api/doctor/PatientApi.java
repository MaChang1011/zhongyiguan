package com.zyt.api.doctor;

import com.google.common.collect.Maps;
import java.util.Map;
import com.zyt.api.BaseApi;
import com.zyt.base.ApiResult;
import com.zyt.service.doctor.IPatientManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping({"/api/patient"})
public class PatientApi
  extends BaseApi
{
  @Autowired
  private IPatientManager patientManager;
  
  @ResponseBody
  @RequestMapping(value={"/getCaseImageCount/{userid}"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public Map<String, Integer> getCaseImageCount(@PathVariable String userid)
  {
    Map<String, Integer> result = Maps.newHashMap();
    result.put("result", Integer.valueOf(this.patientManager.getCaseImageCount(userid)));
    return result;
  }
  
  @ResponseBody
  @RequestMapping(value={"/saveCaseImageCount"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public ApiResult saveCaseImageCount(@RequestParam String userid, @RequestParam int caseImageCount)
  {
    return this.patientManager.saveCaseImageCount(userid, caseImageCount);
  }
}

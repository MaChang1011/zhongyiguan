package com.zyt.service.doctor.impl;

import com.google.common.collect.Maps;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import com.zyt.base.ApiResult;
import com.zyt.base.PageQuery;
import com.zyt.bo.resource.CaseBo;
import com.zyt.cons.ApiStatus;
import com.zyt.cons.UserType;
import com.zyt.dao.doctor.IPatientMapper;
import com.zyt.dao.system.IUserMapper;
import com.zyt.entity.doctor.PatientEntity;
import com.zyt.entity.resource.CaseEntity;
import com.zyt.entity.system.UserEntity;
import com.zyt.kits.HtmlKit;
import com.zyt.kits.StrKit;
import com.zyt.service.doctor.IPatientManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
class PatientManagerImpl
  implements IPatientManager
{
  @Autowired
  private IPatientMapper patientMapper;
  @Autowired
  private IUserMapper userMapper;
  
  public PatientEntity findById(String userid)
  {
    return (PatientEntity)this.patientMapper.findById(userid);
  }
  
  public int getCaseImageCount(String userid)
  {
    String count = this.patientMapper.getCaseImageCount(userid);
    return StrKit.isBlank(count) ? 0 : Integer.parseInt(count);
  }
  
  public ApiResult saveCaseImageCount(String userid, int caseImageCount)
  {
    Map<String, Object> params = Maps.newHashMap();
    params.put("userid", userid);
    params.put("caseImageCount", Integer.valueOf(caseImageCount));
    int result = this.patientMapper.updateCaseImageCount(params);
    if (result == 0)
    {
      PatientEntity entity = new PatientEntity();
      entity.setUserid(Integer.parseInt(userid));
      entity.setCaseImageCount(caseImageCount);
      this.patientMapper.saveCaseImageCount(entity);
      result = 1;
    }
    return new ApiResult(result, "操作成功");
  }
  
  public ApiResult Update(PatientEntity entity)
  {
    ApiResult apiResult = new ApiResult(ApiStatus.FAILED);
    this.patientMapper.update(entity);
    apiResult.setResult(ApiStatus.SUCCESS);
    apiResult.setMsg("更新信息成功");
    return apiResult;
  }
  
  
  public void delete(String id)
  {
    this.patientMapper.delete(id);
  }
  
  public List<PatientEntity> findByCond(Map<String, Object> cond)
  {
    return null;
  }
  
  public PageQuery<PatientEntity> findPage(PageQuery<PatientEntity> page)
  {
    List<PatientEntity> list = this.patientMapper.findAll(page.getCondition());
    page.setList(list);
    page.setTotal(this.patientMapper.findAllCount(page.getCondition()));
    int size = (int)Math.ceil(page.getTotal() * 1.0F / page.getLimit());
    page.setSize(size);
    return page;
  }
  
  public PageQuery<PatientEntity> findPageBo(PageQuery<PatientEntity> page)
  {
    List<PatientEntity> list = this.patientMapper.findAll(page.getCondition());
    page.setList(list);
    page.setTotal(this.patientMapper.findAllCount(page.getCondition()));
    
    int size = (int)Math.ceil(page.getTotal() * 1.0F / page.getLimit());
    page.setSize(size);
    return page;
  }
  
  public PageQuery<PatientEntity> findPageBoIsPass(PageQuery<PatientEntity> page)
  {
    List<PatientEntity> list = this.patientMapper.findAllIsPass(page.getCondition());
    page.setList(list);
    page.setTotal(this.patientMapper.findAllCount(page.getCondition()));
    
    int size = (int)Math.ceil(page.getTotal() * 1.0F / page.getLimit());
    page.setSize(size);
    return page;
  }
  
  public ApiResult saveOrUpdate(PatientEntity entity)
  {
	ApiResult apiResult = new ApiResult(ApiStatus.FAILED);
	UserEntity user = (UserEntity)this.userMapper.findById(String.valueOf(entity.getUserid()));
	if (entity.getId() > 0) {
	      this.patientMapper.update(entity);
	    }
	entity.setPubtime(new Timestamp(System.currentTimeMillis()));
    this.patientMapper.save(entity);
	if (user == null)
    {
      apiResult.setMsg("该用户不存在");
      return apiResult;
    }
    if (user.getType() != UserType.PATIENT.getType())
    {
      apiResult.setMsg("非患者用户无法更新");
      return apiResult;
    }
    if (this.patientMapper.update(entity) == 0) {
      this.patientMapper.save(entity);
    }
    apiResult.setResult(ApiStatus.SUCCESS);
    apiResult.setMsg("更新信息成功");
    return apiResult;

  }
}

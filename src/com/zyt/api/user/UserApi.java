package com.zyt.api.user;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.POST;

import com.zyt.api.BaseApi;
import com.zyt.base.ApiResult;
import com.zyt.base.PageQuery;
import com.zyt.cons.ApiStatus;
import com.zyt.entity.doctor.DoctorEntity;
import com.zyt.entity.doctor.PatientEntity;
import com.zyt.entity.system.UserEntity;
import com.zyt.kits.StrKit;
import com.zyt.kits.UploadKit;
import com.zyt.service.Jpush.JpushService;
import com.zyt.service.doctor.IDoctorManager;
import com.zyt.service.doctor.IPatientManager;
import com.zyt.service.system.IUserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping({"/api/user"})
public class UserApi
  extends BaseApi
{
  @Autowired
  private IUserManager userManager;
  @Autowired
  private IDoctorManager doctorManager;
  @Autowired
  private IPatientManager patientManager;

  /**
   * @Title : newauth
   * @Function: 添加医生审核
   */
  @ResponseBody
  @RequestMapping(value ="/newauth",method ={org.springframework.web.bind.annotation.RequestMethod.POST})
  public ApiResult newauth(@RequestParam String mobile)
  {
    return userManager.authDoctor(mobile);
  }

  /**
   * @Title : resetPwd
   * @Function : 重置密码,验证码验证前端处理
   * @Arguments: String mobile,String newPwd
  * */
  @ResponseBody
  @RequestMapping(value = "/resetPwd",method={org.springframework.web.bind.annotation.RequestMethod.POST} )
  public ApiResult resetPwd(@RequestParam String mobile,@RequestParam String newPwd)
  {
    return this.userManager.resetPwd(mobile,newPwd);
  }
  //验证登录
  @ResponseBody
  @RequestMapping(value={"/auth"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public ApiResult auth(@ModelAttribute UserEntity user)
  {
    return this.userManager.authUser(user);
  }

  //更换密码
  @ResponseBody
  @RequestMapping(value={"/change_psw"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public ApiResult changePassword(@RequestParam String userid, @RequestParam String oldPwd, @RequestParam String newPwd)
  {
    return this.userManager.changePsw(userid, oldPwd, newPwd);
  }

  //获得用户所有信息
  @ResponseBody
  @RequestMapping(value={"/get/{userid}"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public UserEntity get(@PathVariable String userid)
  {
    return (UserEntity)this.userManager.findById(userid);
  }

  @ResponseBody
  @RequestMapping(value={"/get_detail/{userid}"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public DoctorEntity getDetail(@PathVariable String userid)
  {
    return this.doctorManager.findById(userid);
  }

  @ResponseBody
  @RequestMapping(value={"/get_detail_patient/{userid}"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public PatientEntity getDetailPatient(@PathVariable String userid)
  {
    return this.patientManager.findById(userid);
  }

  @ResponseBody
  @RequestMapping(value={"/improve"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public ApiResult improve(@RequestParam int userid, @ModelAttribute DoctorEntity entity)
  {
    entity.setUserid(userid);
    entity.setNickname(this.request.getParameter("nickname"));
    return this.doctorManager.saveOrUpdate(entity);
  }

  //处方状态改变接口
  @ResponseBody
  @RequestMapping(value={"/updateRecipe"},method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public ApiResult updateRecipe(@RequestParam int id,@ModelAttribute PatientEntity entity)
  {
	  //更新订单的状态
	  entity.setId(id);
	  this.patientManager.Update(entity);
	  //获取User的Mobile字段作为推送的alias
	  PatientEntity p = this.patientManager.findById(String.valueOf(id));
	  String uid = String.valueOf(p.getUserid());
	  UserEntity u = this.userManager.findById(uid);
	  String mobile = u.getMobile();
	  //检查通过的订单推送
	  if(entity.getStatus()==1)
		  {
		  	String alert="您好,您的订单已经审核通过.金额为:"+entity.getMoney()+",请尽快支付!";
		  	JpushService.testSendPush(alert,mobile);
		  }
	  return new ApiResult(ApiStatus.SUCCESS, "操作成功");
  }

  //处方输入接口
  @ResponseBody
  @RequestMapping(value={"/recipeInput"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public ApiResult recipeInput(@RequestParam int userid, @ModelAttribute PatientEntity entity)
  {
    entity.setUserid(userid);
    this.patientManager.saveOrUpdate(entity);
    return new ApiResult(ApiStatus.SUCCESS, "操作成功");
  }

  //处方上传接口
  /**
 *@Method recipeUpfile
 *@Date 2016年3月14日
 *@param : userid,PatientEntity实体,file数组
 *@Return ApiResult 返回ApiResult结果
 *@throws
 *@EnclosingType UserApi
 */
  @ResponseBody
  @RequestMapping(value={"/recipeUpfile"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public ApiResult recipeUpfile(HttpServletRequest request, @RequestParam int userid,
		  @ModelAttribute PatientEntity entity, @RequestParam MultipartFile[] file)
  {
	ApiResult apiResult = new ApiResult(ApiStatus.FAILED);
	/*
	 * 改为时间毫秒存储图片名   改动位置：com.zyt.kits.UploadKit  58行位置
	 * */
    String path = UploadKit.filesUpload(request, String.valueOf(userid), file);
       if (!StrKit.isBlank(path))
        {
          apiResult.setResult(ApiStatus.SUCCESS);
          apiResult.setMsg(path);
		  entity.setDrug(path);
		  entity.setUserid(userid);
		  this.patientManager.saveOrUpdate(entity);
        }
        else
        {
          apiResult.setMsg("上传出错");
        }

    return apiResult;
  }

  //获取处方确认列表
  /**
 *@Method list
 *@Date 2016年3月14日
 *@param
 *@Return List<PatientEntity> 获取所有处方列表
 *@throws
 *@EnclosingType UserApi
 */
  @ResponseBody
  @RequestMapping(value={"/list/{start}"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public List<PatientEntity> list(@PathVariable int start)
  {
    PageQuery<PatientEntity> page = getPageQuery(start);
    PageQuery<PatientEntity> result = this.patientManager.findPageBo(page);
    return result.getList();
  }

//获取我的通过处方列表

  /**
 *@Method mylistIsPass
 *@Date 2016年3月14日
 *@param: String userid,int start
 *@Return List<PatientEntity> 获取我的通过处方列表
 *@throws
 *@EnclosingType UserApi
 */
  @ResponseBody
  @RequestMapping(value={"/mylistispass/{userid}/{start}"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public List<PatientEntity> mylistIsPass(HttpServletRequest request, @PathVariable String userid, @PathVariable int start)
  {
    PageQuery<PatientEntity> page = getPageQuery(start);
    page.getCondition().put("userid", userid);
    String status = request.getParameter("status");
    if (!StrKit.isBlank(status)) {
      page.getCondition().put("status", status);
    }
    PageQuery<PatientEntity> result = this.patientManager.findPageBoIsPass(page);
    return result.getList();
  }

  //获取我的处方列表
  /**
 *@Method mylist
 *@Date 2016年3月14日
 *@param: String userid 处方列表中的userid,int start 初始位置
 *@Return List<PatientEntity>  获取我的处方 所有列表
 *@throws
 *@EnclosingType UserApi
 */
  @ResponseBody
  @RequestMapping(value={"/mylist/{userid}/{start}"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public List<PatientEntity> mylist(HttpServletRequest request, @PathVariable String userid, @PathVariable int start)
  {
    PageQuery<PatientEntity> page = getPageQuery(start);
    page.getCondition().put("userid", userid);
    String status = request.getParameter("status");
    if (!StrKit.isBlank(status)) {
      page.getCondition().put("status", status);
    }
    PageQuery<PatientEntity> result = this.patientManager.findPageBo(page);
    return result.getList();
  }

  //获取处方详情
  /**
 *@Method recipeGet
 *@Date 2016年3月14日
 *@param: String id  处方的ID
 *@Return PatientEntity  获取处方的详情
 *@throws
 *@EnclosingType UserApi
 */
  @ResponseBody
  @RequestMapping(value={"/getRecipe/{id}"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public PatientEntity recipeGet(@PathVariable String id)
  {
    return (PatientEntity)this.patientManager.findById(id);
  }

  //用户注册
  @ResponseBody
  @RequestMapping(value={"/register"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public ApiResult register(@ModelAttribute UserEntity user)
  {
    return this.userManager.saveRegister(user);
  }

  //用户更新
  @ResponseBody
  @RequestMapping(value={"/update"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public ApiResult update(@RequestParam int userid, @ModelAttribute UserEntity entity)
  {
    entity.setId(userid);
    return this.userManager.update(entity);
  }

  //上传文件通用接口
  @ResponseBody
  @RequestMapping(value={"/upfile"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public ApiResult upfile(HttpServletRequest request, @RequestParam int userid, @RequestParam MultipartFile file)
  {
    ApiResult apiResult = new ApiResult(ApiStatus.FAILED);
    String path = UploadKit.upload(request, String.valueOf(userid), file);
    if (!StrKit.isBlank(path))
    {
      apiResult.setResult(ApiStatus.SUCCESS);
      apiResult.setMsg(path);
    }
    else
    {
      apiResult.setMsg("上传出错");
    }
    return apiResult;
  }

  //上传头像通用接口
  @ResponseBody
  @RequestMapping(value={"/upload_head"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public ApiResult uploadHead(HttpServletRequest request, @RequestParam int userid, @RequestParam MultipartFile head)
  {
    ApiResult apiResult = new ApiResult(ApiStatus.FAILED);
    String path = UploadKit.uploadHead(request, String.valueOf(userid),
      head);
    if (!StrKit.isBlank(path))
    {
      UserEntity entity = new UserEntity();
      entity.setId(userid);
      entity.setHead(path);
      this.userManager.saveOrUpdate(entity);
      apiResult.setResult(ApiStatus.SUCCESS);
      apiResult.setMsg(entity.getHead());
    }
    else
    {
      apiResult.setMsg("上传出错");
    }
    return apiResult;
  }
}

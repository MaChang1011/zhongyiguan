package com.zyt.service.system;

import java.util.List;
import java.util.Map;

import com.zyt.base.ApiResult;
import com.zyt.base.IBaseManager;
import com.zyt.entity.doctor.DoctorEntity;
import com.zyt.entity.system.UserEntity;

/**
 * Author: @author LJW . <br>
 * Date: 2015-9-9 下午8:36:56 . <br>
 * Function: 用户Service
 */
public interface IUserManager extends IBaseManager<UserEntity> {
  /**
   * @Title : saveRegister
   * @Description : 保存注册用户
   */
  ApiResult saveRegister(UserEntity entity);

  /**
   * @Title : findOneByCond
   * @Description : 查询单个记录
   */
  UserEntity findOneByCond(Map<String, Object> cond);

  /**
   * @Title : changePsw
   * @Description : 修改密码
   */
  ApiResult changePsw(String userid, String oldPwd, String newPwd);

  /**
   * @Title : authUser
   * @Description : 验证用户
   */
  ApiResult authUser(UserEntity user);


  /**
   * @Title : update
   * @Description : 修改个人信息
   */
  ApiResult update(UserEntity entity);

  /**
   * @Title : improve
   * @Description : 完善个人信息
   */
  int improve(UserEntity user);

  /**
   * @Title : findUserLogin
   * @Description : 登陆
   */
  UserEntity findUserLogin(UserEntity entity);

  /**
   * @Title : findDoctorCheck
   * @Description : 验证医生审核状态(d_check)
   */
  DoctorEntity findDoctorCheck(String mobile);

  /**
   * @Title : authDoctor
   * @Description : 验证医生
   */
  ApiResult authDoctor(String mobile);
}

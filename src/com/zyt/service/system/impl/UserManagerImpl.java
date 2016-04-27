package com.zyt.service.system.impl;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import com.zyt.base.ApiResult;
import com.zyt.base.PageQuery;
import com.zyt.cons.ApiStatus;
import com.zyt.cons.UserType;
import com.zyt.dao.system.IUserMapper;
import com.zyt.entity.doctor.DoctorEntity;
import com.zyt.entity.system.UserEntity;
import com.zyt.kits.CollectionKit;
import com.zyt.kits.MD5Kit;
import com.zyt.kits.StrKit;
import com.zyt.service.chat.IChatManager;
import com.zyt.service.system.IUserManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Maps;

/**
 * Author: @author LJW . <br>
 * Date: 2015-9-9 下午8:46:09 . <br>
 * Function: IUserManager实现类
 */
@Service
@Transactional
class UserManagerImpl implements IUserManager {
    @Autowired
    private IUserMapper userMapper;
    @Autowired
    private IChatManager chatManager;

    /*
     * (non-Javadoc)
     *
     * @see
     * me.hys.service.system.IUserManager#authUser(me.hys.entity.system.UserEntity
     * )
     */
    @Override
    public ApiResult authUser(UserEntity user) {
        ApiResult apiResult = new ApiResult(ApiStatus.FAILED);
        UserEntity result = findUserLogin(user);
        if (null == result) {
            apiResult.setMsg("账号或密码错误");
            return apiResult;
        }
        if (result.getType() == UserType.ADMIN.getType()) {
            apiResult.setMsg("管理员账户无法登陆");
            return apiResult;
        }
        apiResult.setResult(result.getId());
        apiResult.setMsg("登陆成功");
        return apiResult;
    }

    /**
     * 新增Service
     * @Params:UserEntity
     * @Function:验证登陆的新接口
     */
    @Override
    public ApiResult authDoctor(String mobile) {
        ApiResult apiResult = new ApiResult(ApiStatus.FAILED);
        DoctorEntity result = findDoctorCheck(mobile);
        if (null == result ) {
            apiResult.setMsg("您还未通过审核,请耐心等待");
            return apiResult;
        }
        apiResult.setResult(result.getId());
        apiResult.setMsg("登陆成功");
        return apiResult;
    }

    /*
     * (non-Javadoc)
     *
     * @see me.hys.service.system.IUserManager#changePsw(java.lang.String,
     * java.lang.String, java.lang.String)
     */
    @Override
    public ApiResult changePsw(String userid, String oldPwd, String newPwd) {
        ApiResult apiResult = new ApiResult();
        Map<String, Object> params = Maps.newHashMap();
        params.put("id", userid);
        params.put("oldPwd", MD5Kit.encrypt(oldPwd));
        params.put("newPwd", MD5Kit.encrypt(newPwd));
        if (userMapper.updatePwd(params) == 1) {
            apiResult.setResult(ApiStatus.SUCCESS);
            apiResult.setMsg("密码修改成功");
        } else {
            apiResult.setResult(ApiStatus.FAILED);
            apiResult.setMsg("旧密码错误");
        }
        return apiResult;
    }

    /**
     * 新增Service
    * @Function:重置密码,前端验证码验证
     * @Arguments:String mobile,String newPwd
     *
    * */
    @Override
    public ApiResult resetPwd(String mobile,String newPwd)
    {
        ApiResult apiResult = new ApiResult();
        Map<String, Object> params = Maps.newHashMap();
        params.put("mobile",mobile);
        params.put("newPwd",MD5Kit.encrypt(newPwd));
        if (userMapper.resetPwd(params) == 1) {
            apiResult.setResult(ApiStatus.SUCCESS);
            apiResult.setMsg("重置密码成功");
        } else {
            apiResult.setResult(ApiStatus.FAILED);
            apiResult.setMsg("重置密码失败");
        }
        return apiResult;

    }
    /*
     * (non-Javadoc)
     *
     * @see me.hys.base.IBaseManager#delete(java.lang.String)
     */
    @Override
    public void delete(String id) {
    }

    /*
     * (non-Javadoc)
     *
     * @see me.hys.base.IBaseManager#findByCond(me.hys.base.ConditionValue)
     */
    @Override
    public List<UserEntity> findByCond(Map<String, Object> cond) {
        return userMapper.findByCond(cond);
    }

    /*
     * (non-Javadoc)
     *
     * @see me.hys.base.IBaseManager#findById(java.lang.String)
     */
    @Override
    public UserEntity findById(String id) {
        return userMapper.findById(id);
    }

    /*
     * (non-Javadoc)
     *
     * @see me.hys.service.system.IUserManager#findOneByCond(java.util.Map)
     */
    @Override
    public UserEntity findOneByCond(Map<String, Object> cond) {
        List<UserEntity> list = findByCond(cond);
        return CollectionKit.isNull(list) ? null : list.get(0);
    }

    /*
     * (non-Javadoc)
     *
     * @see me.hys.base.IBaseManager#findAll(java.util.Map)
     */
    @Override
    public PageQuery<UserEntity> findPage(PageQuery<UserEntity> page) {
        page.setList(userMapper.findAll(page.getCondition()));
        page.setTotal(userMapper.findAllCount(page.getCondition()));
        // 总页数
        int size = (int) Math.ceil(page.getTotal() * 1.0f / page.getLimit());
        page.setSize(size);
        return page;
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * me.hys.service.system.IUserManager#findUserLogin(me.hys.entity.system
     * .UserEntity)
     */
    @Override
    public UserEntity findUserLogin(UserEntity entity) {
        List<UserEntity> users = userMapper.findUserLogin(entity);
        return (null != users && users.size() > 0) ? users.get(0) : null;
    }

    /**
     * 新增Service
     * @params DoctorEntity
     * @Function:验证医生用户是否审查通过
     */
    @Override
    public DoctorEntity findDoctorCheck(String mobile) {
        List<DoctorEntity> doctor = userMapper.findDoctorCheck(mobile);
        return (null != doctor && doctor.size() > 0) ? doctor.get(0) : null;
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * me.hys.service.system.IUserManager#improve(me.hys.entity.system.UserEntity
     * )
     */
    @Override
    public int improve(UserEntity user) {
        return userMapper.update(user) > 0 ? ApiStatus.SUCCESS
                : ApiStatus.FAILED;
    }

    /*
     * (non-Javadoc)
     *
     * @see me.hys.base.IBaseManager#saveOrUpdate(java.lang.Object)
     */
    @Override
    public int saveOrUpdate(UserEntity entity) {
        if (entity.getId() > 0) {
            // 需要验证手机号码不重复
            return userMapper.update(entity);
        } else {
            userMapper.save(entity);
            return entity.getId();
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * me.hys.service.system.IUserManager#saveRegister(me.hys.entity.system.
     * UserEntity)
     */
    @Override
    public ApiResult saveRegister(UserEntity entity) {
        ApiResult apiResult = new ApiResult();
        Map<String, Object> cond = Maps.newHashMap();
        cond.put("mobile", entity.getMobile());
        List<UserEntity> users = userMapper.findByCond(cond);
        if (!CollectionKit.isNull(users)) {
            apiResult.setResult(ApiStatus.FAILED);
            apiResult.setMsg("手机号已经存在");
            return apiResult;
        }
        // 设置密码
        entity.setPassword(MD5Kit.encrypt(entity.getPassword()));
        // 设置注册日期
        entity.setRegtime(new Timestamp(System.currentTimeMillis()));
        userMapper.save(entity);
        // 注册环信
        ApiResult result = chatManager.register(entity.getId() + "",
                entity.getMobile(), entity.getNickname());
        if (result.getResult() == ApiStatus.FAILED) {
            return result;
        }
        apiResult.setResult(entity.getId());
        apiResult.setMsg("注册成功");
        return apiResult;
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * me.hys.service.system.IUserManager#update(me.hys.entity.system.UserEntity
     * )
     */
    @Override
    public ApiResult update(UserEntity entity) {
        ApiResult apiResult = new ApiResult(ApiStatus.FAILED, "操作失败");
        if (userMapper.update(entity) > 0) {
            // 不为空，更新环信nickname
            if (!StrKit.isBlank(entity.getNickname())) {
                chatManager.modifyNickname(entity.getId() + "",
                        entity.getNickname());
            }
            apiResult.setResult(ApiStatus.SUCCESS);
            apiResult.setMsg("操作成功");
        }
        return apiResult;
    }
}

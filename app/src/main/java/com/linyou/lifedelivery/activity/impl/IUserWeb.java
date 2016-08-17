package com.linyou.lifedelivery.activity.impl;

import com.linyou.lifedelivery.activity.entity.TouXiang;
import com.linyou.lifedelivery.activity.entity.User;
import com.linyou.lifedelivery.activity.listener.DataListener;

/**
 * Created by Administrator on 2016/7/7 0007.
 */
public interface IUserWeb {

    /**
     * 获取验证码
     * @param phoneNum
     * @param dataListener
     */
    public void getCode(String phoneNum,final DataListener<String> dataListener);

    /**
     * 登陆
     * @param phoneNum
     * @param password
     * @param dataListener
     */
    public void login(String phoneNum, String password,
                      final DataListener<User> dataListener);

    /**
     * 注册
     * @param password
     * @param phoneNum
     * @param phoneCode
     * @param dataListener
     */
    public void register(String password, String phoneNum,
                         String phoneCode,String type,
                         final DataListener<User> dataListener);

    /**
     * 修改用户信息
     * @param id
     * @param nickName
     * @param email
     * @param age
     * @param sex
     * @param dataListener
     */
    public void modifyUserInfo(String id,String nickName,String email,String age,String sex,final DataListener<User> dataListener);
    /**
     * 上传头像
     * @param file
     * @param fileFileName
     * @param userId
     * @param dataListener
     */
    public void uploadHeadPortrait(String file,String fileFileName,String userId,DataListener<TouXiang> dataListener);

    /**
     * 修改密码
     * @param id
     * @param oldPassword
     * @param newPassword
     * @param dataListener
     */
    public void modifyPassword(String id,String oldPassword,String newPassword,DataListener dataListener);
}

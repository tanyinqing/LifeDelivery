package com.linyou.lifedelivery.activity.model;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.linyou.lifedelivery.activity.Constant;
import com.linyou.lifedelivery.activity.ServiceApplication;
import com.linyou.lifedelivery.activity.entity.User;
import com.linyou.lifedelivery.activity.utils.PreferenceUtil;

public class BaseModel {
	
	protected Context mContext;
	
	protected ServiceApplication serviceApplication;//全局 成员变量 成员方法

	//配置文件的初始化
	protected PreferenceUtil mPrefUtil;  //用于配制信息的业务类  继成了各种方法
	
	public BaseModel(Context mContext)
	{
		this.mContext = mContext;
		serviceApplication = ServiceApplication.getInstance();
		mPrefUtil = new PreferenceUtil(mContext, Constant.prefName, Context.MODE_PRIVATE);
	}
	

	public boolean isLogin()//判断是否登录
	{
		User user = serviceApplication.readUser();
		if(null != user)
		{
			return true;
		}
		else
		{
			return true;
		}
	}
	
	protected User getUser()//获取用户
	{
		return serviceApplication.readUser();
	}
	
	/**
	 * 关闭当前activity
	 */
	protected void closeActivity()
	{
		((Activity)mContext).finish();
	}
	
	/**
	 * 跳转到其他activity
	 * @param cls
	 */
	protected void startAcitityByClass(Class cls)
	{
		Intent intent = new Intent();
		intent.setClass(mContext, cls);
		mContext.startActivity(intent);
	}
	
	
}

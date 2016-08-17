package com.linyou.lifedelivery.activity;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.linyou.lifedelivery.activity.entity.DeliveryAddress;
import com.linyou.lifedelivery.activity.entity.District;
import com.linyou.lifedelivery.activity.entity.User;
import com.linyou.lifedelivery.activity.utils.PreferenceUtil;

import java.util.ArrayList;
import java.util.List;

import cn.jpush.android.api.JPushInterface;


		/**************************极光推送代码**************************/
		/***************************************************************/
public class ServiceApplication extends Application {

	private static ServiceApplication instance;
	private static PreferenceUtil mPrefUtil;  //用于配制信息的业务类  继成了各种方法
	private List<Activity> mActivityList;

	private static final String TAG = "JPush";

	@Override
	public void onCreate() {
		Log.d(TAG, "[ExampleApplication] onCreate");
		super.onCreate();

		instance = this;
		mPrefUtil = new PreferenceUtil(this, Constant.prefName, Context.MODE_PRIVATE);
		mActivityList = new ArrayList<Activity>();


		// 初始化极光推送  todo UnsatisfiedLinkError
		JPushInterface.setDebugMode(true);
		JPushInterface.init(this);
		JPushInterface.setAlias(this,"tan", null);
	}


	public static ServiceApplication getInstance() {
		return instance;
	}


	/**
	 * 定义一个方法  来读取配置的信息的值
	 *
	 */
	public static String read_String(String store_id){
		String m=mPrefUtil.getStrSetting(store_id);
		return m;
	}
	/**
	 * 保存用户信息
	 * @param u
	 */
	public void saveUser(User u)
	{
		mPrefUtil.putSetting(Constant.user_pref, u);
		if (null!=u){
			mPrefUtil.putSetting(Constant.user_name,u.getNickName());
		}

	}
	/**
	 * 读取用户信息
	 * @return
	 */
	public User readUser()
	{
		User user = (User) mPrefUtil.readObject(Constant.user_pref);
		return (User) mPrefUtil.readObject(Constant.user_pref);
	}

	/**
	 * 保存服务区域
	 * @param district
	 */
	public void saveDistrict(District district)
	{
		mPrefUtil.putSetting(Constant.district_pref, district);
		if (null!=district) {
			mPrefUtil.putSetting("storeId",district.getId());
			mPrefUtil.putSetting("storeName",district.getName());
			mPrefUtil.putSetting("classlist",district.getClasslist());
		}

	}

	/**
	 * 读取服务区域
	 * @return
	 */
	public District readDistrict()
	{
		return (District) mPrefUtil.readObject(Constant.district_pref);
	}

    /**
     * 最近使用地址
     * @param address
     */
    public void saveAddress(DeliveryAddress address)
    {
        mPrefUtil.putSetting(Constant.address_pref, address);
    }

    public DeliveryAddress readAddress()
    {
        return (DeliveryAddress) mPrefUtil.readObject(Constant.address_pref);
    }
	/**
	 * session信息
	 * @param
	 */
	public void saveSession(String session)
	{
		mPrefUtil.putSetting(Constant.session_pref, session);
	}

	public String readSession()
	{
		return mPrefUtil.getStrSetting(Constant.session_pref);
	}
	/**
	 * 注册和退出Activity
	 * @param
	 */

	public void register(Activity activity)
	{
		mActivityList.add(activity);
	}

	public void exit()
    {
        try {
            for (Activity activity : mActivityList) {
                if (activity != null)
                    activity.finish();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.exit(0);
        }
    }

}

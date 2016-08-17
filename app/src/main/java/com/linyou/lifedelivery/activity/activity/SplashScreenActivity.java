package com.linyou.lifedelivery.activity.activity;

import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.lidroid.xutils.view.annotation.ContentView;
import com.linyou.lifedelivery.R;
import com.linyou.lifedelivery.activity.ServiceApplication;
import com.linyou.lifedelivery.activity.entity.District;
import com.linyou.lifedelivery.activity.utils.PreferenceUtil;
import com.linyou.lifedelivery.activity.utils.UpdateManager;

import cn.jpush.android.api.JPushInterface;

@ContentView(R.layout.activity_splash)
public class SplashScreenActivity extends BaseActivity {

    private String TAG = "SplashScreenActivity";

    private UpdateManager up_banben;

    public static boolean isForeground = false;

    @Override
    void setListeners() {

    }

    @Override
    void initDatas() {

        //在这里完成升级
        //up_banben=new UpdateManager(SplashScreenActivity.this);
       // up_banben.checkUpdate(false);

        new Handler().postDelayed(new Runnable() {
            public void run() {
                District district = ServiceApplication.getInstance().readDistrict();

              /*  if (null == district) {
                    startActivityByClass(DistrictSelectActivity.class);
                } else {
                    startActivityByClass(MainActivityJpush.class);
                }*/
                boolean appFirstUse = PreferenceUtil
                        .getFirstUse(SplashScreenActivity.this);
                if (appFirstUse) {
                  /*  intent.setClass(WelcomeActivity.this, GuideActivity.class);*/
                    startActivityByClass(GuideActivity.class);
                    mPrefUtil.putSetting("firstUse", false);
                } else {
                    /*DBHelper.copyDB(WelcomeActivity.this);
                    intent.setClass(WelcomeActivity.this, MyMainActivity.class);*/
                     if (null == district) {
                    startActivityByClass(DistrictSelectActivity.class);
                } else {
                         // 正式发布前开启
                         startActivityByClass(UserCenterActivity.class);
                }

                }

                finish();
           }
        }, 20);// 延时2秒

    }

    @Override
    void createView() {

    }

    @Override
    protected void onResume() {
        isForeground = true;
        super.onResume();
        JPushInterface.onResume(SplashScreenActivity.this);
    }


    @Override
    protected void onPause() {
        isForeground = false;
        super.onPause();
        JPushInterface.onPause(SplashScreenActivity.this);
    }
}

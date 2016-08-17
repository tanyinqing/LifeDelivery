package com.linyou.lifedelivery.activity.activity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;

import com.lidroid.xutils.ViewUtils;
import com.linyou.lifedelivery.activity.Constant;
import com.linyou.lifedelivery.activity.ServiceApplication;
import com.linyou.lifedelivery.activity.utils.PreferenceUtil;

public abstract class BaseActivity extends FragmentActivity
{
    
	protected Context context;
    protected ServiceApplication application = null;
    //配置文件的初始化
    protected PreferenceUtil mPrefUtil;  //用于配制信息的业务类  继成了各种方法
    
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        application = ServiceApplication.getInstance();
        application.register(this);
        context = this;
        mPrefUtil = new PreferenceUtil(this, Constant.prefName, Context.MODE_PRIVATE);
        ViewUtils.inject(this);

        
        createView();
        
        setListeners();
        
        initDatas();

    }
    
    /**
     * 通过Class启动Activity
     * 
     * @param cls
     */
    protected void startActivityByClass(Class cls)
    {
        Intent intent = new Intent();
        intent.setClass(this, cls);
        startActivity(intent);
    }
    
    /**
     * 设置事件监听
     */
    abstract void setListeners();
    
    /**
     * 初始化设置
     */
    abstract void initDatas();
    
    /**
     * 初始化
     */
    abstract void createView();
    
    @Override
    protected void onStart()
    {
        // TODO Auto-generated method stub
        super.onStart();
    }
    
    @Override
    protected void onResume()
    {
        // TODO Auto-generated method stub
        super.onResume();
    }
    
    @Override
    protected void onPause()
    {
        // TODO Auto-generated method stub
        super.onPause();
    }
    
    @Override
    protected void onStop()
    {
        // TODO Auto-generated method stub
        super.onStop();
    }

    public void p(String msg) {
        if (true) {
            new AlertDialog.Builder(BaseActivity.this).setTitle("测试数据").setMessage(msg).show();
        }
    }

    public  void tt(String msg) {
        if (true) {
            Toast.makeText(BaseActivity.this, msg, Toast.LENGTH_LONG).show();
        }
    }
    
}

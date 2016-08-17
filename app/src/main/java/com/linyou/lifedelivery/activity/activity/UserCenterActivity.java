package com.linyou.lifedelivery.activity.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lidroid.xutils.view.annotation.ContentView;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;
import com.linyou.lifedelivery.R;
import com.linyou.lifedelivery.activity.Constant;
import com.linyou.lifedelivery.activity.customview.CircularImage;
import com.linyou.lifedelivery.activity.entity.District;
import com.linyou.lifedelivery.activity.entity.User;
import com.linyou.lifedelivery.activity.model.UserCenterModel;
import com.linyou.lifedelivery.activity.saomiao.CaptureActivity;
import com.linyou.lifedelivery.activity.utils.PublicUtil;


@ContentView(R.layout.activity_user_center)
public class UserCenterActivity extends TitleBarActivity {

    /**************************注解绑定控件**************************/
    private UserCenterModel mUserCenterModel;

    @ViewInject(R.id.buttonLogin)
    private Button buttonLogin;
    @ViewInject(R.id.buttonRegister)
    private Button buttonRegister;
    @ViewInject(R.id.linearOrderList)  //这个是当日新订单的列表
    private LinearLayout linearOrderList;
    @ViewInject(R.id.linearCollection)  //这个是我接订单的列表
    private LinearLayout linearCollection;
    @ViewInject(R.id.linearAddr)
    private LinearLayout linearAddr; //这个是我本月的历史订单的列表
    @ViewInject(R.id.linearExit)
    private LinearLayout linearExit; //这个是退出
    @ViewInject(R.id.relativeUser)
    private RelativeLayout relativeUser;
    @ViewInject(R.id.relativeLogin)
    private RelativeLayout relativeLogin;
    @ViewInject(R.id.textName)
    private TextView textName;

    @ViewInject(R.id.textAddr)
    private TextView textAddr;
    @ViewInject(R.id.imageHead)
    private CircularImage imageHead;

    /***************************************************************/

    /**************************控件绑定事件**************************/


    @OnClick(R.id.buttonLogin)  //登录页面
    public void login(View view)
    {
        startActivityByClass(LoginAcitvity.class);
    }

    @OnClick(R.id.linearExit)  //退出登录页面
    public void exit(View view)
    {
        mUserCenterModel.exit();
        updateUser();
    }

    @OnClick(R.id.buttonRegister)  //注册页面
    public void register(View view)
    {
        startActivityByClass(RegisterAcitivty.class);
    }

    @OnClick(R.id.relativeUser)    //修改资料页面
    public void userInfo(View view)
    {
        startActivityByClass(UserInfoActivity.class);
    }

    @OnClick(R.id.linearOrderList)  //当日新订单
    public void orderList(View view)
    {
        mPrefUtil.putSetting(Constant.PagerNumber, 1);
        if(!mUserCenterModel.isLogin())
        {
            PublicUtil.ShowToast("请先登录");
            return;
        }
        startActivityByClass(OrderListActivity.class);
    }

    @OnClick(R.id.linearCollection)   //当日我接到的新订单
    public void collectionList(View view)
    {
        mPrefUtil.putSetting(Constant.PagerNumber,2);
        if(!mUserCenterModel.isLogin())
        {
            PublicUtil.ShowToast("请先登录");
            return;
        }
        startActivityByClass(OrderListActivity.class);
    }

    @OnClick(R.id.linearAddr)   //本月历史订单
    public void addrList(View view)
    {
        mPrefUtil.putSetting(Constant.PagerNumber,3);
        if(!mUserCenterModel.isLogin())
        {
            PublicUtil.ShowToast("请先登录");
            return;
        }
        Intent i = new Intent();
        i.setAction(Constant.addr_manage);
        i.setClass(this, OrderListActivity.class);
        startActivity(i);
    }
    /***************************************************************/

    private void updateUser()
    {
        if(mUserCenterModel.isLogin())
        {
            buttonLogin.setVisibility(View.GONE);
            buttonRegister.setVisibility(View.GONE);
            relativeLogin.setVisibility(View.VISIBLE);
            linearExit.setVisibility(View.VISIBLE);

            User u = mUserCenterModel.getUser();
            //String name = u.getNickName();  这是原来的代码
            //这是自己写的代码
            String name = u.getUserName();
            textName.setText("" + ((null == name || "".equals(name))?"匿名":name));
            PublicUtil.getImageLoader().displayImage(Constant.URLBASE + u.getHeadportrait(), imageHead, PublicUtil.getHeadOption());

            District d = mUserCenterModel.getDistrict();
            if(d != null)
            {
                textAddr.setText("常住地："+d.getName());
            }
        }
        else
        {
            buttonLogin.setVisibility(View.VISIBLE);
            buttonRegister.setVisibility(View.VISIBLE);
            relativeLogin.setVisibility(View.GONE);
            linearExit.setVisibility(View.GONE);
        }
    }

   @Override
    void setListeners() {

    }

    @Override
    void initDatas() {
//        setButtonLeft("返回");
        setButtonLeft("选区域");
        /*setButtonLeftHide(); 隐藏左边的按钮*/
        setTitle(R.drawable.title_user_center);
       //setButtonRight("", R.drawable.setting_selector);
       setButtonRight("退出");
        mUserCenterModel = new UserCenterModel(this);
    }


    @Override
    void RightButtonClicked() {
        application.exit();
    }

    @Override
    void LeftButtonClicked() {
        startActivityByClass(DistrictSelectActivity.class);
    }

    @Override
    protected void onResume() {
          updateUser();
        super.onResume();
    }

}

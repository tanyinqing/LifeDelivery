package com.linyou.lifedelivery.activity.activity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.lidroid.xutils.view.annotation.ContentView;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;
import com.linyou.lifedelivery.R;
import com.linyou.lifedelivery.activity.model.LoginModel;

/**
 * Created by Administrator on 2016/7/6 0006.
 */
@ContentView(R.layout.activity_login)
public class LoginAcitvity extends TitleBarActivity{

    /******************************成员变量**************************/
    @ViewInject(R.id.editPhone)
    private EditText editPhone;

    @ViewInject(R.id.editPassword)
    private EditText editPassword;


    @ViewInject(R.id.buttonLogin)
    private Button buttonLogin;

    @ViewInject(R.id.buttonRegister)
    private Button buttonRegister;

    @ViewInject(R.id.textForget)
    private TextView textForget;

    private LoginModel mLoginModel;
    /***************************************************************/

    /******************************控件绑定事件**********************/
    @OnClick(R.id.buttonLogin)
    public void login(View view)
    {
        mLoginModel.login(editPhone.getText().toString(), editPassword.getText().toString());
    }
    @OnClick(R.id.buttonRegister)
    public void register(View view)
    {
        mLoginModel.gotoRegister();
    }

    @OnClick(R.id.textForget)
    public void forgetPwd(View view)
    {
        startActivityByClass(FindPwdActivity.class);
    }
    /***************************************************************/
    @Override
    void setListeners() {

    }

    @Override
    void initDatas() {
        setButtonLeft("返回");
        setTitle(R.drawable.title_logo);
        if(mLoginModel == null)
        {
            mLoginModel = new LoginModel(this);
        }
    }

    @Override
    void RightButtonClicked() {

    }

    @Override
    void LeftButtonClicked() {
    finish();
    }
}

package com.linyou.lifedelivery.activity.model;

import android.content.Context;

import com.linyou.lifedelivery.activity.entity.District;
import com.linyou.lifedelivery.activity.entity.User;

/**
 * Created by Administrator on 2016/6/29 0029.
 */
public class UserCenterModel extends BaseModel {

    public UserCenterModel(Context mContext) {
        super(mContext);
    }
    public boolean isLogin()
    {
        User user = serviceApplication.readUser();
        if(null != user)
        {
            return true;
        }
        else
        {
           // return true;
            return false;
        }
    }

    public User getUser()
    {
        return serviceApplication.readUser();
    }

    public District getDistrict()
    {
        return serviceApplication.readDistrict();
    }

    public void exit()
    {
        serviceApplication.saveUser(null);
    }

}

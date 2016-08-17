package com.linyou.lifedelivery.activity.model;

import android.content.Context;

import com.linyou.lifedelivery.activity.entity.TouXiang;
import com.linyou.lifedelivery.activity.entity.User;
import com.linyou.lifedelivery.activity.listener.DataListener;
import com.linyou.lifedelivery.activity.utils.PublicUtil;
import com.linyou.lifedelivery.activity.web.UserWeb;

/**
 * Created by Administrator on 2016/7/8 0008.
 */
public class UserInfoModel extends BaseModel{
    private UserWeb mUserWeb;

    public UserInfoModel(Context mContext) {
        super(mContext);
        mUserWeb = new UserWeb(mContext);
    }


    public User getUser()
    {
        return serviceApplication.readUser();
    }

    public void uploadHead(String file)
    {
        final User user = serviceApplication.readUser();
        if(null == user)
        {
            PublicUtil.ShowToast("请先登录");
            return;
        }
        mUserWeb.uploadHeadPortrait(file, "tmp.jpg", user.getId(), new DataListener<TouXiang>() {

            @Override
            public void onSuccess(TouXiang data) {
                user.setHeadportrait(data.getWangZhi());
                serviceApplication.saveUser(user);
                PublicUtil.ShowToast("修改头像成功");
            }

        });
    }

    public void modifyUserInfo(String nickName,String sex)
    {
        sex = sex.trim();
//		if(TextUtils.isEmpty(nickName))
//		{
//			PublicUtil.ShowToast("请输入您的昵称");
//			return;
//		}
        if(!"男".equals(sex) && !"女".equals(sex) )
        {
            PublicUtil.ShowToast("请选择性别");
            return;
        }
        User user = serviceApplication.readUser();
        if(null == user)
        {
            PublicUtil.ShowToast("请先登录");
            return;
        }
        if ("男".equals(sex)){
            sex="1";
        }else  if ("女".equals(sex)){
            sex="2";
        }
        mUserWeb.modifyUserInfo(user.getId(),nickName, "dd@fg", "15", sex, new DataListener<User>(){


            @Override
            public void onSuccess(User data) {
                PublicUtil.ShowToast("修改个人信息成功");
                serviceApplication.saveUser(data);
            }
        });
    }
}

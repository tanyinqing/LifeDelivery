package com.linyou.lifedelivery.activity.web;


import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.reflect.TypeToken;
import com.lidroid.xutils.http.RequestParams; //携带参数的类是来自jar包
import com.linyou.lifedelivery.activity.entity.District;
import com.linyou.lifedelivery.activity.impl.ICommonWeb;
import com.linyou.lifedelivery.activity.listener.DataListener;

import android.content.Context;
import android.util.Log;

/**
 *广告、区域相关
 * @author 志强
 *
 */
public class CommonWeb extends BaseWeb implements ICommonWeb {
    private static String CommonUrl = BaseUrl + "/common/";

    private static String FindDistrictUrl = CommonUrl + "findDistrict.do";

    private Context context;
    public CommonWeb(Context context) {
        super(context);
    }

    /**
     * 获取区域列表
     * @param dataListener
     */
    public void findDistrict(final DataListener<List<District>> dataListener)
    {
        //RequestParams就是一个请求是携带的一个数据参数  以键值对的形式
        RequestParams params = new RequestParams();
        post(FindDistrictUrl, params, new IRequestListener() {

            @Override
            public void onFailed() {
				/*
				 //dataListener.onFailed();
				String json="{\"data\":[{\"createTime\":\"2015-02-14T14:41:46\",\"id\":1,\"name\":\"模拟数据\n" +
						"1\"},{\"createTime\":\"2015-02-14T14:41:46\",\"id\":1,\"name\":\"模拟数据2\"}],\"msg\":\"查询成功\n" +
						"！\",\"success\":true}";
				Type type = new TypeToken<List<District>>() {
				}.getType();
				parse(json, type, dataListener);
				 */

            }
            public void onSuccess(String json) {
                String json1=""; //这个是模拟数据
                Type type = new TypeToken<List<District>>() {
                }.getType();
                parse(json, type, dataListener);
            }
        });
    }
}

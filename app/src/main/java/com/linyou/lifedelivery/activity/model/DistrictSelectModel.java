package com.linyou.lifedelivery.activity.model;

import java.util.List;

import android.content.Context;

import com.linyou.lifedelivery.activity.activity.UserCenterActivity;
import com.linyou.lifedelivery.activity.adapter.DistrictAdapter;
import com.linyou.lifedelivery.activity.ceshi.p;
import com.linyou.lifedelivery.activity.entity.District;
import com.linyou.lifedelivery.activity.listener.DataListener;
import com.linyou.lifedelivery.activity.web.CommonWeb;

/**
 * 服务选择
 * @author 志强
 *
 */
public class DistrictSelectModel extends BaseModel{
    private DistrictAdapter mDistrictAdapter;
    private CommonWeb mDistrictWeb;
    private boolean isFirstIn;
    private  Context context;
    public DistrictSelectModel(Context mContext) {
        super(mContext);
        this.context=mContext;
        mDistrictAdapter = new DistrictAdapter(mContext);
        mDistrictWeb = new CommonWeb(mContext);
        isFirstIn = false;
        if( null == serviceApplication.readDistrict() )
        {
            isFirstIn = true;
        }
    }

    public DistrictAdapter getDistrictAdapter()
    {
        return mDistrictAdapter;
    }

    /**
     * 保存中区域
     * @param pos
     */
    public void selectDistrict(int pos)
    {
        serviceApplication.saveDistrict((District)mDistrictAdapter.getItem(pos));
        if (isFirstIn)
        {
            startAcitityByClass(UserCenterActivity.class);
        }
        //这些都是父类中的方法
        closeActivity();
    }

    /**
     * 请求数据
     */
    public void requestDistrict()
    {
        mDistrictWeb.findDistrict(new DataListener<List<District>>(){


            @Override
            public void onSuccess(List<District> data) {
                for(District d:data){
                    //p.dd(context,d.toString());
                    p.L("地址信息的对象", d.toString());
                }
                if(null != data)
                {
                    mDistrictAdapter.appendToListAndClear(data);
                }
            }

            @Override
            public void onFailed(List<District> data) {

            }
        });
    }
}


package com.linyou.lifedelivery.activity.wheel;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import com.linyou.lifedelivery.R;


public class WheelSex
{
    private View view;
    private Context mContext;
    private WheelView wheelViewSex;
    
    private static final String mSex[] = {"男","女"};
    
    public View getView()
    {
        return view;
    }
    
    public WheelSex(Context mContext)
    {
        super();
        this.mContext = mContext;
        setView();
        setSexPicker();
    }
    
    
    private void setView()
    {
        this.view = LayoutInflater.from(mContext).inflate(R.layout.sex_picker, null);
    }
    
    
    ArrayWheelAdapter<String> adapter;
    
   
    
    private void setSexPicker()
    {
        if (wheelViewSex == null)
        {
        	wheelViewSex = (WheelView) view.findViewById(R.id.wv_sex);
        }
        ArrayWheelAdapter<String> adapter = new ArrayWheelAdapter<String>(mContext,mSex);
        wheelViewSex.setViewAdapter(adapter);
        wheelViewSex.setCurrentItem(0);
    }
    
    public String getSex()
    {
        return mSex[wheelViewSex.getCurrentItem()];
    }
}

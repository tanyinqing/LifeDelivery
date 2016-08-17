package com.linyou.lifedelivery.activity.adapter;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.linyou.lifedelivery.R;
import com.linyou.lifedelivery.activity.entity.District;


import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
public class DistrictAdapter  extends AdapterBase<District> {
    public DistrictAdapter(Context mContext) {
        super(mContext);
    }

    @Override
    protected View getExView(int position, View convertView, ViewGroup parent) {
        //getItem�Ǹ����еķ��� �Ӹ����еķ�����õ����� ����������
        District district = (District) getItem(position);
        ViewHolder viewHolder;
        if(convertView == null)
        {
            viewHolder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.district_item,parent, false);
            ViewUtils.inject(viewHolder, convertView);
            convertView.setTag(viewHolder);
        }
        else
        {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.textDistrict.setText(""+district.getName());
        return convertView;
    }

    private static class ViewHolder
    {
        @ViewInject(R.id.textDistrict)
        public TextView textDistrict;
    }
}

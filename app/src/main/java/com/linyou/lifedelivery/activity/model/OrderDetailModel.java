package com.linyou.lifedelivery.activity.model;

import android.content.Context;

import com.linyou.lifedelivery.activity.adapter.OrderGoodsAapater;
import com.linyou.lifedelivery.activity.entity.Order;
import com.linyou.lifedelivery.activity.listener.DataListener;
import com.linyou.lifedelivery.activity.web.OrderWeb;

/**
 * Created by Administrator on 2016/7/5 0005.
 */
public class OrderDetailModel extends BaseModel {
    private OrderWeb mOrderWeb;
    private OrderGoodsAapater mOrderGoodsAapater;
    public OrderDetailModel(Context mContext) {
        super(mContext);
        mOrderWeb = new OrderWeb(mContext);
        mOrderGoodsAapater = new OrderGoodsAapater(mContext);
    }

    public void loadOrder(String order_id,DataListener<Order> listener)
    {
        mOrderWeb.orderDetail(order_id, listener);
    }

    public OrderGoodsAapater getOrderGoodsAapater()
    {
        return mOrderGoodsAapater;
    }

}

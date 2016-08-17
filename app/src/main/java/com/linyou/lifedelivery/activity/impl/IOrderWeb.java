package com.linyou.lifedelivery.activity.impl;

import com.linyou.lifedelivery.activity.entity.Order;
import com.linyou.lifedelivery.activity.listener.DataListener;

import java.util.List;

/**
 * Created by Administrator on 2016/7/8 0008.
 */
public interface IOrderWeb {

    /**
     * 获取订单列表
     * @param listener
     */
    public void queryOrderList(String userId,String limit,String start,final DataListener<List<Order>> listener);

    /**
     * 获取订单详情
     * @param id
     * @param listener
     */
    public void orderDetail(String id,final DataListener<Order> listener);

    /**
     * 获取当日新订单列表
     * @param listener
     */
    public void queryOrderByState(String limit,String start,final DataListener<List<Order>> listener);
}

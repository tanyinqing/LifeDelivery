package com.linyou.lifedelivery.activity.web;

import android.content.Context;
import android.util.Log;

import com.google.gson.reflect.TypeToken;
import com.lidroid.xutils.http.RequestParams;
import com.linyou.lifedelivery.activity.ceshi.PromptManager;
import com.linyou.lifedelivery.activity.ceshi.p;
import com.linyou.lifedelivery.activity.entity.Order;
import com.linyou.lifedelivery.activity.impl.IOrderWeb;
import com.linyou.lifedelivery.activity.listener.DataListener;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by Administrator on 2016/7/25 0025.
 */
public class OrderWeb extends BaseWeb implements IOrderWeb {

    private static String OrderUrl = GuoBaseUrl + "/order/";
    private static String OrderUrl1 = GuoBaseUrl + "/robOrder/";

    //这是新订单的地址
    private static String QueryOrderListUrl = OrderUrl + "queryOrderByState.do";

    //这是抢订单的地址
    private static String GrabOrderUrl =OrderUrl1+"addRobOrder.do";

    //这是修改订单的价格地址
    private static String updateRobOrderPriceUrl =OrderUrl1+"updateRobOrderPrice.do";

     //这是历史订单的地址
    private static String queryRobOrderByHistoryUrl =OrderUrl1+"queryRobOrderByHistory.do";

    //这是完成订单的地址
    private static String updateRobOrderUrl =OrderUrl1+"updateRobOrder.do";

    //这是未完成订单的地址
    private static String queryRobOrderUrl =OrderUrl1+"queryRobOrder.do";

    //查询订单详情
    private static String OrderDetailUrl = OrderUrl + "queryOrderById.do";

    private Context context;


    public OrderWeb(Context context) {
        super(context);
        this.context=context;
    }

    @Override
    public void queryOrderList(String userId, String limit, String start, DataListener<List<Order>> listener) {

    }

    /**
     * 获取订单详情
     * @param id
     * @param listener
     */
    public void orderDetail(String id,final DataListener<Order> listener)
    {
        RequestParams params = new RequestParams();
        params.addBodyParameter("id", id);
        p.L("查询订单详情订单ID",id);
        post(OrderDetailUrl, params, new IRequestListener() {
            @Override
            public void onSuccess(String json) {
                Type type = new TypeToken<Order>() {
                }.getType();
                parse(json, type, listener);
            }

            @Override
            public void onFailed() {
                listener.onFailed();
            }
        });
    }



    /**
     * 新订单
     * @param listener
     */
    public void queryOrderByState(String limit,String start,final DataListener<List<Order>> listener)
    {        
        RequestParams params = new RequestParams();
        params.addBodyParameter("limit", limit);
        params.addBodyParameter("start", start);
        post(QueryOrderListUrl, params, new IRequestListener() {
            @Override
            public void onSuccess(String json) {
                Type type = new TypeToken<List<Order>>(){}.getType();
                parse(json, type, listener);
            }
            @Override
            public void onFailed() {
                listener.onFailed();
            }
        });
    }

    /**
     * 抢订单
     * @param  listener
     */
    public void GrabOrder(String phone,String orderId,String userId,String userName,final DataListener<String> listener) {
        RequestParams params = new RequestParams();
        params.addBodyParameter("orderId", orderId);
        params.addBodyParameter("userName", userName);
        params.addBodyParameter("userId", userId);
        params.addBodyParameter("phone", phone);

        post(GrabOrderUrl, params, new IRequestListener() {
            @Override
            public void onSuccess(String json) {
              /*  Type type = new TypeToken<List<Order>>() {
                }.getType();
                parse(json, type, listener);*/
                parse(json, listener);
            }

            @Override
            public void onFailed() {
                listener.onFailed();
            }
        });
    }


    /**
     * 修改订单价格的方法
     * @param
     */
    public void updateRobOrderPrice(String id, String price,final DataListener<String> dataListener) {
        RequestParams params = new RequestParams();
        params.addBodyParameter("id", id);
        params.addBodyParameter("price", price);

        post(updateRobOrderPriceUrl, params, new IRequestListener() {
            @Override
            public void onSuccess(String json) {
                /*Type type = new TypeToken<List<Order>>() {
                }.getType();
                parse(json, type, dataListener);*/

                parse(json, dataListener);
            }

            @Override
            public void onFailed() {
                dataListener.onFailed();
            }
        });
    }

    /**
     * 历史订单
     * @param listener
     */
    public void queryRobOrderByHistory(String userId,String limit,String start,final DataListener<List<Order>> listener)
    {
        RequestParams params = new RequestParams();
        params.addBodyParameter("limit", limit);
        params.addBodyParameter("start", start);
        params.addBodyParameter("userId", userId);
        Log.d("ByHistory  userId",userId);
        post(queryRobOrderByHistoryUrl, params, new IRequestListener() {
            @Override
            public void onSuccess(String json) {
                Type type = new TypeToken<List<Order>>() {
                }.getType();
                parse(json, type, listener);
            }

            @Override
            public void onFailed() {
                listener.onFailed();
            }
        });
    }

    /**
     * 未完成的订单
     * @param listener
     */
    public void queryRobOrder(String userId,String limit,String start,final DataListener<List<Order>> listener)
    {
        RequestParams params = new RequestParams();
        params.addBodyParameter("limit", limit);
        params.addBodyParameter("start", start);
        params.addBodyParameter("userId", userId);
        post(queryRobOrderUrl, params, new IRequestListener() {
            @Override
            public void onSuccess(String json) {
                Type type = new TypeToken<List<Order>>(){}.getType();
                parse(json, type, listener);
            }
            @Override
            public void onFailed() {
                listener.onFailed();
            }
        });
    }

    /**
     * 本订单配送成功
     * @param
     */
    public void updateRobOrder(String orderId, final DataListener<String> listener) {
        RequestParams params = new RequestParams();
        params.addBodyParameter("orderId", orderId);

        post(updateRobOrderUrl, params, new IRequestListener() {
            @Override
            public void onSuccess(String json) {
                /*Type type = new TypeToken<List<Order>>() {
                }.getType();
                parse(json, type, dataListener);*/

                parse(json, listener);
            }

            @Override
            public void onFailed() {
                listener.onFailed();
            }
        });
    }
}

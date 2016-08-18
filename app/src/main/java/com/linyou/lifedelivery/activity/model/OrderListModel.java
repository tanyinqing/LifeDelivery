package com.linyou.lifedelivery.activity.model;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.util.Log;

import com.linyou.lifedelivery.activity.Constant;
import com.linyou.lifedelivery.activity.activity.OrderDetailActivity;
import com.linyou.lifedelivery.activity.adapter.OrderAdapter;
import com.linyou.lifedelivery.activity.ceshi.p;
import com.linyou.lifedelivery.activity.entity.District;
import com.linyou.lifedelivery.activity.entity.Order;
import com.linyou.lifedelivery.activity.entity.User;
import com.linyou.lifedelivery.activity.listener.DataListener;
import com.linyou.lifedelivery.activity.utils.PublicUtil;
import com.linyou.lifedelivery.activity.web.OrderWeb;

import java.util.List;

/**
 * Created by Administrator on 2016/7/1 0001.
 */
public class OrderListModel extends BaseModel {
    private OrderAdapter mOrderAdapter;
    private OrderWeb mOrderWeb;

    private static int pageNumber=0;//标志变量

    private Handler mHandler;

    private int start;
    private Context context;
    public OrderListModel(Context mContext,Handler mHandler) {
        super(mContext);
        this.context=mContext;
        this.mHandler = mHandler;
        mOrderAdapter = new OrderAdapter(mContext,mHandler);
        mOrderWeb = new OrderWeb(mContext);
        start = 0;

        pageNumber=mPrefUtil.getIntSetting(Constant.PagerNumber);//初始化标志变量
    }

    public OrderAdapter getOrderAdapter() {
        return mOrderAdapter;
    }

    public void refreshOrder(final DataListener listener) {
        if (!isLogin()) {
            PublicUtil.ShowToast("请登陆");
            return;
        }
        User mUser = serviceApplication.readUser();
        District mDistrict = serviceApplication.readDistrict();
        Log.d("服务区域",mDistrict.getName());
        switch (pageNumber){
            case 1:
                mOrderWeb.queryOrderByState(Constant.DEFAULT_LIMIT, "" +0,
                        new DataListener<List<Order>>() {
                            @Override
                            public void onSuccess(List<Order> data) {
                                for(Order good:data){
                                    //p.d(context, good.toString());
                                    p.L("查看数据是否解析成对象", good.toString());
                                }
                                mOrderAdapter.appendToListAndClear(data);
                                if(null != data)
                                {
                                    start = data.size();
                                    mPrefUtil.putSetting(Constant.OrderNumber,start);
                                    mHandler.sendEmptyMessage(2);
                                }
                                listener.onSuccess();
                            }

                            @Override
                            public void onFailed() {
                                listener.onSuccess();
                            }

                        });
                break;
            case 2:
                mOrderWeb.queryRobOrder(mUser.getId(),Constant.DEFAULT_LIMIT, "" +0,
                        new DataListener<List<Order>>() {
                            @Override
                            public void onSuccess(List<Order> data) {
                                for (Order good : data) {
                                    //p.d(context, good.toString());
                                    p.L("查看数据是否解析成对象", good.toString());
                                }
                                mOrderAdapter.appendToListAndClear(data);
                                if (null != data) {
                                    start = data.size();
                                    mPrefUtil.putSetting(Constant.OrderNumber,start);
                                    mHandler.sendEmptyMessage(2);
                                }
                                listener.onSuccess();
                            }

                            @Override
                            public void onFailed() {
                                listener.onSuccess();
                            }

                        });
                break;
            case 3:
                mOrderWeb.queryRobOrderByHistory(mUser.getId(),Constant.DEFAULT_LIMIT, "" +0,
                        new DataListener<List<Order>>() {
                            @Override
                            public void onSuccess(List<Order> data) {
                                for (Order good : data) {
                                    //p.d(context, good.toString());
                                    p.L("查看数据是否解析成对象", good.toString());
                                }
                                mOrderAdapter.appendToListAndClear(data);
                                if (null != data) {
                                    start = data.size();
                                    mPrefUtil.putSetting(Constant.OrderNumber,start);
                                    mHandler.sendEmptyMessage(2);
                                }
                                listener.onSuccess();
                            }

                            @Override
                            public void onFailed() {
                                listener.onSuccess();
                            }

                        });
                break;
               /* mOrderWeb.queryOrderByState(Constant.DEFAULT_LIMIT, "" +5,
                        new DataListener<List<Order>>() {
                            @Override
                            public void onSuccess(List<Order> data) {
                                for(Order good:data){
                                    //p.d(context, good.toString());
                                    p.L("查看数据是否解析成对象", good.toString());
                                }
                                mOrderAdapter.appendToListAndClear(data);
                                if(null != data)
                                {
                                    start = data.size();
                                }
                                listener.onSuccess();
                            }

                            @Override
                            public void onFailed() {
                                listener.onSuccess();
                            }

                        });*/

        }

       /* List<Order> data= GetOrder.getOrderList();
        mOrderAdapter.appendToListAndClear(data);
        if(null != data)
        {
            start = data.size();
        }
        listener.onSuccess();*/
    }

    public void loadMoreOrder(final DataListener listener) {
        if (!isLogin()) {
            PublicUtil.ShowToast("请登陆");
            return;
        }
        User mUser = serviceApplication.readUser();
        switch (pageNumber){
            case 1:
                mOrderWeb.queryOrderByState(Constant.DEFAULT_LIMIT, "" +start,
                        new DataListener<List<Order>>() {
                            @Override
                            public void onSuccess(List<Order> data) {
                                for(Order good:data){
                                    //p.d(context, good.toString());
                                    p.L("查看数据是否解析成对象", good.toString());
                                }
                                mOrderAdapter.appendToList(data);
                                if(null != data)
                                {
                                    start += data.size();
                                    mPrefUtil.putSetting(Constant.OrderNumber,start);
                                    mHandler.sendEmptyMessage(2);
                                }
                                listener.onSuccess();
                            }

                            @Override
                            public void onFailed() {
                                listener.onSuccess();
                            }

                        });
                break;
            case 2:
                mOrderWeb.queryRobOrder(mUser.getId(),Constant.DEFAULT_LIMIT, "" +start,
                        new DataListener<List<Order>>() {
                            @Override
                            public void onSuccess(List<Order> data) {
                                for (Order good : data) {
                                    //p.d(context, good.toString());
                                    p.L("查看数据是否解析成对象", good.toString());
                                }
                                mOrderAdapter.appendToList(data);
                                if (null != data) {
                                    start += data.size();
                                    mPrefUtil.putSetting(Constant.OrderNumber,start);
                                    mHandler.sendEmptyMessage(2);
                                }
                                listener.onSuccess();
                            }

                            @Override
                            public void onFailed() {
                                listener.onSuccess();
                            }

                        });
                break;
            case 3:
                mOrderWeb.queryRobOrderByHistory(mUser.getId(),Constant.DEFAULT_LIMIT, "" +start,
                        new DataListener<List<Order>>() {
                            @Override
                            public void onSuccess(List<Order> data) {
                                for (Order good : data) {
                                    //p.d(context, good.toString());
                                    p.L("查看数据是否解析成对象", good.toString());
                                }
                                mOrderAdapter.appendToList(data);
                                if (null != data) {
                                    start += data.size();
                                    mPrefUtil.putSetting(Constant.OrderNumber,start);
                                    mHandler.sendEmptyMessage(2);
                                }
                                listener.onSuccess();
                            }

                            @Override
                            public void onFailed() {
                                listener.onSuccess();
                            }

                        });
                break;
       /* mOrderWeb.queryOrderList(mUser.getId(), Constant.DEFAULT_LIMIT, "" + start,
                new DataListener<List<Order>>() {
                    @Override
                    public void onSuccess(List<Order> data) {
                        mOrderAdapter.appendToList(data);
                        if(null != data)
                        {
                            start += data.size();
                        }
                        listener.onSuccess();
                    }

                    @Override
                    public void onFailed() {
                        listener.onSuccess();
                    }

                });*/
    }
    }


    public void selectOrder(int position) {
        Intent i = new Intent();
        i.putExtra(Constant.INTENT_ORDER_ID, ((Order)mOrderAdapter.getItem(position)).getId()); //把实体对象传过去
        i.setClass(mContext, OrderDetailActivity.class);
        mContext.startActivity(i);
    }


}

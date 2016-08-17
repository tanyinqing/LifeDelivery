package com.linyou.lifedelivery.activity.activity;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.lidroid.xutils.view.annotation.ContentView;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.linyou.lifedelivery.R;
import com.linyou.lifedelivery.activity.Constant;
import com.linyou.lifedelivery.activity.adapter.OrderGoodsAapater;
import com.linyou.lifedelivery.activity.customview.MyListView;
import com.linyou.lifedelivery.activity.data.GetOrder;
import com.linyou.lifedelivery.activity.entity.DeliveryAddress;
import com.linyou.lifedelivery.activity.entity.Order;
import com.linyou.lifedelivery.activity.entity.OrderMapGoods;
import com.linyou.lifedelivery.activity.entity.PayMethod;
import com.linyou.lifedelivery.activity.listener.DataListener;
import com.linyou.lifedelivery.activity.model.OrderDetailModel;

@ContentView(R.layout.activity_orderdetail)
public class OrderDetailActivity extends TitleBarActivity {

    private String order_id;

    private OrderDetailModel mOrderDetailModel;

    @ViewInject(R.id.textOrderNum)
    private TextView textOrderNum;

    @ViewInject(R.id.textTime)
    private TextView textTime;

    @ViewInject(R.id.textName)
    private TextView textName;

    @ViewInject(R.id.sellerName)
    private TextView sellerName;

    @ViewInject(R.id.textPhone)
    private TextView textPhone;

    @ViewInject(R.id.textAddr)
    private TextView textAddr;

    @ViewInject(R.id.textRemark)
    private TextView textRemark;

    @ViewInject(R.id.textDiscount)
    private TextView textDiscount;

    @ViewInject(R.id.textPayType)
    private TextView textPayType;

    @ViewInject(R.id.textCost)
    private TextView textCost;

    @ViewInject(R.id.textState)
    private TextView textState;

    @ViewInject(R.id.textCount)
    private TextView textCount;

    @ViewInject(R.id.listGoods)
    private MyListView listGoods;

    private PayMethod mPayMethod;

    private OrderGoodsAapater mOrderGoodsAapater;

    @Override
    void setListeners() {
    //这里可以实现的功能是点击订单中的商品列表可以进入到商品详情的界面
    }

    @Override
    void initDatas() {
        setButtonLeft("返回");
        //从这里得到订单的Id号
        order_id = getIntent().getStringExtra(Constant.INTENT_ORDER_ID);
        mPrefUtil.putSetting(Constant.INTENT_ORDER_ID,order_id);
        setTitle(R.drawable.title_order_detail);
        mOrderDetailModel = new OrderDetailModel(this);
         mOrderGoodsAapater = mOrderDetailModel.getOrderGoodsAapater();
        listGoods.setAdapter(mOrderGoodsAapater);
        loadData();
    }

    void loadData()//初始化商品订单的信息  把解析的数据显示处来
    {
        mOrderDetailModel.loadOrder(order_id, new DataListener<Order>() {

            @Override
            public void onSuccess(Order data) {
                DeliveryAddress addr = data.getDeliveryAddress();
                if (null != addr) {
                    textAddr.setText("" + addr.getAddress());
                    textName.setText("" + addr.getReciever());
                    textPhone.setText("" + addr.getRecieverPhone());
                }
                sellerName.setText(data.getGoodsUser());
                mPayMethod = data.getPayMethod();
                if (null != mPayMethod) {
                    textPayType.setText("" + mPayMethod.getName());
                }
                int count = 0;
                for (OrderMapGoods goods : data.getOrderMapGoodsList()) {
                    count += Integer.parseInt(goods.getCount());
                }

                textCount.setText("商品清单：（" + count + "）");
//				textCount.setText("商品清单：（"+data.getOrderMapGoodsList().size()+"）");
                if (!"".equals(data.getOrderCode())) {
                    textOrderNum.setText("" + data.getOrderCode());
                }
//				if (data.getState()!=null){
//					textState.setText(""+data.getState());
//				}
                if (data.getState().equals("10")) {
                    //textState.setText("" + mOrder.getState());
                    textState.setText("订单已提交");
                } else if (data.getState().equals("11")) {
                    textState.setText("等待买家付款");
                } else if (data.getState().equals("20")) {
                    textState.setText("买家已付款，等待卖家发货");
                } else if (data.getState().equals("30")) {
                    textState.setText("卖家已发货");
                } else if (data.getState().equals("40")) {
                    textState.setText("交易成功");
                } else if (data.getState().equals("0")) {
                    textState.setText("交易已取消");
                }
                textCost.setText("" + data.getPrice()); //这个是商品的总价格
                textRemark.setText("" + data.getRemark());
                textDiscount.setText("" + data.getDiscountCode());
                textTime.setText("" + data.getCreateTime().replace("T", " "));
                mOrderGoodsAapater.appendToListAndClear(data.getOrderMapGoodsList());
            }
        });
       /* Order data= GetOrder.getDeliveryAddress();
        DeliveryAddress addr = data.getDeliveryAddress();
        if (null != addr) {
            textAddr.setText("" + addr.getAddress());
            textName.setText("" + addr.getReciever());
            textPhone.setText("" + addr.getRecieverPhone());
        }
        sellerName.setText(data.getGoodsUser());
        mPayMethod = data.getPayMethod();
        if (null != mPayMethod) {
            textPayType.setText("" + mPayMethod.getName());
        }
        int count = 0;
        for (OrderMapGoods goods : data.getOrderMapGoodsList()) {
            count += Integer.parseInt(goods.getCount());
        }

        textCount.setText("商品清单：（" + count + "）");
//				textCount.setText("商品清单：（"+data.getOrderMapGoodsList().size()+"）");
        if (!"".equals(data.getOrderCode())) {
            textOrderNum.setText("" + data.getOrderCode());
        }
//				if (data.getState()!=null){
//					textState.setText(""+data.getState());
//				}
        if (data.getState().equals("10")) {
            //textState.setText("" + mOrder.getState());
            textState.setText("订单已提交");
        } else if (data.getState().equals("11")) {
            textState.setText("等待买家付款");
        } else if (data.getState().equals("20")) {
            textState.setText("买家已付款，等待卖家发货");
        } else if (data.getState().equals("30")) {
            textState.setText("卖家已发货");
        } else if (data.getState().equals("40")) {
            textState.setText("交易成功");
        } else if (data.getState().equals("0")) {
            textState.setText("交易已取消");
        }
        textCost.setText("" + data.getPrice()); //这个是商品的总价格
        textRemark.setText("" + data.getRemark());
        textDiscount.setText("" + data.getDiscountCode());
        textTime.setText("" + data.getCreateTime().replace("T", " "));

        mOrderGoodsAapater.appendToListAndClear(data.getOrderMapGoodsList());*/
    }



    @Override
    void RightButtonClicked() {
        // TODO Auto-generated method stub

    }

    @Override
    void LeftButtonClicked() {
        finish();
    }


}

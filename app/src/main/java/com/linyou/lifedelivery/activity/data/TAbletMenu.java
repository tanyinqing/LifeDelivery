package com.linyou.lifedelivery.activity.data;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.lidroid.xutils.view.annotation.ContentView;
import com.linyou.lifedelivery.R;
import com.linyou.lifedelivery.activity.Constant;
import com.linyou.lifedelivery.activity.ServiceApplication;
import com.linyou.lifedelivery.activity.activity.BaseActivity;
import com.linyou.lifedelivery.activity.activity.OrderDetailActivity;
import com.linyou.lifedelivery.activity.activity.TitleBarActivity;
import com.linyou.lifedelivery.activity.activity.UserCenterActivity;
import com.linyou.lifedelivery.activity.adapter.AdapterBase;
import com.linyou.lifedelivery.activity.adapter.OrderAdapter;
import com.linyou.lifedelivery.activity.model.OrderListModel;


public  class TAbletMenu extends Activity {

        public int a=R.layout.activity_user_center;//这个是主页面的界面
        public int b=R.layout.activity_order_list; //这个是订单列表页面的界面
        public int c=R.layout.order_goods_item; //这个是订单详情适配的布局
        public int d=R.layout.order_item; //这个是订单列表适配的布局

    /**************************所有页面代码**************************/
    public UserCenterActivity userCenterActivity; //这个是订单列表页面的界面
    public OrderDetailActivity mOrderDetailActivity; //这个是订单列表页面的界面
    public TitleBarActivity mTitleBarActivity; //这个是订单列表页面的界面
    public BaseActivity mBaseActivity; //这个是订单列表页面的界面


    /***************************************************************/

    /**************************所有主导器页面代码**************************/
    public OrderListModel orderListModel;//这里实现跳转到订单详情的页面


    /***************************************************************/

    /**************************所有适配器页面代码**************************/
    public OrderAdapter mOrderAdapter;//这是订单详情页面的适配器
    public AdapterBase mAdapterBase;//这是订单详情页面的适配器


    /***************************************************************/

    public GetOrder mGetOrder;//这里实现跳转到订单详情的页面
    public Constant mConstant;//这里实现跳转到订单详情的页面
    public ServiceApplication mServiceApplication;//这里实现跳转到订单详情的页面

}

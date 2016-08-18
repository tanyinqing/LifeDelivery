package com.linyou.lifedelivery.activity.activity;

import android.app.Activity;
import android.content.Intent;
import com.linyou.lifedelivery.activity.saomiao.CaptureActivity;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.InputType;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.ab.view.pullview.AbPullToRefreshView;
import com.lidroid.xutils.view.annotation.ContentView;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;
import com.lidroid.xutils.view.annotation.event.OnItemClick;
import com.linyou.lifedelivery.R;
import com.linyou.lifedelivery.activity.Constant;
import com.linyou.lifedelivery.activity.listener.DataListener;
import com.linyou.lifedelivery.activity.model.OrderListModel;
import com.linyou.lifedelivery.activity.saomiao.CaptureActivity;
import com.linyou.lifedelivery.activity.utils.DateType;
import com.linyou.lifedelivery.activity.utils2.DateUtil;
import com.linyou.lifedelivery.activity.utils.MyDialog;
import com.linyou.lifedelivery.activity.wheel2.WheelView;

import java.text.DecimalFormat;
import java.util.Date;

@ContentView(R.layout.activity_order_list)
public class OrderListActivity extends TitleBarActivity {

    private OrderListModel mOrderListModel;

    private static int pageNumber=0;//标志变量

    @ViewInject(R.id.mPullRefreshView)
    private AbPullToRefreshView mPullRefreshView;

    @ViewInject(R.id.XianTime1)
    private TextView timeText1;

    @ViewInject(R.id.XinEndTime)
    private TextView timeText2;

    @ViewInject(R.id.listOrder)
    private ListView mlistOrder;

    @ViewInject(R.id.OrderNumber)
    private TextView OrderNumber;

    @ViewInject(R.id.XianTime1)
    private TextView start_time;

    @ViewInject(R.id.end_time)
    private TextView end_time;

    @ViewInject(R.id.time_date)
    private LinearLayout time_date;

    /**************************页面交互代码**************************/
    @OnItemClick(R.id.listOrder)
    public void SelectedDistrict(AdapterView<?> parent, View view,
                                 int position, long id) {
        mOrderListModel.selectOrder(position);
    }

    @OnClick(R.id.huli_time_start)
    public void start_time(View view) {
        /*Log.d("dd", "dd");*/
        showDateTimePicker(timeText1);
    }

    @OnClick(R.id.huli_time_end)
    public void end_time(View view) {
        /*Log.d("dd2","dd2");*/
        showDateTimePicker(timeText2);
    }
    /***************************************************************/

    private Handler mHandler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 1:
                    mPullRefreshView.headerRefreshing();
                    break;
                case 2:
                        OrderNumber.setText("合计共有"+mPrefUtil.getIntSetting(Constant.OrderNumber)+"个订单");
                  /* Log.d("订单个数",""+mPrefUtil.getIntSetting(Constant.OrderNumber));
                    Log.d("订单个数", "258");*/
                    break;
                case 3:
                    SaoMiao();
                    break;
            }
        }
    };

    private void SaoMiao(){
        // 扫码操作 扫描条形码
        Intent intent = new Intent(this, CaptureActivity.class);
        startActivityForResult(intent, 0);
        Log.d("测试", "randnumber");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            String randnumber = data.getExtras().getString("result");
            /*String username = etUsername.getText().toString();
            String url = WEB_URL + "saveUsername.php?randnumber=" + randnumber
                    + "&username=" + username;*/
            //访问url
          // etUsername.setText(randnumber);
            Log.d("测试", randnumber+"小票对应的订单号"+mPrefUtil.getStrSetting(Constant.OrderId));
            //HttpUtils.login("https://www.baidu.com/");
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        pageNumber=mPrefUtil.getIntSetting(Constant.PagerNumber);//初始化标志变量
        if (3==pageNumber){
            time_date.setVisibility(View.VISIBLE);
        }
    }

    @Override
    void setListeners() {

        mPullRefreshView.setOnHeaderRefreshListener(new AbPullToRefreshView.OnHeaderRefreshListener() {
            @Override
            public void onHeaderRefresh(final AbPullToRefreshView view) {
                view.onHeaderRefreshFinish();
                mOrderListModel.refreshOrder(new DataListener() {
                    @Override
                    public void onSuccess() {
                        mOrderListModel.refreshOrder(new DataListener() {
                            @Override
                            public void onSuccess() {
                                view.onHeaderRefreshFinish();
                               /* Log.d("订单个数", mPrefUtil.getStrSetting(Constant.OrderNumber));*/
                                // Log.d("订单个数", "258");
                            }
                        });

                    }
                });
            }
        });

        mPullRefreshView.setOnFooterLoadListener(new AbPullToRefreshView.OnFooterLoadListener() {
            @Override
            public void onFooterLoad(final AbPullToRefreshView view) {
                mOrderListModel.loadMoreOrder(new DataListener() {
                    @Override
                    public void onSuccess() {
                        view.onFooterLoadFinish();
                        //Log.d("订单个数", "258");
                    }
                });
            }
        });


    }

    @Override
    void initDatas() {
        setButtonLeft("返回");
        setTitle(R.drawable.title_orders);
        mOrderListModel=new OrderListModel(this,mHandler);
        mlistOrder.setAdapter(mOrderListModel.getOrderAdapter());
        mPullRefreshView.headerRefreshing();

        timeText2.setText(DateUtil.getNowDate(DateUtil.YEAR_MONTH_DAY));
        timeText1.setText(com.linyou.lifedelivery.activity.utils.DateUtil.formatDate(DateUtil.getLongOfFirstDayOfMonth(0)));


    }


    @Override
    void RightButtonClicked() {

    }

    @Override
    void LeftButtonClicked() {
        finish();
    }

  /*  protected void showChooseIconDialog() {
        MyDialog dialog = new MyDialog(this)
                .setTitle(R.string.phone_title)
                *//*.setMessage(R.string.phone_msg)*//*
               *//* .setEditText("dd", InputType.TYPE_TEXT_FLAG_MULTI_LINE,new InputFilter[]{new InputFilter.LengthFilter(20)})
              *//*
                .setDateTimePicker(date, DateType.YEAR_MONTH_DAY);

        dialog.create(null);
        dialog.showMyDialog();
    }*/

    // 弹出日期选择器 yyyy-mm-dd
    private void showDateTimePicker(final TextView timeText) {

        String dateStr = "";
        dateStr = timeText.getText().toString().trim();
        if (dateStr.equals("")) {
            dateStr = "2016-01-01";
        }

        Date date = DateUtil.dateFromString(dateStr, DateUtil.YEAR_MONTH_DAY);
        MyDialog dialog = new MyDialog(context).setTitle(R.string.check_time)
                .setDateTimePicker(date, DateType.YEAR_MONTH_DAY)
                .setNegativeButton(R.string.cancel, new View.OnClickListener() {

                    @Override
                    public void onClick(View arg0) {

                    }
                }).setPositiveButton(R.string.ok, new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        // 如果是个数,则显示为"02"的样式
                        WheelView wv_year = (WheelView) v
                                .findViewById(R.id.year);
                        WheelView wv_month = (WheelView) v
                                .findViewById(R.id.month);
                        WheelView wv_day = (WheelView) v.findViewById(R.id.day);

                        String parten = "00";
                        DecimalFormat decimal = new DecimalFormat(parten);
                        // 设置日期的显示
                        String text = (wv_year.getCurrentItem() + MyDialog.START_YEAR)
                                + "-"
                                + decimal.format((wv_month.getCurrentItem() + 1))
                                + "-"
                                + decimal.format((wv_day.getCurrentItem() + 1));
                       // timeText.setBackgroundColor(R.color.transparent);
                        timeText.setText(text);
                    }
                });

        dialog.create(null).show();
    }
}

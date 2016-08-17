package com.linyou.lifedelivery.activity.adapter;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.text.InputFilter;
import android.text.InputType;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;
import com.linyou.lifedelivery.R;
import com.linyou.lifedelivery.activity.Constant;
import com.linyou.lifedelivery.activity.entity.Order;
import com.linyou.lifedelivery.activity.entity.OrderMapGoods;
import com.linyou.lifedelivery.activity.entity.User;
import com.linyou.lifedelivery.activity.listener.DataListener;
import com.linyou.lifedelivery.activity.utils.DensityUtil;
import com.linyou.lifedelivery.activity.utils.MyDialog;
import com.linyou.lifedelivery.activity.utils.PublicUtil;
import com.linyou.lifedelivery.activity.web.OrderWeb;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * Created by Administrator on 2016/7/1 0001.
 */
public class OrderAdapter extends AdapterBase<Order> {

    private static LinearLayout.LayoutParams imageParam;
    private static Context mContext;
    private static OrderWeb mOrderWeb;
    private static OrderAdapter mOrderAdapter;

    private static ImageLoader imageLoader;

    private static int pageNumber=0;//标志变量

    private static String money;//修改之后的价格

    private static Handler mHandler;

    public OrderAdapter(Context baseContext,Handler mHandler) {
        super(baseContext);
        mContext = baseContext;
        this.mHandler = mHandler;
        mOrderAdapter = this;
        int len = DensityUtil.dip2px(baseContext, 80);
        imageParam = new LinearLayout.LayoutParams(len, len, 1);
        imageParam.setMargins(5,5,5,5);
        mOrderWeb = new OrderWeb(baseContext);
        imageLoader = PublicUtil.getImageLoader();
        pageNumber=mPrefUtil.getIntSetting(Constant.PagerNumber);
    }

    @Override
    protected View getExView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        Order mOrder = (Order) getItem(position);

        Log.d("查看当订单的详情", mOrder.toString());
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.order_item, null);
            ViewUtils.inject(holder, convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.update(mOrder);
        return convertView;
    }

    private static class ViewHolder {
        @ViewInject(R.id.textOrderNum)
        TextView textOrderNum;
        @ViewInject(R.id.textTime)
        TextView textTime;
        @ViewInject(R.id.textState)
        TextView textState;
        @ViewInject(R.id.linearImages)
        LinearLayout linearImages;
        @ViewInject(R.id.textMoney)
        TextView textMoney;

        @ViewInject(R.id.buttonMod)
        Button buttonMod;
        @ViewInject(R.id.ShuRuXiaoPiao)
        LinearLayout ShuRuXiaoPiao;
        @ViewInject(R.id.btnScan)
        private Button btnScan;
        @ViewInject(R.id.etUsername)
        private TextView etUsername;

        @ViewInject(R.id.buttonControl)
        Button buttonControl;
        @ViewInject(R.id.buttonGrab)
        Button buttonGrab;
        @ViewInject(R.id.buttonCom)
        Button buttonCom;
        Order mOrder;

        void update(Order mOrder) {
            this.mOrder = mOrder;

            List<OrderMapGoods> list = mOrder.getOrderMapGoodsList();

           switch (pageNumber){

                case 1:
                    buttonGrab.setVisibility(View.VISIBLE);
                    Log.d("1",String.valueOf(pageNumber));
                    break;
                case 2:
                     buttonMod.setVisibility(View.VISIBLE);
                    buttonControl.setVisibility(View.VISIBLE);
                    ShuRuXiaoPiao.setVisibility(View.VISIBLE);
                    Log.d("2",String.valueOf(pageNumber));
                    break;
                case 3:
                    buttonCom.setVisibility(View.VISIBLE);
                    Log.d("3",String.valueOf(pageNumber));
                    break;
            }

            ImageView imageView;
            if (list != null) {
                linearImages.removeAllViews();
                for (int i = 0; i < 4; i++) {
                    imageView = new ImageView(mContext);
                    imageView.setLayoutParams(imageParam);
                    linearImages.addView(imageView);
                }
                int size = mOrder.getOrderMapGoodsList().size();
                size = size > 4 ? 4 : size;
                list = mOrder.getOrderMapGoodsList().subList(0, size);
                for (int i = 0; i < size; i++) {
                    imageView = (ImageView) linearImages.getChildAt(i);
                    //List<GoodsImage> pics = list.get(i).getGoods().getPicList();
                    String pic=list.get(i).getGoods().getPic();
                    //if(null != pics && pics.size() > 0)
                    if(null != pic && !pic.equals(""))
                    {
                        //imageLoader.displayImage(Constant.URLBASE+pics.get(0).getPic(), imageView,PublicUtil.getGoodsOption());
                        imageLoader.displayImage(Constant.URLBASE+pic, imageView,PublicUtil.getGoodsOption());
                    }
                    else
                    {
                        imageView.setImageResource(R.drawable.default_goods);
                    }
                }
            }

            if (!"".equals(mOrder.getOrderCode())){
                textOrderNum.setText("" + mOrder.getOrderCode());
            }
            textMoney.setText("￥" + PublicUtil.priceFormat(mOrder.getPrice()));
            //订单会以数字的格式返回  所以判断不同的状态
            if (mOrder.getState().equals("10")){
                //textState.setText("" + mOrder.getState());
                textState.setText("订单已提交");
            }else if (mOrder.getState().equals("11")){
                textState.setText("等待买家付款");
            }else if (mOrder.getState().equals("20")){
                textState.setText("买家已付款，等待卖家发货");
            }else if (mOrder.getState().equals("30")){
                textState.setText("卖家已发货");
            }else if (mOrder.getState().equals("40")){
                textState.setText("交易成功");
            }else if (mOrder.getState().equals("0")){
                textState.setText("交易已取消");
            }

            textTime.setText("" + mOrder.getCreateTime().replace("T", " "));


        }

        //订单价格修改对应的点击事件
        @OnClick(R.id.buttonMod)
        void buttonModClick(View v) {

           /* AlertDialog.Builder builder=new AlertDialog.Builder(mContext);
            builder.setMessage("请输入价格:");
            builder.setTitle("请输入价格：");
            builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            });
            builder.create().show();*/

            /*LayoutInflater factory = LayoutInflater.from(mContext);
            final View textEntryView = factory.inflate(R.layout.alert_dialog_text_entry, null);
             new AlertDialog.Builder(mContext)
                    .setIconAttribute(android.R.attr.alertDialogIcon)
                    .setTitle(R.string.alert_dialog_text_entry)
                    .setView(textEntryView)
                    .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int whichButton) {

                        *//* User clicked OK so do some stuff *//*
                        }
                    })
                    .setNegativeButton(R.string.alert_dialog_cancel, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int whichButton) {

                        *//* User clicked cancel so do some stuff *//*
                        }
                    }).create();*/


            /*  没统一风格前的弹出框
            LayoutInflater factory = LayoutInflater.from(mContext);
            final View textEntryView = factory.inflate(R.layout.alert_dialog_text_entry, null);
            final EditText mEditText=(EditText)textEntryView.findViewById(R.id.password_edit);
            Dialog dialog=new AlertDialog.Builder(mContext)
                    //.setIconAttribute(android.R.attr.alertDialogIcon)
                    //.setTitle("ddss")
                    .setView(textEntryView)
                    .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int whichButton) {
                            money=mEditText.getText().toString();

                            mOrderWeb.updateRobOrderPrice(mOrder.getId(), money, new DataListener<String>() {

                                @Override
                                public void onSuccess(String data) {
                                    PublicUtil.ShowToast(data);
                                    //textMoney.setText(money);
                                    // mOrderAdapter.removeItem(mOrder);
                                    // mOrderAdapter.notifyDataSetChanged();
                                     mHandler.sendEmptyMessage(1);
                                }

                            });

                        }
                    })
                    .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int whichButton) {

                        *//* User clicked cancel so do some stuff *//*
                        }
                    })
                    .create();

            dialog.show();*/
            //PublicUtil.ShowToast("订单价格修改成功");

            final MyDialog dialog = new MyDialog(mContext);
              dialog.setTitle(R.string.good_price)
                    .setEditText("", InputType.TYPE_TEXT_FLAG_MULTI_LINE, new InputFilter[]{new InputFilter.LengthFilter(20)})
                    .setNegativeButton(R.string.cancel, new View.OnClickListener() {

                        @Override
                        public void onClick(View arg0) {

                        }
                    }).setPositiveButton(R.string.ok, new View.OnClickListener() {

                        @Override
                        public void onClick(View v) {
                           // money=mEditText.getText().toString();
                            money=dialog.getCurrentEditText().getText().toString();
                            mOrderWeb.updateRobOrderPrice(mOrder.getId(), money, new DataListener<String>() {

                                @Override
                                public void onSuccess(String data) {
                                    PublicUtil.ShowToast(data);
                                    //textMoney.setText(money);
                                    // mOrderAdapter.removeItem(mOrder);
                                    // mOrderAdapter.notifyDataSetChanged();
                                    mHandler.sendEmptyMessage(1);
                                }

                            });
                    }
                    });

            dialog.create(null).show();
                        }

        //扫描小票号的点击事件
        @OnClick(R.id.btnScan)
        public void SaoMiao(View view)
        {
            mHandler.sendEmptyMessage(3);

        }

                        //本订单配送成功
                        @OnClick(R.id.buttonControl)
                        void buttonControlClick(View v) {
                            mOrderWeb.updateRobOrder(mOrder.getId(), new DataListener<String>() {

                                @Override
                                public void onSuccess(String data) {
                                    PublicUtil.ShowToast(data);
                                    mOrderAdapter.removeItem(mOrder);
                                }

                            });
                            // PublicUtil.ShowToast("本订单配送成功");
                        }


                        //抢单对应的点击事件
                        @OnClick(R.id.buttonGrab)
                        void buttonGrabClick(View v) {

                            User mUser = serviceApplication.readUser();

                            mOrderWeb.GrabOrder(mUser.getPhoneNum(), mOrder.getId(), mUser.getId(), mUser.getUserName(), new DataListener<String>() {

                                @Override
                                public void onSuccess(String data) {
                                    //PublicUtil.ShowToast("删除订单成功");
                                    PublicUtil.ShowToast(data);
                                    mOrderAdapter.removeItem(mOrder);
                                }

                            });
                            //PublicUtil.ShowToast("点击按钮  抢单成功");
                        }

                        @OnClick(R.id.buttonComment)
                        void buttonCommentClick(View v) {
           /* mOrderWeb.deleteOrder(mOrder.getId(), new DataListener() {

                @Override
                public void onSuccess() {
                    PublicUtil.ShowToast("删除订单成功");
                    mOrderAdapter.removeItem(mOrder);
                }

            });*/
                            PublicUtil.ShowToast("删除订单成功");
                        }
                    }
        }

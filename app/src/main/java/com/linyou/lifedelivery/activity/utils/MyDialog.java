package com.linyou.lifedelivery.activity.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.Html;
import android.text.InputFilter;
import android.text.InputType;
import android.text.method.LinkMovementMethod;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.linyou.lifedelivery.R;
import com.linyou.lifedelivery.activity.wheel2.NumericWheelAdapter;
import com.linyou.lifedelivery.activity.wheel2.OnWheelChangedListener;
import com.linyou.lifedelivery.activity.wheel2.WheelView;

/**
 * Created by Administrator on 2016/7/28 0028.
 */
public class MyDialog {
    public static final int START_YEAR = 1900;

    private boolean clickDismiss = true;

    public boolean isClickDismiss() {
        return clickDismiss;
    }

    public void setClickDismiss(boolean clickDismiss) {
        this.clickDismiss = clickDismiss;
    }

    private Context mContext;
    private View dialogView;
    private Dialog mDialog;
    private int width;
    private int height;
    private ProgressBar progressBar;
    private TextView progressText;

    @SuppressLint("InflateParams")
    @SuppressWarnings("deprecation")
    public MyDialog(Context context) {
        mContext = context;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        dialogView = inflater.inflate(R.layout.my_dialog, null);
        int w1 = ((android.app.Activity) mContext).getWindowManager()
                .getDefaultDisplay().getWidth();
        int w2 = ((android.app.Activity) mContext).getWindowManager()
                .getDefaultDisplay().getHeight();
        width = (int) (Math.min(w1, w2) * 0.8);
    }

    public View getView() {
        return dialogView;
    }

    public Dialog create(final OnClickListener backPressed) {
        mDialog = new Dialog(mContext, R.style.MyDialog) {
            @Override
            public boolean onKeyDown(int keyCode, KeyEvent event) {
                if (backPressed != null) {
                    backPressed.onClick(null);
                    return true;
                }

                return super.onKeyDown(keyCode, event);
            }
        };
        initStyle();
        mDialog.setContentView(dialogView);
        LayoutParams params = mDialog.getWindow().getAttributes();
        params.width = width;
        if (height > 0)
            params.height = height;
        mDialog.setContentView(dialogView, params);
        setCanceledOnTouchOutside(true);
        return mDialog;
    }

    public MyDialog setCanceledOnTouchOutside(boolean cancel) {
        if (mDialog != null)
            mDialog.setCanceledOnTouchOutside(cancel);

        return this;
    }

    private void initStyle() {

        // Button button1 = (Button)
        // (dialogView.findViewById(R.id.DialogButton1));
        // Button button2 = (Button)
        // (dialogView.findViewById(R.id.DialogButton2));
        // ImageView middleDivider = (ImageView) dialogView
        // .findViewById(R.id.DialogButtonDivider);
        //
        // if (button1.getVisibility() == View.VISIBLE
        // && button2.getVisibility() == View.VISIBLE) {
        // middleDivider.setVisibility(View.VISIBLE);
        // } else {
        // middleDivider.setVisibility(View.GONE);
        // }
    }

    public void showMyDialog() {
        if (mDialog != null) {
            mDialog.show();
        }
    }

    @SuppressWarnings("deprecation")
    public MyDialog setDialogCustomWidthHeight() {

        if (mDialog != null) {
            int w1 = ((android.app.Activity) mContext).getWindowManager()
                    .getDefaultDisplay().getWidth();
            int w2 = ((android.app.Activity) mContext).getWindowManager()
                    .getDefaultDisplay().getHeight();
            int ww = (int) (Math.min(w1, w2) * 0.8);
            int hh = (int) (Math.max(w1, w2) * 0.8);
            mDialog.getWindow().setLayout(ww, hh);
            mDialog.getWindow().setBackgroundDrawableResource(R.drawable.trans_bg);
        }

        return this;
    }

    public MyDialog setTitle(int resId) {
        TextView title = (TextView) (dialogView
                .findViewById(R.id.DialogTitleText));
        title.setText(resId);
        title.setVisibility(View.VISIBLE);
        dialogView.findViewById(R.id.DialogTitle).setVisibility(View.VISIBLE);
        return this;
    }
    public MyDialog setMessage(int resId) {
        TextView text = (TextView) (dialogView
                .findViewById(R.id.DialogContentText));
        text.setText(resId);
        text.setVisibility(View.VISIBLE);
        return this;
    }

    public MyDialog setEditText(String text, int inputType,
                                InputFilter[] filters) {
        final EditText editText = (EditText) (dialogView
                .findViewById(R.id.DialogContentEditText));
        editText.setVisibility(View.VISIBLE);
        editText.setText(text);
        editText.setInputType(inputType);
        if (inputType == InputType.TYPE_TEXT_FLAG_MULTI_LINE) {
            editText.setGravity(Gravity.TOP);
            editText.setSingleLine(false);
            editText.setHorizontallyScrolling(false);
        }
        editText.setFilters(filters);
        editText.setSelection(text.length());
        editText.postDelayed(new Runnable() {
            @Override
            public void run() {
                editText.requestFocus();
                ((InputMethodManager) editText.getContext().getSystemService(
                        Context.INPUT_METHOD_SERVICE)).showSoftInput(editText,
                        InputMethodManager.SHOW_FORCED);
            }
        }, 50);

        return this;
    }

    public MyDialog setDateTimePicker(Date date, DateType type) {
        LinearLayout timeLayout = (LinearLayout) (dialogView
                .findViewById(R.id.DialogDateTimePicker));
        timeLayout.setVisibility(View.VISIBLE);

        int year = 0;
        int month = 0;
        int day = 0;

        Calendar calendar = Calendar.getInstance();
        int currentYear = calendar.get(Calendar.YEAR);

        if (date != null)
            calendar.setTime(date);

        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        if (type == DateType.YEAR_MONTH_DAY) {
            day = calendar.get(Calendar.DATE);
        }

        // 添加大小月月份并将其转换为list,方便之后的判断
        String[] months_big = { "1", "3", "5", "7", "8", "10", "12" };
        String[] months_little = { "4", "6", "9", "11" };

        final List<String> list_big = Arrays.asList(months_big);
        final List<String> list_little = Arrays.asList(months_little);

        // 年
        final WheelView wv_year = (WheelView) dialogView
                .findViewById(R.id.year);
        wv_year.setAdapter(new NumericWheelAdapter(START_YEAR, currentYear));// 设置"年"的显示数据
        wv_year.setCyclic(true);// 可循环滚动
        wv_year.setLabel("年");// 添加文字
        wv_year.setCurrentItem(year - START_YEAR);// 初始化时显示的数据

        // 月
        final WheelView wv_month = (WheelView) dialogView
                .findViewById(R.id.month);
        wv_month.setAdapter(new NumericWheelAdapter(1, 12));
        wv_month.setCyclic(true);
        wv_month.setLabel("月");
        wv_month.setCurrentItem(month);

        // 日
        final WheelView wv_day = (WheelView) dialogView.findViewById(R.id.day);
        wv_day.setCyclic(true);
        // 判断大小月及是否闰年,用来确定"日"的数据
        if (list_big.contains(String.valueOf(month + 1))) {
            wv_day.setAdapter(new NumericWheelAdapter(1, 31));
        } else if (list_little.contains(String.valueOf(month + 1))) {
            wv_day.setAdapter(new NumericWheelAdapter(1, 30));
        } else {
            // 闰年
            if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)
                wv_day.setAdapter(new NumericWheelAdapter(1, 29));
            else
                wv_day.setAdapter(new NumericWheelAdapter(1, 28));
        }
        wv_day.setLabel("日");
        wv_day.setCurrentItem(day - 1);

        // 添加"年"监听
        OnWheelChangedListener wheelListener_year = new OnWheelChangedListener() {
            public void onChanged(WheelView wheel, int oldValue, int newValue) {
                int year_num = newValue + START_YEAR;
                // 判断大小月及是否闰年,用来确定"日"的数据
                if (list_big
                        .contains(String.valueOf(wv_month.getCurrentItem() + 1))) {
                    wv_day.setAdapter(new NumericWheelAdapter(1, 31));
                } else if (list_little.contains(String.valueOf(wv_month
                        .getCurrentItem() + 1))) {
                    wv_day.setAdapter(new NumericWheelAdapter(1, 30));
                } else {
                    if ((year_num % 4 == 0 && year_num % 100 != 0)
                            || year_num % 400 == 0)
                        wv_day.setAdapter(new NumericWheelAdapter(1, 29));
                    else
                        wv_day.setAdapter(new NumericWheelAdapter(1, 28));
                }
            }
        };
        // 添加"月"监听
        OnWheelChangedListener wheelListener_month = new OnWheelChangedListener() {
            public void onChanged(WheelView wheel, int oldValue, int newValue) {
                int month_num = newValue + 1;
                // 判断大小月及是否闰年,用来确定"日"的数据
                if (list_big.contains(String.valueOf(month_num))) {
                    wv_day.setAdapter(new NumericWheelAdapter(1, 31));
                } else if (list_little.contains(String.valueOf(month_num))) {
                    wv_day.setAdapter(new NumericWheelAdapter(1, 30));
                } else {
                    if (((wv_year.getCurrentItem() + START_YEAR) % 4 == 0 && (wv_year
                            .getCurrentItem() + START_YEAR) % 100 != 0)
                            || (wv_year.getCurrentItem() + START_YEAR) % 400 == 0)
                        wv_day.setAdapter(new NumericWheelAdapter(1, 29));
                    else
                        wv_day.setAdapter(new NumericWheelAdapter(1, 28));
                }
            }
        };
        wv_year.addChangingListener(wheelListener_year);
        wv_month.addChangingListener(wheelListener_month);

        // 显示的是 年月日 还是 年月
        if (type == DateType.YEAR_MONTH_DAY) {
            wv_day.setVisibility(View.VISIBLE);
        } else {
            wv_day.setVisibility(View.GONE);
        }

        // 根据屏幕密度来指定选择器字体的大小
        int textSize = 0;

        textSize = 50;

        wv_day.TEXT_SIZE = textSize;
        wv_month.TEXT_SIZE = textSize;
        wv_year.TEXT_SIZE = textSize;

        return this;
    }

    public MyDialog setNegativeButton(int resId, final OnClickListener listener) {
        Button button = (Button) (dialogView.findViewById(R.id.DialogButton1));
        button.setText(resId);
        button.setVisibility(View.VISIBLE);
        dialogView.findViewById(R.id.DialogButton).setVisibility(View.VISIBLE);
        button.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                if (listener != null)
                    listener.onClick(dialogView);

                hideEditTextSofeBoard();

                if (mDialog != null && clickDismiss)
                    mDialog.dismiss();
            }
        });
        return this;
    }

    public MyDialog setPositiveButton(int resId, final OnClickListener listener) {
        Button button = (Button) (dialogView.findViewById(R.id.DialogButton2));
        button.setText(resId);
        button.setVisibility(View.VISIBLE);
        dialogView.findViewById(R.id.DialogButton).setVisibility(View.VISIBLE);
        button.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                if (listener != null)
                    listener.onClick(dialogView);

                hideEditTextSofeBoard();

                if (mDialog != null  && clickDismiss)
                    mDialog.dismiss();

            }
        });
        return this;
    }

    private void hideEditTextSofeBoard() {
        EditText editText = (EditText) dialogView
                .findViewById(R.id.DialogContentEditText);
        if (editText != null && editText.getVisibility() == View.VISIBLE) {
            editText.clearFocus();
            ((InputMethodManager) editText.getContext().getSystemService(
                    Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(
                    editText.getWindowToken(), 0);
        }
    }

    public EditText getCurrentEditText() {
        EditText editText = (EditText) (dialogView
                .findViewById(R.id.DialogContentEditText));
        return editText;
    }
}

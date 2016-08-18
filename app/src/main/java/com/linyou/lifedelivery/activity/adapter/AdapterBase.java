package com.linyou.lifedelivery.activity.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.linyou.lifedelivery.activity.Constant;
import com.linyou.lifedelivery.activity.ServiceApplication;
import com.linyou.lifedelivery.activity.utils.PreferenceUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/7/1 0001.
 */
public abstract class AdapterBase<T> extends BaseAdapter {

    /*
      但对于一些容器类型（比如，ArrayList、HashMap）的实例变量，
    不可以改变容器变量本身，但可以修改容器中存放的对象，这一点在编程中用到很多
     */
    public final List<T> mList = new ArrayList<T>();
    public Context context;
    public LayoutInflater mInflater;
    public static PreferenceUtil mPrefUtil;
    protected static ServiceApplication serviceApplication;//全局 成员变量 成员方法

    public AdapterBase(Context baseContext)
    {
        this.context = baseContext;
        mInflater = LayoutInflater.from(baseContext);
        mPrefUtil = new PreferenceUtil(baseContext, Constant.prefName, Context.MODE_PRIVATE);
        serviceApplication = ServiceApplication.getInstance();

    }

    public List<T> getList()
    {
        return mList;
    }

    public void appendToList(T t)
    {
        if (t == null)
        {
            return;
        }
        mList.add(t);
        notifyDataSetChanged();
    }

    public void appendToList(List<T> list)
    {
        if (list == null)
        {
            return;
        }
        mList.addAll(list);
        notifyDataSetChanged();
    }

    public void appendToListAndClear(List<T> list)
    {
        mList.clear();
        this.appendToList(list);
    }

    public void appendToTopList(List<T> list)
    {
        if (list == null)
        {
            return;
        }
        mList.addAll(0, list);
        notifyDataSetChanged();
    }

    public void clear()
    {
        mList.clear();
        notifyDataSetChanged();
    }

    @Override
    public int getCount()
    {
        return mList.size();
    }

    @Override
    public Object getItem(int position)
    {
        if (position > mList.size() - 1)
        {
            return null;
        }
        return mList.get(position);
    }

    public void removeItem(int position)
    {
        if (position >= 0 && position < mList.size())
        {
            mList.remove(position);
            notifyDataSetChanged();
        }
    }

    public void removeItem(T item)
    {
        if (mList.contains(item))
        {
            mList.remove(item);
            notifyDataSetChanged();
        }
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        return getExView(position, convertView, parent);
    }
    //abstract加入这个关键词表示是抽象的方法，子类中必须进行重写这个方法

    protected abstract View getExView(int position, View convertView, ViewGroup parent);

    
}

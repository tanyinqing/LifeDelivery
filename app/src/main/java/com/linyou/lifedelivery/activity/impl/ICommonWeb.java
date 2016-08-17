package com.linyou.lifedelivery.activity.impl;

import com.linyou.lifedelivery.activity.entity.District;
import com.linyou.lifedelivery.activity.listener.DataListener;

import java.util.List;

/**
 * Created by Administrator on 2016/8/15 0015.
 */
public interface ICommonWeb {
    /**
     * 获取区域列表
     * @param dataListener
     */
    public void findDistrict(final DataListener<List<District>> dataListener);
}

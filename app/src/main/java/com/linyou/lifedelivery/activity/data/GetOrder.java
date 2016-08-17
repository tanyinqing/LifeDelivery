package com.linyou.lifedelivery.activity.data;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lidroid.xutils.http.RequestParams;
import com.linyou.lifedelivery.activity.ServiceApplication;
import com.linyou.lifedelivery.activity.ceshi.PromptManager;
import com.linyou.lifedelivery.activity.ceshi.p;
import com.linyou.lifedelivery.activity.entity.DeliveryAddress;
import com.linyou.lifedelivery.activity.entity.Order;
import com.linyou.lifedelivery.activity.listener.DataListener;
import com.linyou.lifedelivery.activity.utils.PublicUtil;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/6/29 0029.
 */
public class GetOrder {

     public static String  order="{\"data\":[{\"addTime\":1452212902,\"anonymous\":0,\"buyerEmail\":\"81438763@qq.com\",\"buyerId\":84,\"buyerName\":\"damselfly\",\"deliveryAddressId\":0,\"discount\":0,\"discountCode\":\"\",\"evaluationStatus\":false,\"evaluationTime\":0,\"extension\":\"normal\",\"finishedTime\":0,\"goodsAmount\":26,\"invoiceNo\":\"1600710051\",\"isPrint\":0,\"jkNote\":\"一包kent爆珠\",\"jkPrint\":1,\"orderAmount\":26,\"orderCode\":\"\",\"orderId\":4941,\"orderSn\":\"1600710051\",\"outTradeSn\":\"\",\"payAlter\":true,\"payMessage\":\"\",\"payTime\":1452462705,\"paymentCode\":\"\",\"paymentId\":0,\"paymentName\":\"\",\"postscript\":\"\",\"remark\":\"\",\"sellerId\":10,\"sellerName\":\"天鹅湖、棕榈泉公寓\",\"shipTime\":1452462713,\"status\":30,\"type\":\"material\",\"orderMapGoodsList\":[{\"comment\":\"\",\"creditValue\":false,\"evaluation\":false,\"goodsId\":770,\"goodsImage\":\"data/files/store_10/goods_141/small_201408082259019277.jpg\",\"goodsName\":\"农夫山泉 饮用天然水 1.5L/瓶\",\"hidden\":0,\"isValid\":true,\"orderId\":4941,\"price\":3,\"quantity\":1,\"recId\":11026,\"specId\":814,\"specification\":\"\",\"start\":0,\"goods\":{\"addTime\":1406922067,\"brand\":\"农夫山泉\",\"cateId\":1258,\"cateId1\":1258,\"cateId2\":0,\"cateId3\":0,\"cateId4\":0,\"cateName\":\"饮料饮品\",\"closeReason\":\"\",\"closed\":0,\"defaultImage\":\"data/files/store_10/goods_141/small_201408082259019277.jpg\",\"defaultSpec\":814,\"deleted\":0,\"description\":\"\n" +
             "商品信息<\\/span><\\/p>\n" +
             "\n" +
             " <\\/span><\\/p>\n" +
             "名称<\\/span><\\/p><\\/td>\n" +
             "\n" +
             "农夫山泉 饮用天然水<\\/span><\\/p><\\/td>\n" +
             "\n" +
             "\n" +
             "<\\/td><\\/tr>\n" +
             "规格<\\/span><\\/p><\\/td>\n" +
             "\n" +
             "1.5L<\\/span><\\/p><\\/td>\n" +
             "\n" +
             "\n" +
             "<\\/td><\\/tr>\n" +
             "配料<\\/span><\\/p><\\/td>\n" +
             "\n" +
             "天然水<\\/span><\\/p><\\/td>\n" +
             "\n" +
             "\n" +
             "<\\/td><\\/tr>\n" +
             "保质期<\\/span><\\/p><\\/td>\n" +
             "\n" +
             "24<\\/span>个月<\\/span><\\/p><\\/td>\n" +
             "\n" +
             "\n" +
             "<\\/td><\\/tr>\n" +
             "保存方法<\\/span><\\/p><\\/td>\n" +
             "\n" +
             "避免日光直接照射及高温<\\/span><\\/p><\\/td>\n" +
             "\n" +
             "\n" +
             "<\\/td><\\/tr>\n" +
             "产地<\\/span><\\/p><\\/td>\n" +
             "\n" +
             "中国大陆<\\/span><\\/p><\\/td>\n" +
             "\n" +
             "\n" +
             "<\\/td><\\/tr><\\/tbody><\\/table>\n" +
             " <\\/span><\\/p>\n" +
             "\n" +
             "营养成分表<\\/span><\\/p>\n" +
             "\n" +
             " <\\/span><\\/p>\n" +
             "项目<\\/span><\\/p><\\/td>\n" +
             "\n" +
             "每100ml<\\/span><\\/p><\\/td>\n" +
             "\n" +
             "\n" +
             "<\\/td><\\/tr>\n" +
             "钙<\\/span><\\/p><\\/td>\n" +
             "\n" +
             "≥400ug<\\/span><\\/p><\\/td>\n" +
             "\n" +
             "\n" +
             "<\\/td><\\/tr>\n" +
             "镁<\\/span><\\/p><\\/td>\n" +
             "\n" +
             "≥50ug<\\/span><\\/p><\\/td>\n" +
             "\n" +
             "\n" +
             "<\\/td><\\/tr>\n" +
             "钾<\\/span><\\/p><\\/td>\n" +
             "\n" +
             "≥35ug<\\/span><\\/p><\\/td>\n" +
             "\n" +
             "\n" +
             "<\\/td><\\/tr>\n" +
             "钠<\\/span><\\/p><\\/td>\n" +
             "\n" +
             "≥80ug<\\/span><\\/p><\\/td>\n" +
             "\n" +
             "\n" +
             "<\\/td><\\/tr>\n" +
             "偏硅酸<\\/span><\\/p><\\/td>\n" +
             "\n" +
             "≥180ug<\\/span><\\/p><\\/td>\n" +
             "\n" +
             "\n" +
             "<\\/td><\\/tr><\\/tbody><\\/table>\n" +
             "\n" +
             "<\\/p>\",\"districtName\":\"\",\"goodsId\":770,\"goodsName\":\"农夫山泉 饮用天然水 1.5L/瓶\",\"goodsUser\":\"\",\"ifShow\":1,\"lastUpdate\":1453058601,\"price\":3,\"recommended\":1,\"saleTime\":\"\",\"serviceId\":0,\"serviceType\":\"\",\"showPeople\":\"\",\"sort\":0,\"specName1\":\"\",\"specName2\":\"\",\"specQty\":0,\"stock\":0,\"storeId\":10,\"tags\":\"\",\"type\":\"material\",\"picList\":[{\"fileId\":2533,\"goodsId\":770,\"imageId\":2506,\"imageUrl\":\"data/files/store_10/goods_141/201408082259019277.jpg\",\"sortOrder\":1,\"thumbnail\":\"data/files/store_10/goods_141/small_201408082259019277.jpg\"}]}}],\"deliveryAddress\":{\"address\":\"天鹅湖23栋3单元18楼7号\",\"consignee\":\"甘\",\"orderId\":4941,\"phoneMob\":\"18628185275\",\"phoneTel\":\"\",\"regionId\":358,\"regionName\":\"中国\\t四川省\\t成都\",\"shipingId\":7,\"shippingFee\":0,\"shippingName\":\"货到付款\",\"zipcode\":\"610000\"},\"payMethod\":{\"config\":\"\",\"enabled\":1,\"isOnline\":0,\"paymentCode\":\"cod\",\"paymentDesc\":\"货到付款，安全放心\",\"paymentId\":12,\"paymentName\":\"货到付款\",\"sortOrder\":0,\"storeId\":10},\"reciveName\":\"甘\",\"phoneNum\":\"18628185275\"}],\"limit\":5,\"msg\":\"查询成功！\",\"start\":0,\"success\":true,\"total\":1}";

            /* public static String  order="{\"data\":[{\"addTime\":1467161187,\"anonymous\":0,\"buyerEmail\":\"dd@fg\",\"buyerId\":479,\"buyerName\":\"1111\",\"deliveryAddressId\":451,\"discount\":0,\"discountCode\":\"\",\"evaluationStatus\":false,\"evaluationTime\":0,\"extension\":\"normal\",\"finishedTime\":0,\"goodsAmount\":97.5,\"invoiceNo\":\"\",\"isPrint\":0,\"jkNote\":\"不用送货，测试\",\"jkPrint\":0,\"orderAmount\":97.5,\"orderCode\":\"\",\"orderId\":5544,\"orderSn\":\"1628847930\",\"outTradeSn\":\"\",\"payAlter\":false,\"payMessage\":\"\",\"payTime\":0,\"paymentCode\":\"\",\"paymentId\":12,\"paymentName\":\"\",\"postscript\":\"\",\"remark\":\"\",\"sellerId\":28,\"sellerName\":\"嘉柏小区\",\"shipTime\":0,\"status\":11,\"type\":\"material\",\"orderMapGoodsList\":[{\"comment\":\"\",\"creditValue\":false,\"evaluation\":false,\"goodsId\":25116,\"goodsImage\":\"data/files/pics/6911316400306.jpg\",\"goodsName\":\"阿尔卑斯 草莓牛奶硬糖 31g/条\",\"hidden\":0,\"isValid\":true,\"orderId\":5544,\"price\":2.5,\"quantity\":1,\"recId\":12396,\"specId\":0,\"specification\":\"\",\"start\":0,\"goods\":{\"addTime\":1439835117,\"brand\":\"阿尔卑斯\",\"cateId\":1718,\"cateId1\":1235,\"cateId2\":0,\"cateId3\":0,\"cateId4\":0,\"cateName\":\"糖果/巧克力\",\"closeReason\":\"\",\"closed\":0,\"defaultImage\":\"data/files/pics/6911316400306.jpg\",\"defaultSpec\":25159,\"deleted\":0,\"description\":\"\",\"districtName\":\"\",\"goodsId\":25116,\"goodsName\":\"阿尔卑斯 草莓牛奶硬糖 31g/条\",\"goodsUser\":\"\",\"ifShow\":1,\"lastUpdate\":1451344195,\"price\":2.5,\"recommended\":1,\"saleTime\":\"\",\"serviceId\":0,\"serviceType\":\"\",\"showPeople\":\"\",\"sort\":414,\"specName1\":\"\",\"specName2\":\"\",\"specQty\":0,\"stock\":0,\"storeId\":28,\"tags\":\"\",\"type\":\"material\",\"picList\":[{\"fileId\":7608,\"goodsId\":25116,\"imageId\":7581,\"imageUrl\":\"data/files/store_28/goods_72/201508191821122797.jpg\",\"sortOrder\":1,\"thumbnail\":\"data/files/store_28/goods_72/small_201508191821122797.jpg\"}]}},{\"comment\":\"\",\"creditValue\":false,\"evaluation\":false,\"goodsId\":27802,\"goodsImage\":\"data/files/store_28/goods_35/small_201508262150357661.jpg\",\"goodsName\":\"蒙牛 冰+ 绚彩冰 桃杏酸奶口味雪糕 75克/支\",\"hidden\":0,\"isValid\":true,\"orderId\":5544,\"price\":3,\"quantity\":1,\"recId\":12398,\"specId\":0,\"specification\":\"\",\"start\":0,\"goods\":{\"addTime\":1439926332,\"brand\":\"\",\"cateId\":1677,\"cateId1\":1677,\"cateId2\":0,\"cateId3\":0,\"cateId4\":0,\"cateName\":\"冷冻食品\",\"closeReason\":\"\",\"closed\":0,\"defaultImage\":\"data/files/store_28/goods_35/small_201508262150357661.jpg\",\"defaultSpec\":27845,\"deleted\":0,\"description\":\"\",\"districtName\":\"\",\"goodsId\":27802,\"goodsName\":\"蒙牛 冰+ 绚彩冰 桃杏酸奶口味雪糕 75克/支\",\"goodsUser\":\"\",\"ifShow\":1,\"lastUpdate\":1455846644,\"price\":3,\"recommended\":1,\"saleTime\":\"\",\"serviceId\":0,\"serviceType\":\"\",\"showPeople\":\"\",\"sort\":0,\"specName1\":\"\",\"specName2\":\"\",\"specQty\":0,\"stock\":0,\"storeId\":28,\"tags\":\"\",\"type\":\"material\",\"picList\":[{\"fileId\":7804,\"goodsId\":27802,\"imageId\":7777,\"imageUrl\":\"data/files/store_28/goods_35/201508262150357661.jpg\",\"sortOrder\":1,\"thumbnail\":\"data/files/store_28/goods_35/small_201508262150357661.jpg\"}]}},{\"comment\":\"\",\"creditValue\":false,\"evaluation\":false,\"goodsId\":51328,\"goodsImage\":\"data/files/pics/6902088701067.jpg\",\"goodsName\":\"金纺衣物护理剂 水清莲香 1L/瓶\",\"hidden\":0,\"isValid\":true,\"orderId\":5544,\"price\":18,\"quantity\":1,\"recId\":12394,\"specId\":0,\"specification\":\"\",\"start\":0,\"goods\":{\"addTime\":1451344386,\"brand\":\"\",\"cateId\":1742,\"cateId1\":0,\"cateId2\":0,\"cateId3\":0,\"cateId4\":0,\"cateName\":\"生活日用品\",\"closeReason\":\"\",\"closed\":0,\"defaultImage\":\"data/files/pics/6902088701067.jpg\",\"defaultSpec\":51736,\"deleted\":0,\"description\":\"1L奥妙金纺衣物护理剂\",\"districtName\":\"\",\"goodsId\":51328,\"goodsName\":\"金纺衣物护理剂 水清莲香 1L/瓶\",\"goodsUser\":\"\",\"ifShow\":1,\"lastUpdate\":0,\"price\":18,\"recommended\":1,\"saleTime\":\"\",\"serviceId\":0,\"serviceType\":\"\",\"showPeople\":\"\",\"sort\":0,\"specName1\":\"\",\"specName2\":\"\",\"specQty\":0,\"stock\":0,\"storeId\":28,\"tags\":\"\",\"type\":\"material\",\"picList\":[null]}},{\"comment\":\"\",\"creditValue\":false,\"evaluation\":false,\"goodsId\":51565,\"goodsImage\":\"data/files/pics/6944169300974.jpg\",\"goodsName\":\"南驰铁观音 100克/包\",\"hidden\":0,\"isValid\":true,\"orderId\":5544,\"price\":20,\"quantity\":1,\"recId\":12397,\"specId\":0,\"specification\":\"\",\"start\":0,\"goods\":{\"addTime\":1451344413,\"brand\":\"\",\"cateId\":1723,\"cateId1\":0,\"cateId2\":0,\"cateId3\":0,\"cateId4\":0,\"cateName\":\"冲饮谷物\",\"closeReason\":\"\",\"closed\":0,\"defaultImage\":\"data/files/pics/6944169300974.jpg\",\"defaultSpec\":51973,\"deleted\":0,\"description\":\"100克南驰红心铁观音\",\"districtName\":\"\",\"goodsId\":51565,\"goodsName\":\"南驰铁观音 100克/包\",\"goodsUser\":\"\",\"ifShow\":1,\"lastUpdate\":0,\"price\":20,\"recommended\":1,\"saleTime\":\"\",\"serviceId\":0,\"serviceType\":\"\",\"showPeople\":\"\",\"sort\":0,\"specName1\":\"\",\"specName2\":\"\",\"specQty\":0,\"stock\":0,\"storeId\":28,\"tags\":\"\",\"type\":\"material\",\"picList\":[null]}},{\"comment\":\"\",\"creditValue\":false,\"evaluation\":false,\"goodsId\":51566,\"goodsImage\":\"data/files/pics/6911045666042.jpg\",\"goodsName\":\"花毛峰 100克/包\",\"hidden\":0,\"isValid\":true,\"orderId\":5544,\"price\":24,\"quantity\":1,\"recId\":12395,\"specId\":0,\"specification\":\"\",\"start\":0,\"goods\":{\"addTime\":1451344413,\"brand\":\"\",\"cateId\":1723,\"cateId1\":0,\"cateId2\":0,\"cateId3\":0,\"cateId4\":0,\"cateName\":\"冲饮谷物\",\"closeReason\":\"\",\"closed\":0,\"defaultImage\":\"data/files/pics/6911045666042.jpg\",\"defaultSpec\":51974,\"deleted\":0,\"description\":\"100克花毛峰茉莉花茶\",\"districtName\":\"\",\"goodsId\":51566,\"goodsName\":\"花毛峰 100克/包\",\"goodsUser\":\"\",\"ifShow\":1,\"lastUpdate\":0,\"price\":24,\"recommended\":1,\"saleTime\":\"\",\"serviceId\":0,\"serviceType\":\"\",\"showPeople\":\"\",\"sort\":0,\"specName1\":\"\",\"specName2\":\"\",\"specQty\":0,\"stock\":0,\"storeId\":28,\"tags\":\"\",\"type\":\"material\",\"picList\":[null]}},{\"comment\":\"\",\"creditValue\":false,\"evaluation\":false,\"goodsId\":52493,\"goodsImage\":\"data/files/pics/9776155006.jpg\",\"goodsName\":\"星巴克盒装咖啡 原味 300g（10条装）/盒\",\"hidden\":0,\"isValid\":true,\"orderId\":5544,\"price\":30,\"quantity\":1,\"recId\":12393,\"specId\":0,\"specification\":\"\",\"start\":0,\"goods\":{\"addTime\":1452213102,\"brand\":\"\",\"cateId\":1723,\"cateId1\":1723,\"cateId2\":0,\"cateId3\":0,\"cateId4\":0,\"cateName\":\"冲饮谷物\",\"closeReason\":\"\",\"closed\":0,\"defaultImage\":\"data/files/pics/9776155006.jpg\",\"defaultSpec\":52901,\"deleted\":0,\"description\":\"300克星巴克原味咖啡\",\"districtName\":\"\",\"goodsId\":52493,\"goodsName\":\"星巴克盒装咖啡 原味 300g（10条装）/盒\",\"goodsUser\":\"\",\"ifShow\":1,\"lastUpdate\":1452213102,\"price\":30,\"recommended\":1,\"saleTime\":\"\",\"serviceId\":0,\"serviceType\":\"\",\"showPeople\":\"\",\"sort\":0,\"specName1\":\"\",\"specName2\":\"\",\"specQty\":0,\"stock\":0,\"storeId\":28,\"tags\":\"\",\"type\":\"material\",\"picList\":[{\"fileId\":40654,\"goodsId\":52493,\"imageId\":40627,\"imageUrl\":\"data/files/pics/9776155006.jpg\",\"sortOrder\":255,\"thumbnail\":\"data/files/pics/9776155006.jpg\"}]}}],\"deliveryAddress\":{\"address\":\"2355\",\"consignee\":\"谈\",\"orderId\":5544,\"phoneMob\":\"17741228966\",\"phoneTel\":\"\",\"regionId\":451,\"regionName\":\"中国 四川 成都\",\"shipingId\":10,\"shippingFee\":1,\"shippingName\":\"货到付款\",\"zipcode\":\"610000\"},\"payMethod\":{\"config\":\"\",\"enabled\":1,\"isOnline\":0,\"paymentCode\":\"cod\",\"paymentDesc\":\"货到付款，安全放心\",\"paymentId\":15,\"paymentName\":\"货到付款\",\"sortOrder\":0,\"storeId\":28},\"reciveName\":\"谈\",\"phoneNum\":\"17741228966\"},{\"addTime\":1462468055,\"anonymous\":0,\"buyerEmail\":\"dd@fg\",\"buyerId\":479,\"buyerName\":\"谈银\",\"deliveryAddressId\":451,\"discount\":0,\"discountCode\":\"\",\"evaluationStatus\":false,\"evaluationTime\":0,\"extension\":\"normal\",\"finishedTime\":0,\"goodsAmount\":4,\"invoiceNo\":\"\",\"isPrint\":0,\"jkNote\":\"\",\"jkPrint\":1,\"orderAmount\":4,\"orderCode\":\"\",\"orderId\":5382,\"orderSn\":\"1628861537\",\"outTradeSn\":\"\",\"payAlter\":false,\"payMessage\":\"\",\"payTime\":0,\"paymentCode\":\"\",\"paymentId\":12,\"paymentName\":\"\",\"postscript\":\"\",\"remark\":\"\",\"sellerId\":10,\"sellerName\":\"天鹅湖、棕榈泉公寓\",\"shipTime\":0,\"status\":0,\"type\":\"material\",\"orderMapGoodsList\":[{\"comment\":\"\",\"creditValue\":false,\"evaluation\":false,\"goodsId\":24658,\"goodsImage\":\"data/files/pics/6922456858698.jpg\",\"goodsName\":\"康师傅 经典奶茶 香浓味 500ml/瓶\",\"hidden\":0,\"isValid\":true,\"orderId\":5382,\"price\":4,\"quantity\":1,\"recId\":12019,\"specId\":0,\"specification\":\"\",\"start\":0,\"goods\":{\"addTime\":1439835104,\"brand\":\"康师傅 \",\"cateId\":1564,\"cateId1\":1238,\"cateId2\":0,\"cateId3\":0,\"cateId4\":0,\"cateName\":\"饮料饮品\",\"closeReason\":\"\",\"closed\":0,\"defaultImage\":\"data/files/pics/6922456858698.jpg\",\"defaultSpec\":24701,\"deleted\":0,\"description\":\"\",\"districtName\":\"\",\"goodsId\":24658,\"goodsName\":\"康师傅 经典奶茶 香浓味 500ml/瓶\",\"goodsUser\":\"\",\"ifShow\":1,\"lastUpdate\":1451344230,\"price\":4,\"recommended\":1,\"saleTime\":\"\",\"serviceId\":0,\"serviceType\":\"\",\"showPeople\":\"\",\"sort\":2167,\"specName1\":\"\",\"specName2\":\"\",\"specQty\":0,\"stock\":0,\"storeId\":28,\"tags\":\"\",\"type\":\"material\",\"picList\":[{\"fileId\":7423,\"goodsId\":24658,\"imageId\":7396,\"imageUrl\":\"data/files/store_28/goods_187/201508182036275321.jpg\",\"sortOrder\":1,\"thumbnail\":\"data/files/store_28/goods_187/small_201508182036275321.jpg\"}]}}],\"deliveryAddress\":{\"address\":\"2355\",\"consignee\":\"谈\",\"orderId\":5382,\"phoneMob\":\"17741228966\",\"phoneTel\":\"\",\"regionId\":451,\"regionName\":\"中国 四川 成都\",\"shipingId\":7,\"shippingFee\":0,\"shippingName\":\"货到付款\",\"zipcode\":\"610000\"},\"payMethod\":{\"config\":\"\",\"enabled\":1,\"isOnline\":0,\"paymentCode\":\"cod\",\"paymentDesc\":\"货到付款，安全放心\",\"paymentId\":12,\"paymentName\":\"货到付款\",\"sortOrder\":0,\"storeId\":10},\"reciveName\":\"谈\",\"phoneNum\":\"17741228966\"},{\"addTime\":1460425676,\"anonymous\":0,\"buyerEmail\":\"dd@fg\",\"buyerId\":479,\"buyerName\":\"谈银\",\"deliveryAddressId\":449,\"discount\":0,\"discountCode\":\"\",\"evaluationStatus\":false,\"evaluationTime\":0,\"extension\":\"normal\",\"finishedTime\":0,\"goodsAmount\":4,\"invoiceNo\":\"\",\"isPrint\":0,\"jkNote\":\"\",\"jkPrint\":0,\"orderAmount\":4,\"orderCode\":\"\",\"orderId\":5307,\"orderSn\":\"1628879780\",\"outTradeSn\":\"\",\"payAlter\":false,\"payMessage\":\"\",\"payTime\":0,\"paymentCode\":\"\",\"paymentId\":12,\"paymentName\":\"\",\"postscript\":\"\",\"remark\":\"\",\"sellerId\":28,\"sellerName\":\"嘉柏小区\",\"shipTime\":0,\"status\":11,\"type\":\"material\",\"orderMapGoodsList\":[{\"comment\":\"\",\"creditValue\":false,\"evaluation\":false,\"goodsId\":25531,\"goodsImage\":\"data/files/pics/6901285991219.jpg\",\"goodsName\":\"怡宝 饮用纯净水 555ml/瓶\",\"hidden\":0,\"isValid\":true,\"orderId\":5307,\"price\":2,\"quantity\":1,\"recId\":11871,\"specId\":0,\"specification\":\"\",\"start\":0,\"goods\":{\"addTime\":1439835130,\"brand\":\"怡宝\",\"cateId\":1564,\"cateId1\":1238,\"cateId2\":0,\"cateId3\":0,\"cateId4\":0,\"cateName\":\"饮料饮品\",\"closeReason\":\"\",\"closed\":0,\"defaultImage\":\"data/files/pics/6901285991219.jpg\",\"defaultSpec\":25574,\"deleted\":0,\"description\":\"\",\"districtName\":\"\",\"goodsId\":25531,\"goodsName\":\"怡宝 饮用纯净水 555ml/瓶\",\"goodsUser\":\"\",\"ifShow\":1,\"lastUpdate\":1451355472,\"price\":2,\"recommended\":1,\"saleTime\":\"\",\"serviceId\":0,\"serviceType\":\"\",\"showPeople\":\"\",\"sort\":23075,\"specName1\":\"\",\"specName2\":\"\",\"specQty\":0,\"stock\":0,\"storeId\":28,\"tags\":\"\",\"type\":\"material\",\"picList\":[{\"fileId\":7239,\"goodsId\":25531,\"imageId\":7212,\"imageUrl\":\"data/files/store_28/goods_61/201508181024211823.jpg\",\"sortOrder\":1,\"thumbnail\":\"data/files/store_28/goods_61/small_201508181024211823.jpg\"}]}},{\"comment\":\"\",\"creditValue\":false,\"evaluation\":false,\"goodsId\":28196,\"goodsImage\":\"data/files/store_28/goods_54/small_201508262130542633.jpg\",\"goodsName\":\"八一牧场 原味奶 80g/支\",\"hidden\":0,\"isValid\":true,\"orderId\":5307,\"price\":2,\"quantity\":1,\"recId\":11872,\"specId\":0,\"specification\":\"\",\"start\":0,\"goods\":{\"addTime\":1439926349,\"brand\":\"\",\"cateId\":1677,\"cateId1\":1677,\"cateId2\":0,\"cateId3\":0,\"cateId4\":0,\"cateName\":\"冷冻食品\",\"closeReason\":\"\",\"closed\":0,\"defaultImage\":\"data/files/store_28/goods_54/small_201508262130542633.jpg\",\"defaultSpec\":28239,\"deleted\":0,\"description\":\"\",\"districtName\":\"\",\"goodsId\":28196,\"goodsName\":\"八一牧场 原味奶 80g/支\",\"goodsUser\":\"\",\"ifShow\":1,\"lastUpdate\":1455846638,\"price\":2,\"recommended\":1,\"saleTime\":\"\",\"serviceId\":0,\"serviceType\":\"\",\"showPeople\":\"\",\"sort\":0,\"specName1\":\"\",\"specName2\":\"\",\"specQty\":0,\"stock\":0,\"storeId\":28,\"tags\":\"\",\"type\":\"material\",\"picList\":[{\"fileId\":7796,\"goodsId\":28196,\"imageId\":7769,\"imageUrl\":\"data/files/store_28/goods_54/201508262130542633.jpg\",\"sortOrder\":1,\"thumbnail\":\"data/files/store_28/goods_54/small_201508262130542633.jpg\"}]}}],\"deliveryAddress\":{\"address\":\"庄里人\",\"consignee\":\"谈\",\"orderId\":5307,\"phoneMob\":\"17741228966\",\"phoneTel\":\"\",\"regionId\":449,\"regionName\":\"中国 四川 成都\",\"shipingId\":10,\"shippingFee\":1,\"shippingName\":\"货到付款\",\"zipcode\":\"610000\"},\"payMethod\":{\"config\":\"\",\"enabled\":1,\"isOnline\":0,\"paymentCode\":\"cod\",\"paymentDesc\":\"货到付款，安全放心\",\"paymentId\":15,\"paymentName\":\"货到付款\",\"sortOrder\":0,\"storeId\":28},\"reciveName\":\"谈\",\"phoneNum\":\"17741228966\"},{\"addTime\":1458860755,\"anonymous\":0,\"buyerEmail\":\"dd@fg\",\"buyerId\":479,\"buyerName\":\"谈银\",\"deliveryAddressId\":449,\"discount\":0,\"discountCode\":\"\",\"evaluationStatus\":false,\"evaluationTime\":0,\"extension\":\"normal\",\"finishedTime\":0,\"goodsAmount\":2.5,\"invoiceNo\":\"\",\"isPrint\":0,\"jkNote\":\"手机app测试，不用送货\",\"jkPrint\":0,\"orderAmount\":2.5,\"orderCode\":\"\",\"orderId\":5237,\"orderSn\":\"1628858025\",\"outTradeSn\":\"\",\"payAlter\":false,\"payMessage\":\"\",\"payTime\":0,\"paymentCode\":\"\",\"paymentId\":12,\"paymentName\":\"\",\"postscript\":\"\",\"remark\":\"\",\"sellerId\":28,\"sellerName\":\"嘉柏小区\",\"shipTime\":0,\"status\":11,\"type\":\"material\",\"orderMapGoodsList\":[{\"comment\":\"\",\"creditValue\":false,\"evaluation\":false,\"goodsId\":14274,\"goodsImage\":\"data/files/store_352/goods_48/small_201601211850488876.jpg\",\"goodsName\":\"伊利 小雪生雪糕 牛奶巧克力口味 65克/支\",\"hidden\":0,\"isValid\":true,\"orderId\":5237,\"price\":2.5,\"quantity\":1,\"recId\":11745,\"specId\":0,\"specification\":\"\",\"start\":0,\"goods\":{\"addTime\":1436656649,\"brand\":\"\",\"cateId\":1479,\"cateId1\":1479,\"cateId2\":0,\"cateId3\":0,\"cateId4\":0,\"cateName\":\"冷冻食品\",\"closeReason\":\"\",\"closed\":0,\"defaultImage\":\"data/files/store_352/goods_48/small_201601211850488876.jpg\",\"defaultSpec\":14317,\"deleted\":0,\"description\":\"\n" +
            "65克优秀小学生<\\/p>\",\"districtName\":\"\",\"goodsId\":14274,\"goodsName\":\"伊利 小雪生雪糕 牛奶巧克力口味 65克/支\",\"goodsUser\":\"\",\"ifShow\":1,\"lastUpdate\":1455845556,\"price\":2.5,\"recommended\":1,\"saleTime\":\"\",\"serviceId\":0,\"serviceType\":\"\",\"showPeople\":\"\",\"sort\":0,\"specName1\":\"\",\"specName2\":\"\",\"specQty\":0,\"stock\":0,\"storeId\":352,\"tags\":\"\",\"type\":\"material\",\"picList\":[{\"fileId\":41066,\"goodsId\":14274,\"imageId\":41039,\"imageUrl\":\"data/files/store_352/goods_48/201601211850488876.jpg\",\"sortOrder\":1,\"thumbnail\":\"data/files/store_352/goods_48/small_201601211850488876.jpg\"}]}}],\"deliveryAddress\":{\"address\":\"庄里人\",\"consignee\":\"谈\",\"orderId\":5237,\"phoneMob\":\"17741228966\",\"phoneTel\":\"\",\"regionId\":449,\"regionName\":\"中国 四川 成都\",\"shipingId\":10,\"shippingFee\":1,\"shippingName\":\"货到付款\",\"zipcode\":\"610000\"},\"payMethod\":{\"config\":\"\",\"enabled\":1,\"isOnline\":0,\"paymentCode\":\"cod\",\"paymentDesc\":\"货到付款，安全放心\",\"paymentId\":15,\"paymentName\":\"货到付款\",\"sortOrder\":0,\"storeId\":28},\"reciveName\":\"谈\",\"phoneNum\":\"17741228966\"}],\"limit\":5,\"msg\":\"查询成功！\",\"start\":0,\"success\":true,\"total\":1}";*/

    public static String deliveryAddress="{\"data\":{\"addTime\":1467331006,\"anonymous\":0,\"buyerEmail\":\"dd@fg\",\"buyerId\":479,\"buyerName\":\"1111\",\"deliveryAddressId\":451,\"discount\":0,\"discountCode\":\"\",\"evaluationStatus\":false,\"evaluationTime\":0,\"extension\":\"normal\",\"finishedTime\":0,\"goodsAmount\":58.5,\"invoiceNo\":\"\",\"isPrint\":0,\"jkNote\":\"\",\"jkPrint\":1,\"orderAmount\":58.5,\"orderCode\":\"\",\"orderId\":5550,\"orderSn\":\"1628822811\",\"outTradeSn\":\"\",\"payAlter\":false,\"payMessage\":\"\",\"payTime\":0,\"paymentCode\":\"\",\"paymentId\":12,\"paymentName\":\"\",\"postscript\":\"\",\"remark\":\"\",\"sellerId\":10,\"sellerName\":\"天鹅湖、棕榈泉公寓\",\"shipTime\":0,\"status\":0,\"type\":\"material\",\"orderMapGoodsList\":[{\"comment\":\"\",\"creditValue\":false,\"evaluation\":false,\"goodsId\":9054,\"goodsImage\":\"data/files/pics/6943497451259.jpg\",\"goodsName\":\"现代美笔芯GP125 0.7mm /根\",\"hidden\":0,\"isValid\":true,\"orderId\":5550,\"price\":4.5,\"quantity\":3,\"recId\":12410,\"specId\":0,\"specification\":\"\",\"start\":0,\"goods\":{\"addTime\":1428216967,\"brand\":\"\",\"cateId\":1440,\"cateId1\":1440,\"cateId2\":0,\"cateId3\":0,\"cateId4\":0,\"cateName\":\"办公用品\",\"closeReason\":\"\",\"closed\":0,\"defaultImage\":\"data/files/pics/6943497451259.jpg\",\"defaultSpec\":9097,\"deleted\":0,\"description\":\"现代美笔芯GP125\",\"districtName\":\"\",\"goodsId\":9054,\"goodsName\":\"现代美笔芯GP125 0.7mm /根\",\"goodsUser\":\"\",\"ifShow\":1,\"lastUpdate\":1463713467,\"price\":1.5,\"recommended\":1,\"saleTime\":\"\",\"serviceId\":0,\"serviceType\":\"\",\"showPeople\":\"\",\"sort\":22992,\"specName1\":\"\",\"specName2\":\"\",\"specQty\":0,\"stock\":0,\"storeId\":10,\"tags\":\"\",\"type\":\"material\",\"picList\":[{\"fileId\":38772,\"goodsId\":9054,\"imageId\":38745,\"imageUrl\":\"data/files/store_10/goods_40/201512161710404360.jpg\",\"sortOrder\":1,\"thumbnail\":\"data/files/store_10/goods_40/small_201512161710404360.jpg\"}]}},{\"comment\":\"\",\"creditValue\":false,\"evaluation\":false,\"goodsId\":24249,\"goodsImage\":\"data/files/pics/6935133801511.jpg\",\"goodsName\":\"十月初五 椰蓉酥 酥性饼干 78g/盒\",\"hidden\":0,\"isValid\":true,\"orderId\":5550,\"price\":9,\"quantity\":1,\"recId\":12411,\"specId\":0,\"specification\":\"\",\"start\":0,\"goods\":{\"addTime\":1439835093,\"brand\":\"十月初五\",\"cateId\":1701,\"cateId1\":1296,\"cateId2\":0,\"cateId3\":0,\"cateId4\":0,\"cateName\":\"饼干\",\"closeReason\":\"\",\"closed\":0,\"defaultImage\":\"data/files/pics/6935133801511.jpg\",\"defaultSpec\":24292,\"deleted\":0,\"description\":\"\",\"districtName\":\"\",\"goodsId\":24249,\"goodsName\":\"十月初五 椰蓉酥 酥性饼干 78g/盒\",\"goodsUser\":\"\",\"ifShow\":1,\"lastUpdate\":1451344266,\"price\":9,\"recommended\":1,\"saleTime\":\"\",\"serviceId\":0,\"serviceType\":\"\",\"showPeople\":\"\",\"sort\":10,\"specName1\":\"\",\"specName2\":\"\",\"specQty\":0,\"stock\":0,\"storeId\":28,\"tags\":\"\",\"type\":\"material\",\"picList\":[null]}},{\"comment\":\"\",\"creditValue\":false,\"evaluation\":false,\"goodsId\":67342,\"goodsImage\":\"data/files/store_10/goods_149/small_201605171505497572.jpg\",\"goodsName\":\"胭脂（单位：斤，9折，包杀）\",\"hidden\":0,\"isValid\":true,\"orderId\":5550,\"price\":45,\"quantity\":1,\"recId\":12412,\"specId\":0,\"specification\":\"\",\"start\":0,\"goods\":{\"addTime\":1460429061,\"brand\":\"\",\"cateId\":1324,\"cateId1\":1324,\"cateId2\":0,\"cateId3\":0,\"cateId4\":0,\"cateName\":\"蔬菜/水果/肉类/鱼\",\"closeReason\":\"\",\"closed\":0,\"defaultImage\":\"data/files/store_10/goods_149/small_201605171505497572.jpg\",\"defaultSpec\":67750,\"deleted\":0,\"description\":\"\n" +
            "胭脂<\\/p>\",\"districtName\":\"\",\"goodsId\":67342,\"goodsName\":\"胭脂（单位：斤，9折，包杀）\",\"goodsUser\":\"\",\"ifShow\":1,\"lastUpdate\":1463530846,\"price\":45,\"recommended\":1,\"saleTime\":\"\",\"serviceId\":0,\"serviceType\":\"\",\"showPeople\":\"\",\"sort\":994,\"specName1\":\"\",\"specName2\":\"\",\"specQty\":0,\"stock\":0,\"storeId\":10,\"tags\":\"\",\"type\":\"material\",\"picList\":[{\"fileId\":54146,\"goodsId\":67342,\"imageId\":54119,\"imageUrl\":\"data/files/store_10/goods_149/201605171505497572.jpg\",\"sortOrder\":1,\"thumbnail\":\"data/files/store_10/goods_149/small_201605171505497572.jpg\"}]}}],\"deliveryAddress\":{\"address\":\"2355\",\"consignee\":\"谈\",\"orderId\":5550,\"phoneMob\":\"17741228966\",\"phoneTel\":\"\",\"regionId\":451,\"regionName\":\"中国 四川 成都\",\"shipingId\":7,\"shippingFee\":0,\"shippingName\":\"货到付款\",\"zipcode\":\"610000\"},\"payMethod\":{\"config\":\"\",\"enabled\":1,\"isOnline\":0,\"paymentCode\":\"cod\",\"paymentDesc\":\"货到付款，安全放心\",\"paymentId\":12,\"paymentName\":\"货到付款\",\"sortOrder\":0,\"storeId\":10},\"reciveName\":\"谈\",\"phoneNum\":\"17741228966\"},\"msg\":\"查询成功！\",\"success\":true}";

    public static Order getDeliveryAddress(){

        Type type = new TypeToken<Order>(){}.getType();

        JSONObject jsonObject;
        Order ta=new Order();
        try {
            jsonObject = new JSONObject(deliveryAddress);//把字符串转化成一个json对象
            if ("true".equals(jsonObject.getString("success"))) {
                Gson gson = new Gson();
                ta = gson.fromJson(jsonObject.getString("data"), type);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return ta;
    }

    public static List<Order> getOrderList(){
        Type type = new TypeToken<List<Order>>(){}.getType();

        JSONObject jsonObject;
        List<Order> ta=new ArrayList<>();
        try {
            jsonObject = new JSONObject(order);//把字符串转化成一个json对象
            if ("true".equals(jsonObject.getString("success"))) {
                Gson gson = new Gson();
                ta = gson.fromJson(jsonObject.getString("data"), type);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return ta;
    }



}

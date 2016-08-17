package com.linyou.lifedelivery.activity.entity;



import com.linyou.lifedelivery.activity.utils.DateUtil;

import java.util.List;

/**
 * 订单
 * @author 志强
 *
 */
public class Order {

	private String addTime;//下单时间  addTime
	private DeliveryAddress deliveryAddress;//送货地址
	private String discountCode;//优惠券号
	private String sellerName;//订单店铺的名称sellerName
	private String orderId;//订单id   orderId
	private String reciveName;//收件人姓名  Buyer_name
	private String orderSn;//订单编码
	private List<OrderMapGoods> orderMapGoodsList; //订单中商品
	private PayMethod payMethod;//支付方式
	private String phoneNum;//收货电话  phoneNum
	//private String orderAmount;//总价  goodsAmout  goodsAmout       order_amount  goods_amount
	private String orderAmount;//总价  goodsAmout       order_amount  goods_amount  orderAmount
	private String jkNote;//备注
	private String status;//订单状态  Status

	@Override
	public  String toString() {
		return "Order{" +
				"addTime='" + addTime + '\'' +
				", deliveryAddress=" + deliveryAddress +
				", discountCode='" + discountCode + '\'' +
				", sellerName='" + sellerName + '\'' +
				", orderId='" + orderId + '\'' +
				", reciveName='" + reciveName + '\'' +
				", orderSn='" + orderSn + '\'' +
				", orderMapGoodsList=" + orderMapGoodsList +
				", payMethod=" + payMethod +
				", phoneNum='" + phoneNum + '\'' +
				", orderAmount='" + orderAmount + '\'' +
				", jkNote='" + jkNote + '\'' +
				", status='" + status + '\'' +
				'}';
	}

	public String getCreateTime() {
		return DateUtil.TimeStamp2Date(addTime, "yyyy-MM-dd HH:mm:ss ");
	}
	public void setCreateTime(String createTime) {
		this.addTime = createTime;
	}
	public DeliveryAddress getDeliveryAddress() {
		return deliveryAddress;
	}
	public void setDeliveryAddress(DeliveryAddress deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}
	public String getDiscountCode() {
		return discountCode;
	}
	public void setDiscountCode(String discountCode) {
		this.discountCode = discountCode;
	}
	public String getGoodsUser() {
		return sellerName;
	}
	public void setGoodsUser(String goodsUser) {
		this.sellerName = goodsUser;
	}
	public String getId() {
		return orderId;
	}
	public void setId(String id) {
		this.orderId = id;
	}
	public String getName() {
		return reciveName;
	}
	public void setName(String name) {
		this.reciveName = name;
	}
	public String getOrderCode() {
		return orderSn;
	}
	public void setOrderCode(String orderCode) {
		this.orderSn = orderCode;
	}
	public List<OrderMapGoods> getOrderMapGoodsList() {
		return orderMapGoodsList;
	}
	public void setOrderMapGoodsList(List<OrderMapGoods> orderMapGoodsList) {
		this.orderMapGoodsList = orderMapGoodsList;
	}
	public PayMethod getPayMethod() {
		return payMethod;
	}
	public void setPayMethod(PayMethod payMethod) {
		this.payMethod = payMethod;
	}
	public String getPhone() {
		return phoneNum;
	}
	public void setPhone(String phone) {
		this.phoneNum = phone;
	}
	public String getPrice() {
		return orderAmount;
	}
	public void setPrice(String price) {
		this.orderAmount = price;
	}
	public String getRemark() {
		return jkNote;
	}
	public void setRemark(String remark) {
		this.jkNote = remark;
	}
	public String getState() {
		return status;
	}
	public void setState(String state) {
		this.status = state;
	}
	
	
	
}

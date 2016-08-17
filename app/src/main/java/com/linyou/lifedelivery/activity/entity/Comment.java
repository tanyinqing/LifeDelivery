package com.linyou.lifedelivery.activity.entity;


import com.linyou.lifedelivery.activity.utils.DateUtil;

/*

 */
public class Comment {
	private String comment;
	private String createTime;
	private Goods goods;
	private String id;
	private User user;

	@Override
	public String toString() {
		return "Comment{" +
				"comment='" + comment + '\'' +
				", createTime='" + createTime + '\'' +
				", goods=" + goods +
				", id='" + id + '\'' +
				", GetOrder=" + user +
				'}';
	}

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getContent() {
		return comment;
	}
	public void setContent(String content) {
		this.comment = content;
	}
	public String getCreateTime() {
		return	DateUtil.TimeStamp2Date(createTime, "yyyy-MM-dd HH:mm:ss ");
		//return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
}

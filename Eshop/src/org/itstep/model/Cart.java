package org.itstep.model;

public class Cart {
	private int id;
	private String accLogin;
	private String imgUrl;
	
	private int orderId;
	private long timeCreation;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAccLogin() {
		return accLogin;
	}
	public void setAccLogin(String accLogin) {
		this.accLogin = accLogin;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public long getTimeCreation() {
		return timeCreation;
	}
	public void setTimeCreation(long timeCreation) {
		this.timeCreation = timeCreation;
	}
	

}

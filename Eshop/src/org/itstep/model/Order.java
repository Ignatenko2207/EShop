package org.itstep.model;

public class Order {
	private long orderId;
	private String good;
	private int amount;

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public String getGood() {
		return good;
	}

	public void setGood(String good) {
		this.good = good;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Order(long orderId, String good, int amount) {
		super();
		this.orderId = orderId;
		this.good = good;
		this.amount = amount;
	}

	public Order() {

	}

}
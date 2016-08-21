package com.bin.lookz.entity;

import java.io.Serializable;
import java.sql.Date;

public class Order implements Serializable{

	private static final long serialVersionUID = -497578733328001281L;
	private int id;
	private long orderid;
	private String payWay;
	private Date time;
	private String orderState;
	private int order_flag;
	
	public Order() {
		super();
	}


	public Order(int id, long orderid, String payWay, Date time,
			String orderState, int orderFlag) {
		super();
		this.id = id;
		this.orderid = orderid;
		this.payWay = payWay;
		this.time = time;
		this.orderState = orderState;
		order_flag = orderFlag;
	}

	public Order(long orderid, String payWay, Date time,
			String orderState, int orderFlag) {
		super();
		this.orderid = orderid;
		this.payWay = payWay;
		this.time = time;
		this.orderState = orderState;
		order_flag = orderFlag;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPayWay() {
		return payWay;
	}

	public void setPayWay(String payWay) {
		this.payWay = payWay;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getOrderState() {
		return orderState;
	}

	public void setOrderState(String orderState) {
		this.orderState = orderState;
	}

	public int getOrder_flag() {
		return order_flag;
	}

	public void setOrder_flag(int orderFlag) {
		order_flag = orderFlag;
	}


	public long getOrderid() {
		return orderid;
	}

	public void setOrderid(long orderid) {
		this.orderid = orderid;
	}
	
	
}

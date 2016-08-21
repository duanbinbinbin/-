package com.bin.lookz.entity;

import java.io.Serializable;
import java.sql.Date;

public class Purchase implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String orderid;
	private String goodsname;
	private double goodsprice;
	private int number;
	private Date time;
	public Purchase() {
		super();
	}
	
	public Purchase(String orderid, String goodsname,
			double goodsprice, int number, Date time) {
		super();
		this.orderid = orderid;
		this.goodsname = goodsname;
		this.goodsprice = goodsprice;
		this.number = number;
		this.time = time;
	}
	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	public String getGoodsname() {
		return goodsname;
	}
	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}
	public double getGoodsprice() {
		return goodsprice;
	}
	public void setGoodsprice(double goodsprice) {
		this.goodsprice = goodsprice;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	

}

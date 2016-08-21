package com.bin.lookz.entity;

import java.io.Serializable;

public class Goods implements Serializable{

	private static final long serialVersionUID = -2419322630817166683L;
	private int id;
	private String name;
	private String introduce;
	private String type;
	private String tasteType;
	private String healthType;
	private String manufacturer;
	private double price;
	private String imgUrl;
	private int evaluate;
	private int num;
	private double dicount;
	private int score;
	private int goods_flag;
	
	public Goods() {
	}

	public Goods(int id, String name, String introduce, String type,
			String tasteType, String healthType, String manufacturer,
			double price, String imgUrl, int evaluate, int num, double dicount,
			int score, int goodsFlag) {
		super();
		this.id = id;
		this.name = name;
		this.introduce = introduce;
		this.type = type;
		this.tasteType = tasteType;
		this.healthType = healthType;
		this.manufacturer = manufacturer;
		this.price = price;
		this.imgUrl = imgUrl;
		this.evaluate = evaluate;
		this.num = num;
		this.dicount = dicount;
		this.score = score;
		goods_flag = goodsFlag;
	}
	
	public Goods(String name, String introduce, String type,
			String tasteType, String healthType, String manufacturer,
			double price, String imgUrl, int evaluate, int num, double dicount) {
		super();
		this.name = name;
		this.introduce = introduce;
		this.type = type;
		this.tasteType = tasteType;
		this.healthType = healthType;
		this.manufacturer = manufacturer;
		this.price = price;
		this.imgUrl = imgUrl;
		this.evaluate = evaluate;
		this.num = num;
		this.dicount = dicount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTasteType() {
		return tasteType;
	}

	public void setTasteType(String tasteType) {
		this.tasteType = tasteType;
	}

	public String getHealthType() {
		return healthType;
	}

	public void setHealthType(String healthType) {
		this.healthType = healthType;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public int getEvaluate() {
		return evaluate;
	}

	public void setEvaluate(int evaluate) {
		this.evaluate = evaluate;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public double getDicount() {
		return dicount;
	}

	public void setDicount(double dicount) {
		this.dicount = dicount;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getGoods_flag() {
		return goods_flag;
	}

	public void setGoods_flag(int goodsFlag) {
		goods_flag = goodsFlag;
	}
	
	
}

package com.bin.lookz.entity;

import java.io.Serializable;

public class Users implements Serializable{

	private static final long serialVersionUID = -6179806310796994986L;
	private int id;
	private String name;
	private String password;
	private String sex;
	private String email;
	private double money;
	private ShoppingCar shoppingCar;
	private int car_flag;
	private int u_flag;
	
	public Users() {
	}

	public Users(int id, String name, String password, String sex,
			String email, double money, ShoppingCar shoppingCar, int carFlag,
			int uFlag) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.sex = sex;
		this.email = email;
		this.money = money;
		this.shoppingCar = shoppingCar;
		car_flag = carFlag;
		u_flag = uFlag;
	}
	
	public Users(int id, String name, String password, String sex,
			String email, double money, int carFlag,
			int uFlag) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.sex = sex;
		this.email = email;
		this.money = money;
		car_flag = carFlag;
		u_flag = uFlag;
	}
	
	public Users(int id, String name, String password, String sex,
			String email, double money) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.sex = sex;
		this.email = email;
		this.money = money;
	}
	
	public Users(String name, String password, String sex,
			String email, int carFlag) {
		super();
		this.name = name;
		this.password = password;
		this.sex = sex;
		this.email = email;
		car_flag = carFlag;
	}
	
	public Users(int id,String name, String password,int car_flag) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.car_flag = car_flag;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public ShoppingCar getShoppingCar() {
		return shoppingCar;
	}

	public void setShoppingCar(ShoppingCar shoppingCar) {
		this.shoppingCar = shoppingCar;
	}

	public int getCar_flag() {
		return car_flag;
	}

	public void setCar_flag(int carFlag) {
		car_flag = carFlag;
	}

	public int getU_flag() {
		return u_flag;
	}

	public void setU_flag(int uFlag) {
		u_flag = uFlag;
	}
	
	
	
}

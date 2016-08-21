package com.bin.lookz.entity;

import java.io.Serializable;

public class Contact implements Serializable{

	private static final long serialVersionUID = 4471107601865509088L;
	private int id;
	private String name;
	private String phone;
	private String msg;
	private String time;
	private int contact_flag;
	public Contact() {
		super();
	}
	public Contact(int id, String name, String phone, String msg, String time,
			int contactFlag) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.msg = msg;
		this.time = time;
		contact_flag = contactFlag;
	}
	public Contact(String name, String phone, String msg, String time,
			int contactFlag) {
		super();
		this.name = name;
		this.phone = phone;
		this.msg = msg;
		this.time = time;
		contact_flag = contactFlag;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getContact_flag() {
		return contact_flag;
	}
	public void setContact_flag(int contactFlag) {
		contact_flag = contactFlag;
	}
	
	
}

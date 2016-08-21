package com.bin.lookz.entity;

public class Address {
	
	private int id;
	private int users_id;//创建地址的用户ID
	private String name;
	private String phone;
	private String postCode;
	private String province;
	private String city;
	private String area;
	private String address;
	private int address_flag;
	
	public Address() {
		super();
	}

	public Address(int id, int usersId, String name, String phone,
			String postCode, String province, String city, String area,
			String address, int addressFlag) {
		super();
		this.id = id;
		users_id = usersId;
		this.name = name;
		this.phone = phone;
		this.postCode = postCode;
		this.province = province;
		this.city = city;
		this.area = area;
		this.address = address;
		address_flag = addressFlag;
	}
	
	public Address(int usersId, String name, String phone,
			String postCode, String province, String city, String area,
			String address, int addressFlag) {
		users_id = usersId;
		this.name = name;
		this.phone = phone;
		this.postCode = postCode;
		this.province = province;
		this.city = city;
		this.area = area;
		this.address = address;
		address_flag = addressFlag;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUsers_id() {
		return users_id;
	}

	public void setUsers_id(int usersId) {
		users_id = usersId;
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

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAddress_flag() {
		return address_flag;
	}

	public void setAddress_flag(int addressFlag) {
		address_flag = addressFlag;
	}
	
	
	
}

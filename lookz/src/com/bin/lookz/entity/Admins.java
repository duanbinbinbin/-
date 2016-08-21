package com.bin.lookz.entity;

import java.io.Serializable;

public class Admins implements Serializable{

	private static final long serialVersionUID = 8505934042828975994L;
	private int id;
	private String name;
	private String password;
	private int admins_rank;
	private int admins_flag;
	public Admins() {
		super();
	}
	public Admins(int id, String name, String password, int adminsRank,
			int adminsFlag) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.admins_rank = adminsRank;
		this.admins_flag = adminsFlag;
	}
	public Admins(String name, String password, int adminsRank,
			int adminsFlag) {
		super();
		this.name = name;
		this.password = password;
		this.admins_rank = adminsRank;
		this.admins_flag = adminsFlag;
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
	public int getAdmins_rank() {
		return admins_rank;
	}
	public void setAdmins_rank(int adminsRank) {
		admins_rank = adminsRank;
	}
	public int getAdmins_flag() {
		return admins_flag;
	}
	public void setAdmins_flag(int adminsFlag) {
		admins_flag = adminsFlag;
	}
	
}

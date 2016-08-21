package com.bin.lookz.entity;

import java.io.Serializable;

public class Pp implements Serializable{

	private static final long serialVersionUID = -5896482292703283021L;
	private int id;
	private String email;
	private String ppone;
	private String pptwo;
	private String ppthree;
	private int pp_flag;
	public Pp() {
		super();
	}
	public Pp(int id, String email, String ppone, String pptwo, String ppthree,
			int ppFlag) {
		super();
		this.id = id;
		this.email = email;
		this.ppone = ppone;
		this.pptwo = pptwo;
		this.ppthree = ppthree;
		pp_flag = ppFlag;
	}
	public Pp(String email, String ppone, String pptwo, String ppthree,
			int ppFlag) {
		super();
		this.email = email;
		this.ppone = ppone;
		this.pptwo = pptwo;
		this.ppthree = ppthree;
		pp_flag = ppFlag;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPpone() {
		return ppone;
	}
	public void setPpone(String ppone) {
		this.ppone = ppone;
	}
	public String getPptwo() {
		return pptwo;
	}
	public void setPptwo(String pptwo) {
		this.pptwo = pptwo;
	}
	public String getPpthree() {
		return ppthree;
	}
	public void setPpthree(String ppthree) {
		this.ppthree = ppthree;
	}
	public int getPp_flag() {
		return pp_flag;
	}
	public void setPp_flag(int ppFlag) {
		pp_flag = ppFlag;
	}
	
	
}

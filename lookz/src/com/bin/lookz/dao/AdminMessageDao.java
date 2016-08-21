package com.bin.lookz.dao;

import java.util.ArrayList;

import com.bin.lookz.entity.Contact;

public interface AdminMessageDao {

	//查找所有的信息
	public ArrayList<Contact> getAllContact();
	
	//根据ID删除信息
	public int delMsgById(int id);
}

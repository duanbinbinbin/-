package com.bin.lookz.service.impl;

import java.util.ArrayList;

import com.bin.lookz.dao.AdminMessageDao;
import com.bin.lookz.entity.Contact;
import com.bin.lookz.service.AdminMessageService;
import com.bin.lookz.util.Factory;

public class AdminMessageServiceImpl implements AdminMessageService{
	private AdminMessageDao adminmessagedao = Factory.getAdminMessageDaoInstance();
	//根据ID删除信息
	public int delMsgById(int id) {
		return adminmessagedao.delMsgById(id);
	}

	//查找所有的信息
	public ArrayList<Contact> getAllContact() {
		return adminmessagedao.getAllContact();
	}

}

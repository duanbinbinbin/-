package com.bin.lookz.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bin.lookz.dao.AdminMessageDao;
import com.bin.lookz.entity.Contact;
import com.bin.lookz.util.C3P0Util;

public class AdminMessageDaoImpl implements AdminMessageDao{

	//查找所有的信息
	public ArrayList<Contact> getAllContact() {
		ArrayList<Contact> contactlist = new ArrayList<Contact>();
		ResultSet rs = C3P0Util.query("select * from contact", null);
		try {
			while(rs.next()){
				Contact c = new Contact(rs.getInt("id"),rs.getString("name"),rs.getString("phone"),rs.getString("msg"),rs.getString("time"),rs.getInt("contact_flag"));
				contactlist.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			C3P0Util.closeAll(rs);
		}
		return contactlist;
	}

	//根据ID删除信息
	public int delMsgById(int id) {
		return C3P0Util.update("delete from contact where id=?", new Object[]{id});
	}

}

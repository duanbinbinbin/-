package com.bin.lookz.dao;

import java.util.ArrayList;

import com.bin.lookz.entity.Contact;
import com.bin.lookz.entity.Pp;
import com.bin.lookz.entity.Purchase;
import com.bin.lookz.entity.Users;

public interface UsersDao {

	//添加用户账号密码等字段
	public abstract int addUsers(Users u);
	
	//添加密保
	public abstract int addPp(Pp p);

	//通过账号和密码查找该用户信息
	public abstract Users findUsersByUsers(String name,String password);
	
	//通过对象修改密码
	public int updPsdByUsers(Users u,String psd);
	
	//根据用户名找到用户订单信息
	public ArrayList<Purchase> getOrderByName(String name);
	
	//添加联系信息
	public int addContact(Contact c);
	
	//找回密码
	public abstract Pp findPp(String ppOne,String ppTwo,String ppThree);
	
	//检查该用户是否存在
	public boolean checkName(String name);
}
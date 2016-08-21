package com.bin.lookz.service.impl;

import java.util.ArrayList;

import com.bin.lookz.dao.UsersDao;
import com.bin.lookz.entity.Contact;
import com.bin.lookz.entity.Pp;
import com.bin.lookz.entity.Purchase;
import com.bin.lookz.entity.Users;
import com.bin.lookz.service.UsersService;
import com.bin.lookz.util.Factory;

public class UsersServiceImpl implements UsersService{
	
	private UsersDao usersdao = Factory.getUsersDaoInstance();
	
	//注册
	public int register(Users u){
		return usersdao.addUsers(u);
	}

	//登录
	public Users login(String name, String password) {
		return usersdao.findUsersByUsers(name, password);
	}

	//修改资料
	public int updPsdByUsers(Users u, String psd) {
		return usersdao.updPsdByUsers(u, psd);
	}

	//根据用户名找到用户订单信息
	public ArrayList<Purchase> getOrderByName(String name) {
		return usersdao.getOrderByName(name);
	}

	//添加联系信息
	public int addContact(Contact c) {
		return usersdao.addContact(c);
	}

	//添加密保
	public int addPp(Pp p) {
		return usersdao.addPp(p);
	}

	//找回密码
	public Pp findPp(String ppOne,String ppTwo,String ppThree) {
		return usersdao.findPp(ppOne,ppTwo,ppThree);
	}

	//检查该用户是否存在
	public boolean checkName(String name) {
		return usersdao.checkName(name);
	}
	
	
	
}

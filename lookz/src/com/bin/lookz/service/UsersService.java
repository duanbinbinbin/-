package com.bin.lookz.service;

import java.util.ArrayList;

import com.bin.lookz.entity.Contact;
import com.bin.lookz.entity.Pp;
import com.bin.lookz.entity.Purchase;
import com.bin.lookz.entity.Users;

public interface UsersService {

	//注册
	public abstract int register(Users u);

	//登录
	public abstract Users login(String name,String password);
	
	//修改资料
	public int updPsdByUsers(Users u,String psd);
	
	//根据用户名找到用户订单信息
	public ArrayList<Purchase> getOrderByName(String name);
	
	//添加联系信息
	public int addContact(Contact c);
	
	//添加密保
	public abstract int addPp(Pp p);
	
	//找回密码
	public abstract Pp findPp(String ppOne,String ppTwo,String ppThree);
	
	//检查该用户是否存在
	public boolean checkName(String name);
	
}
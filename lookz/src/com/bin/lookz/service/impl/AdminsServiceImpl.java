package com.bin.lookz.service.impl;

import java.util.ArrayList;

import com.bin.lookz.dao.AdminsDao;
import com.bin.lookz.entity.Admins;
import com.bin.lookz.entity.Users;
import com.bin.lookz.service.AdminsService;
import com.bin.lookz.util.Factory;

public class AdminsServiceImpl implements AdminsService{

	private AdminsDao adminsdao = Factory.getAmindsDaoInstance();
	
	//登录
	public Admins login(String name, String password) {
		return adminsdao.findAdminsByAdmins(name, password);
	}

	//根据ID删除信息
	public int delUsersById(int id) {
		return adminsdao.delUsersById(id);
	}

	//查找所有用户
	public ArrayList<Users> getAllUsers() {
		return adminsdao.getAllUsers();
	}

	//添加管理员信息
	public int addAdmins(Admins a) {
		return adminsdao.addAdmins(a);
	}

	//查找所有管理员信息
	public ArrayList<Admins> getAllAdmins() {
		return adminsdao.getAllAdmins();
	}

	//根据ID删除管理员信息
	public int delAdminsById(int id) {
		return adminsdao.delAdminsById(id);
	}

}

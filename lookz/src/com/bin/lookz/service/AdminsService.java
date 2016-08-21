package com.bin.lookz.service;

import java.util.ArrayList;

import com.bin.lookz.entity.Admins;
import com.bin.lookz.entity.Users;

public interface AdminsService {

	//登录
	public abstract Admins login(String name,String password);
	//查找所有用户
	public ArrayList<Users> getAllUsers();
	//根据ID删除信息
	public int delUsersById(int id);
	//添加管理员信息
	public abstract int addAdmins(Admins a);
	//查找所有管理员信息
	public ArrayList<Admins> getAllAdmins();
	//根据ID删除管理员信息
	public int delAdminsById(int id);
}

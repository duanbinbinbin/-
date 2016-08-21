package com.bin.lookz.dao;

import java.util.ArrayList;

import com.bin.lookz.entity.Admins;
import com.bin.lookz.entity.Users;

public interface AdminsDao {

	//通过账号和密码查找该管理员信息
	public abstract Admins findAdminsByAdmins(String name,String password);
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

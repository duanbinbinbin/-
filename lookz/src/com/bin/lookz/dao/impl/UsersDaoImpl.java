package com.bin.lookz.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bin.lookz.dao.UsersDao;
import com.bin.lookz.entity.Contact;
import com.bin.lookz.entity.Pp;
import com.bin.lookz.entity.Purchase;
import com.bin.lookz.entity.Users;
import com.bin.lookz.util.C3P0Util;

public class UsersDaoImpl implements UsersDao {

	//添加用户账号密码等字段
	public int addUsers(Users u){
		return C3P0Util.update("insert into users (name,password,sex,email,car_flag,money,u_flag) values (?,?,?,?,?,?,?)",new Object[]{u.getName(),u.getPassword(),u.getSex(),u.getEmail(),u.getCar_flag(),100,1});
	}
	
	//通过账号和密码查找该用户信息
	public Users findUsersByUsers(String name, String password) {
		Users u = null;
		ResultSet rs = C3P0Util.query("select * from users where name=? and password=? and u_flag=1", new Object[]{name,password});
		try {
			while(rs.next()){
				u = new Users(rs.getInt("id"),rs.getString("name"),rs.getString("password"),rs.getInt("car_flag"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			C3P0Util.closeAll(rs);
		}
		return u;
	}

	//通过对象修改密码
	public int updPsdByUsers(Users u, String psd) {
		return C3P0Util.update("update users set password=? where name=? and u_flag=1", new Object[]{psd,u.getName()});
	}

	//根据用户名找到用户订单信息
	public ArrayList<Purchase> getOrderByName(String name) {
		ArrayList<Purchase> plist = new ArrayList<Purchase>();
		Purchase p=null;
		String sql = "select b.orders_id,e.name,e.price,d.number,c.time from users a,users_orders b,orders c,orders_goods d, goods e where a.id=b.users_id and b.orders_id=c.orderid and c.orderid=d.orders_id and d.goods_id=e.id and a.name=?";
		ResultSet rs = C3P0Util.query(sql, new Object[]{name});
		try {
			while(rs.next()){
				p= new Purchase(rs.getString("orders_id"),rs.getString("name"),rs.getDouble("price"),rs.getInt("number"),rs.getDate("time"));
				plist.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			C3P0Util.closeAll(rs);
		}
		return plist;
	}

	//添加联系信息
	public int addContact(Contact c) {
		return C3P0Util.update("insert into contact (name,phone,msg,time,contact_flag) values (?,?,?,?,?)", new Object[]{c.getName(),c.getPhone(),c.getMsg(),c.getTime(),c.getContact_flag()});
	}

	//添加密保
	public int addPp(Pp p) {
		return C3P0Util.update("insert into passwordProtect (email,ppOne,pptwo,ppThree,pp_flag) values (?,?,?,?,?)",new Object[]{p.getEmail(),p.getPpone(),p.getPptwo(),p.getPpthree(),p.getPp_flag()});
	}

	//找回密码
	public Pp findPp(String ppOne,String ppTwo,String ppThree) {
		Pp pp = null;
		ResultSet rs = C3P0Util.query("select * from passwordProtect where ppOne=? and ppTwo=? and ppThree=? and pp_flag=1", new Object[]{ppOne,ppTwo,ppThree});
		try {
			while(rs.next()){
				pp = new Pp(rs.getInt("id"),rs.getString("email"),rs.getString("ppOne"),rs.getString("ppTwo"),rs.getString("ppThree"),rs.getInt("pp_flag"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			C3P0Util.closeAll(rs);
		}
		return pp;
	}

	//检查该用户是否存在
	public boolean checkName(String name) {
		boolean flag=false;
		ResultSet rs = C3P0Util.query("select * from users where name=?", new Object[]{name});
		try {
			while(rs.next()){
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
	
}

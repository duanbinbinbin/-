package com.bin.lookz.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bin.lookz.dao.AddressDao;
import com.bin.lookz.entity.Address;
import com.bin.lookz.util.C3P0Util;

public class AddressDaoImpl implements AddressDao{

	//通过用户来查找该用户的收货地址
	public List<Address> findUserAddress(int users_id){
		ArrayList<Address> addresslist = new ArrayList<Address>();
		Address add = null;
		ResultSet rs = C3P0Util.query("select * from deliveryAddress where users_id=? and address_flag=1", new Object[]{users_id});
		try {
			while(rs.next()){
				add = new Address(rs.getInt("id"),rs.getInt("users_id"),rs.getString("name"),rs.getString("phone"),rs.getString("postCode"),rs.getString("province"),rs.getString("city"),rs.getString("area"),rs.getString("address"),rs.getInt("address_flag"));
				addresslist.add(add);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			C3P0Util.closeAll(rs);
		}
		return addresslist;
	}

	
}

package com.bin.lookz.dao;

import java.util.List;

import com.bin.lookz.entity.Address;

public interface AddressDao {

	//通过用户来查找该用户的收货地址
	public abstract List<Address> findUserAddress(int users_id);
	
}

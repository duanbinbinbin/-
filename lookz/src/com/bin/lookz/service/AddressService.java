package com.bin.lookz.service;

import java.util.List;

import com.bin.lookz.entity.Address;

public interface AddressService {

	//通过用户来查找该用户的收货地址
	public abstract List<Address> findUserAddress(int users_id);
	
}

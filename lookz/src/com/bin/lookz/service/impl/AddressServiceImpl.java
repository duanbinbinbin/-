package com.bin.lookz.service.impl;

import java.util.List;

import com.bin.lookz.dao.AddressDao;
import com.bin.lookz.entity.Address;
import com.bin.lookz.service.AddressService;
import com.bin.lookz.util.Factory;

public class AddressServiceImpl implements AddressService {

	private AddressDao addressdao = Factory.getAddressDaoInstance();
	
	//通过用户来查找该用户的收货地址
	public List<Address> findUserAddress(int usersId) {
		return addressdao.findUserAddress(usersId);
	}

}

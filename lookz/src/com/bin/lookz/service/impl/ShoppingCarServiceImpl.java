package com.bin.lookz.service.impl;

import com.bin.lookz.dao.ShoppingCarDao;
import com.bin.lookz.service.ShoppingCarService;
import com.bin.lookz.util.Factory;

public class ShoppingCarServiceImpl implements ShoppingCarService{
	private ShoppingCarDao shoppingcardao = Factory.getShoppingCarDaoInstance();
	/**
	 * 添加到购物车
	 * */
	public int addShoppingCart(int number, double sumPrice, String time,
			int shoppingcarFlag) {
		return shoppingcardao.addShoppingCart(number, sumPrice, time, shoppingcarFlag);
	}

}

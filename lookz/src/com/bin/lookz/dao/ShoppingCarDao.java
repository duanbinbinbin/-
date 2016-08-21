package com.bin.lookz.dao;

public interface ShoppingCarDao {
	
	//添加到购物车
	public int addShoppingCart(int number,double sumPrice,String time,int shoppingcarFlag);
	
}

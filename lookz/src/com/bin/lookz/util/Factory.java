package com.bin.lookz.util;

import com.bin.lookz.dao.AddressDao;
import com.bin.lookz.dao.AdminMessageDao;
import com.bin.lookz.dao.AdminsDao;
import com.bin.lookz.dao.AdminsGoodsDao;
import com.bin.lookz.dao.GoodsDao;
import com.bin.lookz.dao.OrderDao;
import com.bin.lookz.dao.ShoppingCarDao;
import com.bin.lookz.dao.UsersDao;
import com.bin.lookz.dao.impl.AddressDaoImpl;
import com.bin.lookz.dao.impl.AdminMessageDaoImpl;
import com.bin.lookz.dao.impl.AdminsDaoImpl;
import com.bin.lookz.dao.impl.AdminsGoodsDaoImpl;
import com.bin.lookz.dao.impl.GoodsDaoImpl;
import com.bin.lookz.dao.impl.OrderDaoImpl;
import com.bin.lookz.dao.impl.ShoppingCarDaoImpl;
import com.bin.lookz.dao.impl.UsersDaoImpl;
import com.bin.lookz.service.AddressService;
import com.bin.lookz.service.AdminMessageService;
import com.bin.lookz.service.AdminsGoodsService;
import com.bin.lookz.service.AdminsService;
import com.bin.lookz.service.GoodsService;
import com.bin.lookz.service.OrderService;
import com.bin.lookz.service.ShoppingCarService;
import com.bin.lookz.service.UsersService;
import com.bin.lookz.service.impl.AddressServiceImpl;
import com.bin.lookz.service.impl.AdminMessageServiceImpl;
import com.bin.lookz.service.impl.AdminsGoodsServiceImpl;
import com.bin.lookz.service.impl.AdminsServiceImpl;
import com.bin.lookz.service.impl.GoodsServiceImpl;
import com.bin.lookz.service.impl.OrderServiceImpl;
import com.bin.lookz.service.impl.ShoppingCarServiceImpl;
import com.bin.lookz.service.impl.UsersServiceImpl;

public class Factory {

	public static UsersDao getUsersDaoInstance(){
		return new UsersDaoImpl();
	}
	public static UsersService getUsersServiceInstance(){
		return new UsersServiceImpl();
	}
	
	public static AdminsDao getAmindsDaoInstance(){
		return new AdminsDaoImpl();
	}
	public static AdminsService getAdminsServiceInstance(){
		return new AdminsServiceImpl();
	}
	
	public static AdminsGoodsDao getAdminsGoodsDaoInstance(){
		return new AdminsGoodsDaoImpl();
	}
	public static AdminsGoodsService getAdminsGoodsServiceInstance(){
		return new AdminsGoodsServiceImpl();
	}
	
	public static GoodsDao getGoodsDaoInstance(){
		return new GoodsDaoImpl();
	}
	public static GoodsService getGoodsServiceInstance(){
		return new GoodsServiceImpl();
	}
	
	public static ShoppingCarDao getShoppingCarDaoInstance(){
		return new ShoppingCarDaoImpl();
	}
	public static ShoppingCarService getShoppingCarServiceInstance(){
		return new ShoppingCarServiceImpl();
	}
	
	public static AddressDao getAddressDaoInstance(){
		return new AddressDaoImpl();
	}
	public static AddressService getAddressServiceInstance(){
		return new AddressServiceImpl();
	}
	
	public static OrderDao getOrderDaoInstance(){
		return new OrderDaoImpl();
	}
	public static OrderService getOrderServiceInstance(){
		return new OrderServiceImpl();
	}
	
	public static AdminMessageDao getAdminMessageDaoInstance(){
		return new AdminMessageDaoImpl();
	}
	public static AdminMessageService getAdminMessageServiceInstance(){
		return new AdminMessageServiceImpl();
	}
	
}

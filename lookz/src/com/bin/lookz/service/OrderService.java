package com.bin.lookz.service;

import com.bin.lookz.entity.Order;
import com.bin.lookz.entity.Users;

public interface OrderService {
	
	//下订单
	public int addAllOrder(Users users,Order order);
	
	//添加订单
	public int addOrder(Order o);
	
	//添加用户和订单
	public int addUserAndOrder(int u_id,long o_id);
	
	//根据用户的ID来查找订单的ID
	public int getOrderIdByUserId(int userid);
	
	//添加订单和商品关联
	public int addOrderAndGoods(long o_id,int g_id,int num);
	//根据订单的ID等到商品的ID
	public int getGoodIdByOrderId(int orderid);
}

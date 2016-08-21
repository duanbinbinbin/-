package com.bin.lookz.service.impl;

import java.util.ArrayList;

import com.bin.lookz.dao.OrderDao;
import com.bin.lookz.entity.Goods;
import com.bin.lookz.entity.Order;
import com.bin.lookz.entity.Users;
import com.bin.lookz.service.OrderService;
import com.bin.lookz.util.Factory;

public class OrderServiceImpl implements OrderService{
	private OrderDao orderdao = Factory.getOrderDaoInstance();
	//添加订单
	public int addOrder(Order o) {
		return orderdao.addOrder(o);
	}

	//添加订单和商品关联
	public int addOrderAndGoods(long oId, int gId, int num) {
		return orderdao.addOrderAndGoods(oId, gId, num);
	}

	//添加用户和订单
	public int addUserAndOrder(int uId, long oId) {
		return orderdao.addUserAndOrder(uId, oId);
	}

	//根据订单的ID等到商品的ID
	public int getGoodIdByOrderId(int orderid) {
		return orderdao.getGoodIdByOrderId(orderid);
	}

	//根据用户的ID来查找订单的ID
	public int getOrderIdByUserId(int userid) {
		return orderdao.getOrderIdByUserId(userid);
	}

	//下订单
	public int addAllOrder(Users users, Order order) {
		//获取商品集合
		ArrayList<Goods> goodslist = users.getShoppingCar().getGoodslist();
		//获取购物车总数量
		ArrayList<Integer> numlist = users.getShoppingCar().getGoodsNum();
		//添加订单
		orderdao.addOrder(order);
		//添加用户和订单
		orderdao.addUserAndOrder(users.getId(), order.getOrderid());
		//添加订单和商品
		for(int i=0;i<goodslist.size();i++){
			orderdao.addOrderAndGoods(order.getOrderid(), goodslist.get(i).getId(), numlist.get(i));
		}
		return 1;
	}

}

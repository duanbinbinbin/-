package com.bin.lookz.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.bin.lookz.dao.OrderDao;
import com.bin.lookz.entity.Order;
import com.bin.lookz.util.C3P0Util;

public class OrderDaoImpl implements OrderDao{
	//添加订单
	public int addOrder(Order o) {
		return C3P0Util.update("insert into orders values (?,?,?,?,?) ", new Object[]{o.getOrderid(),o.getPayWay(),o.getTime(),o.getOrderState(),o.getOrder_flag()});
	}

	//添加订单和商品关联
	public int addOrderAndGoods(long o_id, int g_id, int num) {
		return C3P0Util.update("insert into orders_goods (orders_id,goods_id,number) values (?,?,?)", new Object[]{o_id,g_id,num});
	}

	//添加用户和订单
	public int addUserAndOrder(int u_id, long o_id) {
		return C3P0Util.update("insert into users_orders (users_id,orders_id) values (?,?)", new Object[]{u_id,o_id});
	}

	//根据用户的ID来查找订单的ID
	public int getOrderIdByUserId(int userid) {
		int orderid=0;
		ResultSet rs = C3P0Util.query("select order_id from users_orders where users_id=?", new Object[]{userid});
		try {
			orderid = rs.getInt("order_id");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			C3P0Util.closeAll(rs);
		}
		return orderid;
	}

	//根据订单的ID等到商品的ID
	public int getGoodIdByOrderId(int orderid) {
		int goodid=0;
		ResultSet rs = C3P0Util.query("select goods_id from orders_goods where orders_id=?", new Object[]{orderid});
		try {
			goodid = rs.getInt("goods_id");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			C3P0Util.closeAll(rs);
		}
		return goodid;
	}

}

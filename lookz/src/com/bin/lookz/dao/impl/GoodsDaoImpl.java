package com.bin.lookz.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bin.lookz.dao.GoodsDao;
import com.bin.lookz.entity.Address;
import com.bin.lookz.entity.Goods;
import com.bin.lookz.util.C3P0Util;

public class GoodsDaoImpl implements GoodsDao{
	public int sizes = 6;
	
	//得到所有的商品信息
	public List<Goods> getAllGoods() {
		ArrayList<Goods> goodslist = new ArrayList<Goods>();
		ResultSet rs = C3P0Util.query("select * from goods where goods_flag=1", null);
		try {
			while(rs.next()){
				Goods goods = new Goods(rs.getInt("id"),rs.getString("name"),rs.getString("introduce"),rs.getString("type"),rs.getString("tasteType"),rs.getString("healthType"),rs.getString("manufacturer"),rs.getDouble("price"),rs.getString("imgUrl"),rs.getInt("evaluate"),rs.getInt("num"),rs.getDouble("dicount"),rs.getInt("score"),rs.getInt("goods_flag"));
				goodslist.add(goods); 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			C3P0Util.closeAll(rs);
		}
		return goodslist;
	}
	
	//根据Type查找商品信息
	public List<Goods> getAllGoodsByType(String type,int pages) {
		int number = (pages-1)*sizes;
		ArrayList<Goods> goodslist = new ArrayList<Goods>();
		ResultSet rs = C3P0Util.query("select top(?) * from goods where type=? and id not in (select top(?) id from goods where type=? order by id) order by id", new Object[]{sizes,type,number,type});
		try {
			while(rs.next()){
				Goods goods = new Goods(rs.getInt("id"),rs.getString("name"),rs.getString("introduce"),rs.getString("type"),rs.getString("tasteType"),rs.getString("healthType"),rs.getString("manufacturer"),rs.getDouble("price"),rs.getString("imgUrl"),rs.getInt("evaluate"),rs.getInt("num"),rs.getDouble("dicount"),rs.getInt("score"),rs.getInt("goods_flag"));
				goodslist.add(goods);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			C3P0Util.closeAll(rs);
		}
		return goodslist;
	}
	
	//根据type找到商品的信息的条数
	public List<Goods> getGoodsByType(String type) {
		ArrayList<Goods> goodslist = new ArrayList<Goods>();
		ResultSet rs = C3P0Util.query("select * from goods where type=? and goods_flag=1", new Object[]{type});
		try {
			while(rs.next()){
				Goods goods = new Goods(rs.getInt("id"),rs.getString("name"),rs.getString("introduce"),rs.getString("type"),rs.getString("tasteType"),rs.getString("healthType"),rs.getString("manufacturer"),rs.getDouble("price"),rs.getString("imgUrl"),rs.getInt("evaluate"),rs.getInt("num"),rs.getDouble("dicount"),rs.getInt("score"),rs.getInt("goods_flag"));
				goodslist.add(goods); 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			C3P0Util.closeAll(rs);
		}
		return goodslist;
	}
	
	
	//得到主菜最大页数
	public int getPage(String type){
		GoodsDaoImpl gdi = new GoodsDaoImpl();
		int c = gdi.getGoodsByType(type).size();
		if(c%sizes==0){
			c = c/sizes;
		}else{
			c = c/sizes+1;
		}
		return c;
	}
	
	//得到type和类型的最大页数
	public int getPageByTwoType(String type1, String type2) {
		ArrayList<Goods> goodslist = new ArrayList<Goods>();
		ResultSet rs = C3P0Util.query("SELECT * FROM goods WHERE type=? and tasteType like ? OR healthType like ? OR manufacturer like ?", new Object[]{type1,type2,type2,type2});
		int c;
		
		try {
			while(rs.next()){
				Goods goods = new Goods(rs.getInt("id"),rs.getString("name"),rs.getString("introduce"),rs.getString("type"),rs.getString("tasteType"),rs.getString("healthType"),rs.getString("manufacturer"),rs.getDouble("price"),rs.getString("imgUrl"),rs.getInt("evaluate"),rs.getInt("num"),rs.getDouble("dicount"),rs.getInt("score"),rs.getInt("goods_flag"));
				goodslist.add(goods); 
			}
			c = goodslist.size();
			if(c%sizes==0){
				c = c/sizes;
			}else{
				c = c/sizes+1;
			}
			return c;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			C3P0Util.closeAll(rs);
		}
		return 0;
	}
	
	//得到keyword查询的最大页数
	public int getPageBySearch(String keyword) {
		ArrayList<Goods> goodslist = new ArrayList<Goods>();
		keyword = "%" + keyword + "%";
		ResultSet rs = C3P0Util.query("SELECT * FROM goods WHERE goods_flag=1 and name like ? OR introduce like ? OR type like ? OR tasteType like ? OR healthType like ? OR manufacturer like ?",new Object[]{keyword,keyword,keyword,keyword,keyword,keyword});
		int c;
		try {
			while( rs.next() ){
				Goods goods = new Goods(rs.getInt("id"),rs.getString("name"),rs.getString("introduce"),rs.getString("type"),rs.getString("tasteType"),rs.getString("healthType"),rs.getString("manufacturer"),rs.getDouble("price"),rs.getString("imgUrl"),rs.getInt("evaluate"),rs.getInt("num"),rs.getDouble("dicount"),rs.getInt("score"),rs.getInt("goods_flag"));
				goodslist.add(goods);
			}
			c = goodslist.size();
			if(c%sizes==0){
				c = c/sizes;
			}else{
				c = c/sizes+1;
			}
			return c;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			C3P0Util.closeAll(rs);
		}
		return 0;
	}

	//根据tasteType查找商品信息
	public List<Goods> getGoodsByTasteType(String type,String tasteType, int pages) {
		int number = (pages-1)*sizes;
		ArrayList<Goods> goodslist = new ArrayList<Goods>();
		ResultSet rs = C3P0Util.query("select top(?) * from goods where type=? and tasteType=? and id not in (select top(?) id from goods where type=? and tasteType=? order by id) order by id", new Object[]{sizes,type,tasteType,number,type,tasteType});
		try {
			while(rs.next()){
				Goods goods = new Goods(rs.getInt("id"),rs.getString("name"),rs.getString("introduce"),rs.getString("type"),rs.getString("tasteType"),rs.getString("healthType"),rs.getString("manufacturer"),rs.getDouble("price"),rs.getString("imgUrl"),rs.getInt("evaluate"),rs.getInt("num"),rs.getDouble("dicount"),rs.getInt("score"),rs.getInt("goods_flag"));
				goodslist.add(goods);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			C3P0Util.closeAll(rs);
		}
		return goodslist;
	}

	//根据healthType查找商品信息
	public List<Goods> getGoodsByHealthType(String type, String healthType,
			int pages) {
		int number = (pages-1)*sizes;
		ArrayList<Goods> goodslist = new ArrayList<Goods>();
		ResultSet rs = C3P0Util.query("select top(?) * from goods where type=? and healthType=? and id not in (select top(?) id from goods where type=? and healthType=? order by id) order by id", new Object[]{sizes,type,healthType,number,type,healthType});
		try {
			while(rs.next()){
				Goods goods = new Goods(rs.getInt("id"),rs.getString("name"),rs.getString("introduce"),rs.getString("type"),rs.getString("tasteType"),rs.getString("healthType"),rs.getString("manufacturer"),rs.getDouble("price"),rs.getString("imgUrl"),rs.getInt("evaluate"),rs.getInt("num"),rs.getDouble("dicount"),rs.getInt("score"),rs.getInt("goods_flag"));
				goodslist.add(goods);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			C3P0Util.closeAll(rs);
		}
		return goodslist;
	}
	//根据manufacturer查找商品信息
	public List<Goods> getGoodsByManufacturer(String type,
			String manufacturer, int pages) {
		int number = (pages-1)*sizes;
		ArrayList<Goods> goodslist = new ArrayList<Goods>();
		ResultSet rs = C3P0Util.query("select top(?) * from goods where type=? and manufacturer=? and id not in (select top(?) id from goods where type=? and manufacturer=? order by id) order by id", new Object[]{sizes,type,manufacturer,number,type,manufacturer});
		try {
			while(rs.next()){
				Goods goods = new Goods(rs.getInt("id"),rs.getString("name"),rs.getString("introduce"),rs.getString("type"),rs.getString("tasteType"),rs.getString("healthType"),rs.getString("manufacturer"),rs.getDouble("price"),rs.getString("imgUrl"),rs.getInt("evaluate"),rs.getInt("num"),rs.getDouble("dicount"),rs.getInt("score"),rs.getInt("goods_flag"));
				goodslist.add(goods);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			C3P0Util.closeAll(rs);
		}
		return goodslist;
	}

	//根据关键字查找相关商品信息
	public List<Goods> getGoodsByKeyWord(String keyword,int pages) {
		int number = (pages-1)*sizes;
		ArrayList<Goods> goodslist = new ArrayList<Goods>();
		keyword = "%" + keyword + "%";
		//ResultSet rs = C3P0Util.query("SELECT * FROM goods WHERE name like ? OR introduce like ? OR type like ? OR tasteType like ? OR healthType like ? OR manufacturer like ?",new Object[]{keyword,keyword,keyword,keyword,keyword,keyword});
		ResultSet rs = C3P0Util.query("select top(?) * from goods where goods_flag=1 and name like ? OR introduce like ? OR type like ? OR tasteType like ? OR healthType like ? OR manufacturer like ? and id not in (select top(?) id from goods where goods_flag=1 and name like ? OR introduce like ? OR type like ? OR tasteType like ? OR healthType like ? OR manufacturer like ? order by id) order by id", new Object[]{sizes,keyword,keyword,keyword,keyword,keyword,keyword,number,keyword,keyword,keyword,keyword,keyword,keyword});
		try {
			while( rs.next() ){
				Goods goods = new Goods(rs.getInt("id"),rs.getString("name"),rs.getString("introduce"),rs.getString("type"),rs.getString("tasteType"),rs.getString("healthType"),rs.getString("manufacturer"),rs.getDouble("price"),rs.getString("imgUrl"),rs.getInt("evaluate"),rs.getInt("num"),rs.getDouble("dicount"),rs.getInt("score"),rs.getInt("goods_flag"));
				goodslist.add(goods);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			C3P0Util.closeAll(rs);
		}
		return goodslist;
	}

	/**
	 * 根据ID查找商品信息
	 * @param id 商品ID
	 * @return Goods
	 * */
	public Goods getGoodsById(int id) {
		Goods g = new Goods();
		ResultSet rs = C3P0Util.query("SELECT * FROM goods WHERE id=? and goods_flag=1",new Object[]{id});
		try {
			while( rs.next() ){
				g = new Goods(rs.getInt("id"),rs.getString("name"),rs.getString("introduce"),rs.getString("type"),rs.getString("tasteType"),rs.getString("healthType"),rs.getString("manufacturer"),rs.getDouble("price"),rs.getString("imgUrl"),rs.getInt("evaluate"),rs.getInt("num"),rs.getDouble("dicount"),rs.getInt("score"),rs.getInt("goods_flag"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			C3P0Util.closeAll(rs);
		}
		return g;
	}

	/**
	 * 添加收货地址信息
	 * @return int类型
	 * */
	public int addAddress(Address a) {
		return C3P0Util.update("insert into deliveryAddress (users_id,name,phone,postCode,province,city,area,address,address_flag) values (?,?,?,?,?,?,?,?,?)",new Object[]{a.getUsers_id(),a.getName(),a.getPhone(),a.getPostCode(),a.getProvince(),a.getCity(),a.getArea(),a.getAddress(),a.getAddress_flag()});
	}

	

	

	
	

}

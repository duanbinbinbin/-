package com.bin.lookz.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bin.lookz.dao.AdminsGoodsDao;
import com.bin.lookz.entity.Goods;
import com.bin.lookz.util.C3P0Util;

public class AdminsGoodsDaoImpl implements AdminsGoodsDao {
	public int sizes = 10;
	//添加商品
	public int addGoods(Goods g) {
		return C3P0Util.update("insert into goods (name,introduce,type,tasteType,healthType,manufacturer,price,imgUrl,evaluate,num,dicount,goods_flag) values (?,?,?,?,?,?,?,?,?,?,?,1)", new Object[]{g.getName(),g.getIntroduce(),g.getType(),g.getTasteType(),g.getHealthType(),g.getManufacturer(),g.getPrice(),g.getImgUrl(),g.getEvaluate(),g.getNum(),g.getDicount()});
	}

	//得到当前页的商品内容
	public ArrayList<Goods> getAllGoods(int pages) {
		ArrayList<Goods> goodslist = new ArrayList<Goods>();
		int number = (pages-1)*sizes;
		ResultSet rs = C3P0Util.query("select top(?) * from goods where id not in (select top(?)  id from goods order by id) order by id", new Object[]{sizes,number});
		try {
			while(rs.next()){
				Goods g = new Goods(rs.getInt("id"),rs.getString("name"),rs.getString("introduce"),rs.getString("type"),rs.getString("tasteType"),rs.getString("healthType"),rs.getString("manufacturer"),rs.getDouble("price"),rs.getString("imgUrl"),rs.getInt("evaluate"),rs.getInt("num"),rs.getDouble("dicount"),rs.getInt("score"),rs.getInt("goods_flag"));
				goodslist.add(g);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			C3P0Util.closeAll(rs);
		}
		return goodslist;
	}
	
	//根据关键字查找相关商品信息
	public List<Goods> getGoodsByKeyWord(String keyword,int pages){
		int number = (pages-1)*sizes;
		ArrayList<Goods> goodslist = new ArrayList<Goods>();
		keyword = "%" + keyword + "%";
		ResultSet rs = C3P0Util.query("select top(?) * from goods where goods_flag=1 and" +
				" name like ? OR introduce like ? OR type like ? OR tasteType like ? OR " +
				"healthType like ? OR manufacturer like ? and id not in (select top(?) " +
				"id from goods where goods_flag=1 and name like ? OR introduce like ? OR " +
				"type like ? OR tasteType like ? OR healthType like ? OR manufacturer like " +
				"? order by id) order by id", new Object[]{sizes,keyword,keyword,keyword,keyword,
				keyword,keyword,number,keyword,keyword,keyword,keyword,keyword,keyword});
		try {
			while( rs.next() ){
				Goods goods = new Goods(rs.getInt("id"),rs.getString("name"),rs.getString("introduce"),
						rs.getString("type"),rs.getString("tasteType"),rs.getString("healthType"),
						rs.getString("manufacturer"),rs.getDouble("price"),rs.getString("imgUrl"),
						rs.getInt("evaluate"),rs.getInt("num"),rs.getDouble("dicount"),rs.getInt("score"),
						rs.getInt("goods_flag"));
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
	public int getPage() {
		GoodsDaoImpl gdi = new GoodsDaoImpl();
		int c = gdi.getAllGoods().size();
		if(c%sizes==0){
			c = c/sizes;
		}else{
			c = c/sizes+1;
		}
		return c;
	}

	//根据ID删除信息
	public int delGoodsById(int id) {
		return C3P0Util.update("delete from goods where id=?", new Object[]{id});
	}
	
	/**
	 * 根据Id查找信息
	 * */
	public Goods getGoodsById(int id) {
		Goods g = new Goods();
		ResultSet rs = C3P0Util.query("SELECT * FROM goods WHERE id=?",new Object[]{id});
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
	 * 根据goods来修改信息
	 * */
	public int updGoodsByGoods(Goods g) {
		return C3P0Util.update("update goods set name=?,introduce=?,type=?,tasteType=?,healthType=?," +
				"manufacturer=?,price=?,evaluate=?,num=?,dicount=? " +
				"where id=?", new Object[]{g.getName(),g.getIntroduce(),g.getType(),
				g.getTasteType(),g.getHealthType(),g.getManufacturer(),g.getPrice(),
				g.getEvaluate(),g.getNum(),g.getDicount(),g.getId()});
	}

	/**
	 * 得到查询的最大页数
	 * */
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

}

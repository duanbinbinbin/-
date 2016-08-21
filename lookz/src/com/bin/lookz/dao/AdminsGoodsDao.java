package com.bin.lookz.dao;

import java.util.ArrayList;
import java.util.List;

import com.bin.lookz.entity.Goods;

public interface AdminsGoodsDao {

	//添加商品
	public abstract int addGoods(Goods g);
	
	//得到当前页的商品内容
	public abstract ArrayList<Goods> getAllGoods(int pages);
	
	//根据关键字查找相关商品信息
	public abstract List<Goods> getGoodsByKeyWord(String key,int pages);
	
	//得到最大页数
	public abstract int getPage();
	
	//根据ID删除信息
	public abstract int delGoodsById(int id);
	
	/**
	 * 根据Id查找信息
	 * */
	public abstract Goods getGoodsById(int id);
	
	/**
	 * 根据goods来修改信息
	 * */
	public abstract int updGoodsByGoods(Goods g);
	
	/**
	 * 得到查询的最大页数
	 * */
	public abstract int getPageBySearch(String keyword);
}

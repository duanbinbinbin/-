package com.bin.lookz.service;

import java.util.ArrayList;
import java.util.List;

import com.bin.lookz.entity.Goods;

public interface AdminsGoodsService {

	//添加商品
	public abstract int addGoods(Goods g);
	
	//得到当前页的商品内容
	public abstract ArrayList<Goods> getAllGoods(int pages);
	
	//根据关键字查找相关商品信息
	public abstract List<Goods> getGoodsByKeyWord(String key,int pages);
	
	//得到最大页数
	public abstract int getPage();
	
	/**
	 * 根据ID删除商品
	 * @return 返回int
	 * */
	public abstract int delGoodsById(int id);
	
	/**
	 * 根据ID查找商品
	 * @param 商品集合
	 * @return 返回Goods对象
	 * */
	public abstract Goods getGoodsById(int id);
	
	/**
	 * 根据goods来修改商品信息
	 * @param Goods 商品对象
	 * @return int类型
	 * */
	public abstract int updGoodsByGoods(Goods g); 
	
	/**
	 * 得到查询的最大页数
	 * */
	public abstract int getPageBySearch(String keyword);
	
}

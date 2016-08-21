package com.bin.lookz.dao;

import java.util.List;

import com.bin.lookz.entity.Address;
import com.bin.lookz.entity.Goods;

public interface GoodsDao {

	//获取所有商品表信息
	public abstract List<Goods> getAllGoods();
	//根据Type查找商品信息
	public abstract List<Goods> getAllGoodsByType(String type,int pages);
	//得到type分类最大页数
	public abstract int getPage(String type);
	//得到type和类型的最大页数
	public abstract int getPageByTwoType(String type1,String type2);
	//得到查询的最大页数
	public abstract int getPageBySearch(String keyword);
	
	//根据tasteType查找商品信息
	public abstract List<Goods> getGoodsByTasteType(String type,String tasteType,int pages);
	//根据healthType查找商品信息
	public abstract List<Goods> getGoodsByHealthType(String type,String healthType,int pages);
	//根据manufacturer查找商品信息
	public abstract List<Goods> getGoodsByManufacturer(String type,String manufacturer,int pages);
	
	//根据type找到商品的信息的条数
	public abstract List<Goods> getGoodsByType(String type);
	
	//根据关键字查找相关商品信息
	public abstract List<Goods> getGoodsByKeyWord(String keyword,int pages);
	
	/**
	 * 根据ID查找商品信息
	 * @return Goods
	 * */
	public abstract Goods getGoodsById(int id);
	
	/**
	 * 添加收货地址信息
	 * @return int
	 * */
	public abstract int addAddress(Address a);
}

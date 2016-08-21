package com.bin.lookz.service;

import java.util.List;

import com.bin.lookz.entity.Address;
import com.bin.lookz.entity.Goods;

public interface GoodsService {

	//查找全部商品信息
	public abstract List<Goods> getAllGoods();
	
	//根据Type查找商品信息
	public abstract List<Goods> getAllGoodsByType(String type,int pages);
	//得到最大页数
	public abstract int getPage(String type);
	//得到type和类型的最大页数
	public abstract int getPageByTwoType(String type1,String type2);
	//得到keyword查询的最大页数
	public abstract int getPageBySearch(String keyword);
	
	//根据tasteType查找商品信息
	public abstract List<Goods> getGoodsByTasteType(String type,String tasteType,int pages);
	//根据healthType查找商品信息
	public abstract List<Goods> getGoodsByHealthType(String type,String healthType,int pages);
	//根据manufacturer查找商品信息
	public abstract List<Goods> getGoodsByManufacturer(String type,String manufacturer,int pages);

	//根据关键字查找相关商品信息
	public abstract List<Goods> getGoodsByKeyWord(String keyword,int pages);
	
	/**
	 * 根据ID查找商品信息
	 * @param id 商品ID
	 * @return Goods
	 * */
	public abstract Goods getGoodsById(int id);
	
	/**
	 * 添加收货地址信息
	 * @return int类型
	 * */
	public abstract int addAddress(Address a);
}

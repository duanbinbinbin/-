package com.bin.lookz.service.impl;

import java.util.List;

import com.bin.lookz.dao.GoodsDao;
import com.bin.lookz.entity.Address;
import com.bin.lookz.entity.Goods;
import com.bin.lookz.service.GoodsService;
import com.bin.lookz.util.Factory;

public class GoodsServiceImpl implements GoodsService {

	private GoodsDao goodsdao = Factory.getGoodsDaoInstance();
	
	//根据Type查找商品信息
	public List<Goods> getAllGoodsByType(String type,int pages) {
		return goodsdao.getAllGoodsByType(type,pages);
	}

	//查找全部商品信息
	public List<Goods> getAllGoods() {
		return goodsdao.getAllGoods();
	}

	//得到最大页数
	public int getPage(String type) {
		return goodsdao.getPage(type);
	}
	//得到type和类型的最大页数
	public int getPageByTwoType(String type1, String type2) {
		return goodsdao.getPageByTwoType(type1, type2);
	}
	//得到keyword查询的最大页数
	public int getPageBySearch(String keyword) {
		return goodsdao.getPageBySearch(keyword);
	}

	//根据tasteType查找 商品信息
	public List<Goods> getGoodsByTasteType(String type,String tasteType, int pages) {
		return goodsdao.getGoodsByTasteType(type,tasteType, pages);
	}

	//根据healthType查找商品信息
	public List<Goods> getGoodsByHealthType(String type, String healthType,
			int pages) {
		return goodsdao.getGoodsByHealthType(type, healthType, pages);
	}
	//根据manufacturer查找商品信息
	public List<Goods> getGoodsByManufacturer(String type,
			String manufacturer, int pages) {
		return goodsdao.getGoodsByManufacturer(type, manufacturer, pages);
	}

	//根据关键字查找相关商品信息
	public List<Goods> getGoodsByKeyWord(String keyword, int pages) {
		return goodsdao.getGoodsByKeyWord(keyword, pages);
	}

	/**
	 * 根据ID查找商品信息
	 * @param id 商品ID
	 * @return Goods
	 * */
	public Goods getGoodsById(int id) {
		return goodsdao.getGoodsById(id);
	}

	/**
	 * 添加收货地址信息
	 * @return int类型
	 * */
	public int addAddress(Address a) {
		return goodsdao.addAddress(a);
	}

	

	
	
}

package com.bin.lookz.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.bin.lookz.dao.AdminsGoodsDao;
import com.bin.lookz.entity.Goods;
import com.bin.lookz.service.AdminsGoodsService;
import com.bin.lookz.util.Factory;

public class AdminsGoodsServiceImpl implements AdminsGoodsService{

	private AdminsGoodsDao adminsgoodsdao = Factory.getAdminsGoodsDaoInstance();
	
	//添加商品
	public int addGoods(Goods g) {
		return adminsgoodsdao.addGoods(g);
	}

	//得到当前页的商品内容
	public ArrayList<Goods> getAllGoods(int pages) {
		return adminsgoodsdao.getAllGoods(pages);
	}

	//根据关键字查找相关商品信息
	public List<Goods> getGoodsByKeyWord(String keyword,int pages) {
		return adminsgoodsdao.getGoodsByKeyWord(keyword,pages);
	}

	//得到主菜最大页数
	public int getPage() {
		return adminsgoodsdao.getPage();
	}

	
	/**
	 * 根据ID删除商品
	 * @return 返回int
	 * */
	public int delGoodsById(int id) {
		return adminsgoodsdao.delGoodsById(id);
	}

	/**
	 * 根据ID查找商品
	 * @param 商品集合
	 * @return 返回Goods对象
	 * */
	public Goods getGoodsById(int id) {
		return adminsgoodsdao.getGoodsById(id);
	}

	/**
	 * 根据goods来修改商品信息
	 * @param Goods 商品对象
	 * @return int类型
	 * */
	public int updGoodsByGoods(Goods g) {
		return adminsgoodsdao.updGoodsByGoods(g);
	}

	/**
	 * 得到查询的最大页数
	 * @return int 
	 * */
	public int getPageBySearch(String keyword) {
		return adminsgoodsdao.getPageBySearch(keyword);
	}

}

package com.bin.lookz.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bin.lookz.entity.Goods;
import com.bin.lookz.entity.ShoppingCar;
import com.bin.lookz.entity.Users;

public class DelShopGoodsServlet extends HttpServlet {

	private static final long serialVersionUID = -44637804858862656L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取索引
		String[] index = request.getParameterValues("index");
		
		Users u = (Users) request.getSession().getAttribute("user");
		ShoppingCar car = u.getShoppingCar();
		
		//通过索引删除信息
		for (int i = index.length-1; i>=0; i--) {
			int in = Integer.parseInt(index[i]);
			car.getGoodslist().remove(in);
			car.getGoodsNum().remove(in);
		}
		
		//设置购物车总价
		car.setSumPrice(this.getSumPrice(car.getGoodslist(), car.getGoodsNum()));
		//设置购物车总数量
		car.setSumCount(this.getSumCount(car.getGoodsNum()));
		response.sendRedirect("cart.jsp");
	}
	
	//购物车总价
	public double getSumPrice(ArrayList<Goods> goods,ArrayList<Integer> counts){
		double d = 0;
		for(int i=0;i<goods.size();i++){
			d+=goods.get(i).getPrice()*counts.get(i);
		}
		return d;
	}

	//购物车总数量
	public int getSumCount(ArrayList<Integer> counts){
		int c = 0;
		for(int i=0;i<counts.size();i++){
			c+=counts.get(i);
		}
		return c;
	}

}

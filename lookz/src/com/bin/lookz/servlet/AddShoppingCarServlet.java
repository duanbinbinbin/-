package com.bin.lookz.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bin.lookz.entity.Goods;
import com.bin.lookz.entity.ShoppingCar;
import com.bin.lookz.entity.Users;
import com.bin.lookz.util.Factory;

public class AddShoppingCarServlet extends HttpServlet {

	private static final long serialVersionUID = -4777331974158283204L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		//通过ID查找商品信息
		Goods good = Factory.getGoodsServiceInstance().getGoodsById(id);
		System.out.println(good.getName());
		//获取购物车用户的对象
		Users user = (Users)request.getSession().getAttribute("user");
		ShoppingCar car = user.getShoppingCar();
		
		boolean b = false;
		//判断该商品是否购买过
		for (int i = 0; i < car.getGoodslist().size(); i++) {
			if(car.getGoodslist().get(i).getId() == good.getId()){
				/**
				 * 如果该商品买过 则修改该商品对应的数量
				 * */
				int count = car.getGoodsNum().get(i); //得到当前这个商品的数量
				car.getGoodsNum().set(i, count+1);
				//修改状态
				b = true;
				break;
			}
		}
		//否则则是第一次购买
		if(!b){
			car.getGoodslist().add(good); //商品加进去
			car.getGoodsNum().add(1);  //数量加1
		}
		
		//设置购物车总价
		car.setSumPrice(this.getSumPrice(car.getGoodslist(), car.getGoodsNum()));
		//设置购物车总数量
		car.setSumCount(this.getSumCounts(car.getGoodsNum()));
		//得到当前的时间
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String currentTime =format.format(new Date());
		
		System.out.println(car.getSumCount());
		System.out.println(user.getCar_flag());
		//添加到购物车表
		Factory.getShoppingCarServiceInstance().addShoppingCart(car.getSumCount(), car.getSumPrice(), currentTime, user.getCar_flag());
		//跳转页面显示
		response.sendRedirect("cart.jsp");
	}
	
	//得到购物车总价
	public double getSumPrice(ArrayList<Goods> goods,ArrayList<Integer> counts){
		double d = 0;
		for (int i=0;i<goods.size();i++) {
			d+=goods.get(i).getPrice()*counts.get(i);
		}
		return d;
	}
	
	//得到购物车的总数量
	public int getSumCounts(ArrayList<Integer> counts){
		int c = 0;
		for (int i = 0; i < counts.size(); i++) {
			c += counts.get(i);
		}
		return c;
	}

}

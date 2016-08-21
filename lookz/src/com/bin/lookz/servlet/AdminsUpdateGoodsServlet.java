package com.bin.lookz.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bin.lookz.entity.Goods;
import com.bin.lookz.util.Factory;
import com.bin.lookz.util.StringUtilBin;

public class AdminsUpdateGoodsServlet extends HttpServlet {

	private static final long serialVersionUID = 3898901648159593184L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = StringUtilBin.filterHtml(request.getParameter("name"));
		String introduce = StringUtilBin.filterHtml(request.getParameter("introduce"));
		String type = StringUtilBin.filterHtml(request.getParameter("type"));
		String tasteType = StringUtilBin.filterHtml(request.getParameter("tasteType"));
		String healthType = StringUtilBin.filterHtml(request.getParameter("healthType"));
		String manufacturer = StringUtilBin.filterHtml(request.getParameter("manufacturer"));
		double price = Double.parseDouble(request.getParameter("price"));
		int num = Integer.parseInt(request.getParameter("num"));
		double dicount = Double.parseDouble(request.getParameter("dicount"));
		
		Goods g = new Goods();
		g.setId(id);
		g.setName(name);
		g.setIntroduce(introduce);
		g.setType(type);
		g.setTasteType(tasteType);
		g.setHealthType(healthType);
		g.setManufacturer(manufacturer);
		g.setPrice(price);
		g.setNum(num);
		g.setDicount(dicount);
		
		int i = Factory.getAdminsGoodsServiceInstance().updGoodsByGoods(g);
		
		if(i>0){
			System.out.println("修改成功!");
			response.sendRedirect("AdminsShowGoodsServlet");
		}else{
			System.out.println("修改失败!");
			request.setAttribute("msg", "修改失败!");
			request.getRequestDispatcher("updGoods.jsp").forward(request, response);
		}
	}

}

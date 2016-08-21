package com.bin.lookz.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bin.lookz.entity.Goods;
import com.bin.lookz.util.Factory;
import com.bin.lookz.util.StringUtilBin;

public class TypeServlet extends HttpServlet {

	private static final long serialVersionUID = -2708683129003671287L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String type = StringUtilBin.filterHtml(request.getParameter("type"));
		int pages;
		String page = request.getParameter("pages");
		if(page==null){
			pages = 1;
		}else{
			pages = Integer.parseInt(page); 
		}
		List<Goods> goodslist = new ArrayList<Goods>();
		
		goodslist = Factory.getGoodsServiceInstance().getAllGoodsByType(type,pages);
		int maxpages = Factory.getGoodsServiceInstance().getPage(type);
		request.setAttribute("cutpage", pages);
		request.setAttribute("goodslist", goodslist);
		request.setAttribute("maxpages", maxpages);
		
		if(type.equals("Ö÷²Ë")){
			request.getRequestDispatcher("main.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("cake.jsp").forward(request, response);
		}
	}

}

package com.bin.lookz.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bin.lookz.entity.Goods;
import com.bin.lookz.util.Factory;

public class ProductdetailServlet extends HttpServlet {

	private static final long serialVersionUID = -7816758718135373069L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Goods goods = Factory.getGoodsServiceInstance().getGoodsById(id);
		//System.out.println(goods);
		request.setAttribute("goods", goods);
		request.getRequestDispatcher("single.jsp").forward(request, response);
	}

}

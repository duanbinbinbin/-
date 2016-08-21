package com.bin.lookz.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bin.lookz.entity.Goods;
import com.bin.lookz.util.Factory;

public class AdminsUpdGoodsServlet extends HttpServlet {

	private static final long serialVersionUID = 159714595650471700L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String ids = request.getParameter("id");
		int id = Integer.parseInt(ids);
		Goods g = Factory.getAdminsGoodsServiceInstance().getGoodsById(id);
		request.setAttribute("g", g);
		request.getRequestDispatcher("admin/updGoods.jsp").forward(request, response);
	}

}

package com.bin.lookz.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bin.lookz.util.Factory;

public class AdminsDelGoodsServlet extends HttpServlet {

	private static final long serialVersionUID = 2491500785015431049L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String ids = request.getParameter("id");
		int id = Integer.parseInt(ids);
		
		int i = Factory.getAdminsGoodsServiceInstance().delGoodsById(id);
		if(i>0){
			System.out.println("删除商品成功！");
			response.sendRedirect("AdminsShowGoodsServlet");
		}else{
			System.out.println("删除商品失败！");
		}
	}

}

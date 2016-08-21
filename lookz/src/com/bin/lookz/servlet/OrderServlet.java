package com.bin.lookz.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bin.lookz.entity.Purchase;
import com.bin.lookz.entity.Users;
import com.bin.lookz.util.Factory;

public class OrderServlet extends HttpServlet {

	private static final long serialVersionUID = -7354624765581480347L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Users user = (Users)request.getSession().getAttribute("user");
		String name = user.getName();
		//System.out.println(name);
		ArrayList<Purchase> plist = Factory.getUsersServiceInstance().getOrderByName(name);
		//System.out.println(plist);
		request.setAttribute("plist", plist);
		request.getRequestDispatcher("showOrder.jsp").forward(request, response);
	}

}

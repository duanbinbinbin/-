package com.bin.lookz.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bin.lookz.entity.Address;
import com.bin.lookz.entity.Users;
import com.bin.lookz.util.Factory;

public class CarToCheckoutServlet extends HttpServlet {

	private static final long serialVersionUID = 2864371961825453328L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取用户的对象
		Users user = (Users)request.getSession().getAttribute("user");
		ArrayList<Address> addresslist = new ArrayList<Address>();
		addresslist = (ArrayList<Address>) Factory.getAddressServiceInstance().findUserAddress(user.getId());
		request.setAttribute("addresslist", addresslist);
		request.getRequestDispatcher("checkout.jsp").forward(request, response);
	}

}

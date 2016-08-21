package com.bin.lookz.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bin.lookz.util.Factory;

public class AdminsDelAdminsServlet extends HttpServlet {

	private static final long serialVersionUID = -4713935028007013328L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String ids = request.getParameter("id");
		int id = Integer.parseInt(ids);
		Factory.getAdminsServiceInstance().delAdminsById(id);
		response.sendRedirect("AdminsShowAdminsServlet");
	}

}

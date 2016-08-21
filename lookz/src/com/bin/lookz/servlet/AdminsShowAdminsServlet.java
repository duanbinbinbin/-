package com.bin.lookz.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bin.lookz.entity.Admins;
import com.bin.lookz.util.Factory;

public class AdminsShowAdminsServlet extends HttpServlet {

	private static final long serialVersionUID = 6707959572635488561L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Admins> adminslist = Factory.getAdminsServiceInstance().getAllAdmins();
		if(adminslist!=null){
			request.setAttribute("adminslist", adminslist);
			request.getRequestDispatcher("admin/showAdmins.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("admin/addAdmins.jsp").forward(request, response);
		}
	}

}

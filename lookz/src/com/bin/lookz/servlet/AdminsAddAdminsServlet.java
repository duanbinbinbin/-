package com.bin.lookz.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bin.lookz.entity.Admins;
import com.bin.lookz.util.Factory;

public class AdminsAddAdminsServlet extends HttpServlet {

	private static final long serialVersionUID = -3330680633242112337L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		System.out.println("++++name+++:"+name);
		System.out.println("++++password+++:"+password);
		int admins_rank = Integer.parseInt(request.getParameter("admins_rank"));
		System.out.println("++++admins_rank+++"+admins_rank);
		Admins admin = new Admins(name,password,admins_rank,1);
		
		int i = Factory.getAdminsServiceInstance().addAdmins(admin);
		if(i>0){
			System.out.println("添加成功!");
			request.setAttribute("msg", "添加成功!");
			request.getRequestDispatcher("admin/addAdmins.jsp").forward(request, response);
		}else{
			System.out.println("添加失败!");
			request.setAttribute("msg", "添加失败!");
			request.getRequestDispatcher("admin/addAdmins.jsp").forward(request, response);
		}
	}

}

package com.bin.lookz.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bin.lookz.entity.Users;
import com.bin.lookz.util.Factory;

public class UpdUserServlet extends HttpServlet {

	private static final long serialVersionUID = 3806074422092107418L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String oldpsd = request.getParameter("oldPassword");
		String newpsd = request.getParameter("newPassword");
		Users u = Factory.getUsersServiceInstance().login(name, oldpsd);
		
		if(u!=null){
			Factory.getUsersServiceInstance().updPsdByUsers(u, newpsd);
			System.out.println("修改成功!");
			request.setAttribute("msg", "修改成功!");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}else{
			System.out.println("修改失败!");
			request.setAttribute("msg", "修改失败!");
			request.getRequestDispatcher("404.jsp").forward(request, response);
		}
	}

}

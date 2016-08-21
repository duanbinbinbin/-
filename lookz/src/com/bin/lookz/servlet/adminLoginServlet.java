package com.bin.lookz.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bin.lookz.entity.Admins;
import com.bin.lookz.util.Factory;
import com.bin.lookz.util.StringUtilBin;

public class adminLoginServlet extends HttpServlet {

	private static final long serialVersionUID = -4793966308258313636L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = StringUtilBin.filterHtml(request.getParameter("name"));
		String password = StringUtilBin.filterHtml(request.getParameter("password"));
		Admins admins = Factory.getAdminsServiceInstance().login(name, password);
		if(admins!=null){
			request.getSession().setAttribute("admins", admins);
			System.out.println("后台登录成功！");
			response.sendRedirect("admin/addGoods.jsp");
		}else{
			System.out.println("后台登录失败！");
			request.setAttribute("msg", "用户名或密码错误！");
			response.sendRedirect("admin/adminLogin.jsp");
		}
		
	}

}

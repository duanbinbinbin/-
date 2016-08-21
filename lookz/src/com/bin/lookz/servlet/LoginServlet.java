package com.bin.lookz.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bin.lookz.entity.ShoppingCar;
import com.bin.lookz.entity.Users;
import com.bin.lookz.util.Factory;
import com.bin.lookz.util.StringUtilBin;

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 7255856009536750127L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = StringUtilBin.filterHtml(request.getParameter("name"));
		String password = StringUtilBin.filterHtml(request.getParameter("password"));
		
		Users user = Factory.getUsersServiceInstance().login(name, password);
		if(user!=null){
			//登录成功,一个用户对应一个购物车对象
			user.setShoppingCar(new ShoppingCar());
			request.getSession().setAttribute("user", user);
			System.out.println("登录成功！");
			//System.out.println(user.getCar_flag());
			response.sendRedirect("index.jsp");
		}else{
			System.out.println("登录失败!");
			request.setAttribute("msg", "用户名或密码错误");
			request.getRequestDispatcher("404.jsp").forward(request, response);
		}
		
	}

}

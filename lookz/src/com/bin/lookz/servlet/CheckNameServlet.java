package com.bin.lookz.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CheckNameServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public CheckNameServlet() {
		super();
	}

	public void destroy() {
		super.destroy();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("name");
		boolean b = com.bin.lookz.util.Factory.getUsersServiceInstance().checkName(name);
		PrintWriter out = response.getWriter();
		//System.out.println(b);
		if(b){
			out.print("用户已存在!");
		}else{
			//out.print("用户名可用");
		}
		
		out.flush();
		out.close();
	}

	public void init() throws ServletException {
	}

}

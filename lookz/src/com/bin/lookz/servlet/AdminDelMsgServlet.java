package com.bin.lookz.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bin.lookz.util.Factory;

public class AdminDelMsgServlet extends HttpServlet {

	private static final long serialVersionUID = 5518007608866476752L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		int i= Factory.getAdminMessageServiceInstance().delMsgById(id);
		if(i>0){
			System.out.println("É¾³ý³É¹¦!");
		}else{
			System.out.println("É¾³ýÊ§°Ü!");
		}
		response.sendRedirect("AdminShowMessageServlet");
	}

}

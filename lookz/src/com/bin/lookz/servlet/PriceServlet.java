package com.bin.lookz.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PriceServlet extends HttpServlet {

	private static final long serialVersionUID = 6881132241398523685L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//String type = StringUtilBin.filterHtml(request.getParameter("type"));
		//int small = Integer.parseInt(request.getParameter("small"));
		//int big = Integer.parseInt(request.getParameter("big"));
		
		
	}

}

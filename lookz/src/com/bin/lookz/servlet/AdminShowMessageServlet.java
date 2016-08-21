package com.bin.lookz.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bin.lookz.entity.Contact;
import com.bin.lookz.util.Factory;

public class AdminShowMessageServlet extends HttpServlet {

	private static final long serialVersionUID = -128606649105772897L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<Contact> contactlist = Factory.getAdminMessageServiceInstance().getAllContact();
		request.setAttribute("contactlist", contactlist);
		request.getRequestDispatcher("admin/message.jsp").forward(request, response);
	}

}

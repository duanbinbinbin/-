package com.bin.lookz.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bin.lookz.entity.Users;
import com.bin.lookz.util.Factory;

public class AdminShowServlet extends HttpServlet {

	private static final long serialVersionUID = -2903864729900415406L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	} 

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<Users> userslist = Factory.getAdminsServiceInstance().getAllUsers();
		request.setAttribute("userslist", userslist);
		request.getRequestDispatcher("admin/admin.jsp").forward(request, response);
	}

}

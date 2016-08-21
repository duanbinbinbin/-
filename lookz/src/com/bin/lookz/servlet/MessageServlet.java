package com.bin.lookz.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bin.lookz.entity.Contact;
import com.bin.lookz.util.Factory;

public class MessageServlet extends HttpServlet {

	private static final long serialVersionUID = -7665178861331409384L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String msg = request.getParameter("msg");
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time =format.format(new Date());

		Contact contact = new Contact(name,phone,msg,time,1);
		int i = Factory.getUsersDaoInstance().addContact(contact);
		if(i>0){
			request.setAttribute("msg", "¡Ù—‘≥…π¶!");
			System.out.println("¡Ù—‘≥…π¶!");
			request.getRequestDispatcher("contact.jsp").forward(request, response);
		}else{
			request.setAttribute("msg", "¡Ù—‘ ß∞‹!");
			System.out.println("¡Ù—‘ ß∞‹!");
			request.getRequestDispatcher("contact.jsp").forward(request, response);
		}
	}

}

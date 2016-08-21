package com.bin.lookz.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bin.lookz.entity.Address;
import com.bin.lookz.entity.Users;
import com.bin.lookz.util.Factory;
import com.bin.lookz.util.StringUtilBin;

public class AddAddressServlet extends HttpServlet {

	private static final long serialVersionUID = 4799095652283605331L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = StringUtilBin.filterHtml(request.getParameter("name"));
		String phone = StringUtilBin.filterHtml(request.getParameter("phone"));
		String postcode = StringUtilBin.filterHtml(request.getParameter("postcode"));
		String province = StringUtilBin.filterHtml(request.getParameter("province"));
		String city = StringUtilBin.filterHtml(request.getParameter("city"));
		String area = StringUtilBin.filterHtml(request.getParameter("area"));
		String address = StringUtilBin.filterHtml(request.getParameter("address"));
		
		Users user = (Users)request.getSession().getAttribute("user");
		int users_id = user.getId();
		Address a = new Address(users_id,name,phone,postcode,province,city,area,address,1);
		
		int i = Factory.getGoodsServiceInstance().addAddress(a);
		
		if(i>0){
			System.out.println("添加地址成功");
			request.setAttribute("msg", "添加地址成功");
			request.getRequestDispatcher("checkout.jsp").forward(request, response);
		}else{
			System.out.println("添加地址失败");
			request.setAttribute("msg", "添加地址失败");
			request.getRequestDispatcher("checkout.jsp").forward(request,response);
		}
	}

}

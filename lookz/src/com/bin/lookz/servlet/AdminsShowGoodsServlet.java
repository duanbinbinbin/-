package com.bin.lookz.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bin.lookz.entity.Goods;
import com.bin.lookz.util.Factory;

public class AdminsShowGoodsServlet extends HttpServlet {

	private static final long serialVersionUID = -1056550961353238291L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int pages;
		String page = request.getParameter("pages");
		if(page==null){
			pages = 1;
		}else{
			pages = Integer.parseInt(page); 
		}
		
		String keyword = request.getParameter("keyword");
		request.setAttribute("keyword", keyword);
		List<Goods> goodslist = null;
		
		int maxpages;
		if(keyword!=null){
			goodslist = Factory.getAdminsGoodsServiceInstance().getGoodsByKeyWord(keyword,pages);
			maxpages = Factory.getAdminsGoodsServiceInstance().getPageBySearch(keyword);
		}else{
			goodslist = Factory.getAdminsGoodsServiceInstance().getAllGoods(pages);
			maxpages = Factory.getAdminsGoodsServiceInstance().getPage();
		}

		request.setAttribute("cutpage", pages);
		request.setAttribute("goodslist", goodslist);
		request.setAttribute("maxpages", maxpages);
		
		request.getRequestDispatcher("admin/goods.jsp").forward(request, response);
		
	}

}

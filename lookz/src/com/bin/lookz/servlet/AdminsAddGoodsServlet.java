package com.bin.lookz.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bin.lookz.entity.Goods;
import com.bin.lookz.util.Factory;
import com.bin.lookz.util.StringUtilBin;
import com.jspsmart.upload.File;
import com.jspsmart.upload.Files;
import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

public class AdminsAddGoodsServlet extends HttpServlet {

	private static final long serialVersionUID = 322724367722043383L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 准备文件接收的根目录
		@SuppressWarnings("unused")
		String rootDir=this.getInitParameter("rootDir");
		String allowlist=this.getInitParameter("allowlist");
		//System.out.println(rootDir);
		rootDir = this.getServletContext().getRealPath("//file");
		String filename=null;
		//System.out.println(rootDir);
		try {
			// 创建smartUpload对象
			SmartUpload su = new SmartUpload();
			// 初始化
			su.initialize(this.getServletConfig(), request, response);
			// 设置
			// 设置允许上传类型
			su.setAllowedFilesList(allowlist);
			// 设置允许上传的单个文件大小
			su.setMaxFileSize(1024 * 1024 * 5);
			// 设置允许上传的总文件大小
			su.setTotalMaxFileSize(1024 * 1024 * 20);
			// 上传(值请求对象)
			su.upload();
			// 获取所有文件
			Files files = su.getFiles();
			//System.out.println(files);
			// 获取文件总数
			int count = files.getCount();
			//System.out.println(count);
			// 遍历获取每个文件
			for (int i = 0; i < count; i++) {
				// 获取当前遍历的文件
				File file = files.getFile(i);
				//System.out.println(filename);
				// 判断文件是是否为空
				if (file.getSize() > 0) {
					filename = file.getFileName();

					// 设置文件的绝对路径
					String path="D:\\MyEclipse 8.5\\Workspaces2\\lookz\\WebRoot\\images\\updFile\\"+filename;
					//String path = rootDir + java.io.File.separator + filename;
					//System.out.print("文件的绝对路径:"+path);
					// 将当前文件拷贝至服务器指定目录
					file.saveAs(path);
					
				}
			}
			//上传文件同时上传表单数据
			Request req=su.getRequest();

			String name = StringUtilBin.filterHtml(req.getParameter("name"));
			String introduce = StringUtilBin.filterHtml(req.getParameter("introduce"));
			String type = StringUtilBin.filterHtml(req.getParameter("type"));
			String tasteType = StringUtilBin.filterHtml(req.getParameter("tasteType"));
			String healthType = StringUtilBin.filterHtml(req.getParameter("healthType"));
			String manufacturer = StringUtilBin.filterHtml(req.getParameter("manufacturer"));
			double price = Double.parseDouble(StringUtilBin.filterHtml(req.getParameter("price")));
			int evaluate = getEvaluate();
			int num = Integer.parseInt(StringUtilBin.filterHtml(req.getParameter("num")));
			double dicount = Double.parseDouble(StringUtilBin.filterHtml(req.getParameter("dicount")));
			
			Goods g = new Goods(name,introduce,type,tasteType,healthType,manufacturer,price,filename,evaluate,num,dicount);
			
			int i = Factory.getAdminsGoodsServiceInstance().addGoods(g);
			if(i>0){
				System.out.println("添加成功!");
				request.setAttribute("msg", "添加成功!");
				request.getRequestDispatcher("admin/addGoods.jsp").forward(request, response);
				//response.sendRedirect("ShowGoodsServlet");
			}else{
				System.out.println("添加失败!");
				request.setAttribute("msg", "添加失败!");
				request.getRequestDispatcher("admin/addGoods.jsp").forward(request, response);
			}
		} catch (SmartUploadException e) {
			e.printStackTrace();
		}
		
	}
	
	//随机生成品论数
	public int getEvaluate(){
		int m = (int)((Math.random()*9+1) * 1000);
		return m;
	}

}

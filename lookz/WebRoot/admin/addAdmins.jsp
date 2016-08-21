<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>管理员添加-Lookz</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="./bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="./bootstrap/css/mystyles.css" rel="stylesheet">
    <link href="./css/admin.css" rel="stylesheet">
    <link href="./css/updGoods.css"rel="stylesheet"/>
    <script src="./bootstrap/js/bootstrap.min.js"></script>

	
  </head>
  
  <body>
  
    <div class="myheading">
        <nav class="navbar navbar-default">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.jsp">
                    Lookz
                </a>
            </div>
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav ">
                    <li class="dropdown">
                    	<a href="ShowAdminServlet"class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">会员管理<span class="caret"></span></a>
                    	<ul class="dropdown-menu" role="menu">
                    		<li><a href="AdminShowServlet">会员管理</a></li>
                    		<li><a href="AdminShowMessageServlet">留言管理</a></li>
                    	</ul>
                    </li>
                    <li class="dropdown" >
                    	<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">商品管理<span class="caret"></span></a>
                    	<ul class="dropdown-menu" role="menu">
                    		<li><a href="AdminsShowGoodsServlet">商品整理</a></li>
                    		<li><a href="admin/addGoods.jsp">商品添加</a></li>
                    	</ul>
                    </li>
                    
                    <c:choose>
	                	<c:when test="${admins.admins_rank==6}">
	                		<li class="dropdown active" >
		                    	<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">管理员管理<span class="caret"></span></a>
		                    	<ul class="dropdown-menu" role="menu">
		                    		<li><a href="AdminsShowAdminsServlet">管理员管理</a></li>
		                    		<li><a href="admin/addAdmins.jsp">管理员添加</a></li>
		                    	</ul>
		                    </li>
		                    <li><a class="pull-right">欢迎超级管理员&nbsp;&nbsp;&nbsp;${admins.name }&nbsp;&nbsp;&nbsp;登录</a></li>
	                	</c:when>
	                	<c:otherwise>
	                		<li><a class="pull-right">欢迎普通管理员&nbsp;&nbsp;&nbsp;${admins.name }&nbsp;&nbsp;&nbsp;登录</a></li>
	                	</c:otherwise>
	                </c:choose>
                </ul>
            </div>
        </nav>
    </div>

    <div class="mybody container" id="updgoodscon">
        <div class="row">
            
            <div class="content col-md-5 col-sm-5">
                
                <div class="table-responsive">
                <form action="AdminsAddAdminsServlet" method="post" enctype="multipart/form-data">
                    <table class="table table-bordered table-hover" align="center">
                        <tr align="center" style="background-color:#e0dde1">
                        	<td colspan="2"><h3>管理员添加</h3></td>
                        </tr>
                        <tr>
                        	<th>登录名</th>
                        	<td><input id="name" name="name" type="text"/></td>
                        </tr>
                        <tr>
                        	<th>密码</th>
                        	<td><input id="password" name="password" type="password"/></td>
                        </tr>
                        <tr>
                        	<th>管理员等级</th>
                        	<td>
								<select name="admins_rank"> 
									<option >&nbsp;&nbsp;&nbsp;&nbsp;</option> 
									<option value ="5">超级管理员</option>  
								    <option value ="6">普通管理员</option>  
								</select> 
							</td>
                        </tr>
                        <tr align="center">
                        	<td colspan="2">
                        		<input type="submit" name="submit" value="提交"/>
                        		<span style="color:red">${msg }</span>
                        	</td>
                        </tr>
                    </table>
                </form>   
                </div>
            </div>
        </div>
    </div>
	
<script src="./bootstrap/js/jquery-2.1.1.min.js"></script>
<script src="./bootstrap/js/bootstrap.min.js"></script>
<script>
    $(".navbar-nav a").click(function(e){
        $(this).tab("show");
    })
</script>
  </body>
</html>

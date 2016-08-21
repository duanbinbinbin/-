<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>后台界面-FlowerShop</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="./bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="./bootstrap/css/mystyles.css" rel="stylesheet">
    <link href="./css/admin.css" rel="stylesheet">
    <script src="./bootstrap/js/bootstrap.min.js"></script>

  </head>
  
  <body>
  <c:if test="${admins==null}">
  	<c:redirect url="adminLogin.jsp"></c:redirect>
  </c:if>
    <div class="myheading">
        <nav class="navbar navbar-default">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">
                    Lookz
                </a>
            </div>
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav ">
                    <li class="active dropdown">
                    	<a href="ShowAdminServlet"class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">会员管理<span class="caret"></span></a>
                    	<ul class="dropdown-menu" role="menu">
                    		<li><a href="AdminShowServlet">会员管理</a></li>
                    		<li><a href="AdminShowMessageServlet">留言管理</a></li>
                    	</ul>
                    </li>
                    <li class="dropdown">
                    	<a href="ShowGoodsServlet" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">商品管理<span class="caret"></span></a>
                    	<ul class="dropdown-menu" role="menu">
                    		<li><a href="AdminsShowGoodsServlet">商品整理</a></li>
                    		<li><a href="admin/addGoods.jsp">商品添加</a></li>
                    	</ul>
                    	
                    </li>
                    
                    <c:choose>
	                	<c:when test="${admins.admins_rank==6}">
	                		<li class="dropdown" >
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

    <div class="mybody container" id="admincon">
        <div class="row">
            
            <div class="content col-md-9 col-sm-7">
                
                <div class="table-responsive">
                    <table class="table table-bordered table-hover">
                        <thead>
                        <tr  style="background-color:#e0dde1">
                            <th>会员ID</th>
                            <th>会员姓名</th>
                            <th>会员密码</th>
                            <th>会员性别</th>
                            <th>会员邮箱</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="list" items="${userslist}">
	                        <tr>
	                            <td>${list.id }</td>
	                            <td>${list.name }</td>
	                            <td>${list.password }</td>
	                            <td>${list.sex }</td>
	                            <td>${list.email }</td>
	                            <td><a href="AdminDelUsersServlet?id=${list.id }">删除</a></td>
	                        </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    
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

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
    
    <title>留言管理-Lookz</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="./bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="./bootstrap/css/mystyles.css" rel="stylesheet">
    <link href="./css/goods.css" rel="stylesheet">
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
                <a class="navbar-brand" href="index.jsp">
                    Lookz
                </a>
            </div>
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav ">
                    <li class="dropdown active">
                    	<a href="ShowAdminServlet"class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">会员管理<span class="caret"></span></a>
                    	<ul class="dropdown-menu" role="menu">
                    		<li><a href="AdminShowServlet">会员管理</a></li>
                    		<li><a href="AdminShowMessageServlet">留言管理</a></li>
                    	</ul>
                    </li>
                    <li class="dropdown " >
                    	<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">商品管理<span class="caret"></span></a>
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

    <div class="mybody container" id="goodscon">
        <div class="row">
            
            <div class="content col-md-10 col-sm-7">
                
                <div class="table-responsive" style="margin-left:190px;">
                    <table class="table table-bordered table-hover" align="center">
                        <thead>
                        <tr style="background-color:#e0dde1">
                            <th>留言ID</th>
                            <th>姓名</th>
                            <th>电话</th>
                            <th>内容</th>
                            <th>时间</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="list" items="${contactlist}">
	                        <tr>
	                            <td>${list.id}</td>
	                            <td>${list.name }</td>
	                            <td>${list.phone }</td>
	                            <td>
									<c:choose>
										<c:when test="${fn:length(list.msg) > 8}">
											${fn:substring(list.msg,0,8)} ...
										</c:when>
										<c:otherwise>
											${list.msg}
										</c:otherwise>
									</c:choose>
								</td>
	                            <td>${list.time }</td>      
	                            <td><a href="AdminDelMsgServlet?id=${list.id }">删除</a></td>
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

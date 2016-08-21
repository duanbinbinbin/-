<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>后台登录-Lookz</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="./bootstrap/css/bootstrap.css" rel="stylesheet">

  </head>
  
  <body>
    <div class="container col-md-2 " style="margin-left:40%">

      <form class="form-signin" role="form" action="adminLoginServlet" method="post">
        <h2 class="form-signin-heading">后台管理系统</h2>
        <input type="text" name="name" class="form-control" placeholder="用户名" required autofocus />
        
        <input type="password" name="password" class="form-control" placeholder="密码" required/>
        
        <button class="btn btn-lg btn-primary btn-block" type="submit">登录</button>
     	<span style="color:red">${msg }</span>
      </form>

    </div> <!-- /container -->
  </body>
</html>

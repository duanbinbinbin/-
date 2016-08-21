<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>footer-Lookz</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
	<link href="css/style.css" rel='stylesheet' type='text/css' />
	<link href="css/flexslider.css" rel='stylesheet' type='text/css' />
	<link href='http://fonts.useso.com/css?family=Raleway:100,200,300,400,500,600,700,800,900' rel='stylesheet' type='text/css'>
	<link href="css/megamenu.css" rel="stylesheet" type="text/css" media="all" />
	<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
	<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
	<script type="text/javascript" src="js/megamenu.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){$(".megamenu").megamenu();});
		
		ddsmoothmenu.init({
			mainmenuid: "templatemo_menu", //menu DIV id
			orientation: 'h', //Horizontal or vertical menu: Set to "h" or "v"
			classname: 'ddsmoothmenu', //class added to menu's outer DIV
			//customtheme: ["#1c5a80", "#18374a"],
			contentsource: "markup" //"markup" or ["container_id", "path_to_menu_file"]
		})
		
		function clearText(field)
		{
		    if (field.defaultValue == field.value) field.value = '';
		    else if (field.value == '') field.value = field.defaultValue;
		}
		
		function login(){
			var info = document.getElementById("info");
			var name = document.getElementById("name").value;
			var password = document.getElementById("password").value;
			
			
			//验证码
			var code = document.getElementById("authcode").value;

			
			//获取错误提示对象
			
			var authcodeInfo = document.getElementById("authcodeInfo");
			//清空记录
			
			authcodeInfo.innerHTML = "";

			//判断
			//test  如果 里面的对象 跟正则表示 匹配成功的话 返回 true 否则返回 false;
			
			if(code.toUpperCase() != codes){
				authcodeInfo.innerHTML = "验证输入错误 !" ;
				return false;
			}else if(name==""||password==""){
				info.innerHTML="用户名或密码不能为空!";
				return false;
			}else{
				//全部输入正确
				return true;	
			}
			
			//表示 不提交表单信息
			return false;
			
			//return success;
		}
		
		 //及时获取当前验证码
        var codes;
        function getCheckCodes(c){
            if( c.length == 4 ){
	    		var http;
	    		if( window.XMLHttpRequest ){
					http = new XMLHttpRequest();
	        	}else{
					http = new ActiveXObject("Microsoft.XMLHTTP");
	            }
				http.open("GET","GetCheckCodeServlet",true);
				http.onreadystatechange = function(){
					if( http.readyState == 4 ){
						if( http.status == 200 ){
							codes = http.responseText;
						}
					}
				}
				http.send();
            }
       	}
  		//更换验证码
		function checkCodes(){
			document.getElementById("checkCode").src = "CheckCodeServlet?m=" + Math.random();
		}
		
		//检查注册
		function checkRegister(){
			
			//验证码
			var code = document.getElementById("authcode").value;

			
			//获取错误提示对象
			
			var authcodeInfo = document.getElementById("authcodeInfo");
			//清空记录
			
			authcodeInfo.innerHTML = "";

			//判断
			//test  如果 里面的对象 跟正则表示 匹配成功的话 返回 true 否则返回 false;
			
			if(code.toUpperCase() != codes){
				alert(1);
				authcodeInfo.innerHTML = "验证输入错误 !!" ;
				return false;
			}else{
				//全部输入正确
				return true;	
			}
			
			//表示 不提交表单信息
			return false;
		}
		
		function register(){
			var info = document.getElementById("info");
			var name = document.getElementById("name").value;
			var password = document.getElementById("password").value;
			if(name==""||password==""){
				info.innerHTML="用户名或密码不能为空!";
				return false;
			}
			return success;
		}
		
		function checkName(name){
			var username = document.getElementById('name');
			var xmlhttp;
			username.onblur=function(){
				if(username.value!=null){
					if(window.ActiveXobject){
						xmlhttp = new ActiveXobject("Microsoft.XMLHTTP");
					}else{
						xmlhttp = new XMLHttpRequest();
					}
				} 
				xmlhttp.open("get","CheckNameServlet?name="+name,true);
				xmlhttp.send(null);
				xmlhttp.onreadystatechange=function(){
					if(xmlhttp.readyState==4){
						if(xmlhttp.status==200||xmlhttp.status==304){
							document.getElementById('info1').innerHTML=xmlhttp.responseText;
						}
					}
					return false;
				}
			}
		}
		
	</script>

  </head>
  
  <body>
  
  <!-- Modal -->
       <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
           <div class="modal-dialog">
               <div class="modal-content">
                   <div class="modal-header">
                       <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                       <h4 class="modal-title" id="myModalLabel">用户注册</h4>
                   </div>
                   <div class="modal-body">
                       <form action="RegisterServlet" method="post" class="navbar-form navbar-center" role="search" onsubmit="return register()">
                           <div class="form-group">
                               <label style="color:#a4a2a2;">姓名&nbsp;</label>
                               <input name="name" type="text" class="form-control" placeholder="Name">
                           </div><br/>
                           <div class="form-group">
                               <label style="color:#a4a2a2;">密码&nbsp;</label>
                               <input name="password" type="password" class="form-control" placeholder="Password">
                           </div><br/>
                           <div class="form-group">
                               <label style="color:#a4a2a2;">性别&nbsp;</label>
                               <input name="sex" type="radio" value="男" checked="checked"/>男
                               <input name="sex" type="radio" value="女"/>女
                           </div><br/>
                           <div class="form-group">
                               <label style="color:#a4a2a2;">邮箱&nbsp;</label>
                               <input name="email" type="text" class="form-control" placeholder="Email"/>
                           </div><br/><br/>
                           <div class="form-group">
                               <label style="color:#a4a2a2;">最喜欢的食物&nbsp;</label>
                               <input name="ppone" type="text" class="form-control" placeholder="密保问题一"/>
                           </div><br/>
                           <div class="form-group">
                               <label style="color:#a4a2a2;">最喜欢的动物&nbsp;</label>
                               <input name="pptwo" type="text" class="form-control" placeholder="密保问题二"/>
                           </div><br/>
                           <div class="form-group">
                               <label style="color:#a4a2a2;">最喜欢的职业&nbsp;</label>
                               <input name="ppthree" type="text" class="form-control" placeholder="密保问题三"/>
                           </div>
                           <span id="info1">${msg }</span>
                           <div class="modal-footer">
		                       <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
		                       <input type="submit" class="btn btn-success" name="submit" value="注册"/>
		                   </div>
                       </form>
                   </div>
                   
               </div>
           </div>
       </div>
       
       
       
       
       <!-- Modal1 -->
       <div class="modal fade" id="myModal1" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
           <div class="modal-dialog">
               <div class="modal-content">
                   <div class="modal-header">
                       <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                       <h4 class="modal-title" id="myModalLabel">用户登录</h4>
                   </div>
                   <div class="modal-body">
                       <form action="LoginServlet" method="post" class="navbar-form navbar-center" role="search" onsubmit="return login()">
                           <div class="form-group">
                               <label style="color:#a4a2a2;">姓&nbsp;&nbsp;&nbsp;&nbsp;名&nbsp;</label>
                               <input name="name" type="text" class="form-control" placeholder="Name">
                           </div><br/>
                           <div class="form-group">
                               <label style="color:#a4a2a2;">密&nbsp;&nbsp;&nbsp;&nbsp;码&nbsp;</label>
                               <input name="password" type="password" class="form-control" placeholder="Password">
                           </div><br/>
                           <div class="form-group">
                               <label style="color:#a4a2a2;">验证码&nbsp;</label>
                               <input placeholder="Verification code" type="text" id="authcode" onblur=getCheckCodes(this.value) style="ime-mode:disabled" name="authcode" tabindex="6" autocomplete="off" maxlength="4"/>
                               <span>
                               		<img style="cursor:pointer;width:100px;height:26px;" alt="验证码" onclick="checkCodes()" id="checkCode" src="CheckCodeServlet"/>
	                           		&nbsp;看不清？<a href="javascript:checkCodes()" class="flk13">换一张</a>
	                           		<span id="authcodeInfo" style="color: red;font-size:13px;"></span>
                               </span>
                           </div><br/>
                          
                           <span id="info">${msg }</span>
                           <div class="modal-footer">
                           	   <a href="pp.jsp">忘记密码？</a>
		                       <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
		                       <input type="submit" class="btn btn-success" name="submit" value="登录"/>
		                   </div>
                       </form>
                   </div>
                  
               </div>
           </div>
       </div>
       
       <!-- Modal1 -->
       <div class="modal fade" id="myModal2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
           <div class="modal-dialog">
               <div class="modal-content">
                   <div class="modal-header">
                       <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                       <h4 class="modal-title" id="myModalLabel">修改资料</h4>
                   </div>
                   <div class="modal-body">
                       <form action="UpdUserServlet" method="post" class="navbar-form navbar-center" role="search">
                           <div class="form-group">
                               <label style="color:#a4a2a2;">姓&nbsp;&nbsp;&nbsp;&nbsp;名&nbsp;</label>
                               <input name="name" type="text" readonly="true" class="form-control" placeholder="Name" value="${user.name }">
                           </div><br/>
                           <div class="form-group">
                               <label style="color:#a4a2a2;">旧密码&nbsp;</label>
                               <input name="oldPassword" type="password" class="form-control" placeholder="oldPassword">
                           </div><br/>
                           <div class="form-group">
                               <label style="color:#a4a2a2;">新密码&nbsp;</label>
                               <input name="newPassword" type="password" class="form-control" placeholder="newPassword">
                           </div>
                           ${msg }
                           <div class="modal-footer">
		                       <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
		                       <input type="submit" class="btn btn-success" name="submit" value="修改"/>
		                   </div>
                       </form>
                   </div>
                  
               </div>
           </div>
       </div>
  
    <div class="footer_top">
	  <div class="span_of_4">
		<div class="col-md-3 box_4">
			<h4>Shop</h4>
			<ul class="f_nav">
				<li><a href="#">new arrivals</a></li>
				<li><a href="#">men</a></li>
				<li><a href="#">women</a></li>
				<li><a href="#">accessories</a></li>
				<li><a href="#">kids</a></li>
				<li><a href="#">brands</a></li>
				<li><a href="#">trends</a></li>
				<li><a href="#">sale</a></li>
				<li><a href="#">style videos</a></li>
			</ul>	
		</div>
		<div class="col-md-3 box_4">
			<h4>help</h4>
			<ul class="f_nav">
				<li><a href="#">frequently asked  questions</a></li>
				<li><a href="#">men</a></li>
				<li><a href="#">women</a></li>
				<li><a href="#">accessories</a></li>
				<li><a href="#">kids</a></li>
				<li><a href="#">brands</a></li>
			</ul>				
		</div>
		<div class="col-md-3 box_4">
			<h4>account</h4>
			<ul class="f_nav">
				<li><a href="#">login</a></li>
				<li><a href="#">create an account</a></li>
				<li><a href="#">create wishlist</a></li>
				<li><a href="#">my shopping bag</a></li>
				<li><a href="#">brands</a></li>
				<li><a href="#">create wishlist</a></li>
			</ul>
		</div>
		<div class="col-md-3 box_4">
			<h4>popular</h4>
			<ul class="f_nav">
				<li><a href="#">new arrivals</a></li>
				<li><a href="#">men</a></li>
				<li><a href="#">women</a></li>
				<li><a href="#">accessories</a></li>
				<li><a href="#">kids</a></li>
				<li><a href="#">brands</a></li>
				<li><a href="#">trends</a></li>
				<li><a href="#">sale</a></li>
				<li><a href="#">style videos</a></li>
				<li><a href="#">login</a></li>
				<li><a href="#">brands</a></li>
			</ul>			
		</div>
		<div class="clearfix"></div>
	</div>
		<!-- start span_of_2 -->
		<div class="span_of_2">
			<div class="span1_of_2">
				<h5>need help? <a href="#">contact us <span> &gt;</span> </a> </h5>
				<p>(or) Call us: +22-34-2458793</p>
			</div>
			<div class="span1_of_2">
				<h5>follow us </h5>
				<div class="social-icons">
					     <ul>
					        <li><a href="#" target="_blank"></a></li>
					        <li><a href="#" target="_blank"></a></li>
					        <li><a href="#" target="_blank"></a></li>
					        <li><a href="#" target="_blank"></a></li>
					       <li class="last2"><a href="#" target="_blank"></a></li>
						</ul>
				</div>
			</div>
			<div class="clearfix"></div>
		</div>
		<div class="copy">
		   <p>Copyright &copy; 2016.Company DB LearningPrograming</p>
		</div>
     </div>
   </div>
</div>	

<script defer src="js/jquery.flexslider.js"></script>
<script type="text/javascript">
$(function(){
	  SyntaxHighlighter.all();
	});
	$(window).load(function(){
	  $('.flexslider').flexslider({
		animation: "slide",
		start: function(slider){
		  $('body').removeClass('loading');
		}
	  });
	});
</script>
  </body>
</html>

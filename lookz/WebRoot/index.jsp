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
    
    <title>主页-Lookz</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link href="css/megamenu.css" rel="stylesheet" type="text/css" media="all" />
	<link href='css/fonts.css' rel='stylesheet' type='text/css'>
	<link href="css/style.css" rel='stylesheet' type='text/css' />
	<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
	<link href="css/flexslider.css" rel='stylesheet' type='text/css' />
	<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
	<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
  	<script type="text/javascript" src="js/megamenu.js"></script>
	<script src="bootstrap/js/bootstrap.min.js"></script>
	<script>
		$(document).ready(function(){$(".megamenu").megamenu();});
	
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
	
	</script>
	
	
	
  </head>
  
  <body>
    <div class="wrap">	
   <div class="container">
        <div class="header_top">
		  <div class="col-sm-9 h_menu4">
				<ul class="megamenu skyblue">
					  <li><a class="color8" href="index.jsp">主页</a></li>
				      <li><a class="color1" href="TypeServlet?type=主菜">主菜</a>
				      <div class="megapanel">
						<div class="row">
							<div class="col1">
								<div class="h_nav">
									<ul>
										<li><a href="TasteTypeServlet?tasteType=麻辣&type=主菜">麻辣</a></li>
										<li><a href="TasteTypeServlet?tasteType=爽口&type=主菜">爽口</a></li>
										<li><a href="TasteTypeServlet?tasteType=海鲜&type=主菜">海鲜</a></li>
										<li><a href="TasteTypeServlet?tasteType=酸&type=主菜">酸</a></li>
										<li><a href="TasteTypeServlet?tasteType=甜&type=主菜">甜</a></li>
										<li><a href="TasteTypeServlet?tasteType=汤&type=主菜">汤</a></li>
										<li><a href="HealthTypeServlet?healthType=西式&type=主菜">西式</a></li>
										<li><a href="HealthTypeServlet?healthType=中式&type=主菜">中式</a></li>
									</ul>	
								</div>							
							</div>
							<div class="col1">
								<div class="h_nav">
									<ul>
										<li><a href="HealthTypeServlet?healthType=养胃&type=主菜">养胃</a></li>
										<li><a href="HealthTypeServlet?healthType=健脾&type=主菜">健脾</a></li>
										<li><a href="HealthTypeServlet?healthType=利肾&type=主菜">利肾</a></li>
										<li><a href="HealthTypeServlet?healthType=早餐&type=主菜">早餐</a></li>
										<li><a href="HealthTypeServlet?healthType=中餐&type=主菜">中餐</a></li>
										<li><a href="HealthTypeServlet?healthType=晚餐&type=主菜">晚餐</a></li>
										<li><a href="HealthTypeServlet?healthType=儿童套餐&type=主菜">儿童套餐</a></li>
										<li><a href="HealthTypeServlet?healthType=学生套餐&type=主菜">学生套餐</a></li>
										<li><a href="HealthTypeServlet?healthType=老年套餐&type=主菜">老年套餐</a></li>
									</ul>	
								</div>							
							</div>
							<div class="col1">
								<div class="h_nav">
									<h4>八大菜系</h4>
									<ul>
										<li><a href="ManufacturerServlet?manufacturer=川菜&type=主菜">川菜</a></li>
										<li><a href="ManufacturerServlet?manufacturer=鲁菜&type=主菜">鲁菜</a></li>
										<li><a href="ManufacturerServlet?manufacturer=粤菜&type=主菜">粤菜</a></li>
										<li><a href="ManufacturerServlet?manufacturer=苏菜&type=主菜">苏菜</a></li>
										<li><a href="ManufacturerServlet?manufacturer=闽菜&type=主菜">闽菜</a></li>
										<li><a href="ManufacturerServlet?manufacturer=浙菜&type=主菜">浙菜</a></li>
										<li><a href="ManufacturerServlet?manufacturer=徽菜&type=主菜">徽菜</a></li>
										<li><a href="ManufacturerServlet?manufacturer=湘菜&type=主菜"">湘菜</a></li>
									</ul>	
								</div>												
							</div>
						  </div>
						</div>
					</li>
				    <li class="grid"><a class="color2" href="TypeServlet?type=糕点">糕点</a>
					  <div class="megapanel">
						<div class="row">
							<div class="col1">
								<div class="h_nav">
									<ul>
										<li><a href="TasteTypeServlet?tasteType=麻辣&type=糕点">麻辣</a></li>
										<li><a href="TasteTypeServlet?tasteType=爽口&type=糕点">爽口</a></li>
										<li><a href="TasteTypeServlet?tasteType=海鲜&type=糕点">海鲜</a></li>
										<li><a href="TasteTypeServlet?tasteType=酸&type=糕点">酸</a></li>
										<li><a href="TasteTypeServlet?tasteType=甜&type=糕点">甜</a></li>
										<li><a href="TasteTypeServlet?tasteType=汤&type=糕点">汤</a></li>
										<li><a href="HealthTypeServlet?healthType=西式&type=糕点">西式</a></li>
										<li><a href="HealthTypeServlet?healthType=中式&type=糕点">中式</a></li>
									</ul>	
								</div>							
							</div>
							<div class="col1">
								<div class="h_nav">
									<ul>
										<li><a href="HealthTypeServlet?healthType=养胃&type=糕点">养胃</a></li>
										<li><a href="HealthTypeServlet?healthType=健脾&type=糕点">健脾</a></li>
										<li><a href="HealthTypeServlet?healthType=利肾&type=糕点">利肾</a></li>
										<li><a href="HealthTypeServlet?healthType=早餐&type=糕点">早餐</a></li>
										<li><a href="HealthTypeServlet?healthType=中餐&type=糕点">中餐</a></li>
										<li><a href="HealthTypeServlet?healthType=晚餐&type=糕点">晚餐</a></li>
										<li><a href="HealthTypeServlet?healthType=儿童套餐&type=糕点">儿童套餐</a></li>
										<li><a href="HealthTypeServlet?healthType=学生套餐&type=糕点">学生套餐</a></li>
										<li><a href="HealthTypeServlet?healthType=老年套餐&type=糕点">老年套餐</a></li>
									</ul>	
								</div>							
							</div>
							<div class="col1">
								<div class="h_nav">
									<h4>八大菜系</h4>
									<ul>
										<li><a href="ManufacturerServlet?manufacturer=川菜&type=糕点">川菜</a></li>
										<li><a href="ManufacturerServlet?manufacturer=鲁菜&type=糕点">鲁菜</a></li>
										<li><a href="ManufacturerServlet?manufacturer=粤菜&type=糕点">粤菜</a></li>
										<li><a href="ManufacturerServlet?manufacturer=苏菜&type=糕点">苏菜</a></li>
										<li><a href="ManufacturerServlet?manufacturer=闽菜&type=糕点">闽菜</a></li>
										<li><a href="ManufacturerServlet?manufacturer=浙菜&type=糕点">浙菜</a></li>
										<li><a href="ManufacturerServlet?manufacturer=徽菜&type=糕点">徽菜</a></li>
									</ul>	
								</div>												
							</div>
						  </div>
						</div>
			    </li>
				<li><a class="color4" href="">个人中心</a>
				
					<div class="megapanel">
						<div class="row">
							<div class="col1">
								<div class="h_nav">
									<ul>
										<li>
											<c:choose>
							                	<c:when test="${user==null}">
							                		<a onclick="alert('请登录!')">注销</a>
							                	</c:when>
							                	<c:otherwise>
							                		<a href="RemoveUsersServlet">注销</a>
							                	</c:otherwise>
							                </c:choose>
										</li>
									</ul>	
								</div>							
							</div>
							<div class="col1">
								<div class="h_nav">
									<ul>
										<li>
											<c:choose>
							                	<c:when test="${user==null}">
							                		<a onclick="alert('请登录!')">修改资料</a>
							                	</c:when>
							                	<c:otherwise>
							                		<a data-toggle="modal" data-target="#myModal2">修改资料</a>
							                	</c:otherwise>
							                </c:choose>
										</li>
									</ul>	
								</div>							
							</div>
							<div class="col1">
								<div class="h_nav">
									<ul>
										<li>
											<c:choose>
							                	<c:when test="${user==null}">
							                		<a onclick="alert('请登录!')">我的订单</a>
							                	</c:when>
							                	<c:otherwise>
							                		<a href="OrderServlet">我的订单</a>
							                	</c:otherwise>
							                </c:choose>
										</li>
									</ul>	
								</div>							
							</div>
							
						  </div>
						</div>
				
				</li>
				<li><a class="color6" href="contact.jsp">联系我们</a></li>
			  </ul> 
			</div>
			<div class="col-sm-3 header-top-right">
			
				<c:choose>
                	<c:when test="${user==null}">
                		<div class="drop_buttons">
		                    <div class="register-info">
		                        <ul>
		                            <li>
		                                <button class="btn btn-success" data-toggle="modal" data-target="#myModal">
		                                   	 注册
		                                </button>
		                            </li>
		                        </ul>
		                    </div>
		                </div>
		
		   			    <div class="register-info">
						    <ul>
								<li><button class="btn btn-success" data-toggle="modal" data-target="#myModal1">
		                          	  登录
		                        </button></li>
							</ul>
					    </div>
                	</c:when>
                	<c:otherwise>
                		<div class="register-info" style="margin-left:110px;">
						    <ul>
								<li><button class="btn btn-success">
		                          	  欢迎&nbsp;&nbsp;&nbsp;${user.name }！
		                        </button></li>
							</ul>
					    </div>
                	</c:otherwise>
                </c:choose>
			
                

				<div class="clearfix"> </div>
   			 </div>
   			 <div class="clearfix"> </div>
	</div>
    <div class="header_bootm">
		<div class="col-sm-4 span_1">
		  <div class="logo">
			<a href="index.jsp"><img src="images/logo.png" alt=""/></a>
		  </div>
		</div>
		<div class="col-sm-8 row_2">
		  <div class="header_bottom_right" style="margin-top:-14px;">
			<div class="search">
				<form action="SearchServlet" method="post" >
			    	<input type="text" name="keyword" id="keyword" placeholder="搜索商品..."">
			    	<input type="submit" value="">
			    </form>
	  		</div>
	  		<ul class="bag">
	  			<a href="cart.jsp"><i class="bag_left"> </i></a>
	  			<a href="cart.jsp"><li class="bag_right"><p>
	  				<c:choose>
	                	<c:when test="${user==null}">
	                		¥0
	                	</c:when>
	                	<c:otherwise>
	                		¥${user.shoppingCar.sumPrice}
	                	</c:otherwise>
	                </c:choose>
	  			</p> </li></a>
	  			<div class="clearfix"> </div>
	  		</ul>
	  		<div class="clearfix"> </div>
		   </div>
		</div>
		 <div class="clearfix"></div>
	</div>
	<div class="grid_1">
		<div class="col-md-3 banner_left">
			<a href="ProductdetailServlet?id=1024"><img src="images/updFile/栗子烧鸡.jpg" class="img-responsive" alt=""/></a>
			<div class="banner_desc">
				<h1>栗子烧鸡</h1>
				<h2>色香味俱全的汉族名肴</h2>
				<h5>14元
				   <small>Only</small>
				</h5>
				<c:choose>
                	<c:when test="${user==null}">
                		<a class="btn1 btn4 btn-1 btn1-1b" onclick="alert('请登录后购买!')">加入购物车</a>
                	</c:when>
                	<c:otherwise>
                		<a href="AddShoppingCarServlet?id=1024" class="btn1 btn4 btn-1 btn1-1b">加入购物车</a>
                	</c:otherwise>
                </c:choose>
			</div>
		</div>
		<div class="col-md-9 banner_right">
			 <!-- FlexSlider -->
              <section class="slider">
				  <div class="flexslider">
					<ul class="slides">
						<li><img src="images/banner.jpg" alt=""/></li>
						<li><img src="images/banner1.jpg" alt=""/></li>
					</ul>
				  </div>
	          </section>
              <!-- FlexSlider -->
		</div>
		<div class="clearfix"></div>
	</div>
<div class="content">
  <div class="content_box">
	<ul class="grid_2">
		<a href="ProductdetailServlet?id=1018"><li><img src="images/updFile/木桶辣子虾.jpg" class="img-responsive" alt=""/>
			<span class="btn5">￥43.00</span>
			<p>木桶辣子虾</p>
		</li></a>
		<a href="ProductdetailServlet?id=1018"><li><img src="images/updFile/红烧狮子头.jpg" class="img-responsive" alt=""/>
			<span class="btn5">￥23.00</span>
			<p>红烧狮子头</p>
		</li></a>
		<a href="ProductdetailServlet?id=1008"><li><img src="images/updFile/小酥肉.jpg" class="img-responsive" alt=""/>
			<span class="btn5">￥20.00</span>
			<p>小酥肉</p>
		</li></a>
		<a href="ProductdetailServlet?id=1003"><li><img src="images/updFile/m6.jpg" class="img-responsive" alt=""/>
			<span class="btn5">￥蛋挞</span>
			<p>蛋挞</p>
		</li></a>
		<a href="ProductdetailServlet?id=1007"><li class="last1"><img src="images/updFile/麻婆豆腐.jpg" class="img-responsive" alt=""/>
			<span class="btn5">￥12.00</span>
			<p>麻婆豆腐饭</p>
		</li></a>
		<div class="clearfix"> </div>
	</ul>
	<div class="grid_3">
		<div class="col-md-6 box_2">
			<div class="section_group"> 
		      	<div class="col_1_of_2 span_1_of_2">
		      		<a href="ProductdetailServlet?id=1009"><img src="images/updFile/香酥卷煎.jpg" class="img-responsive" alt=""/></a>
		        </div>
                <div class="col_1_of_2 span_1_of_2">
		      		<a href="ProductdetailServlet?id=1016"><img src="images/updFile/白切鸡.jpg" class="img-responsive" alt=""/></a>
		        </div>
                <div class="clearfix"> </div>
            </div>
		</div>
		<div class="col-md-6">
			<div class="box_3">
			  <div class="col_1_of_2 span_1_of_2 span_3">
		      	  <h3>最新菜品上架--茸汤广肚</h3>
                  <h4>￥20.00</h4>
                  <p>提供日期至2016年7月</p>
                  <c:choose>
                	<c:when test="${user==null}">
                		<a class="btn1 btn6 btn-1 btn1-1b" onclick="alert('请登录后购买!')">加入购物车</a>
                	</c:when>
                	<c:otherwise>
                		<a href="AddShoppingCarServlet?id=1019" class="btn1 btn6 btn-1 btn1-1b">加入购物车</a>
                	</c:otherwise>
                 </c:choose>
		        </div>
                <div class="col_1_of_2 span_1_of_2 span_4">
                   <div class="span_5" style="width:200px;height:5px;">
		      		 <img src="images/updFile/茸汤广肚.jpg" class="img-responsive" alt=""/>
		      	   </div>
		        </div>
                <div class="clearfix"> </div>
            </div>
		</div>
		<div class="clearfix"> </div>
	</div>
	
<jsp:include page="./common/footer.jsp"></jsp:include>
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

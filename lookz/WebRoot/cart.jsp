<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>购物车-Lookz</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
	<link href="css/style.css" rel='stylesheet' type='text/css' />
	<link href='http://fonts.useso.com/css?family=Raleway:100,200,300,400,500,600,700,800,900' rel='stylesheet' type='text/css'>
	<link href="css/megamenu.css" rel="stylesheet" type="text/css" media="all" />
	<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
	<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
	<script type="text/javascript" src="js/megamenu.js"></script>
	<script src="bootstrap/js/bootstrap.min.js"></script>
	<script>$(document).ready(function(){$(".megamenu").megamenu();});</script>
	<script>
		//删除指定购物车商品
		function deleteGoods(index){
			if(confirm("确定要删除吗?")){
				window.location.href="DelShopGoodsServlet?index="+index;
			}
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
				    <li class="grid"><a class="color2" href="#">点心</a>
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
				<li><a class="color4" href="404.jsp">个人中心</a>
				
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
			<a href="index.html"><img src="images/logo.png" alt=""/></a>
		  </div>
		</div>
		<div class="col-sm-8 row_2">
		  <div class="header_bottom_right" style="margin-top:-14px;">
			<div class="search">
			    <form action="SearchServlet" method="post" >
			    	<input type="text" name="keyword" id="keyword" value="搜索商品..." onFocus="this.value = '';" onBlur="if (this.value == '') {this.value = '搜索商品...';}">
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
<div class="content">
  <div class="content_box">
	<div class="men cart">
	   <div class="table-responsive">
	   <h3>购物车</h3>
		  <table class="table">
		  	<tr>
		  		<td>商品</td>
		  		<td>名称</td>
		  		<td>数量</td>
		  		<td>单价</td>
		  		<td>总计</td>
		  		<td>删除</td>
		  	</tr>
		  	 
            
            <c:choose>
               <c:when test="${user.shoppingCar.goodslist==null}">
               	<tr>
                	<td colspan="6">
                		<center><h2>空空如也~~</h2></center>
					</td>
            	</tr>
               </c:when>
               <c:otherwise>
               		<c:forEach var="list" items="${user.shoppingCar.goodslist}" varStatus="i">
	            <tr>
	                <td style="width:140px;"><img style="width:90px;height:90px;" class="img-rounded img-responsive" src="images/updFile/${list.imgUrl}" alt="${list.name }" /></td> 
	                <td>
	                	<div style="margin-top:25px;">
	                	${list.name }
	                	</div>
	                </td> 
	                <td style="width:140px;">
	                	<div style="margin-top:25px;">
	                		${user.shoppingCar.goodsNum[i.index]}
	                	</div>
	                </td>
	                <td>
	                	<div style="margin-top:25px;">
	                		${list.price }元
	                	</div>
	                </td> 
	                <td>
	                	<div style="margin-top:25px;">
	                		${list.price*user.shoppingCar.goodsNum[i.index] }元
	                	</div>
	                </td>
	                <td>
	                	<div style="margin-top:25px;">
	                		<a href="javascript:deleteGoods(${i.index})"><img src="images/remove.png" alt="remove" /></a>
	                	</div>
	                </td>
	            </tr>
            </c:forEach>
               </c:otherwise>
            </c:choose>
            
            
		  </table>
		  <div class="pull-right">
		  	<h4>总计:¥${user.shoppingCar.sumPrice}</h4>
		  	<br/>
		  	<a href="CarToCheckoutServlet"><button class="btn btn-success">结算购物车</button></a>
		  	<button onclick="history.back(-1)" class="btn btn-success">继续购买</button>
		  </div>
		  
		</div>
    </div>
	<jsp:include page="./common/footer.jsp"></jsp:include>
   </div>
</div>	
  </body>
</html>

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
    
    <title>结算购物车-Lookz</title>
    
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
	<script>$(document).ready(function(){$(".megamenu").megamenu();});</script>
	<script src="bootstrap/js/bootstrap.min.js"></script>
	
	<script type="text/javascript">

      var req;
      var doc;
      function getProvinces() {

         sendAjax();

      }
      function createAjax() {

         if (window.ActiveXObject) {

            req = new ActiveXObject("Microsoft.XMLHTTP");

         } else if (window.XMLHttpRequest) {

            req = new XMLHttpRequest;

         } else {

            alert("请使用IE或者FireFox内核的浏览器");

         }

      }

      function sendAjax() {

      

         createAjax();

         // 设置请求方式

         req.open("post", "city.xml", true);

         req.onreadystatechange = callBackMethod;

         req.send(null);

      }

      function callBackMethod() {

         if (req.readyState == 4) {

            doc = req.responseXML;

            showProvinces();

         }

      }

      function showProvinces() {

         addChooseOption("province");

         var provinces = doc.getElementsByTagName("province");

         appendOptions(provinces, "province");

      }

      function addChooseOption(id) {

         var select = document.getElementById(id);

         select.innerHTML = "";

         var chooseOpt = document.createElement("option");

         var chooseText = document.createTextNode("--choose");

         chooseOpt.value = "123";

         chooseOpt.appendChild(chooseText);

         select.appendChild(chooseOpt);

      }

      function appendOptions(arr, id) {

         var select = document.getElementById(id);

         for ( var i = 0; i < arr.length; i++) {

            var cname = arr[i].attributes[0].value;

            var cid = arr[i].attributes[1].value;

            var opt = document.createElement("option");

            var text = document.createTextNode(cname);

            opt.appendChild(text);

            opt.value = cid;

            select.appendChild(opt);

         }

      }

      function getCities(c) {

         addChooseOption("city");

         addChooseOption("area");

         var cid = c.value;

         var provinces = doc.getElementsByTagName("province");

         for ( var i = 0; i < provinces.length; i++) {

            if (provinces[i].attributes[1].value == cid) {

                var cities = provinces[i].getElementsByTagName("city");

                appendOptions(cities, "city");

            }
         }
      }

      function getAreas(obj) {

         addChooseOption("area");

         var pid = obj.value;

         var cities = doc.getElementsByTagName("city");

         for ( var i = 0; i < cities.length; i++) {

            if (cities[i].attributes[1].value == pid) {

                var areas = cities[i].getElementsByTagName("area");

                appendOptions(areas, "area");

            }
         }
      }
      
      function checkout(){
			
			if(${user==null}){
				alert("亲,登录后购物才能购买哦!");
				window.location.href="index.jsp";
			}else{
				alert("亲,登录后购物才能购买哦!");
				//window.location.href="checkout.jsp";
			}
		}
   </script>
	
  </head>
  
  <body onload="getProvinces()">
    <div class="wrap">	
<div class="container">
      <div class="header_top">
		  <div class="col-sm-9 h_menu4">
				<ul class="megamenu skyblue"> 
					  <li><a class="color8" href="index.jsp">主页</a></li>
					  <li><a class="color1" href="TypeServlet?type=主菜">主菜</a><div class="megapanel">
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
				<li><a class="color4" href="404.html">个人中心</a>
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

  
	<br/>
	<h3>确认收货地址&nbsp;&nbsp;&nbsp;&nbsp;<small><a href="">管理收货地址&gt;&gt;</a><small/></h3>
	<hr/>
	
	<c:forEach var="list" items="${addresslist}">
		<input name="address" type="radio" value="${list.address }"/>
		${list.address }&nbsp;&nbsp;&nbsp;${list.name}&nbsp;&nbsp;&nbsp;收<br/>
	</c:forEach>
	<br/>
	<button class="btn btn-success" data-toggle="modal" data-target="#myModalAddress">
         	+添加地址
    </button>
    
	<br/><br/><br/>
	<h3>确认订单信息</h3>
	<form method="post" action="CheckoutServlet">
	<table class="table">
		  	<tr>
		  		<td>商品</td>
		  		<td>名称</td>
		  		<td>数量</td>
		  		<td>单价</td>
		  		<td>优惠</td>
		  		<td>总计</td>
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
	                		无优惠
	                	</div>
	                </td>
	                <td>
	                	<div style="margin-top:25px;">
	                		${list.price*user.shoppingCar.goodsNum[i.index] }元
	                	</div>
	                </td>
	                
	            </tr>
            </c:forEach>
               </c:otherwise>
            </c:choose>
		  </table>
	
	<div class="pull-right">
		<h4>店铺优惠：-0.00元</h4>
		<h4>
			运送方式：
			<select name="delivery"> 
				<option>尽快送达</option> 
				<option>延长10分钟</option>  
			    <option>延长20分钟</option>
			    <option>延长30分钟</option>
			    <option>延长40分钟</option>
			    <option>延长50分钟</option>
			    <option>延长60分钟</option>  
			</select>
		</h4>
		<h4>实付款：¥${user.shoppingCar.sumPrice}</h4><br/>
		<a href="cart.jsp">&lt;&lt;返回购物车</a>&nbsp;&nbsp;&nbsp;
		
		<c:choose>
        	<c:when test="${user!=null}">
        		<input type="submit" name="submit" value="付款"/>
        	</c:when>
        	<c:otherwise>
        		<button onclick="checkout()">付款</button>
        	</c:otherwise>
        </c:choose>
        
	</div>
	</form>
	<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
	<jsp:include page="./common/footer.jsp"></jsp:include>
   </div>
</div>	
       
       <!-- Modal -->
       <div class="modal fade" id="myModalAddress" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
           <div class="modal-dialog">
               <div class="modal-content">
                   <div class="modal-header">
                       <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                       <h4 class="modal-title" id="myModalLabel">地址添加</h4>
                   </div>
                   <div class="modal-body">
                       <form action="AddAddressServlet" method="post" class="navbar-form navbar-center" role="search" onsubmit="return register()">
                           <div class="form-group">
                               <label style="color:#a4a2a2;">姓名&nbsp;</label>
                               <input name="name" type="text" class="form-control" placeholder="Name">
                           </div><br/>
                           <div class="form-group">
                               <label style="color:#a4a2a2;">电话&nbsp;</label>
                               <input name="phone" type="text" class="form-control" placeholder="Phone">
                           </div><br/>
                           <div class="form-group">
                               <label style="color:#a4a2a2;">邮编&nbsp;</label>
                               <input name="postcode" type="text" class="form-control" placeholder="PostCode">
                           </div><br/>
                           <div class="form-group">
                               <label style="color:#a4a2a2;">省份&nbsp;</label>
                               <select name="province" id="province" onchange="getCities(this)"></select>
                               <label style="color:#a4a2a2;">市&nbsp;</label>
                               <select name="city" id="city" onchange="getAreas(this)"></select>
                               <label style="color:#a4a2a2;">区&nbsp;</label>
                               <select name="area" id="area"></select>
                           </div><br/>
                           
                           <div class="form-group">
                               <label style="color:#a4a2a2;">详细地址&nbsp;</label>
                               <input name="address" type="text" class="form-control" placeholder="详细地址"/>
                           </div><br/>
                           
                           <span id="info1">${msg }</span>
                           <div class="modal-footer">
		                       <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
		                       <input type="submit" class="btn btn-success" name="submit" value="添加"/>
		                   </div>
                       </form>
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

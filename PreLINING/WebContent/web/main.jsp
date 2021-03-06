<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
	<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>PreLINING</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="http://fonts.googleapis.com/earlyaccess/notosanskr.css" rel="stylesheet">
	<link href="http://fonts.googleapis.com/earlyaccess/nanumpenscript.css" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css?family=Lato:300,400,700" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css?family=Kaushan+Script" rel="stylesheet">
	<!-- Animate.css -->
	<link rel="stylesheet" href="${pageContext.request.contextPath }/web/bootstrap/css/animate.css">
	<!-- Icomoon Icon Fonts-->
	<link rel="stylesheet" href="${pageContext.request.contextPath }/web/bootstrap/css/icomoon.css">
	<!-- Themify Icons-->
	<link rel="stylesheet" href="${pageContext.request.contextPath }/web/bootstrap/css/themify-icons.css">
	<!-- Bootstrap  -->
	<link rel="stylesheet" href="${pageContext.request.contextPath }/web/bootstrap/css/bootstrap.css">
	<!-- Magnific Popup -->
	<link rel="stylesheet" href="${pageContext.request.contextPath }/web/bootstrap/css/magnific-popup.css">
	<!-- Bootstrap DateTimePicker -->
	<link rel="stylesheet" href="${pageContext.request.contextPath }/web/bootstrap/css/bootstrap-datetimepicker.min.css">
	<!-- Owl Carousel  -->
	<link rel="stylesheet" href="${pageContext.request.contextPath }/web/bootstrap/css/owl.carousel.min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath }/web/bootstrap/css/owl.theme.default.min.css">
	<!-- Theme style  -->
	<link rel="stylesheet" href="${pageContext.request.contextPath }/web/bootstrap/css/style.css">
	<!-- Modernizr JS -->
	<script src="${pageContext.request.contextPath }/web/bootstrap/js/modernizr-2.6.2.min.js"></script>
	</head>
	
	<body>
		
	<div id="page">
	<!-- <div class="page-inner"> -->
	<c:if test="${not empty sessionScope.id }">
		<c:if test="${sessionScope.memberType==1 }">
			<c:import url="/web/navi/login_okM.jsp"></c:import>
			<c:if test="${flag_qck }">
				<c:import url="/web/header/header_main.jsp"></c:import>
			</c:if>
			<c:if test="${!flag_qck }">
				<c:import url="/web/header/header_main3.jsp"></c:import>
			</c:if>
		</c:if>
		
		<c:if test="${sessionScope.memberType==2 }">
			<c:if test="${empty myshop.name}">
				<c:import url="/web/navi/login_ok2M.jsp"></c:import>
				<c:import url="/web/header/header_main4.jsp"></c:import>
			</c:if>
			
			<c:if test="${not empty myshop.name}">
				<c:import url="/web/navi/login_ok3M.jsp"></c:import>
				<c:import url="/web/header/header_main1.jsp"></c:import>
			</c:if>
		</c:if>
	</c:if>
	<c:if test="${empty sessionScope.id }">
		<c:import url="/web/navi/indexM.jsp"></c:import>
		<c:import url="/web/header/header_main2.jsp"></c:import>
	</c:if>

	<c:import url="/ShopListController"></c:import>
	
	<div id="gtco-features">
		<div class="gtco-container">
			<div class="row">
				<div class="col-md-8 col-md-offset-2 text-center gtco-heading">
					<h2>??????</h2>
					<br>
					<form action="${pageContext.request.contextPath }/ShopListController">
						<div class="col-lg-6" >
						    <div class="input-group">
						      <input type="text" name="search" class="form-control" placeholder="Search for..." width="300px">
						      <span class="input-group-btn">
						        <button class="btn btn-default">
						        <span class="glyphicon glyphicon-search" aria-hidden="true"></span>
						        </button>
						      </span>
						    </div><!-- /input-group -->
						  </div><!-- /.col-lg-6 -->
					</form>
				</div>
			</div>
			<div class="row">
				<div class="col-md-4 col-sm-6">
					<div class="feature-center" >
					<a href="${pageContext.request.contextPath }/ShopListController?category=??????">
						<img src="${pageContext.request.contextPath }/web/images/chicken.png" width=100/>
						<h3>??????</h3>
					</a>
					</div>
				</div>
				<div class="col-md-4 col-sm-6">
					<div class="feature-center" >
					<a href="${pageContext.request.contextPath }/ShopListController?category=??????">
						<img src="${pageContext.request.contextPath }/web/images/pizza.png" width=100/>
						<h3>??????</h3>
					</a>
				</div>
				</div>
				<div class="col-md-4 col-sm-6">
					<div class="feature-center">
					<a href="${pageContext.request.contextPath }/ShopListController?category=??????">
						<img src="${pageContext.request.contextPath }/web/images/korean.png" width=100/>
						<h3>??????</h3>
					</a>
					</div>
				</div>
			</div>
				<div class="row">
					<div class="col-md-4 col-sm-6">
						<div class="feature-center" >
						<a href="${pageContext.request.contextPath }/ShopListController?category=??????">		
							<img src="${pageContext.request.contextPath }/web/images/chinese.png" width=100/>
							<h3>??????</h3>
						</a>
						</div>
					</div>
					<div class="col-md-4 col-sm-6">
						<div class="feature-center" >
						<a href="${pageContext.request.contextPath }/ShopListController?category=?????????">
							<img src="${pageContext.request.contextPath }/web/images/hamburger.png" width=100/>
							<h3>?????????</h3>
						</a>	
						</div>
					</div>
					<div class="col-md-4 col-sm-6">
						<div class="feature-center" >
						<a href="${pageContext.request.contextPath }/ShopListController?category=??????">
							<img src="${pageContext.request.contextPath }/web/images/western.png" width=100/>
							<h3>??????</h3>
						</a>	
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-4 col-sm-6">
						<div class="feature-center">
						<a href="${pageContext.request.contextPath }/ShopListController?category=??????">
							<img src="${pageContext.request.contextPath }/web/images/japan.png" width=100/>
							<h3>??????</h3>
						</a>
						</div>
					</div>
					<div class="col-md-4 col-sm-6">
						<div class="feature-center">
						<a href="${pageContext.request.contextPath }/ShopListController?category=???????????????">
							<img src="${pageContext.request.contextPath }/web/images/asian.png" width=100/>
							<h3>???????????????</h3>
						</a>
						</div>
					</div>
					<div class="col-md-4 col-sm-6">
						<div class="feature-center">
						<a href="${pageContext.request.contextPath }/ShopListController?category=?????????">
							&nbsp;&nbsp;<img src="${pageContext.request.contextPath }/web/images/dessert.png" width=100/>
							<h3>?????????</h3>
						</a>	
						</div>
					</div>
				</div>
		</div>
	</div>


	
	<c:import url="/web/bottom/bottom.jsp"></c:import>
	
	<!-- page </div> -->
	</div>

	<div class="gototop js-top">
		<a href="#" class="js-gotop"><i class="icon-arrow-up"></i></a>
	</div>
	
	<!-- jQuery -->
	<script src="${pageContext.request.contextPath }/web/bootstrap/js/jquery.min.js"></script>
	<!-- jQuery Easing -->
	<script src="${pageContext.request.contextPath }/web/bootstrap/js/jquery.easing.1.3.js"></script>
	<!-- Bootstrap -->
	<script src="${pageContext.request.contextPath }/web/bootstrap/js/bootstrap.min.js"></script>
	<!-- Waypoints -->
	<script src="${pageContext.request.contextPath }/web/bootstrap/js/jquery.waypoints.min.js"></script>
	<!-- Carousel -->
	<script src="${pageContext.request.contextPath }/web/bootstrap/js/owl.carousel.min.js"></script>
	<!-- countTo -->
	<script src="${pageContext.request.contextPath }/web/bootstrap/js/jquery.countTo.js"></script>
	<!-- Stellar Parallax -->
	<script src="${pageContext.request.contextPath }/web/bootstrap/js/jquery.stellar.min.js"></script>
	<!-- Magnific Popup -->
	<script src="${pageContext.request.contextPath }/web/bootstrap/js/jquery.magnific-popup.min.js"></script>
	<script src="${pageContext.request.contextPath }/web/bootstrap/js/magnific-popup-options.js"></script>
	<script src="${pageContext.request.contextPath }/web/bootstrap/js/moment.min.js"></script>
	<script src="${pageContext.request.contextPath }/web/bootstrap/js/bootstrap-datetimepicker.min.js"></script>
	<!-- Main -->
	<script src="${pageContext.request.contextPath }/web/bootstrap/js/main.js"></script>

	</body>
</html>


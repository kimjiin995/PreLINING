<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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

		<!-- 검색, 카테고리 없을 경우 -->
		<c:if test="${flag==1 }">
			<c:if test="${not empty sessionScope.id }">
				<c:if test="${sessionScope.memberType==1 }">
					<c:import url="/web/navi/login_ok.jsp"></c:import>
				</c:if>
			
				<c:if test="${sessionScope.memberType==2 }">
					<c:if test="${empty shop.name}">
						<c:import url="/web/navi/login_ok2.jsp"></c:import>
					</c:if>
						
					<c:if test="${not empty shop.name}">
						<c:import url="/web/navi/login_ok3.jsp"></c:import>
					</c:if>
				</c:if>
			</c:if>
				
			<c:if test="${empty sessionScope.id }">
				<c:import url="/web/navi/index.jsp"></c:import>
			</c:if>
			
			<header id="gtco-header" class="gtco-cover gtco-cover-sm" role="banner" 
				style="background-image: url(${pageContext.request.contextPath }/web/images/img_bg_1.jpg)" data-stellar-background-ratio="0.5">
					<div class="overlay"></div>
					<div class="gtco-container">
						<div class="row">
							<div class="col-md-12 col-md-offset-0">
								<div class="row row-mt-15em">
									<div class="col-md-4 col-md-push-4 animate-box" data-animate-effect="fadeIn">
										<div class="form-wrap">
											<div class="tab tab-content tab-content-inner active">
													<div class="text-center">
													<label>등록되어 있는 상점이 없습니다!</label>
													</div>
													<br>
													<input type="button" value="확인" class="btn btn-primary btn-block"
													onclick="location.href='${pageContext.request.contextPath }/web/main.jsp'"> <br>
											</div>
										</div>
									</div>	
								</div>	
							</div>
						</div>
					</div>
			</header>
		</c:if>
		
			<!-- 검색했을 경우 -->
			<c:if test="${not empty slistbysearch }">
				<c:if test="${not empty sessionScope.id }">
					<c:if test="${sessionScope.memberType==1 }">
						<c:import url="/web/navi/login_ok.jsp"></c:import>
					</c:if>
			
					<c:if test="${sessionScope.memberType==2 }">
						<c:if test="${empty shop.name}">
							<c:import url="/web/navi/login_ok2.jsp"></c:import>
						</c:if>
						
						<c:if test="${not empty shop.name}">
							<c:import url="/web/navi/login_ok3.jsp"></c:import>
						</c:if>
					</c:if>
				</c:if>
				<c:if test="${empty sessionScope.id }">
					<c:import url="/web/navi/index.jsp"></c:import>
				</c:if>
				
				<c:import url="/web/header/header_xss.jsp"></c:import>
				
			<div class="gtco-section" >
				<div class="gtco-container">		
					<div class="panel panel-default">
						  <div class="panel-heading text-center" style="height:70px;">		  
			   				 <form action="${pageContext.request.contextPath }/ShopListController">
						<div>
						    <div class="input-group" >
						      <input type="text" name="search" class="search" value="${param.search }">
						      <span class="input-group-btn">
						        <button style="background-color:rgba(0,0,0,0.3);" class="btn btn-default">
						        <span class="glyphicon glyphicon-search" aria-hidden="true"></span>
						        </button>
						      </span>
						    </div><!-- /input-group -->
						  </div><!-- /.col-lg-6 -->
					</form>
			  		</div>
			  		</div>
			 		 <div class="panel-body">
						<c:forEach var="s1" items="${slistbysearch }">
							<div class="animate-box">
							  <div class="well">
				    			<div class="media">
					 				 <div class="media-left">
					   				 <a href="${pageContext.request.contextPath }/ShopDetailController?num=${s1.num}">
										<div class="box" style="background: #BDBDBD;">
										<img class="profile" src="${s1.img }" width="170" height="170">
										</div>
									</a>
					  				</div>
					 		 	   <div class="media-body">
					    			<div class="media-heading"> &nbsp; &nbsp; ${s1.name }</div>
					    			 <div>
					    			  <c:set var="arrLocation" value="${fn:split(s1.location,' ')}" />
					    			  &nbsp; &nbsp; &nbsp; &nbsp;<span class="glyphicon glyphicon-map-marker"></span>
										<c:forEach var="loca" items="${arrLocation}" varStatus="g">
    									 <c:if test="${g.count == 1}">${loca}</c:if>
      									 <c:if test="${g.count == 2}">${loca}</c:if>
										</c:forEach> 
									 </div> 
					     				&nbsp; &nbsp; &nbsp; &nbsp;<span class="glyphicon glyphicon-star" aria-hidden="true"></span>평점 : ${s1.scoreavg } <br>
					     				&nbsp; &nbsp; &nbsp; &nbsp; 대기 수 : ${s1.queue_num }
									<div class="text-right">
										<c:if test="${ empty flag_qck || (flag_qck && s1.num != bshopnum) || !flag_qck }">
											<a href="${pageContext.request.contextPath }/EnqueueController?pnum=2&s_name=${s1.name}">
											<button class="btn btn-primary">대기신청
											</button>
											</a>
										</c:if>
										<c:if test="${bshopnum==s1.num && flag_qck && not empty bshopnum}">
											<a href="${pageContext.request.contextPath }/DequeueController">
											<button class="btn btn-primary">대기취소
											</button>
											</a>
										</c:if>
									</div>
							 		</div>
								</div>
							</div>
						</div>
						</c:forEach>
					 </div>
				</div>
				</div>
			</c:if>
			
			<!-- 카테고리 검색 -->
			<c:if test="${not empty slistbycategory }">		
				<c:if test="${not empty sessionScope.id }">
					<c:if test="${sessionScope.memberType==1 }">
						<c:import url="/web/navi/login_ok.jsp"></c:import>
					</c:if>		
					<c:if test="${sessionScope.memberType==2 }">
						<c:if test="${empty shop.name}">
							<c:import url="/web/navi/login_ok2.jsp"></c:import>
						</c:if>
						
						<c:if test="${not empty shop.name}">
							<c:import url="/web/navi/login_ok3.jsp"></c:import>
						</c:if>
					</c:if>
				</c:if>		
				<c:if test="${empty sessionScope.id }">
					<c:import url="/web/navi/index.jsp"></c:import>
				</c:if>	
				<c:import url="/web/header/header_xss.jsp"></c:import>

			<div class="gtco-section" >
				<div class="gtco-container">	
					<div class="panel panel-default">
						  <div class="panel-heading">  
			   				 <div class="panel-title">category : <span>${param.category }</span>&nbsp;</div>
						</div>
			  		</div>
			 		 <div class="panel-body">
						<c:forEach var="s2" items="${slistbycategory }">
							<div class="animate-box">
							  <div class="well">
				    			<div class="media">
					 				 <div class="media-left">
					   				 <a href="${pageContext.request.contextPath }/ShopDetailController?num=${s2.num}">
										<div class="box" style="background: #BDBDBD;">
										<img class="profile" src="${s2.img }" width="170" height="170">
										</div>
									</a>
					  				</div>
					 		 	   <div class="media-body">
					    			<div class="media-heading"> &nbsp; &nbsp; ${s2.name }</div>
					    			 <div>
					    			  <c:set var="arrLocation" value="${fn:split(s2.location,' ')}" />
					    			  &nbsp; &nbsp; &nbsp; &nbsp;<span class="glyphicon glyphicon-map-marker"></span>
										<c:forEach var="loca" items="${arrLocation}" varStatus="g">
    									 <c:if test="${g.count == 1}">${loca}</c:if>
      									 <c:if test="${g.count == 2}">${loca}</c:if>
										</c:forEach> 
									 </div> 
					     				&nbsp; &nbsp; &nbsp; &nbsp;<span class="glyphicon glyphicon-star" aria-hidden="true"></span>평점 : ${s2.scoreavg } <br>
					     				&nbsp; &nbsp; &nbsp; &nbsp; 대기 수 : ${s2.queue_num }
									<div class="text-right">
										<c:if test="${ empty flag_qck || (flag_qck && s2.num != bshopnum) || !flag_qck }">
											<a href="${pageContext.request.contextPath }/EnqueueController?pnum=2&s_name=${s2.name}">
											<button class="btn btn-primary">대기신청
											</button>
											</a>
										</c:if>
										<c:if test="${bshopnum==s2.num && flag_qck && not empty bshopnum}">
											<a href="${pageContext.request.contextPath }/DequeueController">
											<button class="btn btn-primary">대기취소
											</button>
											</a>
										</c:if>
									</div>
							 		</div>
								</div>
							</div>
						</div>
					</c:forEach>
				 </div>
				</div>
				</div>
			</c:if>
			
			
			<!-- 핫플, 평점순  -->			
				<c:if test="${not empty slistbyqnum || not empty slistbyscore}">
					<div class="gtco-section" style="background-color:#FFF">
					<div class="gtco-container">
						<div class="row" >
							<div class="col-md-8 text-left gtco-heading" style="margin-bottom:30px">
								<h2 class="cursive-font primary-color">Hot Place</h2>
							</div>
						</div>
						<div class="row">
						<c:forEach var="s1" items="${slistbyqnum }" begin="0" end="2">
						<c:set var="arrLocation" value="${fn:split(s1.location,' ')}" />
							<div class="col-lg-4 col-md-4 col-sm-6" >
								<a href="${pageContext.request.contextPath }/ShopDetailController?num=${s1.num}">
									<figure class="box" style="background: #BDBDBD;">
										<img src="${s1.img }" width="250" height="250">
									</figure>
									<div class="col-lg-12">
									<div class="fh5co-text">
										<h2>${s1.name }</h2>
										<span class="glyphicon glyphicon-map-marker"></span>
										<c:forEach var="loca" items="${arrLocation}" varStatus="g">
    									 <c:if test="${g.count == 1}">${loca}</c:if>
      									 <c:if test="${g.count == 2}">${loca}</c:if>
										</c:forEach> 
										<p>${s1.content }</p>
										<h4 style="color:rgba(217, 17, 17,0.9);">${s1.queue_num }명 대기중!</h4>
										<p><span class="price cursive-font"><span class="glyphicon glyphicon-star"></span>${s1. scoreavg}</span></p>
									</div>
									</div>
								</a>
							</div>
						</c:forEach>
						</div>
						<br>
						<hr>
						
						<div class="row">
							<div class="col-md-8 text-left gtco-heading" style="margin-bottom:30px">
								<h2 class="cursive-font primary-color">High Rating</h2>
							</div>
						</div>
						<div class="row">
							<c:forEach var="s2" items="${slistbyscore }" begin="0" end="2">
							 <c:set var="arrLocation" value="${fn:split(s2.location,' ')}" />
								<div class="col-lg-4 col-md-4 col-sm-6">
									<a href="${pageContext.request.contextPath }/ShopDetailController?num=${s2.num}" >
										<figure class="box" style="background: #BDBDBD;">
										<img src="${s2.img }" width="250" height="250">
										</figure>
										<div class="fh5co-text">
										<h2>${s2.name }</h2>
										<span class="glyphicon glyphicon-map-marker"></span>
										<c:forEach var="loca" items="${arrLocation}" varStatus="g">
    									 <c:if test="${g.count == 1}">${loca}</c:if>
      									 <c:if test="${g.count == 2}">${loca}</c:if>
										</c:forEach> 
										<p>${s2.content }</p>
										<h4 style="color:rgba(217, 17, 17,0.9);">${s2.queue_num }명 대기중!</h4>
										<p><span class="price cursive-font"><span class="glyphicon glyphicon-star"></span>${s2. scoreavg}</span></p>
										</div>
									</a>
								</div>
							</c:forEach>
						</div>
					</div>
					</div>
				</c:if>
				
		
<!-- 페이지설정 -->			
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
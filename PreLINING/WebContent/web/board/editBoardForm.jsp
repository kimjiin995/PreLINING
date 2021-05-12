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

<!-- 회원인 경우 -->
<c:if test="${memberType==1 }">
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
		style="background-image: url(${pageContext.request.contextPath }/web/images/img_bg_2.jpg)" data-stellar-background-ratio="0.5">
			<div class="overlay"></div>
			<div class="gtco-container">
				<div class="row">
					<div class="col-md-15 col-md-offset-0">	
						<div class="row row-mt-10em">
							<div class="col-md-6 col-md-push-3 animate-box" data-animate-effect="fadeIn">
							<h2 class="text-center">댓글 수정</h2>
								<div class="form-wrap">
									<div class="tab tab-content tab-content-inner active">
										<form action="${pageContext.request.contextPath }/EditBoardController" method="post">
											<table>
												<tr>
													<td colspan="3" width="30%">
														<input type="text" name="content" value="<%=request.getParameter("content") %>" class="form-control">
													</td>
												</tr>
												<tr>
													<td width="5%">
														평점  : <input type="number" name="score" value=<%=request.getParameter("score") %>>
														<input type="hidden" name="bnum" value=<%=request.getParameter("bnum") %>>
													</td>
													<td width="5%">
														<input type="reset" value="취소" class="form-control">
													</td>
													<td width="5%">
														<input type="submit" value="수정" class="form-control">
													</td>
												</tr>
											</table>
										</form>
									</div>
								</div>
							</div>
						</div>					
					</div>
				</div>
			</div>
	</header>
</c:if>

<!-- 상점인 경우 -->
<c:if test="${memberType==2 }">
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
		style="background-image: url(${pageContext.request.contextPath }/web/images/img_bg_2.jpg)" data-stellar-background-ratio="0.5">
			<div class="overlay"></div>
			<div class="gtco-container">
				<div class="row">
					<div class="col-md-15 col-md-offset-0">	
						<div class="row row-mt-10em">
							<div class="col-md-6 col-md-push-3 animate-box" data-animate-effect="fadeIn">
							<h2 class="text-center">댓글 수정</h2>
								<div class="form-wrap">
									<div class="tab tab-content tab-content-inner active">
										<form action="${pageContext.request.contextPath }/EditBoardController" method="post">
											<table>
												<tr>
													<td colspan="3" width="30%">
														<input type="text" name="content" value="<%=request.getParameter("content") %>" class="form-control">
													</td>
												</tr>
												<tr>
													<td width="5%">
														<input type="hidden" name="bnum" value=<%=request.getParameter("bnum") %>>
													</td>
													<td width="5%">
														<input type="reset" value="취소" class="form-control">
													</td>
													<td width="5%">
														<input type="submit" value="수정" class="form-control">
													</td>
												</tr>
											</table>
										</form>
									</div>
								</div>
							</div>
						</div>					
					</div>
				</div>
			</div>
	</header>

</c:if>

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
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>PreLINING</title>
<link href="https://fonts.googleapis.com/css?family=Lato:300,400,700"
	rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Kaushan+Script"
	rel="stylesheet">
<link
	href="http://fonts.googleapis.com/earlyaccess/nanumbrushscript.css"
	rel="stylesheet">
<link href="http://fonts.googleapis.com/earlyaccess/notosanskr.css"
	rel="stylesheet">


<!-- Animate.css -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/web/bootstrap/css/animate.css">
<!-- Icomoon Icon Fonts-->
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/web/bootstrap/css/icomoon.css">
<!-- Themify Icons-->
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/web/bootstrap/css/themify-icons.css">
<!-- Bootstrap  -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/web/bootstrap/css/bootstrap.css">
<!-- Magnific Popup -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/web/bootstrap/css/magnific-popup.css">
<!-- Bootstrap DateTimePicker -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/web/bootstrap/css/bootstrap-datetimepicker.min.css">
<!-- Owl Carousel  -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/web/bootstrap/css/owl.carousel.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/web/bootstrap/css/owl.theme.default.min.css">
<!-- Theme style  -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/web/bootstrap/css/style.css">
<!-- Modernizr JS -->
<script
	src="${pageContext.request.contextPath }/web/bootstrap/js/modernizr-2.6.2.min.js"></script>
<script type="text/javascript">
	function Check() {
		var flag_qck = <%=session.getAttribute("flag_qck")%>;
		var bshopnum = <%=session.getAttribute("bshopnum")%>;
		var shopnum = <%=session.getAttribute("shopnum")%>;
		if (flag_qck && (shopnum != bshopnum)) {
			alert("이미 대기중인 가게가 있습니다");
		} else
			location.href = '${pageContext.request.contextPath }/EnqueueController?pnum=2';
	}
</script>
</head>
<body>
	<div id="page">

		<c:if test="${not empty sessionScope.id }">
			<c:if test="${sessionScope.memberType==1 }">
				<c:import url="/web/navi/login_ok.jsp"></c:import>
				<c:import url="/web/header/header_xss.jsp"></c:import>
			</c:if>

			<c:if test="${sessionScope.memberType==2 }">
				<c:if test="${empty shop.name}">
					<c:import url="/web/navi/login_ok2.jsp"></c:import>
					<c:import url="/web/header/header_xss.jsp"></c:import>
				</c:if>

				<c:if test="${not empty shop.name}">
					<c:import url="/web/navi/login_ok3.jsp"></c:import>
					<c:import url="/web/header/header_xss.jsp"></c:import>
				</c:if>
			</c:if>
		</c:if>
		<c:if test="${empty sessionScope.id }">
			<c:import url="/web/navi/index.jsp"></c:import>
			<c:import url="/web/header/header_xss.jsp"></c:import>
		</c:if>

		<c:if test="${sessionScope.memberType==1 }">

			<div class="gtco-section">
				<div class="gtco-container">
					<div class="row">
						<div class="jb-wrap text-center">
							<div class="jb-image">
								<img src="${shop.img }" alt="" width=100%>
							</div>
							<div class="jb-text">
								<div class="jb-text-table">
									<div class="jb-text-table-row">
										<div class="jb-text-table-cell">
											<div class="well-shop">
												<span class="glyphicon glyphicon-home"></span>&nbsp;${shop.name }
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<br> <br>
					<div class="well">
						<div class="row">
							<div class="col-lg-12">
								<div class="fh5co-text">
									<h2>음식점소개</h2>
									<br>
									<h4>${shop.content }</h4>
								</div>
							</div>
						</div>
					</div>
					<br> <br>
				<div class="well">
					<div class="row">
						<div class="col-lg-12">
							<div class="fh5co-text">
								<h2>메뉴</h2>
									<br>
									<c:forEach var="menu" items="${menulist }" varStatus="status">
										<ul>
											<li>
												<h4>${menu }</h4>
											</li>
										</ul>
									</c:forEach>
							</div>
						</div>
					</div>
				</div>

				<br> <br>

				<div class="well">
					<div class="row">
						<div class="col-lg-8">
							<div class="fh5co-text">
								<h2>위치</h2>
								<br>
								<h4>${shop.location }</h4>
								<c:import url="/api/kakaomap.jsp"></c:import>
							</div>
						</div>
					</div>
				</div>

				<br> <br>
				<div class="well">
					<div class="row">
						<div class="col-lg-12">
							<div class="fh5co-text">
								<h2>예약현황</h2>
								<br>
								<h4>${shop.queue_num }명</h4>
							</div>
						</div>
					</div>
				</div>

				<br> <br>

				<div class="row">
					<div class="col-lg-12">
						<c:if
							test="${  empty flag_qck || (flag_qck&&shop.num != bshopnum) || !flag_qck}">
							<div class="text-center">
								<input type="button" class="btn btn-primary" value="대기신청"
									onclick="Check()">

							</div>
						</c:if>
						<c:if
							test="${  flag_qck && not empty bshopnum && shop.num == bshopnum}">
							<div class="text-center">
								<input type="button" class="btn btn-primary" value="대기취소"
									onclick="location.href='${pageContext.request.contextPath }/DequeueController'">
							</div>
						</c:if>
					</div>
				</div>

				<br> <br>
				<hr>

				<div class="well">
					<div class="row">
						<div class="col-lg-12">
							<div class="fh5co-text">
								<h2>댓글</h2>
								<c:import url="/BoardListController"></c:import>
								<br>
								<br>
								<br>
								<c:import url="/web/board/addBoardForm.jsp"></c:import>
							</div>
						</div>
					</div>
				</div>


			</div>
	</div>
	</c:if>


	<c:if test="${sessionScope.memberType==2 }">
		<c:if test="${not empty sessionScope.shop }">
			<%-- <c:import url="${pageContext.request.contextPath }/SearchQueueController"></c:import> --%>

			<div class="gtco-section">
				<div class="gtco-container">
					<div class="row">
						<div class="jb-wrap text-center">
							<div class="jb-image">
								<img src="${shop.img }" alt="" width=100%>
							</div>
							<div class="jb-text">
								<div class="jb-text-table">
									<div class="jb-text-table-row">
										<div class="jb-text-table-cell">
											<div class="well-shop">
												<span class="glyphicon glyphicon-home"></span>&nbsp;${shop.name }
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<br> <br>
					<div class="well">
						<div class="row">
							<div class="col-lg-12">
								<div class="fh5co-text">
									<h2>음식점소개</h2>
									<br>
									<h4>${shop.content }</h4>
								</div>
							</div>
						</div>
					</div>
					<br> <br>
					<div class="well">
						<div class="row">
							<div class="col-lg-12">
								<div class="fh5co-text">
									<h2>메뉴</h2>
									<br>
									<c:forEach var="menu" items="${menulist }" varStatus="status">
										<ul>
											<li>
												<h4>${menu }</h4>
											</li>
										</ul>
									</c:forEach>
								</div>
							</div>
						</div>
					</div>

					<br> <br>

					<div class="well">
						<div class="row">
							<div class="col-lg-8">
								<div class="fh5co-text">
									<h2>위치</h2>
									<br>
									<h4>${shop.location }</h4>
									<c:import url="/api/kakaomap.jsp"></c:import>
								</div>
							</div>
						</div>
					</div>
					<br> <br>

					<div class="well">
						<div class="row">
							<div class="col-lg-12">
								<div class="fh5co-text">
									<h2>예약현황</h2>
									<br>
									<h4>${shop.queue_num }명</h4>
								</div>
							</div>
						</div>
					</div>

					<br> <br>

					<c:if test="${shop.id==id }">
						<div class="row">
							<div class="col-lg-12">
								<div class="text-center">
									<input type="button" value="현재 대기열 확인" class="btn btn-primary"
										onclick="location.href='${pageContext.request.contextPath }/SearchQueueController'">
									<br>
								</div>
							</div>
						</div>
					</c:if>

					<br> <br>
					<hr>

					<div class="well">
						<div class="row">
							<div class="col-lg-12">
								<div class="fh5co-text">
									<h2>댓글</h2>
									<c:import url="/BoardListController"></c:import>
								</div>
							</div>
						</div>
					</div>

				</div>
			</div>
		</c:if>

		<c:if test="${empty sessionScope.shop }">
			<c:import url="/web/navi/login_ok3.jsp"></c:import>
			<c:import url="/web/header/header_xss.jsp"></c:import>
			<h3>현재 등록한 가게가 없습니다</h3>
			<a
				href="${pageContext.request.contextPath }/web/shop/addShopForm.jsp">가게등록</a>
		</c:if>

	</c:if>






	<!-- page </div> -->
	</div>

	<!-- jQuery -->
	<script
		src="${pageContext.request.contextPath }/web/bootstrap/js/jquery.min.js"></script>
	<!-- jQuery Easing -->
	<script
		src="${pageContext.request.contextPath }/web/bootstrap/js/jquery.easing.1.3.js"></script>
	<!-- Bootstrap -->
	<script
		src="${pageContext.request.contextPath }/web/bootstrap/js/bootstrap.min.js"></script>
	<!-- Waypoints -->
	<script
		src="${pageContext.request.contextPath }/web/bootstrap/js/jquery.waypoints.min.js"></script>
	<!-- Carousel -->
	<script
		src="${pageContext.request.contextPath }/web/bootstrap/js/owl.carousel.min.js"></script>
	<!-- countTo -->
	<script
		src="${pageContext.request.contextPath }/web/bootstrap/js/jquery.countTo.js"></script>
	<!-- Stellar Parallax -->
	<script
		src="${pageContext.request.contextPath }/web/bootstrap/js/jquery.stellar.min.js"></script>
	<!-- Magnific Popup -->
	<script
		src="${pageContext.request.contextPath }/web/bootstrap/js/jquery.magnific-popup.min.js"></script>
	<script
		src="${pageContext.request.contextPath }/web/bootstrap/js/magnific-popup-options.js"></script>
	<script
		src="${pageContext.request.contextPath }/web/bootstrap/js/moment.min.js"></script>
	<script
		src="${pageContext.request.contextPath }/web/bootstrap/js/bootstrap-datetimepicker.min.js"></script>
	<!-- Main -->
	<script
		src="${pageContext.request.contextPath }/web/bootstrap/js/main.js"></script>

</body>
</html>


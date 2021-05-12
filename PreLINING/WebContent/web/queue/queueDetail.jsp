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

<script>
function onClick(){
	
}
</script>
</head>
<body>
<div id="page">

	<!-- 로그인 된 경우 -->
	<c:if test="${not empty sessionScope.id }">
					<!-- 회원인 경우 예약조회 -->
					<c:if test="${sessionScope.memberType==1 }">
						<c:import url="/web/navi/login_ok.jsp"></c:import>
						
							<!-- 예약한 경우 -->
							<c:if test="${not empty q }">
								<header id="gtco-header" class="gtco-cover gtco-cover-sm" role="banner" 
											style="background-image: url(${pageContext.request.contextPath }/web/images/img_bg_2.jpg)" data-stellar-background-ratio="0.5">
												<div class="overlay"></div>
												<div class="gtco-container">
													<div class="row">
														<div class="col-md-12 col-md-offset-0">
															<div class="row row-mt-15em">
																<div class="col-md-8 col-md-push-2 animate-box" data-animate-effect="fadeIn">
																	<div class="form-wrap">
																		<div class="tab tab-content tab-content-inner active">
																		<div class="text-center">
																		<label>예약한 가게 : ${shop.name }</label>
																		</div>
																		<table class="table text-center" >
																				<tr>
																					<th class="text-center">가게명</th>
																					<th class="text-center">현재 순번</th>
																					<th class="text-center">예약시간</th>
																					<th class="text-center">확인</th>
																				</tr>
																				<tr>
																					<td>${q.s_name }</td>
																					<td>${seq_wait }</td>
																					<td>${q.r_date }</td>
																					<td><a href = "${pageContext.request.contextPath }/DequeueController">예약취소</a></td>
																				</tr>
																			</table>
																		</div>
																	</div>
																</div>	
															</div>	
														</div>
													</div>
													<c:import url="/SearchLogController"></c:import>													
												</div>
										</header>
								</c:if>
								
								<c:if test="${empty q }">
									<header id="gtco-header" class="gtco-cover gtco-cover-sm" role="banner" 
											style="background-image: url(${pageContext.request.contextPath }/web/images/img_bg_2.jpg)" data-stellar-background-ratio="0.5">
												<div class="overlay"></div>
												<div class="gtco-container">
													<div class="row">
														<div class="col-md-12 col-md-offset-0">
															<div class="row row-mt-15em">
																<div class="col-md-4 col-md-push-4 animate-box" data-animate-effect="fadeIn">
																	<div class="form-wrap">
																		<div class="tab tab-content tab-content-inner active">
																				<div class="text-center">
																				<label>현재 예약한 가게가 없습니다!</label>
																				</div>
																				<br>
																				<input type="button" value="확인" class="btn btn-primary btn-block"
																				onclick="location.href='${pageContext.request.contextPath }/web/member/memberInfo.jsp'"> <br>
																		</div>
																	</div>
																</div>	
															</div>	
														</div>
													</div>
													<c:import url="/SearchLogController"></c:import>
												</div>
										</header>
								</c:if>

					</c:if>
			
					<c:if test="${sessionScope.memberType==2 }">					
						<!-- 상점에서 정보본경우 -->
						<c:if test="${not empty myshop.name}">
							<c:import url="/web/navi/login_ok3.jsp"></c:import>
							
									<!-- 상점, 대기열 있는 경우 -->
									<c:if test="${not empty qlist }">
										<header id="gtco-header" class="gtco-cover gtco-cover-index" role="banner" 
											style="background-image: url(${pageContext.request.contextPath }/web/images/img_bg_2.jpg)" data-stellar-background-ratio="0.5">
												<div class="overlay"></div>
												<div class="gtco-container">
													<div class="row">
														<div class="col-md-12 col-md-offset-0">
															<div class="row row-mt-15em">
																<div class="col-md-8 col-md-push-2 animate-box" data-animate-effect="fadeIn">
																	<div class="form-wrap">
																		<div class="tab tab-content tab-content-inner active">
																		<div class="text-center">
																		<label>${shop.name }</label>
																		</div>
																		<br>
																		<table class="table text-center" >
																				<tr>
																					<th class="text-center">고객명</th>
																					<th class="text-center">인원수</th>
																					<th class="text-center">예약시간</th>
																					<th colspan="2" class="text-center">확인</th>
																				</tr>
																			<c:forEach var="x" items="${qlist }">
																				<tr>
																					<td>${x.g_name }</td>
																					<td>${x.pnum }</td>
																					<td>${x.r_date }</td>
																					<td><a href = "${pageContext.request.contextPath }
																						/DequeueController?qnum=${x.num }&g_name=${x.g_name }&log=1">방문완료</a></td>
																					<td><a href = "${pageContext.request.contextPath }
																						/DequeueController?qnum=${x.num }&g_name=${x.g_name}&log=0">방문취소</a></td>
																				</tr>
																				</c:forEach>
																			</table>
																		</div>
																	</div>
																</div>	
															</div>	
														</div>
													</div>
												</div>
										</header>
									</c:if>
									
									<!-- 상점, 대기열 없는 경우 -->
									<c:if test="${empty qlist }">
										<header id="gtco-header" class="gtco-cover gtco-cover-index" role="banner" 
											style="background-image: url(${pageContext.request.contextPath }/web/images/img_bg_2.jpg)" data-stellar-background-ratio="0.5">
												<div class="overlay"></div>
												<div class="gtco-container">
													<div class="row">
														<div class="col-md-12 col-md-offset-0">
															<div class="row row-mt-15em">
																<div class="col-md-4 col-md-push-4 animate-box" data-animate-effect="fadeIn">
																	<div class="form-wrap">
																		<div class="tab tab-content tab-content-inner active">
																				<div class="text-center">
																				<label>현재 대기중인 손님이 없습니다!</label>
																				</div>
																				<br>
																				<input type="button" value="확인" class="btn btn-primary btn-block"
																				onclick="location.href='${pageContext.request.contextPath }/ShopDetailController?num=${myshop.num }'"> <br>
																		</div>
																	</div>
																</div>	
															</div>	
														</div>
													</div>
												</div>
										</header>
									</c:if>
						</c:if>
					</c:if>
				</c:if>
				
	<!-- 로그인 안된 경우 -->
	<c:if test="${empty sessionScope.id }">
		<c:import url="/web/navi/index.jsp"></c:import>
		<c:import url="/web/header/header_xss.jsp"></c:import>
	</c:if>


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
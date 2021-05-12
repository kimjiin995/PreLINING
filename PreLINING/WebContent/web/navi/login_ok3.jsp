<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
	<head>
	<meta charset="utf-8">

	</head>
	<body>
		<nav class="gtco-nav" role="navigation">
				<div class="gtco-container">
					<div class="row">
						<div class="col-sm-4 col-xs-12">
							<div id="gtco-logo"><a href="${pageContext.request.contextPath }/web/main.jsp">PreLINING</a></div>
						</div>
						<div class="col-xs-8 text-right menu-1">
							<ul>
								<li>${m.nickname }님 환영합니다.</li>
								<li><a href="${pageContext.request.contextPath }/LogoutController">로그아웃</a></li>
								<li class="has-dropdown">
									<a href="#">Mypage</a>
									<ul class="dropdown">
										<li><a href="${pageContext.request.contextPath }/SearchController">회원정보</a></li>
										<li><a href="${pageContext.request.contextPath }/ShopDetailController?num=${myshop.num}">가게정보</a></li>
										<li><a href="${pageContext.request.contextPath }/web/shop/editShopForm.jsp">가게정보수정</a></li>
									</ul>
								</li>
								<li class="btn-cta"><a href="${pageContext.request.contextPath }/web/shop/searchForm.jsp">
								<span class="glyphicon glyphicon-search" aria-hidden="true"></span></a></li>
							</ul>
						</div>
					</div>
				</div>
			</nav>


	</body>
</html>


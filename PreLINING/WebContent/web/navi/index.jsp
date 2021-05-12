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
						<li><a href="${pageContext.request.contextPath }/web/member/loginForm.jsp">로그인</a></li>
						<li><a href="${pageContext.request.contextPath }/web/member/joinForm.jsp">회원가입</a></li>
						<li class="btn-cta"><a href="${pageContext.request.contextPath }/web/shop/searchForm.jsp">
						<span class="glyphicon glyphicon-search" aria-hidden="true"></span></a></li>
					</ul>	
				</div>
			</div>
		</div>
	</nav>
	
	</body>
</html>


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script>
<c:if test="${flag_log}">
	alert("로그기록 완료");
	location.href = "${pageContext.request.contextPath }/DetailQueueController";
</c:if>
<c:if test = "${!flag_log}">
	alert("로그기록 실패");
</c:if>
</script>

<!-- "${pageContext.request.contextPath }/UpdateQueueController"  -->
</body>
</html>
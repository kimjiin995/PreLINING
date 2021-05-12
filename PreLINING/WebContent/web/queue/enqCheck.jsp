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
<c:if test="${flag_qck}">
	alert("예약 완료");
	location.href = "${pageContext.request.contextPath }/UpdateQueueController";
	// 현재 대기열 업데이트 
</c:if>
	
 <c:if test = "${!flag_qck}">
	alert("예약 실패");
	location.href = "${pageContext.request.contextPath }/ShopDetailController?num=${shop.num}";
</c:if> 
</script>

</body>
</html>
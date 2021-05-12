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
<c:if test="${memberType==1}">
	<c:if test="${!flag_qck}">
		alert("예약 취소 완료");
		location.href = "${pageContext.request.contextPath }/UpdateQueueController";
	</c:if>
	
	<c:if test="${flag_qck}">
	alert("예약 취소 실패");
	location.href = "${pageContext.request.contextPath }/ShopDetailController?num=${shop.num}";
	</c:if>
</c:if>

<c:if test="${memberType==2}">
	<c:if test="${complete}">
		alert("처리 완료");
		location.href = "${pageContext.request.contextPath }/SearchQueueController";
	</c:if>

	<c:if test="${!complete}">
		alert("처리 실패");
		location.href = "${pageContext.request.contextPath }/SearchQueueController";
	</c:if>
</c:if>


</script>

</body>
</html>
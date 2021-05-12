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
<c:if test="${not empty vlist }">
	<div class="row">
		<div class="col-md-12 col-md-offset-0">
		<div class="row row-mt-15em">
		<div class="text-center">
		<hr>
		<h3>최근에 예약한 가게</h3><br>
			</div>
				<div class="col-md-8 col-md-push-2 animate-box" data-animate-effect="fadeIn">
				<div class="form-wrap">
					<div class="tab tab-content tab-content-inner active">
						<table class="table text-center" >
							<tr>
								<th class="text-center">가게명</th>
								<th class="text-center">평점</th>
								<th class="text-center">현재 대기팀</th>
								<th class="text-center">확인</th>
							</tr>
							<c:forEach var = "v" items = "${vlist }" >
							<tr>
								<td>${v.s_name }</td>
								<td></td>
								<td>${x.pnum }</td>
								<td><a href = "${pageContext.request.contextPath }/EnqueueController?name=${v.name }&pnum=2&history=1">예약하기</a></td>
							</tr>
							</c:forEach>
						</table>
					</div>
				</div>
				</div>	
			</div>	
		</div>
	</div>
</c:if>

<c:if test="${empty vlist }">
	<div class="row">
		<div class="col-md-12 col-md-offset-0">
			<div class="row row-mt-15em">
				<div class="text-center">
				<hr>
				<h3>최근에 방문한 가게</h3><br>
				</div>
				<div class="col-md-4 col-md-push-4 animate-box" data-animate-effect="fadeIn">
					<div class="form-wrap">
						<div class="tab tab-content tab-content-inner active">
								<div class="text-center">
								<label>방문한 가게가 없습니다!</label>
								</div>
						</div>
					</div>
				</div>	
			</div>	
		</div>
	</div>
</c:if>
</body>
</html>
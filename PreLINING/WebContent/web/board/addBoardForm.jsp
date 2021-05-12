<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
	<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>PreLINING</title>

	</head>
<body>

	<hr class="bold">
		<form action="${pageContext.request.contextPath }/AddBoardController" method="post">
 		 		<table class="addBoard" >
 		 		<tr>
					<th class="br" style="width:100%">
					<span class="glyphicon glyphicon-star"></span>평점:&nbsp;
					<input type="number" name="score" min="1" max="5">
					</th>
				</tr>	
				<tr>
					<th width="70%">
						<input type="text" name="content"  class="form-control">

					</th>
					<th width="10%">
						<input type="submit" value="작성" class="form-control">
					</th>
				</tr>
	
			</table>
			<input type="hidden" name="g_name" value="${m.nickname }">
			<input type="hidden" name="s_name" value="${shop.name }">
			<input type="hidden" name="parent" value="0">
		</form>




</body>
</html>
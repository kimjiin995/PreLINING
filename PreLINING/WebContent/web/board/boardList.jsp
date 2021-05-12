<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
	<head>
	<meta charset="utf-8">
	</head>
<body>
<c:if test="${not empty boardlist }">
	
	<table style="margin:2px">
		<c:forEach var="b" items="${boardlist }" >
			<c:if test="${b.parent==0 }">
		<tr><td colspan="5"><hr style="margin:3px"></td></tr>
			<tr>
				<th class="black" width="15%"><span class="glyphicon glyphicon-user"></span>&nbsp;${b.g_name }<span class="glyphicon glyphicon-menu-right"></span>
				</th>
				<td class="text-left black" width=70%> ${b.content }<br></td>
				<td width="5%"></td>
				<c:if test="${b.g_name==m.nickname && memberType==1 }">
					<td width="5%">
						<a href="${pageContext.request.contextPath }
						/web/board/editBoardForm.jsp?bnum=${b.num}&content=${b.content}&score=${b.score}">수정</a>
					</td>
					<td width="5%">
						<a href="${pageContext.request.contextPath }/DelBoardController?bnum=${b.num}">삭제</a>
					</td>
				</c:if>
								<c:if test="${id==shop.id && memberType==2 }">
					<td width="5%">
						<a href="${pageContext.request.contextPath }
						/web/board/replyForm.jsp?bnum=${b.num}">답글</a>
					</td>
				</c:if>
			</tr>
			<tr>
				<td>
				<c:forEach var="i" begin="1" end="5" varStatus="status">
					<c:if test="${b.score==i }">
				 		<c:forEach var="j" begin="1" end="${status.count}">
					 		<span class="glyphicon glyphicon-star"></span>				 	
				 		</c:forEach>
				 	</c:if> 
				</c:forEach>
				</td>
			</tr>
			</c:if>
			<!-- 대댓글 -->
			<c:if test="${b.parent!=0 }">
			<tr>
				<th class="black">&nbsp;&nbsp;&nbsp;└&nbsp;<span class="glyphicon glyphicon-home"></span>&nbsp;${b.s_name }<span class="glyphicon glyphicon-menu-right"></span></th>
				<td class="black" > ${b.content }<br></td>
				
				<c:if test="${b.s_name==shop.name && m.id==shop.id  }">
					<td>
						<a href="${pageContext.request.contextPath }/web/board/editBoardForm.jsp?bnum=${b.num}&content=${b.content}">수정</a>
					</td>
					<td>
						<a href="${pageContext.request.contextPath }/DelBoardController?bnum=${b.num}">삭제</a>
					</td>	
				</c:if>
			</tr>
				

			</c:if>
		</c:forEach>		
	</table>

</c:if>
<c:if test="${empty boardlist }">

댓글이 없습니다.

</c:if>

	</body>
</html>
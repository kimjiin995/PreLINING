<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<header id="gtco-header" class="gtco-cover gtco-cover-sm" role="banner" 
	style="background-image: url(${pageContext.request.contextPath }/web/images/img_bg_2.jpg)" data-stellar-background-ratio="0.5">
		<div class="overlay"></div>
		<div class="gtco-container">
			<div class="row">
				<div class="col-md-15 col-md-offset-0">	
					<div class="row row-mt-10em">
						<div class="col-md-6 col-md-push-3 animate-box" data-animate-effect="fadeIn">
						<h2 class="text-center">내 정보</h2>
							<div class="form-wrap">
								<div class="tab tab-content tab-content-inner active">
									<form action="${pageContext.request.contextPath }/BeforePwdCkController?check=edit" method = "post" name="loginForm" onsubmit="return check()">
										<label class="text-left">아이디</label>								
										<input type="text" name="id" class="form-control" value="${m.id }" readonly> <br>
										<label class="text-left">이름</label>
										<input type="text" name="name" class="form-control" value="${m.name }" readonly> <br>
										<label class="text-left">닉네임</label>
										<input type="text" name="nickname" class="form-control" value="${m.nickname }" readonly> <br>
										<label class="text-left">핸드폰번호</label>
										<input type="tel" name="phone" class="form-control" value="${m.phone }" readonly> <br>
										<label class="text-left">이메일</label>
										<input type="email" name="email" class="form-control" value="${m.email }" readonly> <br>
										<label class="text-left">주소</label>
										<input type="text" name="addr" class="form-control" value="${m.addr }" readonly> <br>
										<label class="text-left">포인트</label>
										<input type="text" name="point" class="form-control" value="${m.point }" readonly> <br>
										<input type="button" class="btn btn-primary btn-block" value="현재 대기순번 조회" 
										onclick="location.href='${pageContext.request.contextPath }/DetailQueueController'"> <br>
										<div class="text-right">
										<input type="submit" class="btn btn-primary" value="수정">
										</div>
										<hr>
									</form>	
								</div>
							</div>
						</div>
					</div>					
				</div>
			</div>
		</div>
	</header>
</body>
</html>
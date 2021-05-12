<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
	<head>
	<meta charset="utf-8">
	</head>
	<body>
		
	<header id="gtco-header" class="gtco-cover gtco-cover-index" role="banner" 
	style="background-image: url(${pageContext.request.contextPath }/web/images/img_bg_2.jpg)" data-stellar-background-ratio="0.5">
		<div class="overlay"></div>
		<div class="gtco-container">
			<div class="row">
				<div class="col-md-12 col-md-offset-0 text-left">
					<div class="row row-mt-15em">
						<div class="col-md-7 mt-text animate-box" data-animate-effect="fadeInUp">
							<span class="intro-text-small">Welcome! <a href="${pageContext.request.contextPath }/web/main.jsp">PreLINING</a></span>
							<h1 class="cursive-font">line up at home!</h1>	
						</div>
						<div class="col-md-4 col-md-push-1 animate-box" data-animate-effect="fadeInRight">
							<div class="form-wrap">
								<div class="tab">
									
									<div class="tab-content">
										<div class="tab-content-inner active" data-content="signup">
											<div class="text-center">
											<h3>현재예약정보</h3>
											<hr style="border-color:rgba(251, 180, 72, 0.3)">
											</div>
											<br>
											<br>
											<br>
											<div class="text-center">
												<h4>예약된 정보가 없습니다.</h4>
											</div>
											<br><br><br><br>
												<div class="row form-group">
													<div class="col-md-12">
														<input type="button" class="btn btn-primary btn-block" value="로그인 하러가기!"
														onclick="location.href='${pageContext.request.contextPath }/web/member/loginForm.jsp'">
													</div>
												</div>
										</div>
									</div>
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


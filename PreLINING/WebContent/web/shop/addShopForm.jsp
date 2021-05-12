<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
	<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>PreLINING</title>
	<link href="https://fonts.googleapis.com/css?family=Lato:300,400,700" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css?family=Kaushan+Script" rel="stylesheet">
	
	<!-- Animate.css -->
	<link rel="stylesheet" href="${pageContext.request.contextPath }/web/bootstrap/css/animate.css">
	<!-- Icomoon Icon Fonts-->
	<link rel="stylesheet" href="${pageContext.request.contextPath }/web/bootstrap/css/icomoon.css">
	<!-- Themify Icons-->
	<link rel="stylesheet" href="${pageContext.request.contextPath }/web/bootstrap/css/themify-icons.css">
	<!-- Bootstrap  -->
	<link rel="stylesheet" href="${pageContext.request.contextPath }/web/bootstrap/css/bootstrap.css">
	<!-- Magnific Popup -->
	<link rel="stylesheet" href="${pageContext.request.contextPath }/web/bootstrap/css/magnific-popup.css">
	<!-- Bootstrap DateTimePicker -->
	<link rel="stylesheet" href="${pageContext.request.contextPath }/web/bootstrap/css/bootstrap-datetimepicker.min.css">
	<!-- Owl Carousel  -->
	<link rel="stylesheet" href="${pageContext.request.contextPath }/web/bootstrap/css/owl.carousel.min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath }/web/bootstrap/css/owl.theme.default.min.css">
	<!-- Theme style  -->
	<link rel="stylesheet" href="${pageContext.request.contextPath }/web/bootstrap/css/style.css">
	<!-- Modernizr JS -->
	<script src="${pageContext.request.contextPath }/web/bootstrap/js/modernizr-2.6.2.min.js"></script>

<script>
function check(){
   idTxt = document.form.id;
   pwTxt = document.form.pwd;
   
   if(idTxt.value == ""){
      alert("아이디를 입력해주세요.");
      idTxt.value = "";
      idTxt.focus();
      return false;
   }
   if(pwTxt.value == ""){
      alert("비밀번호를 입력해주세요.");
      idTxt.value = "";
      idTxt.focus();
      return false;
   }
}
</script>
<script language="javascript">
// opener관련 오류가 발생하는 경우 아래 주석을 해지하고, 사용자의 도메인정보를 입력합니다. ("팝업API 호출 소스"도 동일하게 적용시켜야 합니다.)
//document.domain = "abc.go.kr";

function goPopup(){
	// 주소검색을 수행할 팝업 페이지를 호출합니다.
	// 호출된 페이지(jusopopup.jsp)에서 실제 주소검색URL(http://www.juso.go.kr/addrlink/addrLinkUrl.do)를 호출하게 됩니다.
	var pop = window.open("/PreLINING/popup/jusoPopup.jsp","pop","width=570,height=420, scrollbars=yes, resizable=yes"); 
	
	// 모바일 웹인 경우, 호출된 페이지(jusopopup.jsp)에서 실제 주소검색URL(http://www.juso.go.kr/addrlink/addrMobileLinkUrl.do)를 호출하게 됩니다.
    //var pop = window.open("/popup/jusoPopup.jsp","pop","scrollbars=yes, resizable=yes"); 
}


function jusoCallBack(addr,roadAddrPart1,addrDetail,roadAddrPart2,engAddr, jibunAddr, zipNo, admCd, rnMgtSn, bdMgtSn,detBdNmList,bdNm,bdKdcd,siNm,sggNm,emdNm,liNm,rn,udrtYn,buldMnnm,buldSlno,mtYn,lnbrMnnm,lnbrSlno,emdNo){
		// 팝업페이지에서 주소입력한 정보를 받아서, 현 페이지에 정보를 등록합니다.
		document.loginForm.s_addr.value = addr;
	
		
}

</script>

	</head>
	<body>
	<div id="page">

	<c:if test="${not empty sessionScope.id }">
		<c:if test="${sessionScope.memberType==1 }">
			<c:import url="/web/navi/login_ok.jsp"></c:import>
		</c:if>
		
		<c:if test="${sessionScope.memberType==2 }">
			<c:if test="${empty shop.name}">
				<c:import url="/web/navi/login_ok2.jsp"></c:import>
			</c:if>
			
			<c:if test="${not empty shop.name}">
				<c:import url="/web/navi/login_ok3.jsp"></c:import>
			</c:if>
		</c:if>
	</c:if>
	<c:if test="${empty sessionScope.id }">
		<c:import url="/web/navi/index.jsp"></c:import>
	</c:if>
	
	<header id="gtco-header" class="gtco-cover gtco-cover-shop" role="banner" 
	style="background-image: url(${pageContext.request.contextPath }/web/images/img_bg_2.jpg)" data-stellar-background-ratio="0.5">
		<div class="overlay"></div>
		<div class="gtco-container">
			<div class="row">
				<div class="col-md-15 col-md-offset-0">	
					<div class="row row-mt-10em">
						<div class="col-md-6 col-md-push-3 animate-box" data-animate-effect="fadeIn">
						<h2 class="text-center">가게 등록</h2>
							<div class="form-wrap">
								<div class="tab tab-content tab-content-inner active">
								<form action="${pageContext.request.contextPath }/AddShopController" method = "post" name="loginForm" onsubmit="return check()"
								enctype="multipart/form-data">
										<label class="text-left">가게이름</label>
										<input type="text" name="name" class="form-control"> <br>
										<label class="text-left">메뉴1</label>
										<input type="text" name="menu1" class="form-control"> <br>
										<label class="text-left">메뉴2</label>
										<input type="text" name="menu2" class="form-control"> <br>
										<label class="text-left">메뉴3</label>
										<input type="text" name="menu3" class="form-control"> <br>
										<label class="text-left">위치</label>
										<button onclick="goPopup();" type="button" class="btn btn-primary btn-join">주소 찾기</button>
										<input type="text" name="s_addr"	 class="form-control" readonly> <br>
										<label class="text-left">전화번호</label>
										<input type="text" name="phone" class="form-control"> <br>
										<label class="text-left">이미지</label>
										<input type="file" name="file" class="form-control"> <br>
										<label class="text-left">상세설명</label>
										<textarea name="content" rows="10" cols="20" class="form-control"></textarea><br>
										<label class="text-left">카테고리</label>
										<select name="category" class="form-control" multiple="multiple">
										    <option value="" selected="selected">카테고리</option>
										    <option value="치킨">치킨</option>
										    <option value="피자" >피자</option>
										    <option value="햄버거">햄버거</option>
										    <option value="한식">한식</option>
										    <option value="양식">양식</option>
										    <option value="일식">일식</option>
										 	<option value="중식">중식</option>
										 	<option value="일식">일식</option>
										 	<option value="아시안음식">아시안음식</option>
										    <option value="디저트">디저트</option>
		 							 	</select><br>
										<div class="text-right">
										<input type="button" class="btn btn-primary" value="취소" 
										onclick="location.href='${pageContext.request.contextPath }/web/main.jsp'">
										<input type="submit" class="btn btn-primary" value="등록">
										<input type="hidden" name="id" value="${sessionScope.id}">
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

	





	
	<!-- page </div> -->
	</div>

	
	<!-- jQuery -->
	<script src="${pageContext.request.contextPath }/web/bootstrap/js/jquery.min.js"></script>
	<!-- jQuery Easing -->
	<script src="${pageContext.request.contextPath }/web/bootstrap/js/jquery.easing.1.3.js"></script>
	<!-- Bootstrap -->
	<script src="${pageContext.request.contextPath }/web/bootstrap/js/bootstrap.min.js"></script>
	<!-- Waypoints -->
	<script src="${pageContext.request.contextPath }/web/bootstrap/js/jquery.waypoints.min.js"></script>
	<!-- Carousel -->
	<script src="${pageContext.request.contextPath }/web/bootstrap/js/owl.carousel.min.js"></script>
	<!-- countTo -->
	<script src="${pageContext.request.contextPath }/web/bootstrap/js/jquery.countTo.js"></script>
	<!-- Stellar Parallax -->
	<script src="${pageContext.request.contextPath }/web/bootstrap/js/jquery.stellar.min.js"></script>
	<!-- Magnific Popup -->
	<script src="${pageContext.request.contextPath }/web/bootstrap/js/jquery.magnific-popup.min.js"></script>
	<script src="${pageContext.request.contextPath }/web/bootstrap/js/magnific-popup-options.js"></script>
	<script src="${pageContext.request.contextPath }/web/bootstrap/js/moment.min.js"></script>
	<script src="${pageContext.request.contextPath }/web/bootstrap/js/bootstrap-datetimepicker.min.js"></script>
	<!-- Main -->
	<script src="${pageContext.request.contextPath }/web/bootstrap/js/main.js"></script>

	</body>
</html>


<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("UTF-8");
%>
<%
	response.setContentType("text/html; charset=UTF-8");
%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>KIVIEW &mdash; Intro</title>

<%@ include file="head.jsp"%>
<script type="text/javascript" src = "resources/js/test.js"></script>

<style type="text/css">
.modal-content {
  position: relative;
  display: -webkit-box;
  display: -ms-flexbox;
  display: flex;
  -webkit-box-orient: vertical;
  -webkit-box-direction: normal;
  -ms-flex-direction: column;
  flex-direction: column;
  width: 100%;
  pointer-events: auto;
  background-color: #fff;
  background-clip: padding-box;
  border: 0;
  border-radius: 0.3rem;
  outline: 0; }
.modal-dialog.modal-fullsize {
  width: 100%;
  height: 100%;
  margin: 0;
  padding: 0;
}

.modal-content.modal-fullsize {
  height: auto;
  min-height: 100%;
  border-radius: 0;
}



</style>




</head>

<body id="body">

	<!-- @@ header 부분 @@ -->
	<%@ include file="header.jsp"%>

	<section class="hero-wrap hero-wrap-2"
		style="background-image: url('resources/images/bg_2.jpg');">
		<div class="overlay"></div>
		<div class="container">
			<div
				class="row no-gutters slider-text align-items-center justify-content-center">
				<div class="col-md-9 ftco-animate text-center">
					<h1 class="mb-2 bread">키뷰 소개</h1>
					<p class="breadcrumbs">
						<span class="mr-2"><a href="index.do">홈 
						<i class="ion-ios-arrow-forward"></i></a>
						</span> <span>키뷰안내 <i class="ion-ios-arrow-forward"></i></span> 
						<span>&nbsp;키뷰 소개</span>
					</p>
				</div>
			</div>
		</div>
	</section>
	
	<!-- @@ header 끝 @@ -->

	<div class="jsx-903324597 content" style = "min-height:0px;" id = "contentdiv">
		<div class="jsx-3810764099 board-box">
			<div class="jsx-1103591975 sidebar sidebar--kindergarten">
				<h2 class="jsx-1103591975">
				<svg xmlns="http://www.w3.org/2000/svg" width="32" height="32"
						viewBox="0 0 24 24" fill="none" stroke="#dfdfdf" stroke-width="2"
						stroke-linecap="round" stroke-linejoin="round"
						style="position: relative;">
						<path
							d="M14 2H6a2 2 0 0 0-2 2v16a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V8z"></path>
						<polyline points="14 2 14 8 20 8"></polyline>
						<line x1="16" y1="13" x2="8" y2="13"></line>
						<line x1="16" y1="17" x2="8" y2="17"></line>
						<polyline points="10 9 9 9 8 9"></polyline></svg>
					<span class="jsx-1103591975">공지사항</span>
				</h2>
				<ul class="jsx-1103591975">
					<!-- <li class="jsx-1103591975">
					<a class="jsx-1103591975" style = "cursor:pointer;"
					 onclick = "notice();" id = "menu01">공지사항</a></li>
					<li class="jsx-1103591975">
					<a class="jsx-1103591975" style = "cursor:pointer;"
					onclick = "intro();" id = "menu02">키뷰소개</a></li>
					<li class="jsx-1103591975 ">
					<a class="jsx-1103591975" style = "cursor:pointer;"
					onclick = "faq();" id = "menu03">FAQ</a></li> -->
					<li class="jsx-1103591975">
					<a class="jsx-1103591975" style = "cursor:pointer;"
					 id = "menu01">공지사항</a></li>
					<li class="jsx-1103591975 active">
					<a class="jsx-1103591975" style = "cursor:pointer;"
					id = "menu02">키뷰소개</a></li>
					<li class="jsx-1103591975">
					<a class="jsx-1103591975" style = "cursor:pointer;"
					id = "menu03">FAQ</a></li>
				</ul>
			</div>
        		<div class="pricing-entry bg-light pb-4 text-center"
        			style = "position:relative; right:25%; width:35%;">
        			<!-- <div>
	        			<h3 class="mb-3">Basic</h3>
	        			<p><span class="price">$24.50</span> <span class="per">/ 5mos</span></p>
	        		</div> -->
	        		<div class="img" 
	        			style="background-image: url(resources/images/bg_1.jpg); height: 100%;"></div>
	        		<div class="px-4" style = "background:#fafafa;">
	        			<p>유치원의 모든 리뷰 KIVIEW</p>
	        			<br>
	        			<p class="button text-center">
	        			<a style = "cursor:pointer;" onclick = 
							"document.getElementById('myFullsizeModal').style.display='block'" 
							class="btn btn-primary px-4 py-3">눌러보세요!</a></p>
        			</div>
        		</div>
        		
         <div class="modal fade" id="myFullsizeModal" tabindex="-1" role="dialog" 
         aria-labelledby="myFullsizeModalLabel" style = "display:none;">
			  <div class="modal-dialog modal-fullsize" role="document">
			    <div class="modal-content modal-fullsize">
			      <div class="modal-header">
			        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
			        <span aria-hidden="true">&times;</span></button>
			        <h4 class="modal-title" id="myModalLabel"></h4>
			      </div>
			      <div class="modal-body">
			        <div class="jsx-2460799870 bar-layout">
			        <h1>SEARCH</h1>
					<p class="jsx-2460799870">
						어떤 <span class="jsx-2460799870">유치원</span>을 찾으세요?
					</p>
					<div class="jsx-2460799870 search-box">
					<div class="jsx-2460799870 search-bar">
						<input type="text" class="search-bar" />
						<span><img src="resources/images/main/search02.png"></span>
					</div>
				</div>
				</div>
			      </div>
			      <!-- <div class="modal-footer">
			        <button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
			      </div> -->
			    </div>
			  </div>
			</div>
        		
		</div>
	</div>
	<br>
	<br>
	<br>
	<section style = "background:#fff;">
		<div class="container">
			<br><br><br><br><br><br><br><br>
		</div>
	</section>
	


	<!-- @@ footer 영역 @@ -->
	<%@ include file="footer.jsp"%>

	

</body>
</html>

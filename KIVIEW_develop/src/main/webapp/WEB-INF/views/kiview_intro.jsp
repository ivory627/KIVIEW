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
<link rel="stylesheet" href="resources/css/modalintro.css">

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

	<div class="jsx-903324597 content" style = "min-height:0px;">
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
					<li class="jsx-1103591975 active"><a class="jsx-1103591975"
						href="kiviewnotice.do">공지사항</a></li>
					<li class="jsx-1103591975 "><a class="jsx-1103591975"
						href="kiviewintro.do">키뷰소개</a></li>
					<li class="jsx-1103591975 "><a class="jsx-1103591975"
						href="kiviewfaq.do">FAQ</a></li>
				</ul>
			</div>
				<div class="col-md-6 course d-lg-flex ftco-animate"
					style = "position:relative; right: 150px;" >
					<div class="img" style="background-image: url(resources/images/course-1.jpg);"></div>
						<div class="text bg-light p-4">
							<h3><a style = "cursor:pointer;" onclick = 
							"document.getElementById('id01').style.display='block'" 
							class="w3-button w3-black">Arts Lesson</a></h3>
							<p class="subheading"><span>Class time:</span> 9:00am - 10am</p>
							<p>Separated they live in. A small river named Duden flows by their place and supplies it with the necessary regelialia. It is a paradisematic country</p>
						</div>
				</div>
				<div id="id01" class="w3-modal">
						    <div class="w3-modal-content w3-animate-top w3-card-4">
						      <header class="w3-container w3-teal"> 
						        <span onclick="document.getElementById('id01').style.display='none'" 
						        class="w3-button w3-display-topright">&times;</span>
						        <h2>KIVIEW를 소개합니다!</h2>
						      </header>
						      <div class="w3-container">
						      <br>
						      </div>
						    </div>
				</div>
		</div>
	</div>


	<br>
	<br>
	<br>


	<!-- @@ footer 영역 @@ -->
	<%@ include file="footer.jsp"%>




	

</body>
</html>

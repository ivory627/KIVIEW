<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>



<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>


<!DOCTYPE html>
<html lang="en">
<head>

<title>KIVIEW &mdash; Cafe Home</title>

<%@ include file="../head.jsp"%>

<style type="text/css">
a {
	text-decoration: none;
}

.intro {
	width: 500px; /* 너비는 변경될수 있습니다. */
	text-overflow: ellipsis; /* 위에 설정한 100px 보다 길면 말줄임표처럼 표시합니다. */
	white-space: nowrap; /* 줄바꿈을 하지 않습니다. */
	overflow: hidden; /* 내용이 길면 감춤니다 */
}
</style>

<script type="text/javascript">
	function test() {
		var keyword = $('#cafesearch').val().trim();
		location.href = "cafesearch.do?keyword=" + keyword;
	}
	
	function member_out(member_no, cafe_member_no){
		
				
		if(confirm("해당 카페를 탈퇴하시겠습니까?")){
			location.href="memberout.do?member_no="+member_no+"&cafe_member_no="+cafe_member_no
		}
	}
	
	function cafe_delete(member_no, cafe_no){ 
		
		
		if(confirm("해당 카페를 폐쇄하시겠습니까? \n\n주의 : 다시 복구하실 수 없습니다.")){
			location.href="cafedelete.do?member_no="+member_no+"&cafe_no="+cafe_no 
		}
	}
	
	
</script>

</head>
<body id="body">



	<!-- @@ header 부분 @@ -->
	<%@ include file="../header.jsp"%>

	<!-- @@ <h1 class = "mb-2 bread"> sub title 이 부분 우선 header에서 따로 빼놨어요!!! </h1> @@ -->
	<section class="hero-wrap hero-wrap-2"
		style="background-image: url('resources/images/bg_2.jpg');">
		<div class="overlay"></div>
		<div class="container">
			<div
				class="row no-gutters slider-text align-items-center justify-content-center">
				<div class="col-md-9 ftco-animate text-center">
					<h1 class="mb-2 bread">카페 홈</h1>
					<p class="breadcrumbs">
						<span class="mr-2"><a href="index.jsp">홈 <i
								class="ion-ios-arrow-forward"></i></a></span> <span>키뷰카페 <i
							class="ion-ios-arrow-forward"></i></span>
					</p>
				</div>
			</div>
		</div>
	</section>
	<!-- @@ header 끝 @@ -->

	<!-- 여기서부터 작업 -->
	<section class="ftco-section bg-light">
		<div class="container">
			<div class="row">

				<!-- 카페 홈 소개 -->
				<div class="col-lg-8 ftco-animate">
					<a href="cafehome.do">
						<h2 class="mb-3" style="font-weight: bold; color: #FFDC00;">
							<span><img src="resources/images/main/chat.png" /></span>&nbsp;&nbsp;
							<span style="color: #9BDAF2;">Kiview</span> Cafe
						</h2>
					</a>
					<hr>
					<p>admin 님이 가입한 카페 가입 목록입니다.</p>

					<!-- 여기서부터 반복 -->
					<c:choose>
						<c:when test="${empty cafe }">
							<div class="row">
								<label>가입한 카페가 없습니다.</label>

							</div>
						</c:when>
						<c:otherwise>
							<c:forEach items="${cafe }" var="cafe">
								

								<div class="row">


									<div class="col-md-12 course d-lg-flex ftco-animate"
										style="padding: 30px; margin: 0px; padding-bottom: 0px;">
										<div style="width: 25%; margin-right: 30px;">
											<a href="cafedetail.do?cafe_no=${cafe.cafe_no }&member_no=${login.member_no}"> <span><img
													style="width: 80%; height: 100%"
													src='http://localhost:8787/img/${cafe.thumb }' /></span></a>



										</div>

										<div style="width: 70%">
											<h3 style="margin: 0px">
												<a href="cafedetail.do?cafe_no=${cafe.cafe_no }&member_no=${login.member_no}"
													style="cursor: pointer">" ${cafe.title } "</a>
											</h3>
											
											
											<p>
												<span>${cafe.admin }</span> | <span>게시글 수</span> | 
												
												
												<c:set var="count" value="0"/>
													<c:forEach items="${member }" var="member">
													
														<c:if test="${cafe.cafe_no == member.cafe_no }">
															<c:set var="count" value="${count+1 }"/>

														</c:if>
													
													</c:forEach>
													<span>${count}</span>
												
											</p>
											
											<p class="intro">${cafe.intro }</p>
											

										</div>

									</div>

									<div style="padding: 0px; width: 100%;">
										
										<c:if test="${cafe.admin ne login.member_id }">
											<c:forEach var="member" items="${member }">
												<c:if test="${login.member_no == member.member_no && cafe.cafe_no == member.cafe_no }">
													<br> <input style="position: relative; left: 90%; background-color:black"
														class="btn btn-secondary" type="button" value="탈퇴"
														onclick="member_out(${login.member_no },${member.cafe_member_no})" > 
													<hr> 
												</c:if>
											</c:forEach> 
										</c:if>  
										<c:if test="${cafe.admin eq login.member_id }">
											
													<br> <input style="position: relative; left: 90%; background-color:black"
														class="btn btn-secondary" type="button" value="폐쇄"
														onclick="cafe_delete(${login.member_no },${cafe.cafe_no})" >
													<hr> 
												
										</c:if>
									</div> 


								</div>
								</c:forEach> 
							
						</c:otherwise>

					</c:choose>
					<!-- 여기까지 반복 -->



					<br> <br>
				</div>

				<div class="col-lg-4 sidebar ftco-animate"
					style="border-left: 0px solid lightgray">

					<div class="sidebar-box">
						<h3>카페 찾기</h3>
						<form action="#" class="search-form" style="padding: 0px">
							<div class="form-group">
								<span class="icon icon-search" style="cursor: pointer"
									onclick="test();"></span> <input type="text"
									class="form-control" placeholder="카페명을 입력해주세요." id="cafesearch"
									onkeypress="if( event.keyCode == 13 ){test();}">
							</div>
						</form>
					</div>



					<!-- 카페 추천 -->
					<div class="sidebar-box ftco-animate">
						<h3>Popular Cafe</h3>
						<div class="block-21 mb-4 d-flex">
							<a class="blog-img mr-4"
								style="background-image: url('resources/images/bg_2.jpg');"></a>
							<div class="text">
								<h3 class="heading">
									<a href="#">Even the all-powerful Pointing has no control
										about the blind texts</a>
								</h3>
								<div class="meta">
									<div>
										<a href="#"><span class="icon-calendar"></span> Jan. 27,
											2019</a>
									</div>
									<div>
										<a href="#"><span class="icon-person"></span> Dave Lewis</a>
									</div>
									<div>
										<a href="#"><span class="icon-chat"></span> 19</a>
									</div>
								</div>
							</div>
						</div>
						<p class="mb-0">
							<a href="cafeopen.do" class="btn btn-secondary"
								style="width: 300px">카페 개설하기 </a>
						</p>
					</div>
				</div>
			</div>





		</div>



	</section>


	<!-- @@ footer 영역 @@ -->
	<%@ include file="../footer.jsp"%>





</body>
</html>
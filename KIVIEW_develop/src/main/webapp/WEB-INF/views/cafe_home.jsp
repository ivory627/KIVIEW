<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("UTF-8");
%>
<%
	response.setContentType("text/html; charset=UTF-8");
%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>


<!DOCTYPE html>
<html lang="en">
<head>

<title>KIVIEW &mdash; Cafe Home</title>

<%@ include file="head.jsp"%>

<style type="text/css">
a {
	text-decoration: none;
}
</style>

<script type="text/javascript">
	
</script>

</head>
<body id="body">

	<%@include file="cafe_modal.jsp"%>

	<!-- @@ header 부분 @@ -->
	<%@ include file="header.jsp"%>

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
					<a href="cafehome.do?cafe_no=${vo.cafe_no }">
						<h2 class="mb-3" style="font-weight: bold; color: #FFDC00;">
							<span><img src="resources/images/main/chat.png" /></span>&nbsp;&nbsp;
							<span style="color: #9BDAF2;">Kiview</span> Cafe
						</h2>
					</a>
					<hr>
					<p>키뷰 안에서 카페를 만들고 새로운 커뮤니티를 만들어보세요. 키뷰에서는 누구든지 카페를 개설할 수 있고 키뷰
						회원들과 친목을 도모할 수 있습니다.</p>
					<p>
						<img src="resources/images/image_2.jpg" alt="" class="img-fluid">
					</p>

					<p>Quisquam esse aliquam fuga distinctio, quidem delectus
						veritatis reiciendis. Nihil explicabo quod, est eos ipsum. Unde
						aut non tenetur tempore, nisi culpa voluptate maiores officiis
						quis vel ab consectetur suscipit veritatis nulla quos quia
						aspernatur perferendis, libero sint. Error, velit, porro. Deserunt
						minus, quibusdam iste enim veniam, modi rem maiores.</p>

					<br> <br>
				</div>

				<div class="col-lg-4 sidebar ftco-animate"
					style="border-left: 0px solid lightgray">

					<div class="sidebar-box">
						<h3>카페 찾기</h3>
						<form action="#" class="search-form" style="padding: 0px">
							<div class="form-group">
								<span class="icon icon-search" style="cursor: pointer"
									onclick="location.href='cafesearch.do'"></span> <input
									type="text" class="form-control" placeholder="카페명을 입력해주세요.">
							</div>
						</form>
					</div>



					<!-- 카페 추천 -->
					<div class="sidebar-box ftco-animate">
						<h3>Popular Cafe</h3>
						<div class="block-21 mb-4 d-flex">
							<a class="blog-img mr-4"
								style="background-image: url(resources/images/image_1.jpg);"></a>
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


			<!-- 카페 리스트 단위 -->
			<span><h3 style="display: inline">가입한 카페</h3>&nbsp;[${fn:length(list)}]<!-- 카페 수 --></span>
			<!-- **20/02/07 내 카페 관리 버튼형식으로 변경  -->
			<span><a href="cafemy.do?member_no=${login.member_no }"
				class="btn btn-secondary2"
				style="width: 160px; position: relative; left: 77%;">내 카페 관리</a></span>
			<hr style="margin-top: 5px;">

			<div class="row">
				<c:choose>
					<c:when test="${empty list }">


						<div class="col-md-6 col-lg-4 ftco-animate"
							style="position: relative; left: 40%">
							<br>
							<br> 가입한 카페가 없습니다. <br>
							<br>
						</div>

					</c:when>


					<c:otherwise>
						<c:forEach var="list" items="${list }" begin="0" end="5">




							<div class="col-md-6 col-lg-4 ftco-animate">
								<div class="blog-entry">
									<!-- 썸네일 -->
									<a href="cafedetail.do?cafe_no=${list.cafe_no }"
										class="block-20 d-flex align-items-end"
										style="background-image: url('http://localhost:8787/img/${list.thumb }');">
										<!-- 가입제한 -->
										<div class="meta-date text-center p-2">
											<span class="mos"> <c:if
													test="${list.restriction eq 'y'}">                           
                                       바로가입                           
                                    </c:if> <c:if
													test="${list.restriction eq 'n'}">
                                       승인후 가입
                                    </c:if>

											</span>
										</div>
									</a>

									<div class="text bg-white p-4">
										<!-- 카페명 -->
										<h3 class="heading">
											<a href="cafe_detail.jsp">${list.title }</a>
										</h3>

										<!-- 카페소개 -->
										<p>${list.intro }</p>
										<div class="d-flex align-items-center mt-4">
											<p class="mb-0">
												<a href="cafedetail.do?cafe_no=${list.cafe_no }"
													class="btn btn-secondary">들어가기 <span
													class="ion-ios-arrow-round-forward"></span></a>
											</p>
											<p class="ml-auto mb-0">
												<!-- 카페장 -->
												<a href="#" class="mr-2">${list.admin }</a>
												<!-- 카페 회원 수 -->
												<a href="#" class="meta-chat">1 /50</a>
											</p>
										</div>
									</div>
								</div>
								<br>
							</div>








						</c:forEach>

					</c:otherwise>
				</c:choose>

			</div>

			<!-- list size가 6개 이상일 경우 더보기 버튼 -->
			<c:if test="${fn:length(list) < 5}">

				<div>
					<span><a href="cafemy.do?member_no=${login.member_no }"
						class="btn btn-secondary2"
						style="width: 25%; position: relative; left: 40%;">더 보기</a></span>
				</div>

			</c:if>
			<br>
			<br>




			<!-- 카페 리스트 단위 -->
			<span><h3 style="display: inline">운영중 카페</h3></span>



			<hr style="margin-top: 5px;">


			<div class="row">
				<c:choose>
					<c:when test="${empty list  }">
						<div class="col-md-6 col-lg-4 ftco-animate"
							style="position: relative; left: 40%">
							<br>
							<br> 가입한 카페가 없습니다. <br>
							<br>
						</div>
					</c:when>
					<c:otherwise>
						
						<c:forEach var="list" items="${list }">
							<c:if test="${list.admin eq login.member_id}">




								<div class="col-md-6 col-lg-4 ftco-animate">
									<div class="blog-entry">
										<!-- 썸네일 -->
										<a href="cafedetail.do?cafe_no=${list.cafe_no }"
											class="block-20 d-flex align-items-end"
											style="background-image: url('http://localhost:8787/img/${list.thumb }');">
											<!-- 가입제한 -->
											<div class="meta-date text-center p-2">
												<span class="mos"> <c:if
														test="${list.restriction eq 'y'}">                           
                                       바로가입                           
                                    </c:if> <c:if
														test="${list.restriction eq 'n'}">
                                       승인후 가입
                                    </c:if>

												</span>
											</div>
										</a>

										<div class="text bg-white p-4">
											<!-- 카페명 -->
											<h3 class="heading">
												<a href="cafe_detail.jsp">${list.title }</a>
											</h3>

											<!-- 카페소개 -->
											<p>${list.intro }</p>
											<div class="d-flex align-items-center mt-4">
												<p class="mb-0">
													<a href="cafedetail.do?cafe_no=${list.cafe_no }"
														class="btn btn-secondary">들어가기 <span
														class="ion-ios-arrow-round-forward"></span></a>
												</p>
												<p class="ml-auto mb-0">
													<!-- 카페장 -->
													<a href="#" class="mr-2">${list.admin }</a>
													<!-- 카페 회원 수 -->
													<a href="#" class="meta-chat">1 /50</a>
												</p>
											</div>
										</div>
									</div>
									<br>
								</div>
								<br>






							</c:if>
						</c:forEach> 
						
					</c:otherwise>
					

				</c:choose>

			</div>


		</div>


		</div>
	</section>


	<!-- @@ footer 영역 @@ -->
	<%@ include file="footer.jsp"%>





</body>
</html>
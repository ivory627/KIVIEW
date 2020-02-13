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
<title>KIVIEW &mdash; About</title>

<%@ include file="head.jsp"%>


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
					<h1 class="mb-2 bread">공지사항</h1>
					<p class="breadcrumbs">
						<span class="mr-2"> <a href="index.do">홈 <i
								class="ion-ios-arrow-forward"></i></a>
						</span> <span>키뷰안내 <i class="ion-ios-arrow-forward"></i></span> 
						<span>&nbsp;공지사항</span>
					</p>
				</div>
			</div>
		</div>
	</section>
	<!-- @@ header 끝 @@ -->



	<!--=================@@게시판 상단 select box + 검색 @@====================-->
	
	<div class="jsx-903324597 content">
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
			
			<div class="jsx-2295643283 content-box">
				
				<div class="jsx-2864104005 board-title">
					<h3 class="jsx-2864104005">공지사항</h3>
					<ol class="jsx-1271347565 ">
						<li class="jsx-1271347565">홈</li>
						<li class="jsx-1271347565">키뷰안내</li>
						<li class="jsx-1271347565">공지사항</li>
					</ol>
				</div>
				
				
				<!--=================@@게시판 상단 select box + 검색 @@====================-->
				
				<div class="jsx-4261166144 select-wrap" >
					<div class="jsx-4261166144 select-box">
						<div class="jsx-4121141969 select">
							<div class="jsx-4121141969 choice">
							
							<form action="#" class="appointment-form ftco-animate fadeInUp ftco-animated">
							  <select class="form-control-sm2" style="cursor:pointer;">
		          				<option selected>분류 전체</option>
							        <option>공지사항</option>
							  </select>
						   </form>
							</div>
						</div>
					</div>
					&nbsp;&nbsp;&nbsp;&nbsp;

					<div class="jsx-4261166144 select-box">
						<div class="jsx-4121141969 select select--none">
							<div class="jsx-4121141969 choice">
								
								<form action="#" class="appointment-form ftco-animate fadeInUp ftco-animated">
								  <select class="form-control-sm2" style="cursor:pointer;">
			          				<option selected>최신순</option>
								        <option>조회순</option>
								  </select>
						  	 </form>
						  	 
							</div>
						</div>
					</div>

					<div class="jsx-4261166144 search">
						<div class="jsx-1738213615 search-box">
							<div class="jsx-3573217014 input">
								<input title="검색어 입력" placeholder="검색어를 입력해 주세요."
									class="jsx-3573217014 input" value="" style="width: 188px;">
							</div>
							<button type="button" class="jsx-574097175 "
								style="margin-left: 16px;">검색</button>
						</div>
					</div>

				</div>
				
				
				
				<div class="jsx-723712822 sort-number">
					<span class="jsx-723712822 total-number">총 3845개</span>
				</div>
				
				<div class="jsx-1702879176 board-list-box">
					<ul class="jsx-1702879176 list-header">
						<li class="jsx-1702879176"><div class="jsx-1702879176"
								style="max-width: 60px;">번호</div>
							<div class="jsx-1702879176" style="max-width: 120px;">분류</div>
							<div class="jsx-1702879176" style="max-width: 344px;">제목</div>
							<div class="jsx-1702879176" style="max-width: 100px;">작성자</div>
							<div class="jsx-1702879176" style="max-width: 100px;">등록일</div>
							<div class="jsx-1702879176" style="max-width: 60px;">조회</div>
					</ul>
					
					
					<!--===========================@@ 공지사항 글 목록 @@========================-->
					
					<c:choose>
					<c:when test="${!empty noticelist}">					
					<ul class="jsx-1702879176 list-body">
						
						<li tabindex="0" class="jsx-1066086808 notice">
						<div class="jsx-1066086808 col-notice hide-on-mobile"
								style="max-width: 60px;">공지</div>
							<div class="jsx-1066086808 col-category"
								style="max-width: 120px;">수다</div>
							<div class="jsx-1066086808 col-title" style="max-width: 344px;">
								<a class="jsx-1066086808"
									href="kiviewdetail.do"
									style="max-width: 250px;">
								<span class="jsx-1066086808 notice-badges">공지</span>[별별선생 이벤트] 선생님!
									외않돼요? AMA 댓글놀이 이벤트 !
								</a>
								<span class="jsx-1066086808 comment-number hide-on-mobile">
									[149]
								</span>
								<span class="jsx-1066086808 comment-number hide-on-desktop">149
								<span class="jsx-1066086808">댓글</span></span>
							</div>
							<div class="jsx-1066086808 nickname" style="max-width: 100px;">별별이</div>
							<div class="jsx-1066086808 col-created" style="max-width: 100px;">20.01.06</div>
							<div class="jsx-1066086808 read_count hide-on-mobile"
								style="max-width: 60px;">2876</div>
							<div class="jsx-1066086808 read_count hide-on-desktop"
								style="max-width: 60px;">2876</div>
							<div class="jsx-1066086808 like_count hide-on-desktop"
								style="max-width: 60px;"></div></li>


						<li tabindex="0" class="jsx-2214240288">
						<div class="jsx-2214240288 col-notice" style="max-width: 60px;">3845</div>
							<div class="jsx-2214240288 col-category"
								style="max-width: 120px;">유치원</div>
							<div class="jsx-2214240288 col-title" style="max-width: 344px;">
								<a class="jsx-2214240288"
									href="kiviewdetail.do"
									style="max-width: 328px;">모든 선생님이 열정으로 일하시는게 보입니다</a>
								<span class="jsx-2214240288 comment-number hide-on-desktop">0
								<span class="jsx-2214240288">댓글</span>
								</span>
							</div>
							<div class="jsx-2214240288 col-nickname"
								style="max-width: 100px;">헤이i</div>
							<div class="jsx-2214240288 col-created" style="max-width: 100px;">20.02.05</div>
							<div class="jsx-2214240288 read_count hide-on-mobile"
								style="max-width: 60px;">16</div>
							<div class="jsx-2214240288 read_count hide-on-desktop"
								style="max-width: 60px;"></div>
							<div class="jsx-2214240288 like_count hide-on-desktop"
								style="max-width: 60px;"></div>
						</li>
					</ul>
					</c:when>
					<c:otherwise>
						<ul class="jsx-1702879176 list-body">
						<li tabindex="0" class="jsx-1066086808 notice" style = "position:relative; left:0%;">
							<div class="jsx-1066086808 col-title" style="max-width: 344px;">
								<table style="position:relative; left: 100%;">
									<tr>
										<td align="center" colspan="10">작성된 글이 없습니다.</td>
									</tr>
								</table>
							</div>
						</ul>
					</c:otherwise>
					</c:choose>
					<!-- ---------@@ 글 목록 끝 @@--------- -->
					
				</div>


				<!--======================== @@ 페이징 @@=========================-->
				
				<div class="jsx-1407906967 board-list-footer">
					<ul class="jsx-3635512122 pagination pagination--kindergarten">
						<li class="jsx-3635512122 prev disabled"><svg
								xmlns="http://www.w3.org/2000/svg" width="24" height="24"
								viewBox="0 0 24 24" fill="none" stroke="#dfdfdf"
								stroke-width="2" stroke-linecap="round" stroke-linejoin="round"
								style="position: relative;">
								<polyline points="11 17 6 12 11 7"></polyline>
								<polyline points="18 17 13 12 18 7"></polyline></svg> <span
							class="jsx-3635512122 alt-text">앞으로</span></li>
						<li class="jsx-3635512122 on">1</li>
						<li class="jsx-3635512122 ">2</li>
						<li class="jsx-3635512122 ">3</li>
						<li class="jsx-3635512122 ">4</li>
						<li class="jsx-3635512122 ">5</li>
						<li class="jsx-3635512122 ">6</li>
						<li class="jsx-3635512122 ">7</li>
						<li class="jsx-3635512122 ">8</li>
						<li class="jsx-3635512122 ">9</li>
						<li class="jsx-3635512122 ">10</li>
						<li class="jsx-3635512122 next"><svg
								xmlns="http://www.w3.org/2000/svg" width="24" height="24"
								viewBox="0 0 24 24" fill="none" stroke="#dfdfdf"
								stroke-width="2" stroke-linecap="round" stroke-linejoin="round"
								style="position: relative;">
								<polyline points="13 17 18 12 13 7"></polyline>
								<polyline points="6 17 11 12 6 7"></polyline></svg> <span
							class="jsx-3635512122 alt-text">뒤로</span></li>
					</ul>
					<div
						class="jsx-1407906967 btn-write btn-write--kindergarten fix-position">
						<button class="jsx-1407906967"
							onclick="location.href='kiviewwrite.do'">글쓰기</button>
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

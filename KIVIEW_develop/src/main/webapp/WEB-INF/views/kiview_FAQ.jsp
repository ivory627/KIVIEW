<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>KIVIEW - FAQ</title>

	<%@ include file="head.jsp"%>
	<link rel="stylesheet" href="resources/css/FAQ.css">


</head>
<body>

	<%@ include file="header.jsp"%>

	<section class="hero-wrap hero-wrap-2"
		style="background-image: url('resources/images/bg_2.jpg');">
		<div class="overlay"></div>
		<div class="container">
			<div
				class="row no-gutters slider-text align-items-center justify-content-center">
				<div class="col-md-9 ftco-animate text-center">
					<h1 class="mb-2 bread">FAQ</h1>
					<p class="breadcrumbs">
						<span class="mr-2"> <a href="index.do">홈 <i
								class="ion-ios-arrow-forward"></i></a>
						</span> <span>키뷰안내 <i class="ion-ios-arrow-forward"></i></span> <span>&nbsp;FAQ</span>
					</p>
				</div>
			</div>
		</div>
	</section>

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
						href="kiview_notice.jsp">키뷰소개</a></li>
					<li class="jsx-1103591975 "><a class="jsx-1103591975"
						href="kiviewfaq.do">FAQ</a></li>
				</ul>
			</div>

			<div class="jsx-2342570284 faq-box faq-box--kindergarten">
				<ul class="jsx-2342570284 faq-tab">
					<li class="jsx-2342570284"><button
							class="jsx-2342570284 active">전체</button></li>
					<li class="jsx-2342570284"><button class="jsx-2342570284 ">별별선생</button></li>
					<li class="jsx-2342570284"><button class="jsx-2342570284 ">회원</button></li>
					<li class="jsx-2342570284"><button class="jsx-2342570284 ">서비스</button></li>
				</ul>
				<div class="jsx-2342570284 faq-item-box">
					<h3 class="jsx-2342570284">
						자주 묻는 질문과 답변
						<ol class="jsx-1271347565 ">
							<li class="jsx-1271347565">별별질문</li>
							<li class="jsx-1271347565">FAQ</li>
						</ol>
					</h3>

					<!-- FAQ 게시글 -->
					<ul class="jsx-2342570284 faq-item-list">
						<li class="jsx-357641531 question-item--kindergarten">
						
							<button type="button" class="jsx-357641531" id = "faqbtn01" >
								<span class="jsx-357641531 question-icon">Q</span>
								<span class="jsx-357641531 tab-name">서비스</span>
								<p class="jsx-357641531">리뷰를 작성했어요, 언제승인 되나요?</p>
								<span class="jsx-357641531 arrow"></span>
							</button>
							
							<div class="jsx-357641531 content" id = "faqcomment01">
								<div class="jsx-2567501591 editor">
									<div class="fr-view">
										<p>별별선생 영업일 기준, 리뷰 작성 후 평균 24시간 이내에 심사가 완료됩니다.&nbsp;</p>
										<p>주말 혹은 공휴일의 경우 심사가 조금 늦어질 수 있습니다.</p>
										<p>
											<br>
										</p>
										<p>작성하신 리뷰는 심사과정에서 [승인]되거나 [반려]될수 있으며</p>
										<p>두 경우 모두 심사결과에 대한 이메일이 발송됩니다.</p>
									</div>
								</div>
							</div>
							
						</li>
					</ul>



					<ul class="jsx-2419612476 pagination pagination--kindergarten">
						<li class="jsx-2419612476 prev disabled"><svg
								xmlns="http://www.w3.org/2000/svg" width="24" height="24"
								viewBox="0 0 24 24" fill="none" stroke="#dfdfdf"
								stroke-width="2" stroke-linecap="round" stroke-linejoin="round"
								style="position: relative;">
								<polyline points="11 17 6 12 11 7"></polyline>
								<polyline points="18 17 13 12 18 7"></polyline></svg><span
							class="jsx-2419612476 alt-text">앞으로</span></li>
						<li class="jsx-2419612476 on">1</li>
						<li class="jsx-2419612476 ">2</li>
						<li class="jsx-2419612476 ">3</li>
						<li class="jsx-2419612476 next disabled"><svg
								xmlns="http://www.w3.org/2000/svg" width="24" height="24"
								viewBox="0 0 24 24" fill="none" stroke="#dfdfdf"
								stroke-width="2" stroke-linecap="round" stroke-linejoin="round"
								style="position: relative;">
								<polyline points="13 17 18 12 13 7"></polyline>
								<polyline points="6 17 11 12 6 7"></polyline></svg><span
							class="jsx-2419612476 alt-text">뒤로</span></li>
					</ul>
				</div>
			</div>
		</div>
	</div>

	<section style="background: #fff;">
		<div class="container">
			<br> <br> <br> <br>
		</div>
	</section>

	<%@ include file="footer.jsp"%>


</body>
</html>
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
<html>
<head>
<meta charset="UTF-8">
<title>KIVIEW &mdash; Login</title>

<link rel="stylesheet" href="resources/css/login.css">
<link
	href="https://fonts.googleapis.com/css?family=Black+Han+Sans&display=swap"
	rel="stylesheet">
<link rel="stylesheet" href="resources/css/modal.css">

</head>
<body>

	<div id="__next">
		<div class="jsx-1458736361 login">
			<!-- 페이지 좌측 로고 -->
			<div class="jsx-145 banner"
				style="background-image: url('resources/images/main/login_img04.png')">
				<a class="jsx-1458736361" href="index.do" style="height: 70px;">
					<img src="resources/images/main/kiview_login.png" alt="Kiview"
					class="jsx-1458736361">
				</a>

			</div>
			<!-- /페이지 좌측 로고 -->

			<div class="jsx-1458736361 login-box">
				<a class="jsx-1458736361 mobile-service go-home" href="/"><img
					src="https://d1ta1myjmiqbpz.cloudfront.net/static/images/logo/logo_square_gray.png"
					alt="Kiview" class="jsx-1458736361"></a>
				<div class="jsx-1458736361 login-box-wrap">
					<!-- 로고 타이틀 -->
					<div class="jsx-1458736361 title">
						<p class="jsx-1458736361">
							<span class="jsx-1458736361">대한민국 NO.1</span> 유치원 평가 플랫폼
						</p>
						<a href="index.do">
							<h2 class="jsx-1458736361"
								style="font-family: 'Black Han Sans', sans-serif;">Kiview</h2>
						</a>

					</div>
					<!-- /로고 타이틀 -->

					<div class="jsx-1458736361 sns-login">
						<ul class="jsx-1458736361">
							<!-- 네이버 계정 로그인 -->
							<li class="jsx-1458736361"><a
								href="https://nid.naver.com/oauth2.0/authorize?response_type=code&amp;client_id=iFnTW27dv2wNRhfYPsFE&amp;redirect_uri=https%3A%2F%2Fwww.starteacher.co.kr%2Fsignup%3Fchannel%3Dnaver%26step%3D6%26type%3Duser&amp;svctype=0"
								tabindex="0" class="jsx-1458736361"><span
									class="jsx-1458736361 alt-text">네이버 계정 로그인</span></a></li>
							<!-- /네이버 계정 로그인 -->

							<!-- 카카오톡 계정 로그인 -->
							<li class="jsx-1458736361"><a
								href="https://kauth.kakao.com/oauth/authorize?response_type=code&amp;client_id=cacac2d9fe13a5f296d0459b1506b1bb&amp;redirect_uri=https%3A%2F%2Fwww.starteacher.co.kr%2Fsignup%3Fchannel%3Dkakao%26step%3D6&amp;state=user"
								tabindex="0" class="jsx-1458736361"><span
									class="jsx-1458736361 alt-text">카카오톡 계정 로그인</span></a></li>
							<!-- /카카오톡 계정 로그인 -->

							<!-- 페이스북 계정 로그인 -->
							<li class="jsx-1458736361"><a
								href="https://www.facebook.com/v3.3/dialog/oauth?response_type=code&amp;client_id=2315035918715891&amp;redirect_uri=https%3A%2F%2Fwww.starteacher.co.kr%2Fsignup%3Fchannel%3Dfacebook%26step%3D6%26type%3Duser"
								tabindex="0" class="jsx-1458736361"><span
									class="jsx-1458736361 alt-text">페이스북 계정 로그인</span></a></li>
							<!-- /페이스북 계정 로그인 -->

						</ul>
					</div>

					<!-- 로그인 -->
					<form class="jsx-1458736361">
						<div class="jsx-1458736361 username">
							<label class="jsx-3712571264 "> <span
								class="jsx-3712571264">아이디&nbsp;</span>&nbsp;&nbsp;<span
								id="loginIdChk" style="color: red;"></span>
								<div class="jsx-639067573 input">
									<input type="text" id="member_id" placeholder="아이디을 입력해 주세요."
										class="jsx-639067573">
								</div>
							</label>
						</div>
						<div class="jsx-1458736361 password">
							<label class="jsx-3712571264 "> <span
								class="jsx-3712571264">비밀번호&nbsp;</span>&nbsp;&nbsp;<span
								id="loginPwdChk" style="color: red;"></span>
								<div class="jsx-1458736361 show-password">
									<div class="jsx-639067573 input">
										<input type="password" id="member_pwd" minlength="10"
											maxlength="20" placeholder="비밀번호를 입력해주세요."
											class="jsx-639067573" />
									</div>
								</div>
							</label>
						</div>

						<p id="loginChk" style="color: red;"></p>

						<div class="jsx-1458736361 btn-login">
							<button type="button" class="jsx-2144885398 " onclick="login();">로그인</button>
						</div>

					</form>
					<!-- /로그인 -->

					<div class="jsx-1458736361 service">
						<!-- 회원가입 버튼 -->
						<a class="jsx-1458736361" href="kiviewsignupoption.do">회원가입</a>
						<!-- /회원가입 버튼 -->

						<span class="jsx-1458736361"></span>

						<!-- 아이디 찾기 버튼 -->
						<a class="jsx-1458736361" style="cursor: pointer;"
							onclick="document.getElementById('id01').style.display='block'"
							class="w3-button w3-black" id="idCkBtn">아이디찾기</a>
						<!-- /아이디 찾기 버튼 -->

						<span class="jsx-1458736361"></span>

						<!-- 아이디 찾기 modal -->
						<div id="id01" class="w3-modal">
							<div class="w3-modal-content w3-animate-top w3-card-4">
								<header class="w3-container w3-teal">
									<span
										onclick="document.getElementById('id01').style.display='none'"
										class="w3-button w3-display-topright">&times;</span>
									<h2>아이디 찾기</h2>
								</header>
								<div class="w3-container">
									<br> <input required="필수 입력사항" placeholder="이름"
										class="find-id" id="idSearch_name"> <br> <input
										required="필수 입력사항" placeholder="이메일" class="find-id"
										id="idSearch_email"> <br>
									<p id="idSearchHTML" style="color: red;"></p>
									<p id="idSearchRes" style="color: blue;"></p>
									<button type="button" class="jsx-2144885398" id="idChkBtn" onclick="idCk()">검색</button>
									<button type="button" class="jsx-2144885398" id="idUseBtn" onclick="idUse()">사용하기</button>
								</div>
							</div>
						</div>
						<!-- /아이디 찾기 modal -->


						<!-- 비밀번호 찾기 버튼 -->
						<a class="jsx-1458736361" style="cursor: pointer;"
							onclick="document.getElementById('id02').style.display='block'"
							class="w3-button w3-black">비밀번호찾기</a>
						<!-- /비밀번호 찾기 버튼 -->

						<!-- 비밀번호 찾기 modal -->
						<div id="id02" class="w3-modal">
							<div class="w3-modal-content w3-animate-top w3-card-4">
								<header class="w3-container w3-teal">
									<span
										onclick="document.getElementById('id02').style.display='none'"
										class="w3-button w3-display-topright">&times;</span>
									<h2>비밀번호 찾기</h2>
								</header>
								<div class="w3-container">
									<br> <input required="필수 입력사항" placeholder="아이디"
										class="find-id" value=""><br> <input
										required="필수 입력사항" placeholder="이메일" class="find-id" value=""><br>
									<button type="button" class="jsx-2144885398 ">검색</button>
								</div>
							</div>
						</div>
						<!-- /비밀번호 찾기 modal -->

					</div>
				</div>

				<address class="jsx-1458736361">Copyright © Kiview Corp.
					All Rights Reserved.</address>
			</div>
		</div>
		<div class="jsx-2567582721 reviews"></div>
		<div id="topmost" class="jsx-2567582721"></div>
	</div>

	<!-- script -->
	<script type="text/javascript"
		src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script type="text/javascript" src="resources/js/login.js?version=1.0"></script>



</body>
</html>
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
<title>Insert title here</title>

	<link rel="stylesheet" href="resources/css/notice_write.css">
	<%@ include file = "head.jsp" %>
	
	
	<!-- 네이버 글쓰기 자바스크립 -->

<script type="text/javascript" src="resources/se2/js/service/HuskyEZCreator.js" charset="utf-8"></script>
<script type="text/javascript" src="//code.jquery.com/jquery-1.11.0.min.js"></script>




</head>
<body>

	<!-- @@ header 부분 @@ -->
	<%@ include file="header.jsp"%>

	<section class="hero-wrap hero-wrap-2"
		style="background-image: url('resources/images/bg_2.jpg');">
		<div class="overlay"></div>
		<div class="container">
			<div
				class="row no-gutters slider-text align-items-center justify-content-center">
				<div class="col-md-9 ftco-animate text-center">
					<h1 class="mb-2 bread">공지사항 글쓰기</h1>
					<p class="breadcrumbs">
						<span class="mr-2">
						<a href="index.jsp">홈 <i class="ion-ios-arrow-forward" style = "color:#fff;"></i></a>
						</span> 
						<span>키뷰안내 <i class="ion-ios-arrow-forward" style = "color:#fff;"></i></span>
						<span>&nbsp;공지사항</span>
					</p>
				</div>
			</div>
		</div>
	</section>
    
	
	<form action="">
	<div class="jsx-903324597 content">
		<div class="jsx-3810764099 board-box">
			<div class="jsx-738848916 content-box">
				<div class="jsx-738848916 card-box">
					<div class="jsx-2265392070 board-title">
						<h3 class="jsx-2265392070">
							KIVIEW 공지사항<span class="jsx-2265392070">글쓰기</span>
						</h3>
						<ol class="jsx-1271347565 ">
							<li class="jsx-1271347565">홈</li>
							<li class="jsx-1271347565">공지사항</li>
						</ol>
					</div>
					<div class="jsx-4261166144 select-wrap">
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
					</div>
					<br>
					<div class="jsx-741803006 input-box">
						<div class="jsx-639067573 input">
							<input title="제목 입력" placeholder="제목을 입력해 주세요."
								class="jsx-639067573 " value="" 
								style = "background-color:#fff; color: black;">
						</div>
					</div>
					<br>
					<div class="jsx-2303464893 editor">
						<div class="fr-box fr-basic fr-top" role="application">
							<div class="fr-toolbar fr-desktop fr-top fr-basic">
							<div class="fr-newline"></div>
							</div>
							
							<div class="fr-wrapper show-placeholder" dir="auto" style = "overflow: scroll;">
								<textarea rows = "30" cols = "150"  class = "smarteditor2" id = "smartEditor">
								</textarea>
							</div>
							
							<div class="second-toolbar">
								<span class="fr-counter" style="bottom: 1px; margin-right: 2px;">Characters
									: 0</span>
							</div>
						</div>
					</div>
					
					
					
					<div class="jsx-738848916 btn-box">
						<div class="jsx-738848916 btn-cancel">
							<button type="button" class="jsx-462732305" 
							onclick = "location.href='kiviewnotice.do'" style = "outline:none;">취소</button>
						</div>
						<div class="jsx-738848916 btn-finish">
							<button type="button" class="jsx-1357017423" 
							onclick = "location.href='kiviewnotice.do'" style = "outline:none;" id = "savebutton">작성완료</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	</form>
	
	<!-- 	<section style = "background:#fff;">
			<div class="container">
				<br><br><br><br>
			</div>
		</section> -->
	
	<%@ include file = "footer.jsp" %>

	
	<script type="text/javascript">
		var oEditors = [];
		nhn.husky.EZCreator.createInIFrame({
			oAppRef: oEditors,
			elPlaceHolder: "smartEditor",
			sSkinURI: "resources/se2/SmartEditor2.html",
			fCreator: "createSEditor2",
			htParams : {
				// 툴바 사용 여부 (true:사용/ false:사용하지 않음)
				bUseToolbar : true,      
				
				// 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
				bUseVerticalResizer : true,     
			
				// 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
				bUseModeChanger : true,
			}
		});
		//전송버튼
	    $("#savebutton").click(function(){
	        //id가 smarteditor인 textarea에 에디터에서 대입
	        obj.getById["smartEditor"].exec("UPDATE_CONTENTS_FIELD", []);
	        //폼 submit
	        $("#frm").submit();
	    })
	</script>


</body>
</html>
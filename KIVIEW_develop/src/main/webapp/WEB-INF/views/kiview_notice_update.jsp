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
<title>KVIEIW - 수정하기</title>

<link rel="stylesheet" href="resources/css/notice_write.css">
<%@ include file = "head.jsp" %>

<!-- SmartEditor2 라이브러리  -->
<script type="text/javascript" src="se2/js/HuskyEZCreator.js" charset="utf-8"></script>
<script type="text/javascript" src="//code.jquery.com/jquery-1.11.0.min.js"></script>


</head>
<body>

	<!-- header 부분 -->
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
					
					<!-- 제목/작성자/내용/분류 카테고리 넘기기  -->
					<form action="noticeUpdateRes.do" method = "get" id = "noticeWriteForm">
					<input type = "hidden" name = "notice_writer" value = "${login.member_id}">
					<input type = "hidden" name = "notice_no" value = "${noticeupdate.notice_no}">
					
					<div class="jsx-4261166144 select-wrap">
					<div class="jsx-4261166144 select-box">
						<div class="jsx-4121141969 select">
							<div class="jsx-4121141969 choice">
							  <select class="form-control-sm2" id = "selcatd" name = "cat_detail" style="cursor:pointer;">
		          					<option>분류 전체</option>
							        <option value = "${noticeupdate.cat_detail}">공지사항</option>
							  </select>
							</div>
						</div>
					</div>
					</div>
					<br>
					<div class="jsx-741803006 input-box">
						<div class="jsx-639067573 input">
							<input type = "text" id = "title" name = "notice_title" placeholder="제목을 입력해 주세요."
								class="jsx-639067573"  value = "${noticeupdate.notice_title}"
								style = "background-color:#fff; color: black;">
						</div>
					</div>
					<br>
					
					<!-- SmartEditor2  -->
					<div class="jsx-2303464893 editor">
						<div class="fr-box fr-basic fr-top" role="application">
							<div class="fr-wrapper show-placeholder" dir="auto" 
							style = "overflow: scroll;">
								<textarea name="notice_content" id="smartEditor"
								style="width:100%; height:412px;">${noticeupdate.notice_content}</textarea>
							</div>
						</div>
					</div>
					
					<!-- 글쓰기 취소/작성완료 -->
					<div class="jsx-738848916 btn-box">
						<div class="jsx-738848916 btn-cancel">
							<button type="button" class="jsx-462732305" 
							onclick = "location.href='kiviewdetail.do?notice_no=${noticeupdate.notice_no}'" style = "outline:none;">취소</button>
						</div>
						<div class="jsx-738848916 btn-finish">
							<button type="button" class="jsx-1357017423" 
							style = "outline:none;" id = "savebutton">수정완료</button>
						</div>
					</div>
					</form>
					
				</div>
			</div>
		</div>
	</div>
	
	<!-- footer 사이 띄우기  -->
	<section style = "background:#fff;">
			<div class="container">
				<br><br><br><br>
			</div>
    </section>
	
	<%@ include file = "footer.jsp" %>


</body>
</html>
	
	<!-- SmartEditor2 -->
	<script type="text/javascript">
	
	var oEditors = [];
	nhn.husky.EZCreator.createInIFrame({
		oAppRef: oEditors,
		elPlaceHolder: "smartEditor",
		sSkinURI: "se2/SmartEditor2Skin.html",
		fCreator: "createSEditor2",
		htParams : {
			// 툴바 사용 여부 (true:사용/ false:사용하지 않음)
			bUseToolbar : true,      
			
			// 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
			bUseVerticalResizer : false,     
		
			// 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
			bUseModeChanger : false
		}
	});
	$(function(){
		$("#savebutton").click(function(){
			oEditors.getById["smartEditor"].exec("UPDATE_CONTENTS_FIELD", []);
		  
			
			
		    $("#noticeWriteForm").submit();
		});  
	})
		
	</script>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8");%>
<% response.setContentType("text/html; charset=UTF-8");%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmf" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>KIVIEW &mdash;리뷰게시판</title>
<!-- 
      파일 2개 추가 다른건 건든게 없음!
      js/star.js 
      css/star.css
 -->

<%@include file="../head.jsp"%>

<link rel="stylesheet" type="text/css" href="resources/css/star.css">


<style type="text/css">

/* The Modal (background) */
.modal2 {
	display: none; /* Hidden by default */
	position: fixed; /* Stay in place */
	z-index: 1; /* Sit on top */
	left: 0;
	top: 0;
	width: 100%; /* Full width */
	height: 100%; /* Full height */
	background-color: rgb(0, 0, 0); /* Fallback color */
	background-color: rgba(0, 0, 0, 0.4); /* Black w/ opacity */
}

/* Modal Content/Box */
.modal-content2 {
	background-color: #fefefe;
	margin: 15% auto; /* 15% from the top and centered */
	margin-top: 10%;
	padding: 20px;
	height: 70%;
	border: 1px solid #888;
	width: 40%; /* Could be more or less, depending on screen size */
	overflow-y: auto; /* Enable scroll if needed */
	overflow-x: hidden;
}

.modal {
	display: none; /* Hidden by default */
	position: fixed; /* Stay in place */
	z-index: 1; /* Sit on top */
	left: 0;
	top: 0;
	width: 100%; /* Full width */
	height: 100%; /* Full height */
	background-color: rgb(0, 0, 0); /* Fallback color */
	background-color: rgba(0, 0, 0, 0.4); /* Black w/ opacity */
}

/* Modal Content/Box */
.modal-content {
	background-color: #fefefe;
	margin: 15% auto; /* 15% from the top and centered */
	margin-top: 10%;
	padding: 20px;
	height: 70%;
	border: 1px solid #888;
	width: 40%; /* Could be more or less, depending on screen size */
	overflow-y: auto; /* Enable scroll if needed */
	overflow-x: hidden;
}
/* The Close Button */
.close {
	color: #aaa;
	float: right;
	font-size: 28px;
	font-weight: bold;
	position: relative;
	left: 100%;
}

.close:hover, .close:focus {
	color: black;
	text-decoration: none;
	cursor: pointer;
}

label {
	font-weight: bold;
	color: black;
	margin-bottom: 5px;
}

input[type=text] {
	border-top: 0px;
	border-left: 0px;
	border-right: 0px;
	outline: none;
}

select {
	border: 1px solid lightgray;
	border-top: 0px;
	border-left: 0px;
	border-right: 0px;
}

form select {
	border: 1px solid lightgray;
	border-top: 0px;
	border-left: 0px;
	border-right: 0px;
	height: 40px;
	width: 120px;
}

.reviewBtn input {
	position: relative;
	left: 80%
}
</style>

<script type="text/javascript">
	$(function() {
		$("#myBtn").on("click", function() {
			//modal.style.display = "block";
			$("#myModal").show();

		})

		/* $("#myBtn2").on("click", function() {
			//modal.style.display = "block";
			$("#myModal2").show();

		}) */

		$("#modal-close").on("click", function() {
			$("#myModal").hide();
		})
		$(".close").on("click", function() {
			$("#myModal").hide();
		})
		$("#modal2-close").on("click", function() {
			$("#myModal2").hide();
		})
		$(".close").on("click", function() {
			$("#myModal2").hide();
		})
		
		
		$("#kinder_search").on("keyup", function(){
			$("#myModal").find($("input[name=kinder_addr]")).val("");
			if($(this).val().length>1){
				var search = []
				$.ajax({
					type:"post",
					url:"searchkinder.do",
					data:{"keyword":$("#kinder_search").val()},
					dataType:"json",
					success:function(data){
						$.each(data.kinder, function(key, value){
							search.push(value.name);
						})
						
					},
					error:function(){
						
					}
					
				})
				
				
				$("#kinder_search").autocomplete({
					source: search
				})
			}
		})

	})
	
function kinder_search2(){
		$.ajax({
			type:"post",
			url:"searchkinder2.do",
			data:{"kinder_name":$("#kinder_search").val()},
			dataType:"json",
			success:function(map){
				console.log(map);
				//Map으로 받은 정보 중 kinder(KinderVo) 안에 있는 addr1을 가지고 온다
				var addr = map.kinder.addr1
				if(!map || addr==null || map==null) {
					alert("해당 유치원이 없습니다.");
					
				} else {
					
					console.log(map.kinder);
					$("#myModal").find($("input[name=kinder_no]")).val(map.kinder.kinder_no);
					$("#myModal").find($("input[name=kinder_addr]")).val(map.kinder.addr1);
				}
			},
			error:function(){
				alert("명령 실행 중 오류가 발생했습니다.");
			}
			
		})
		
	}	


function update_form(review_no){
	$.ajax({
		type:"post",
		url:"reviewselect.do",
		data:{"review_no":review_no},
		dataType:"json",
		success:function(data){
			$("#myModal2").find($("input[name=review_no]")).val(data.review.review_no);
			$("#myModal2").find($("input[name=kinder_no]")).val(data.review.kinder_no);
			$("#myModal2").find($("input[name=kinder_name]")).val(data.review.kinder_name);
			$("#myModal2").find($("input[name=kinder_addr]")).val(data.review.kinder_addr);
			$("#myModal2").find($("input[name=avg_score1]:input[value="+data.review.avg_score1+"]")).prop("checked", true);
			$("#myModal2").find($("input[name=avg_score2]:input[value="+data.review.avg_score2+"]")).prop("checked", true);
			$("#myModal2").find($("input[name=avg_score3]:input[value="+data.review.avg_score3+"]")).prop("checked", true);
			$("#myModal2").find($("input[name=review_title]")).val(data.review.review_title);
			$("#myModal2").find($("textarea[name=review_content]")).val(data.review.review_content);
			
			$("#review_year_update option").each(function(i){
				if($(this).val()==data.review.review_year){
					$(this).attr("selected", "selected")
				}
				
			})
			
			$("#myModal2").find($("input[name=review_date]")).val(data.review.review_date);
			
		},
		error:function(){
			alert("실패")
		}
	
	})
	
	$("#myModal2").show(); 
	
}

function insertchk(){
		
	if($("#review_year option:selected").val()=="선택"){
			
		alert("등원시기를 선택해 주세요.")
		return false;
	}
		
	
	if($("#myModal").find("input[name=kinder_addr]").val()==''){
		alert("유치원을 검색해 주세요.")
		
		return false;
		
	}
	return true;
}

/////////////////////////// 지민like //////////////////////////////

var likeSubmit = function(review_no){
   var member_no = '${login.member_no}';
   console.log(member_no);
   
   
      $.ajax({
         url: "likeSubmit.do",
         dataType:"json",
         type: "post",
         contentType:"application/json",  
         data: JSON.stringify({
            "review_no":review_no,
            "member_no":member_no       
         }),
         success:function(data){
            
            var resultFlag = data.resultFlag;
            var resultMsg = data.resultMsg;
            if(resultFlag > 0){
                if(resultMsg == "insert"){
                  alert("좋아요 목록에 추가되었습니다.");
               }else if(resultMsg == "delete"){
                  alert("좋아요 목록에서 삭제되었습니다.");
               }
            }
            
         },
         error : function(request,status,error){
            alert('오류가 발생했습니다. 다시 시도해 주세요.');
            console.log("code = "+request.status + "message = " + request.responseText + "error  =   "+ error);
         }
      });
   }
   
function LikeBtn(){
	alert('로그인이 필요합니다.');
}

/////////////////////////// 지민like 끝 //////////////////////////////


</script>
</head>

<body id = "body">
	<!-- @@ header 부분 @@ -->
	<%@ include file="../header.jsp"%>

	<!-- @@ <h1 class = "mb-2 bread"> sub title 이 부분 우선 header에서 따로 빼놨어요!!! </h1> @@ -->
	<section class="hero-wrap hero-wrap-2"
		style="background-image: url('images/bg_2.jpg');">
		<div class="overlay"></div>
		<div class="container">
			<div
				class="row no-gutters slider-text align-items-center justify-content-center">
				<div class="col-md-9 ftco-animate text-center">
					<h1 class="mb-2 bread">리뷰 게시판</h1>
					<p class="breadcrumbs">
						<span class="mr-2"><a href="index.jsp">홈
						 <i class="ion-ios-arrow-forward"></i></a></span> 
						 <span class="mr-2"><a href="kiview_reviewboard.jsp">리뷰 게시판 
						 <i class="ion-ios-arrow-forward"></i></a></span>
					</p>
				</div>
			</div>
		</div>
	</section>
	<!-- @@ header 끝 @@ -->






	<section class="ftco-section"
		style="padding: 0; background-color: #fafafa; padding-top: 60px">
		<div class="container">
			<!-- 리뷰 게시판 작성  -->


			<!-- 검색영역 -->

			<div class="text px-4 ftco-animate"
				style="background-color: white; padding: 40px; border: 1px solid lightgray;">
				<h1>
					<label>유치원 리뷰 </label>
				</h1>
				<br>
				<!-- 검색 기능 -->
				<form action="reviewsearch.do" >
					
					<select name="type">
						<option value="kinder_name">유치원명</option>
						<option value="review_writer">작성자</option>
						

					</select> &nbsp;&nbsp; 
					<input type="text" name="keyword" placeholder="검색어를 입력하세요." style="height: 40px; width: 40%"> 
					<input class="btn btn-secondary" style="width: 10%; border-radius: 0px"
						type="submit" value="검색"> <br>
				</form>

				<br>
				
				
			</div>

			<div class="ftco-animate" style="margin: 40px; margin-bottom: 0px;">
				<c:choose>
					<c:when test="${keyword != null && keyword!=''}">
						<h2>
					<label><span style="color: #fda638">${keyword}</span>에 대한 <span style="color: #fda638">${fn:length(list)} </span>건의 리뷰가 검색되었습니다.</label>
						</h2>
					</c:when>
					<c:otherwise>
					
					</c:otherwise>
				</c:choose>
				
			</div>
			
			<!-- 리뷰리스트 영역 -->
			<div class="text px-4 ftco-animate"
				style="background-color: white; margin-top: 20px; 
				 padding: 40px; border: 1px solid lightgray;">
				<input style="position: relative; left: 35%; width: 30%"
					class="btn btn-secondary" id="myBtn" type="button" value="리뷰쓰기">
				<br>
				<br>
				
				<!-- 여기서부터 반복 -->
				<c:forEach items="${list}" var="review">
				<div class="row">
					<div class="col-md-12 course d-lg-flex ftco-animate"
						style="padding: 30px;">
						<input type="hidden" name="review_no" value="${review.review_no}">
						<div class="review"
							style="width: 25%; margin-right: 30px; border-right: 1px solid lightgray">
							<label style="font-size:20px"> ${review.kinder_name} </label>
							<p style="font-size: 14px;"> ${review.kinder_addr}</p>
							<br> <label style="font-size: 18px;">원장/교사</label><span
								style="font-size: 18px; position: relative; left: 10%"> 
								<c:forEach begin="1" end="${review.avg_score1}"> ★ </c:forEach>
								</span>
							<br> <label style="font-size: 18px;">교과/수업</label>
							<span
								style="font-size: 18px; position: relative; left: 10%">
								<c:forEach begin="1" end="${review.avg_score2}"> ★ </c:forEach>
							</span>
							<br> <label style="font-size: 18px;">시설/청결</label><span
								style="font-size: 18px; position: relative; left: 10%">
								<c:forEach begin="1" end="${review.avg_score3}"> ★ </c:forEach>
							</span>
							<br>
							<h3>
								<c:set var="score" value="${(review.avg_score1+review.avg_score2+review.avg_score3)/3 }"/>
								<label>총점</label>&nbsp;&nbsp;&nbsp;<span><fmt:formatNumber value="${score}" pattern=".00"/></span> / 5.00 <br>
							</h3>
						</div>
					

						<div style="width: 70%">
						
							<h3>
								<label>“ ${review.review_title} ”</label>
							</h3>
							<p class="subheading">
								<span id="writer"> ${review.review_writer} </span>　|　<span>${review.review_year}</span>　|　<span><fmf:formatDate value="${review.review_date}" pattern='yyyy-MM-dd HH:mm'/> </span>
							</p>
							<c:if test="${login.member_id==null }">
								<img src="resources/images/review_blur.jpg" width="90%"/>
							</c:if>
							<c:if test="${login.member_id!=null }">
							<p>${review.review_content} </p>
							</c:if>
						</div>
					</div>

					<div class="reviewBtn" style="padding: 30px; width: 100%;">
					<c:if test="${review.review_writer eq login.member_id}">
						<input class="btn btn-secondary" type="button" value="수정" onclick="update_form(${review.review_no})">
						<input class="btn btn-primary" type="button" value="삭제" onclick="location.href='reviewDelete.do?review_no=${review.review_no}'">
					</c:if>
					<c:if test="${login.member_id!=null }">
						<input class="btn btn-primary" type="button" value="좋아요" onclick="likeSubmit('${review.review_no}')">
					</c:if>
					<c:if test="${login.member_id==null }">
						<input class="btn btn-primary" type="button" value="좋아요" onclick="javascript:LikeBtn()">
					</c:if>
						<hr>
					</div>
					

				</div>
				</c:forEach>
				<!-- 여기까지 반복 -->

			</div>
		</div>
	</section>
		
		<!-- **20/02/07 리뷰게시판 section footer랑 띄우기** -->
		<section style = "background:#fafafa;">
			<div class="container">
				<br><br><br><br>
			</div>
		</section>

	<!-- 리뷰 글 작성 시 모달 페이지 -->
	<!-- Trigger/Open The Modal -->
	<!--<button id="myBtn">Open Modal</button>-->

	<!-- The Modal -->
	<div id="myModal" class="modal">

		<!-- Modal content -->
		<div class="modal-content" style="padding: 40px;">
			<span style="width: 5%;" class="close">&times;</span>

			<div>
				<h3>
					<b>유치원 리뷰쓰기</b>
				</h3>
				<h6 style="width: 100%">키뷰는 평가자의 익명성을 보장하며 평가내역에 어떠한 개인정보도 노출되지
					않음을 약속드립니다.</h6>
				<br>

				<form action="reviewInsert.do" onsubmit="return insertchk()">
					<div>
						<label>유치원 명 </label><br> 
						<input type="hidden" name="review_writer" value="${login.member_id}">
						<input type="hidden" name="kinder_no" >
						
						<input id="kinder_search" type="text" placeholder="유치원을 검색해 주세요." name="kinder_name"
							style="width: 50%" minlength="4" maxlength="20" required>
						<input type="button" onclick="kinder_search2()" value="선택"> 
						<input style="width:100%" type="text" name="kinder_addr" placeholder="유치원 주소" readonly>
							
							<br> <br> 
							<label> 등원시기 </label><br> 
							<select id="review_year" style="width: 101%; height: 35px;" name="review_year" >
							<option selected="selected">선택</option>
							<option>2020년</option>
							<option>2019년</option>
							<option>2018년</option>
							<option>2017년</option>
							<option>2016년</option>
							<option>2015년</option>
							<option>2014년</option>
							<option>2013년</option>
							<option>2012년</option>
							<option>2011년</option>
							<option>2010년</option>
							<option>2009년</option>
							<option>2008년</option>
							<option>2007년</option>
							<option>2006년</option>
							<option>2006년 이전</option>
						</select> 
						<br> <br> 
						<label>제목 </label><br> 
						<input
							type="text" placeholder="제목을 입력하세요" name="review_title"
							style="width: 101%" minlength="4" maxlength="30" required><br> <br> 
							<label>내용 </label>
							<span style="position: relative; left: 85%">0/500자</span><br>
						<textarea style="width: 100%; height: auto; resize: none;"
							placeholder="200자 이상, 500자 이하의 글자수만 작성이 가능합니다." name="review_content" minlength="200" maxlength="500" required></textarea>
						<br> <br>
					</div>
					<br>

					<div>
						<div class="star-input">
							<h4>
								<b>평점</b>
							</h4>
							<label>원장/교사</label><br>
							<div class="input">

								<input type="radio" name="avg_score1" value="1" id="p1" required>
								<label for="p1">1</label> 
								<input type="radio" name="avg_score1" value="2" id="p2" required> 
									<label for="p2">2</label> 
								<input type="radio" name="avg_score1" value="3" id="p3" required> 
								<label for="p3">3</label> 
								<input type="radio" name="avg_score1" value="4" id="p4" required> 
								<label for="p4">4</label> 
								<input type="radio" name="avg_score1" value="5" id="p5" required> 
								<label for="p5">5</label>

							</div>

							
						</div>
						<br> <br>
						<div class="star-input2">
							<label>교과/수업</label><br>
							<div class="input2">

								<input type="radio" name="avg_score2" value="1" id="p12" required>
								<label for="p12">1</label> 
								<input type="radio" name="avg_score2" value="2" id="p22" required> 
								<label for="p22">2</label>
								<input type="radio" name="avg_score2" value="3" id="p32" required>
								<label for="p32">3</label> 
								<input type="radio" name="avg_score2" value="4" id="p42" required> 
								<label for="p42">4</label>
								<input type="radio" name="avg_score2" value="5" id="p52" required>
								<label for="p52">5</label>


							</div>

							
						</div>
						<br> <br>
						<div class="star-input3">
							<label>시설/청결</label><br>
							<div class="input3">

								<input type="radio" name="avg_score3" value="1" id="p13" required>
								<label for="p13">1</label> 
								<input type="radio" name="avg_score3" value="2" id="p23" required> 
								<label for="p23">2</label>
								<input type="radio" name="avg_score3" value="3" id="p33" required>
								<label for="p33">3</label> 
								<input type="radio" name="avg_score3" value="4" id="p43" required> 
								<label for="p43">4</label>
								<input type="radio" name="avg_score3" value="5" id="p53" required>
								<label for="p53">5</label>


							</div>

							
						</div>
						<br> <br> <br>

					</div>
					<div style="position: relative; left: 38%;">
						<input class="btn btn-secondary" style="width: 15%" type="submit" value="작성">
						&nbsp;&nbsp;&nbsp;
						<input id="modal-close" class="btn btn-primary" style="width: 15%" type="button" value="취소" onclick="location.href='reviewboard.do'">
					</div>
				</form>
			</div>



		</div>




	</div>


	<!-- 리뷰 수정 시 모달 페이지  -->
	<!-- 수정 부분에서 별평점 수정 시 //////// 기존 작성 된 별 점수를 별점수로 output 하는 부분은 따로 구현이 필요 -->
	<!-- 현재 별 평점 수정 모달에서는 선택 불가 상태임. -->
	<!-- Trigger/Open The Modal -->
	<!--<button id="myBtn">Open Modal</button>-->

	<!-- The Modal -->
	<div id="myModal2" class="modal">

		<!-- Modal content -->
		<div class="modal-content" style="padding: 40px;">
			<span style="width: 5%;" class="close">&times;</span>

			<div>
				<h3>
					<b>유치원 리뷰수정</b>
				</h3>
				<h6 style="width: 100%">키뷰는 평가자의 익명성을 보장하며 평가내역에 어떠한 개인정보도 노출되지
					않음을 약속드립니다.</h6>
				<br>

				<form id="reviewUpdate" action="reviewUpdate.do" method="get">
					<input type="hidden" name="review_no" >
					<input type="hidden" name="kinder_no">
					<div>
						<label>유치원 명 </label><br> 
						<input type="hidden" name="review_writer" >
						<input type="text" placeholder="유치원명을 입력하세요." name="kinder_name" 
							style="width: 101%">
							<input type="text" name="kinder_addr">
								<br> <br> 
							<label> 등원시기 </label><br> 
							<select id="review_year_update" style="width: 101%; height: 35px;" name="review_year" disabled>
							<option selected="selected">선택</option>
							<option>2020년</option>
							<option>2019년</option>
							<option>2018년</option>
							<option>2017년</option>
							<option>2016년</option>
							<option>2015년</option>
							<option>2014년</option>
							<option>2013년</option>
							<option>2012년</option>
							<option>2011년</option>
							<option>2010년</option>
							<option>2009년</option>
							<option>2008년</option>
							<option>2007년</option>
							<option>2006년</option>
							<option>2006년 이전</option>
						</select> 
						<br> <br> 
						<label>제목 </label><br> 
						<input
							type="text" name="review_title"
							style="width: 101%" placeholder="제목을 입력하세요." minlength="4" maxlength="30" required><br> <br> 
							
							
							<label>내용 </label>
							<span style="position: relative; left: 85%">0/200자</span><br>
						<textarea style="width: 100%; height: auto; resize: none;" name="review_content" minlength="200" maxlength="1000" required></textarea>
						<br> <br>
					</div>
					<br>

					<div>
						<div class="star-input">
							<h4>
								<b>평점</b>
							</h4>
							<label>원장/교사</label><br>
							<div class="input">

								<input type="radio" name="avg_score1" value="1" id="p1" disabled>
								<label for="p1">1</label> 
								<input type="radio" name="avg_score1" value="2" id="p2" disabled> 
								<label for="p2">2</label> 
								<input type="radio" name="avg_score1" value="3" id="p3" disabled> 
								<label for="p3">3</label> 
								<input type="radio" name="avg_score1" value="4" id="p4" disabled> 
								<label for="p4">4</label> 
								<input type="radio" name="avg_score1" value="5" id="p5" disabled> 
								<label for="p5">5</label>

							</div>

						</div>
						<br> <br>
						<div class="star-input2">
							<label>교과/수업</label><br>
							<div class="input2">

								<input type="radio" name="avg_score2" value="1" id="p12" disabled>
								<label for="p12">1</label> 
								<input type="radio" name="avg_score2" value="2" id="p22" disabled> 
								<label for="p22">2</label>
								<input type="radio" name="avg_score2" value="3" id="p32" disabled>
								<label for="p32">3</label> 
								<input type="radio" name="avg_score2" value="4" id="p42" disabled> 
								<label for="p42">4</label>
								<input type="radio" name="avg_score2" value="5" id="p52" disabled>
								<label for="p52">5</label>


							</div>

						</div>
						<br> <br>
						<div class="star-input3">
							<label>시설/청결</label><br>
							<div class="input3">

								<input type="radio" name="avg_score3" value="1" id="p13" disabled>
								<label for="p13">1</label> 
								<input type="radio" name="avg_score3" value="2" id="p23" disabled> 
								<label for="p23">2</label>
								<input type="radio" name="avg_score3" value="3" id="p33" disabled>
								<label for="p33">3</label> 
								<input type="radio" name="avg_score3" value="4" id="p43" disabled> 
								<label for="p43">4</label>
								<input type="radio" name="avg_score3" value="5" id="p53" disabled>
								<label for="p53">5</label>


							</div>

						</div>
						<br> <br> <br>

					</div>
					<div style="position: relative; left: 38%;">
						<input class="btn btn-secondary" style="width: 15%" type="submit" value="수정">
						&nbsp;&nbsp;&nbsp;
						<input id="modal2-close" class="btn btn-primary" style="width: 15%" type="button" value="취소">
					</div>
				</form>
			</div>

		</div>

	</div>

	<!-- @@ footer 영역 @@ -->
	<%@ include file="../footer.jsp"%>

	


</body>
</html>
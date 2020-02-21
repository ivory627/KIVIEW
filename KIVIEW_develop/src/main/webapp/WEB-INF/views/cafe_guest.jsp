<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
   
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmf" uri="http://java.sun.com/jsp/jstl/fmt" %>



<!DOCTYPE html>
<html lang="en">
  <head>
    <title>KIVIEW &mdash; Blog</title>
    
    <%@ include file = "head.jsp" %>
<style type="text/css">
textarea {
	resize:none; 
	padding:15px;
	
}	

.underline:hover{
	text-decoration: underline;
	cursor : pointer;
}

</style>
<script type="text/javascript">
function show(cafe_board_no){
	$("#replylist"+cafe_board_no).toggle(); 
	
}


 function update(cafe_board_no){
	 $("#board"+cafe_board_no).hide();
	 $("#update"+cafe_board_no).show();
 }
 
 function cancle(cafe_board_no){
	 $("#board"+cafe_board_no).show();
	 $("#update"+cafe_board_no).cancle();
 } 

 function guest_update(cafe_board_no){

	 var form = $("#update_data"+cafe_board_no);
	 var formdata = form.serialize();
	
	 
	 $.ajax({
		type:"post",
		url:"cafeguestupdate.do",
		data:formdata,
		dataType:"json",
		success:function(data){
			
			$("#update"+cafe_board_no).hide();
			$("#board"+cafe_board_no).show();
			$("#board"+cafe_board_no).empty();
		
			$("#board"+cafe_board_no).append(
					
					"<label style='margin-left:10px;'>"+data.guest.writer+
					"&nbsp;&nbsp;|&nbsp;&nbsp;"+data.guest.regdate+"</label><br>"+  
                   
		            "<p class='content' style='margin-left:10px;'>"+data.guest.content+"</p>"+
   					"<div style='margin-right:60px; margin-top:10px; position:relative; left:80%'>"+
			               "<input type='button' value='수정' class='btn btn-secondary' onclick='update("+data.guest.cafe_board_no+")'>"+
			               "<input type='button' value='삭제' class='btn btn-primary' onclick='guest_delete("+data.guest.cafe_board_no+")'>"+ 
			               "<br><br>"+   
			              
		               	"</div>"+	               
		               
		                   
		               "<br>"
			
			
			)
			
			
			
			
			
		}, 
		
		error:function(request){
			alert(request);
		}
		 
		 
	 })
	 
 }
 
 function reply_write(cafe_board_no){
	 var form = $("#reply_data"+cafe_board_no);
	 var formdata = form.serialize();
	 
	
	 
	 $.ajax({
		 type:"post",
		 url:"cafereplywrite.do",
		 data:formdata,
		 dataType:"json",
		 success:function(data){
			 
			 $("#replylist"+data[0].cafe_board_no).show();  
			 $("#replylist"+data[0].cafe_board_no).empty();  
			 $("#replylist"+data[0].cafe_board_no).find("textarea").val("");
			 
			$.each(data, function(idx, value){
				$("#reply"+data[0].cafe_board_no).empty();
				 $("#reply"+data[0].cafe_board_no).append(
						 "댓글 <a style='color:#fda638;'>"+value.length+"</a>개"	   
						 
				 );
				 
				 
				 $("#replylist"+data[0].cafe_board_no).append(
						 "<div style=' background-color:#F2F2F2'>"+
						 "<div style='font-weight:bold; color:black'>"+value.writer+"</div>" +
		                  "<div style='color:black'>"+value.content+"</div>"+
		                  "<div style='font-size:small'>"+value.regdate+"</div>"+
		               "<hr>"
						 +"</div>"
						 
						 
				 );
			 })		  
			 
			 
			 
			
			 
		 },
		 error:function(error){
			 alert(error);
		 }
		 
	 })
 }
 
</script>
  </head>
  
  <body id = "body">
 <%@include file="cafe_modal.jsp" %> 
     <!-- @@ header 부분 @@ -->
     <%@ include file = "header.jsp" %>
    
     <!-- @@ <h1 class = "mb-2 bread"> sub title 이 부분 우선 header에서 따로 빼놨어요!!! </h1> @@ -->
    <section class="hero-wrap hero-wrap-2" style="background-image: url('images/bg_2.jpg');">
      <div class="overlay"></div>
      <div class="container">
        <div class="row no-gutters slider-text align-items-center justify-content-center">
          <div class="col-md-9 ftco-animate text-center">
            <h1 class="mb-2 bread">서울유치원 학부모 모임</h1>
            <p class="breadcrumbs"><span class="mr-2"><a href="index.jsp">Home <i class="ion-ios-arrow-forward"></i></a></span> <span>Blog <i class="ion-ios-arrow-forward"></i></span></p>
          </div>
        </div>
      </div>
    </section>
     <!-- @@ header 끝 @@ -->
     
      
      <section class="ftco-section bg-light">
         <div class="container" style="margin-left:30px; ">   
         <div class="row" style="width:1650px; overflow:auto;"> 
            <!-- 카페 메뉴 -->
            <div class="col-lg-3 sidebar ftco-animate" style="padding:25px; margin-right:30px;  background-color:white; border:1px solid lightgray;" >
                
               
               <%@include file="cafe_sidebar.jsp" %>

            </div>

            <!-- 카페 홈  --> 
            
            <div id="home" class="col-lg-8 ftco-animate" style="padding:0px;  ">   
               
               <!-- 글쓰기 영역 -->
               <div class="col-lg-8 ftco-animate" style="padding:20px; width:100%;  background-color:white; border:1px solid lightgray;"> 
               		<h2 class="mb-3">
                 	 <b>${menu.name }</b>
              		 </h2>

  					
               		<label>${login.member_id } 님</label><br>
               		
	               	<form action="cafeguestwrite.do">
	               		<input type="hidden" name="cafe_no" value="${cafe_list[0].cafe_no }">
	               		<input type="hidden" name="title" value="방명록">               		
	               		<input type="hidden" name="cafe_menu_no" value=${menu.cafe_menu_no }>
	               		<input type="hidden" name="writer" value="${login.member_id }">
	                  	<textarea style="resize:none" cols="80" rows="7" name="content" placeholder="글을 입력해주세요." minlength="4" maxlength="1000" required></textarea>  
	                  	 
		               <br>
		               <br>
		               <div align="center">
			               <input type="submit" value="작 성" class="btn btn-secondary" style="width:20%">
			               
			              		  
		                
		               </div>
	               	</form>
               </div>
               
               <!-- 방명록영역 -->
               <c:choose>
               	<c:when test="${empty guest }">
               	
               	</c:when>
               	<c:otherwise>
               		<c:forEach var="guest" items="${guest }">
               	
                <div class="col-lg-8 ftco-animate" style="padding:20px; margin-top:20px; width:100%;  background-color:white; border:1px solid lightgray;"> 
                  	
                  	<!-- 본문영역 -->
                  	<div id="board${guest.cafe_board_no }">   
		               <label style="margin-left:10px;">${guest.writer }&nbsp;&nbsp;|&nbsp;&nbsp;<fmf:formatDate value='${guest.regdate}' pattern='yyyy-MM-dd'/></label><br>  
		                    
		               <p class="content" style="margin-left:10px;">${guest.content }</p>
      					<div style="margin-right:60px; margin-top:10px; position:relative; left:80%">
			               <input type="button" value="수정" class="btn btn-secondary" onclick="update(${guest.cafe_board_no});">
			               <input type="button" value="삭제" class="btn btn-primary" onclick='guest_delete(${guest.cafe_board_no})'>  
			               <br><br>   
			              
		               	</div> 		               
		              
		                   
		               <br> 
	            
		               
               		</div>
               		
               		<!-- 본문수정 -->
               		<div id="update${guest.cafe_board_no }" style="display:none"> 
               			<form id="update_data${guest.cafe_board_no }" action="cafeguestupdate.do">
               				<input type="hidden" name="cafe_board_no" value="${guest.cafe_board_no }"> 
               				<input type="hidden" name="title" value="방명록">  
			               <label style="margin-left:10px;">${guest.writer }&nbsp;&nbsp;|&nbsp;&nbsp;<fmf:formatDate value='${guest.regdate}' pattern='yyyy-MM-dd'/></label><br>  
			                    
			       			<textarea style="resize:none" cols="80" rows="7" name="content" minlength="4" maxlength="500">${guest.content }</textarea> 
	      					<div style="margin-right:60px; margin-top:10px; position:relative; left:80%">
				               <input type="button" value="수정" class="btn btn-secondary" onclick="guest_update(${guest.cafe_board_no });">
				               <input type="button" value="취소" class="btn btn-primary" onclick="cancle(${guest.cafe_board_no })"> 
				               <br><br>   
				              
			               	</div> 		               
		              
		               </form>     
		               <br> 
	            
		               
               		</div>
               		
               		 
               		
               		
               		
               		
               		<!-- 댓글영역 -->
               		<c:set var="count" value="0"/>
               		<h5 id="reply${guest.cafe_board_no}" onclick="show(${guest.cafe_board_no})" class="underline">댓글 <a style="color:#fda638;" >${count }</a>개</h5>   
               		<div id="replylist${guest.cafe_board_no}">
	               		<c:forEach var="reply" items="${reply }">
	               			<c:if test="${guest.cafe_board_no==reply.cafe_board_no }">
	               				<c:set var="count" value="${count+1 }"/>
	               			</c:if> 
	               		
	               			
	               			<c:if test="${guest.cafe_board_no==reply.cafe_board_no }">
			               		<div style=" background-color:#F2F2F2">
			               			
					                 
					               
					                  <div style="font-weight:bold; color:black">${reply.writer }</div> 
					                  <div style="color:black">${reply.content }</div> 
					                  <div style="font-size:small">${reply.regdate }</div>
					               <hr>          
				               
			               		</div>
		               		</c:if>
	               		</c:forEach>
               		</div>
               		
               		<!-- 댓글 작성 -->
	               <div style="width:80%; border:0px solid lightgray"> 
	               	<br>
		               <form id="reply_data${guest.cafe_board_no }">
		               		<input type="hidden" name="cafe_board_no" value="${guest.cafe_board_no }">
		               		<input type="hidden" name="writer" value="${login.member_id}">
			               <label style="font-weight:bold; color:black">${login.member_id }</label> 
			               <br>
			                  <textarea style="resize:none; padding:10px;" name="content" cols="80" rows="3" minlength="4" maxlength="100" ></textarea>
			                    
			                  <input style="display:inline; position:relative; left:112%"  type="button" class="btn btn-primary"  
			                  value="등록" onclick="reply_write(${guest.cafe_board_no})">          
			                   
		               </form>
	               </div>
               
                
               </div> 
               
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
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
	

</style>
<script type="text/javascript">


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
	                  	<textarea style="padding:15px;" cols="80" rows="7" name="content" placeholder="글을 입력해주세요." minlength="4" maxlength="1000" required></textarea>  
	                  	 
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
                  	<div id="board"> 
		               <label style="margin-left:10px;">${guest.writer }&nbsp;&nbsp;|&nbsp;&nbsp;<fmf:formatDate value='${guest.regdate}' pattern='yyyy-MM-dd'/></label><br>  
		                    <textarea style="padding:15px;" cols="80" rows="7" name="content" minlength="4" maxlength="500" readonly>${guest.content }</textarea> 
		                  
		               <br> 
	            
		               <div id="board_button" style="margin-right:60px; margin-top:10px; position:relative; left:80%">
			               <input type="button" value="수정" class="btn btn-secondary" onclick="">
			               <input type="button" value="삭제" class="btn btn-primary" style="width:10%" onclick=""> 
			               
		               </div> 
               		</div>
               		<!-- 댓글영역 -->
               		<div id="replylist" style="width:100%;"> 
		               <h5>댓글 <a style="color:#fda638">149</a>개</h5> 
		               <hr>
		                  <div style="font-weight:bold; color:black">user2</div> 
		                  <div style="color:black">반갑습니다 ㅎㅎ</div>
		                  <div style="font-size:small">2019-12-14</div>
		               <hr>          
	               
               		</div>
               		
               		<!-- 댓글 작성 -->
	               <div id="reply" style="width:80%; border:0px solid lightgray"> 
		               <form action="#">
			               <label style="font-weight:bold; color:black">user1</label> 
			               <br>
			                  <input type="text" size="70" placeholder="상대방을 향한 욕설, 음담패설은 자제해주세요.">
			                  <input type="submit" class="btn btn-primary" value="등록">
			                  <div>0/100</div> 
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
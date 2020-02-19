<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
   
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<!DOCTYPE html>
<html lang="en">
  <head>
    <title>KIVIEW &mdash; Blog</title>
    
    <%@ include file = "head.jsp" %>
<style type="text/css">
	

</style>
<script type="text/javascript">
$(function(){
	alert('${cafe_list[0].cafe_no}');
})

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
         <div class="row" style="width:1400px; overflow:auto;"> 
            <!-- 카페 메뉴 -->
            <div class="col-lg-3 sidebar ftco-animate" style="padding:25px; margin-right:30px;  background-color:white; border:1px solid lightgray;" >
                
               
               <%@include file="cafe_sidebar.jsp" %>

            </div>

            <!-- 카페 홈  -->
            
            <div id="home" class="col-lg-8 ftco-animate" style="padding:25px; margin-left:0px; background-color:white; border:1px solid lightgray; "> 
               <h2 class="mb-3">
                  <b>${cafe_menu_name }</b>
               </h2>
                
               
               <table class="table table" style="text-align:center">
                  <col width="10%"><col width="10%"><col width="50%"><col width="20%"><col width="10%">
                  <tr>
                  <th>번 호</th>
                  <th>작성자</th>
                  <th>제 목</th>
                  <th>작성일</th>
                  <th>조회수</th>
                  </tr>
                  <c:choose>
                  <c:when test="${fn:length(Blist) == 0 }" >
                  <tr>
                     <td  colspan="5" >
                        <p>작성 된 게시글이 없습니다.</p>
                     </td>
                  </tr>                  
                  </c:when>
                  
                  <c:otherwise>
                  <c:forEach var="boardlist" items="${Blist }">
                  <tr>
                  <td>${boardlist.cafe_board_no }</td>
                  <td>${boardlist.writer }</td>
                  <td> 
                  <a href="cafeboarddetail.do?cafe_board_no=${boardlist.cafe_board_no }&cafe_menu_no=${cafe_list[1].cafe_menu_no}&cafe_no=${cafe_list[0].cafe_no }" style="font-size:small; text-align:left">
                  <c:if test="${fn:length(boardlist.category) != 0 && boardlist.category ne 'null' }">
                  [ ${boardlist.category } ] ${boardlist.title } 
                  </c:if> 
                  
                  ${boardlist.title }
                  
                  [1] 댓글 추가하자!
                  
                  </a>
                  </td>
                  <td>${boardlist.regdate }</td>
                  <td>${boardlist.hit }</td> 
                  </tr>
                  </c:forEach>
                  </c:otherwise>
                  </c:choose>
                  
                  
                  
               </table> 
               
               <div align=right>
               <input type="button" value="글작성" class="btn btn-secondary" onclick="location.href='cafeboardwriteform.do?cafe_menu_no=${cafe_list[1].cafe_menu_no}&cafe_no=${cafe_list[0].cafe_no }'">
               </div>
               
               <div align=center>
               <form>
               <select style="height:30px"><option>제 목</option><option>작성자</option></select>
               <input style="height:30px" type="text" name="keyword">
               <input style="height:30px;border-top-width: 0px;" type="submit" value="검색"> 
               </form>
               </div>
               <br>
               <br>
            </div>
            

            

         </div>


         
         


      </div>
      </section>

      
   <!-- @@ footer 영역 @@ -->
   <%@ include file="footer.jsp"%>
   
   


    
  </body>
</html>
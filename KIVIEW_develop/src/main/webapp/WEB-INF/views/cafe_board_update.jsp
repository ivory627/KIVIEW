<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
   
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 


<!DOCTYPE html>
<html lang="en">
  <head>
    <title>KIVIEW &mdash; Blog</title>
    
    <%@ include file = "head.jsp" %>


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
            <h1 class="mb-2 bread">Our Blog</h1>
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

            
            
            <div id="home" class="col-lg-8 ftco-animate" style="padding:25px; margin-left:0px; background-color:white; border:1px solid lightgray; "> 
               <h2 class="mb-3"><b># 글작성</b></h2>
               <hr>
                
               <form action="cafeboardupdate.do">
               <input type="hidden" name="cafe_no" value="${cafe_list[0].cafe_no }">
               <input type="hidden" name="cafe_board_no" value="${cafeboardvo.cafe_board_no}">
               <input type="hidden" name="cafe_menu_no" value="${cafe_menu_no }">
               <label>게시판 말머리</label>
                  ${cafeboardvo.category } 이것도 추후에 건들예쩡&nbsp;&nbsp;&nbsp; || ${cafeboardvo.hit }
                  <br>
               <label>제 목</label><br>
                  <input type="text" value="${cafeboardvo.title }" name="title" size="70">
                  <br><br>
               <label>내 용</label><br>
                  <textarea cols="90" rows="10" name="content" >${cafeboardvo.content }</textarea>  
                  
               <br>
               <br>
               <div align="center">
               <input type="submit" value="수 정" class="btn btn-secondary" style="width:20%">
               <input type="button" value="취 소" class="btn btn-primary" style="width:20%" onclick="location.href='cafeboarddetail.do?cafe_no=${cafe_no}&cafe_menu_no=${cafe_menu_no }&cafe_board_no=${cafeboardvo.cafe_board_no }'"> 
               </div>
               </form>
               
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
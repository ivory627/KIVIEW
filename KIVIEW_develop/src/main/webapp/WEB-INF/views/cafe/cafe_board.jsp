<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
   
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmf" uri="http://java.sun.com/jsp/jstl/fmt"%> 

<!DOCTYPE html>
<html lang="en">
  <head>
    <title>KIVIEW &mdash; Blog</title>
    
    <%@ include file = "../head.jsp" %>

  </head>
  
  <body id = "body">
 <%@include file="cafe_modal.jsp" %> 
     <!-- @@ header 부분 @@ -->
     <%@ include file = "../header.jsp" %>
    
     <!-- @@ <h1 class = "mb-2 bread"> sub title 이 부분 우선 header에서 따로 빼놨어요!!! </h1> @@ -->
    <section class="hero-wrap hero-wrap-2" style="background-image: url('images/bg_2.jpg');">
      <div class="overlay"></div>
      <div class="container">
        <div class="row no-gutters slider-text align-items-center justify-content-center">
          <div class="col-md-9 ftco-animate text-center">
            <h1 class="mb-2 bread">카페 게시판</h1>
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
               <div id="seachbeforetable">
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
                        
                           <a href="boarddetail.do?cafe_no=${cafe_list[0].cafe_no }&cafe_board_no=${boardlist.cafe_board_no }&cafe_menu_no=${cafe_menu_no}" style="font-size:small; text-align:left">
                           <c:if test="${fn:length(boardlist.category) != 0 && boardlist.category ne 'null' }">
                              [ ${boardlist.category } ] 
                           </c:if>
                           ${boardlist.title }   
                           <c:set var="commentcount" value="0"/> 
                           <c:forEach var="rlist" items="${cafe_list[4] }">
                              <c:if test="${rlist.cafe_board_no eq boardlist.cafe_board_no}">
                                <c:set var="commentcount" value="${commentcount+1}"/>                              
                             </c:if>   
                           </c:forEach>
                                
                                  [${commentcount }]     
                           </a>
                        </td>
                        <td><fmf:formatDate value='${boardlist.regdate}' pattern='yyyy-MM-dd'/></td>
                        <td>${boardlist.hit }</td> 
                     </tr>
                  </c:forEach>
                  </c:otherwise>
                  </c:choose>        
      
               </table>
              <!-- 글목록 페이징.  -->
              
<!-- ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ게시글 목록 페이징.....ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ -->             

             
                           
              <c:if test="${Blistpaging.totallistcount ne '0' }">  
                <div class="col-md-12" style = "margin-top:2%;margin-bottom:2%">
                    <ul class="pagination pull-right">
                    <li><a href="javascript:PageMove(1)">맨앞으로</a></li>
                    <c:if test="${Blistpaging.pagepre eq true }">
                    <li class="active"><a href="javascript:PageMove(${Blistpaging.curpagenum-1 })">앞으로</a></li>
                    </c:if>
                          <c:forEach var="i" begin="1" end="10" >
                              <c:choose>
                                  <c:when test="${i eq Blistpaging.curpagenum }">
                                    <li class="active"><a href="javascript:PageMove(${i})">${i}</a></li>
                                  </c:when>
                                  <c:otherwise>
                                    <li><a href="javascript:PageMove(${i})">${i}</a></li>
                                  </c:otherwise>
                              </c:choose>
                          </c:forEach>
                    <c:if test="${Blistpaging.pagenext eq true }">    
                    <li class="active"><a href="javascript:PageMove(${Blistpaging.curpagenum+1 })">뒤로</a></li>
                    </c:if>  
                    <li><a href="javascript:PageMove(${Blistpaging.totalpagecount})">맨뒤로</a></li>
                  </ul>    
                    
               
                  
              </div>
              </c:if>
             

 </div>                     
<!-- ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ게시글 목록 페이징 끝ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ -->               
              
               
             
              <div id="searchaftertable">
                    <table id="searchlisttable"  class="table table" style="text-align:center" style="display:none;">                                               
                    </table>
              </div>
                           
               
               <c:if test="${ cafe_list[0].admin eq login.member_id}">
                  <div align=right>
                     <input type="button"  value="글작성" class="btn btn-secondary" onclick="location.href='boardwrite.do?cafe_no=${cafe_list[0].cafe_no}&cafe_menu_no=${cafe_menu_no }'">
                  </div>
               </c:if>                      
              
                              
               <div align=center>
 
               <form id="ajaxform" action="">
                     <input id="cafe_menu_no" type="hidden" name="cafe_menu_no" value="${cafe_menu_no}" />                 
                  <select id="searchopt" name="searchoption" style="height:30px">
                       <option value="title">제목</option>                   
                     <option value="writer">작성자</option>
                    
                     <option value="content">내용</option>
                     <option value="title+content">제목+내용</option>                     
                  </select>                  
                  <input id="keyword" style="height:30px" type="text" name="keyword"/>
                   <input style="height:30px; border-top-width:0px;" type="button" onclick="ajaxboardsearch();" value="검색"> 
                
               </form>
               </div>
               <br>
               <br>
<!-- ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ검색 결과 페이징 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ -->      
<c:choose>
             
              <c:when test="${ rpage.listCount > 10 }">                 
              <c:if test="${rpage.listCount ne '0' }">  
                <div class="col-md-12" style = "margin-top:2%;margin-bottom:2%">
                    <ul class="pagination pull-right">
                    <li><a href="javascript:PageMove(1)">맨앞으로</a></li>
                    <c:if test="${page.preve eq true }">
                    <li class="active"><a href="javascript:PageMove(${rpage.currentPage-1 })">앞으로</a></li>
                    </c:if>
                          <c:forEach var="i" begin="${rpage.startPage }" end="${rpage.endPage }" >
                              <c:choose>
                                  <c:when test="${i eq rpage.currentPage }">
                                    <li class="active"><a href="javascript:PageMove(${i})">${i}</a></li>
                                  </c:when>
                                  <c:otherwise>
                                    <li><a href="javascript:PageMove(${i})">${i}</a></li>
                                  </c:otherwise>
                              </c:choose>
                          </c:forEach>
                    <c:if test="${rpage.next eq true }">    
                    <li class="active"><a href="javascript:PageMove(${rpage.currentPage+1 })">뒤로</a></li>
                    </c:if>  
                    <li><a href="javascript:PageMove(${rpage.allPage})">맨뒤로</a></li>
                  </ul>    
                    
               
                  
              </div>
              </c:if>
              </c:when>
</c:choose>               
<!-- ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ검색 결과 페이징 끝ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ -->               
               
               
               
            </div><!-- 카페 홈 div 태그 끝 -->
         </div><!-- 카페 row div 태그 끝 -->
      </div><!-- 컨테이너 div 태그 끝 -->
      </section>


      
   <!-- @@ footer 영역 @@ -->
   <%@ include file="../footer.jsp"%>

  </body>
</html>

<script type="text/javascript">

function PageMove(page){   
   var count ='<c:out value="${count}"/>';
   var curpagenum ='<c:out value="${curpagenum}"/>';
   var boardno ='<c:out value="${bvo.boardno}"/>';      
       location.href = "controller.do?command=boarddetail&rcurpagenum="+page+"&categoryname="+categoryname+"&count="+count+"&curpagenum="+curpagenum+"&boardno="+boardno;
}

function ajaxboardsearch(){
   var cafe_menu_no = $("#cafe_menu_no").val();
   var searchoption = $("#searchopt").val();
   var keyword = $("#keyword").val();
   console.log("cafe_menu_no   :   "+cafe_menu_no);
   console.log("searchoption   :   "+searchoption);
   console.log("keyword   :   "+keyword);
   
   $.ajax({
       url :"ajaxboardsearchlist.do",
       type : "post",
       dataType:"json",       
       data : JSON.stringify({
          "cafe_menu_no":   cafe_menu_no,
          "searchoption"   :   searchoption,
          "keyword"   :   keyword          
       }),
       contentType:"application/json",
       success : function(data){
         alert("성공!");
         
         $("#searchlisttable").empty();
         
         if(data.slist.length==0){
            $("#seachbeforetable").hide();         
            
            var slistnodata = '';
            
            slistnodata +=
                  "<col widtj='10%'><col width='10%'><col width='50%'><col width='20%'><col width='10%'>"+
                  "<tr><th>번 호</th><th>작성자</th><th>제 목</th><th>작성일</th><th>조회수</th></tr>"+
                  "<tr>"+"<td colspan='5' ><p>검색된 결과가 없습니다.</p></td>"+"</tr>";
            
            console.log(slistnodata);            
            $("#searchlisttable").append(slistnodata); 
            
            
         }else{
        	 alert('${cafe_list[0].cafe_no}')  
            $("#seachbeforetable").hide();
            var tablecolsetting = "<col widtj='10%'><col width='10%'><col width='50%'><col width='20%'><col width='10%'>"+
                              "<tr><th>번 호</th><th>작성자</th><th>제 목</th><th>작성일</th><th>조회수</th></tr>";
            $("#searchlisttable").append(tablecolsetting);
            
            $.each(data.slist,function(key,value){
               var category = value.category;               
               var title = value.title;
               
               console.log("category   :   "+category);               
               function titleinto(category,title){
                  if(category == null){
                     return title;
                  }else{
                     return "["+category+"]"+title;
                  }
               }
               var slistdata = '';               
               slistdata += 
                                 
                  "<tr><td>"+value.cafe_board_no+"</td>"+
                  "<td>"+value.writer+"</1td>"+
                  "<td><a href='boarddetail.do?cafe_no=${cafe_list[0].cafe_no }&cafe_board_no="+value.cafe_board_no+"&cafe_menu_no="+value.cafe_menu_no+"' style='font-size:small; text-align:left;'>"+   
                  titleinto(category,title)+"["+value.replycount+"]</a></td><td>"+changeDate(value.regdate)+"</td>"+
                  "<td>"+value.hit+"</td></tr>";
                  
                  
                  console.log(tablecolsetting+slistdata);
                  $("#searchlisttable").append(slistdata);   

            })
         }
         
          
       },
       error : function(request,status,error){
          alert("실패");
          alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);

       }
         
      
      
   });

}

function changeDate(date){
    date = new Date(parseInt(date));
    year = date.getFullYear();
    month = date.getMonth();
    day = date.getDate();
    hour = date.getHours();
    minute = date.getMinutes();
    second = date.getSeconds();
    strDate = year+"-"+month+"-"+day+" "+hour+":"+minute+":"+second;
    return strDate;
}

</script>
<style type="text/css">



   
</style>
   
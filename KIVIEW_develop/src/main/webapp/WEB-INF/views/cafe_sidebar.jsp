<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
$(function(){
   $("b").eq(0).hover(function(){
      $(this).css("text-decoration","underline")
   }, function(){
      $(this).css("text-decoration","none")
   })
})



</script>
<script src="https://kit.fontawesome.com/5c51969fc5.js" crossorigin="anonymous"></script>
<style type="text/css">
section ul{
 padding:0px;
}
section ul li{
   list-style:none;
   text-decoration:none;
}

a:link { 
color: black; text-decoration: none;
}
a:visited {
 color: black; text-decoration: none;
 }
a:hover {
 color: black; text-decoration: none;
 }

section li:hover{
   text-decoration:underline;
   
} 

section a:first-child {
   color:#212529;
}

input[type=text] {
   border-top:0px;
   border-left:0px;
   border-right:0px;
       outline: none;
   
}

label {
   color:black;
   font-weight:bold;
}

section ul{
 padding:0px;
}
section ul li{
   list-style:none;
   text-decoration:none;
   cursor:pointer;
}


#home th, td{
   text-align:center;
   color:black;
}

td a{
   text-align:left;
}

#home table{
   border-top:2px solid black;
   border-bottom:1px solid
}

textarea{
 border-radius:3%;
}



</style>
</head>
<body id = "body">

<div class="sidebar-box ftco-animate" style="margin-right:30px; border-bottom:1px solid lightgray; background-color:white;">
                  
                  <br> 
                  <span class="glyphicon glyphicon-list-alt" aria-hidden="true"></span>
                  <h3 style="cursor:pointer"><b onclick="location.href='cafe_detail.jsp'">${cafe_list[0].title }</b></h3>
                  
                  
                  <table style="border:0px" > 
                  <a style="color:blue"><span class="icon-person"></span>${cafe_list[0].admin }</a>
                  <tr><th>회원수</th><td>${fn:length(cafe_list[2]) }</td></tr>    
                  <tr><th>게시글</th><td>2341개</td></tr>
                  </table>
                  <a href="cafeconfig.do?cafe_no=${cafe_list[0].cafe_no }" style="color:blue"># 카페 관리</a>
                  <br><br>
<!-- ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ -->                  
                  <c:choose>
                  <c:when test="${caferegyn eq 'null'}">
                  <p class="mb-0" align=center><a href="cafejoinform.do?cafe_no=${cafe_list[0].cafe_no }" class="btn btn-secondary" style="width:100%; border-radius:0px;" >카페 가입하기 </a></p>
                  </c:when>
                  <c:otherwise>
                  <p class="mb-0" align=center><a href="cafejoinform.do?cafe_no=${cafe_list[0].cafe_no }" class="btn btn-secondary" style="width:100%; border-radius:0px;" >채팅방 입장하기 </a></p>
                  </c:otherwise>     
                  </c:choose>
<!--ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ  -->                       
               </div>
               
               <div class="sidebar-box ftco-animate">         
                 
                  <h3><b>게시판</b></h3>       
                         
                    
                  <c:if test="${!empty cafe_list[1] }">
                  <ul id="channel">
                  <c:forEach var="menu" items="${cafe_list[1] }">
                      <c:choose>
                               
                     <c:when test="${menu.concept eq 'table' }">                          
                           <li><i class="fas fa-clipboard-list"></i><a href="#"> ${menu.name}</a></li>                        
                     </c:when>
                     <c:otherwise>
                           <li><i class="fas fa-clipboard-check"></i><a href="#"> ${menu.name}</a></li>        
                     </c:otherwise>
                    </c:choose>   
                  </c:forEach>
                 </ul>  
                  </c:if>   
                     
                     
                     

               </div>
</body>
</html>
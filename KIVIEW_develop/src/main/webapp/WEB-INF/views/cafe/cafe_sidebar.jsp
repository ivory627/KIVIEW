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

function sign_ready(){
	alert('${login.member_id}님은 승인 대기중이십니다.');
}

function ataglink(cafe_no,cafe_menu_no){
	alert('카페를 이용 할 수 없습니다.');
}

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

<div class="sidebar-box ftco-animate" style="margin-right:30px; background-color:white; padding-left:15px" > 
                  
                  <br> 
                  <span class="glyphicon glyphicon-list-alt" aria-hidden="true"></span>
                  <h3 style="cursor:pointer"><b onclick="location.href='cafedetail.do?cafe_no=${cafe_list[0].cafe_no }&member_no=${login.member_no }'">${cafe_list[0].title }</b></h3>
                  <hr>
                  
                  <table style="border:0px" > 
                  <a style="color:blue"><span class="icon-person"></span>${cafe_list[0].admin }</a>
                  <tr><th>회원수</th><td>${fn:length(cafe_list[2]) }명</td></tr>    
                  <tr><th>게시글</th><td>${fn:length(cafe_list[3]) }개</td></tr>
                  </table>
                  <c:if test="${!empty cafe_list[1] && permit eq 'true'}"> 
                  <a href="cafeconfig.do?cafe_no=${cafe_list[0].cafe_no }&memeberno=${login.member_no}" style="color:blue"># 카페 관리</a>
                  </c:if>
                  <br><br>
<!-- ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ-->
           		
               
              	<div>
              		<c:set var="count" value="0"/>
               			<c:forEach var="member" items="${cafe_list[2] }">
		
               				<c:if test="${login.member_no == member.member_no }">
               					<c:set var="count" value="${count+1 }"/>
               					<c:if test="${count>0 }">
               							<c:if test="${member.signyn eq 'Y' || member.signyn eq 'A' }">
											<p class="mb-0" align=center><a href="cafejoinform.do?cafe_no=${cafe_list[0].cafe_no }" 
											class="btn btn-secondary" style="width:100%; border-radius:0px;" >채팅방 입장하기</a></p>
            							</c:if>
            						
	            						<c:if test="${member.signyn eq 'N' }">
	            							<p class="mb-0" align=center><a onclick="sign_ready()" class="btn btn-secondary" 
	            							style="width:100%; border-radius:0px;" >가입 승인 대기 </a></p>
	            						</c:if>
               					</c:if>
		
            				</c:if>
            			</c:forEach> 	
            			
            				
            				
            				<c:if test="${count==0 }">
               							<p class="mb-0" align=center><a href="cafejoinform.do?cafe_no=${cafe_list[0].cafe_no }&member_no=${login.member_no }" 
               							class="btn btn-secondary" style="width:100%; border-radius:0px;" >카페 가입하기 </a></p>
               				</c:if>
            				
            				
            				
							
							
            						
            				  
							
            				
            				
            			
            			
				
<!--ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ  -->                       
               
               
               
                 <br>
                  <h3><b>게시판</b></h3>
                  <hr>
                        
                  <!--가입여부-->
           		<c:set var="sign" value="0"/>
           		<c:set var="permit" value="false"/>  
           		<c:forEach var="member" items="${cafe_list[2] }">
		
               				<c:if test="${login.member_no == member.member_no }">
               					<c:set var="sign" value="${sign+1 }"/>
	               					<c:if test="${sign>0 }"> 
	               						
	               						<c:if test="${member.signyn eq 'Y' || member.signyn eq 'A' }">
	               							<c:set var="permit" value="true"/>
	               						</c:if>
	               					</c:if> 
            				</c:if>
            				
            				
            	</c:forEach> 
           		   
                     
                         
                       
                  <c:if test="${!empty cafe_list[1] && permit eq 'true'}">   
                  <ul id="channel">
                  <c:forEach var="menu" items="${cafe_list[1] }">
                      <c:choose>
                     <c:when test="${menu.concept eq 'table' }">                       
                           <li><i class="fas fa-clipboard-list"></i><a href="cafeboardlist.do?cafe_no=${cafe_list[0].cafe_no }&cafe_menu_no=${menu.cafe_menu_no }&curpagenum=1"> ${menu.name}</a></li>                        
                     </c:when>
                     <c:otherwise>
                           <li><i class="fas fa-clipboard-check"></i><a href="cafeguestlist.do?cafe_no=${cafe_list[0].cafe_no }&cafe_menu_no=${menu.cafe_menu_no }"> ${menu.name}</a></li>        
                     </c:otherwise>
                    </c:choose>   
                  </c:forEach>
                 </ul>  
                  </c:if> 
                  <c:if test="${!empty cafe_list[1] && permit eq 'false'}">   
                   <ul id="channel">
                  <c:forEach var="menu" items="${cafe_list[1] }">
                      <c:choose>
                     <c:when test="${menu.concept eq 'table' }">                       
                           <li><i class="fas fa-clipboard-list"></i>
	                           <a onclick="ataglink(${cafe_list[0].cafe_no },${menu.cafe_menu_no });"> 
	                           		${menu.name}
	                           </a>
                           </li>                        
                     </c:when>
                     <c:otherwise>
                           <li><i class="fas fa-clipboard-check"></i>
	                            <a onclick="ataglink(${cafe_list[0].cafe_no },${menu.cafe_menu_no });"> 
	                           		${menu.name}
	                           </a>                       
                           </li>        
                     </c:otherwise>
                    </c:choose>   
                  </c:forEach>
                 </ul>  
                  
                  </c:if>
                     
                     
                     

               </div>
	</div>
</body>
</html>
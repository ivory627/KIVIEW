<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">

.chat_member{
	padding:15px;
	overflow:scroll; 
	width:30%; 
	height:100%; 
	border:1px solid lightgray; 
	overflow:scroll;
	margin:0px; 
	font-weight:bold;
	color:black;
}

li{
	list-style:none;
}

.chat{
	width:70%; height:100%";
}


.chat_top{
	width:100%; height:8%; 
	margin:0px;
	
	background-color:#fda638; 
	text-align: center; 
	vertical-align:middle;
}

.chat_body{
	background-color:#9BDAF2;
	width:100%; height:82%; 
}

.chat_input{
border:1px solid lightgray;
padding:15px;
height:10%
	
}
</style>
<script type="text/javascript">
window.onload=function(){
	window.document.body.scroll="auto";
	
}

</script>

</head>
<body onresize="parent.resizeTo(900,680)" onload="parent.resizeTo(900,680)">
<%@ include file="../head.jsp" %>

<!-- 카페 홈  --> 
            
            <div class="row" style="width:900px; height:680px; margin-left:0px; " >   
               
               <!-- 채팅방 영역 -->
               <div class="chat" > 
               		<div class="chat_top">
               			<label style="padding-top:10px; color:white; font-weight:bold;  ">카페 채팅방</label> 
               		</div>
               		
               		<div class="chat_body">
               		
  					
               		
               		</div>
	               
	          <div class="chat_input">
	               <form action="#">
	                  	<input style="border-radius:5px;" placeholder="메시지를 입력하세요." type="text" size="50" name="text">  
	                   	<input style="width:20%; border-radius:5px" type="submit" value="작 성" class="btn btn-secondary">
			       </form>

		      </div>
	               	
               </div>
               
               <!-- 채팅방 영역 -->
               <div class="chat_member">  
               		<label>대화멤버 0명</label> 
               		<hr style="width:100%; padding-left:0px">
               		<ul>
               			<li>${login.member_id }</li>
               		</ul>
               </div>
               
            </div>  
               
<script src="resources/js/main.kiview.js"></script>
	<!-- <script src="resources/js/jquery.min.js"></script>
	<script src="resources/js/jquery-migrate-3.0.1.min.js"></script> -->
	<script src="resources/js/popper.min.js"></script>
	<script src="resources/js/bootstrap.min.js"></script>
	<script src="resources/js/jquery.easing.1.3.js"></script>
	<script src="resources/js/jquery.waypoints.min.js"></script>
	<script src="resources/js/jquery.stellar.min.js"></script>
	<script src="resources/js/owl.carousel.min.js"></script>
	<script src="resources/js/jquery.magnific-popup.min.js"></script>
	<script src="resources/js/aos.js"></script>
	<script src="resources/js/jquery.animateNumber.min.js"></script>
	<script src="resources/js/scrollax.min.js"></script>
	<script src="resources/js/main.js"></script>               


</body>
</html>
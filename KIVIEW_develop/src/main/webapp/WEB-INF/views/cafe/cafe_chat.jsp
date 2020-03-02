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

.msgbox{
	background-color:white;
	border:1px solid lightgray;
	margin:15px;
	padding:15px;
	border-radius:5px;
}

label{
	color:black;
	font-weight:bold;
}
</style>
<script src="http://localhost:82/socket.io/socket.io.js"></script>
<script src="https://code.jquery.com/jquery-1.11.1.js"></script>

<script type="text/javascript">
$(function(){
	window.document.body.scroll="auto";
	var socket = io("http://localhost:82");

	$("#msg").on("keydown",function(key){
		if(key.keyCode=='13'){
			$("#msg_submit").click();
		}
	})
	
	$("#msg_submit").on("click",function(){
		
		socket.emit("send_msg",$("#msg").val());
		$("#msg").val('');
	})
	
	socket.on("send_msg",function(msg){
		
		$(".chat_body").append("<div class='msgbox'>"+'<label>${login.member_id}</label>'+"<br>"+msg+"</div>")
	})
	
	socket.on("connection", function(msg){
		$(".chat_body").append("<div class='msgbox'>"+'<label>${login.member_id}</label>'+msg+"</div>")
	})
	



})




</script>

</head>
<body onresize="parent.resizeTo(900,740)" onload="parent.resizeTo(900,740)">
<%@ include file="../head.jsp" %>

<!-- 카페 홈  --> 
            
            <div class="row" style="width:900px; height:680px; margin-left:0px; " >   
               
               <!-- 채팅방 영역 -->
               <div class="chat" > 
               		<div class="chat_top">
               			<label style="padding-top:10px; color:white; font-weight:bold;  ">카페 채팅방</label> 
               		</div>
               		
               		<div class="chat_body">
					<br>
  					
               		
               		</div>
	               
	          <div class="chat_input">
	               
	          	<input style="border-radius:5px;" placeholder="메시지를 입력하세요." type="text" size="50" name="text" id="msg">  
	         	<input style="width:20%; border-radius:5px" type="button" value="작 성" class="btn btn-secondary" id="msg_submit">
			       

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
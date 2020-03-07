<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">

.chat_member{
	padding:15px;
	overflow:scroll; 
	width:25%; 
	height:680px; 
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

	width:75%; height:680px";

}

 
.chat_top{
	width:100%; height:54px; 
	margin:0px;
	
	background-color:#fda638; 
	text-align: center; 
	vertical-align:middle;
}

.chat_body{
	background-color:#9BDAF2;
	width:100%; 
	height:557px; 
	overflow:scroll;

}

.chat_input{
border:1px solid lightgray;
padding:15px;
height:10%
	
}

.msgbox_me{
	clear:both;
	float:right;
	background-color:#F2F5A9;
	border:1px solid lightgray;
	margin:15px;
	padding:15px;
	border-radius:5px;
}

.msgbox_system{
	clear:both;
	float:center;
	text-align:center;
	
	margin:15px;
	padding:15px;
	border-radius:5px;
}

.msgbox_other{
	clear:both;
	float:left;
	text-align:right;
	background-color:white;
	border:1px solid lightgray;
	margin:15px;
	padding:10px;
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
	
	var now = new Date();
	
	var socket = io("http://localhost:82"); //페이지 로드시 해당 포트로 접속
	
	socket.on('connection', function(data){
		if(data.type == 'connected'){
			socket.emit('connection', {
				type:'join',
				member_no:'${login.member_no}',
				member_id:'${login.member_id}',
				cafe_no:'${cafe.cafe_no}',
				title:'${cafe.title}'
				
				
			});
		}
	})
	
	socket.on('disconnect', function(data){
		writeMsg('system','SYSTEM',data.msg,changeDate(now));
	})

	
	socket.on('system',function(data){
		writeMsg('system','SYSTEM',data.msg,changeDate(now));
	})
	
	socket.on('other',function(data){
		writeMsg('other', data.member_id, data.msg, data.time);
	})
	
	socket.on("me",function(data){
		writeMsg('me', data.member_id, data.msg, data.time);
			
	})
	
	
	
	$("#msg").on("keydown",function(key){
		if(key.keyCode=='13'){
			$("#msg_submit").click();
		}
	})
	
	$("#msg_submit").on("click",function(){
		
		socket.emit("me", {
			member_no:"${login.member_no}",
			member_id:"${login.member_id}",
			msg:$("#msg").val(),
			time:changeDate(now)
			
		});
		
		
		$("#msg").val('');
		
		
	})
	

	
	
	function writeMsg(type, name, msg, time){
		if(type=='me'){
			$(".chat_body").append("<div class='msgbox_me'>"+'<label>'+name+'</label>  <span>'+time+'</span>'+"<br>"+msg+"</div>")
			$(".chat_body").scrollTop($(".chat_body").prop('scrollHeight'));
			
		}
		
		if(type=='system'){
			$(".chat_body").append("<div class='msgbox_system'>"+'<label>'+name+'</label>'+"<br><span>"+time+'</span><br>'+msg+"</div>")
			$(".chat_body").scrollTop($(".chat_body").prop('scrollHeight'));
		}
		
		if(type=='other'){
			$(".chat_body").append("<div class='msgbox_other'>"+'<label>'+name+'</label>  <span>'+time+'</span>'+"<br>"+msg+"</div>")
			$(".chat_body").scrollTop($(".chat_body").prop('scrollHeight'));
			
		}
		
	}
	
	function changeDate(date){
	    //date = new Date(parseInt(date));
	    year = date.getFullYear();
	    month = date.getMonth();
	    day = date.getDate();
	    hour = date.getHours();
	    minute = date.getMinutes();
	    second = date.getSeconds();
	    
	    if(month<10){
	        
	       month = "0"+month
	    }
	     
	    if(day<10){
	       day = "0"+day
	    }
	    
	    if(hour<10){
	       hour = "0"+hour
	    }
	    
	    if(minute<10){
	       minute = "0"+minute
	    }
	    
	           
	    strDate = hour+":"+minute
	    
	    
	    return strDate;
	}



})




</script>

</head>
<body onresize="parent.resizeTo(900,740)" onload="parent.resizeTo(900,740)">
<%@ include file="../head.jsp" %>

<!-- 카페 홈  --> 
            
            <div class="row" style="width:900px; height:680px; margin-left:0px; overflow:auto" >   
               
               <!-- 채팅방 영역 -->
               <div class="chat" > 
               		<div class="chat_top">
               			<label style="padding-top:10px; color:white; font-weight:bold;  ">카페 채팅방</label> 
               		</div>
               		
               		<div class="chat_body">
					
  					
               		
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
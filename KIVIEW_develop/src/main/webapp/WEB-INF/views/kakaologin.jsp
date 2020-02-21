<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<input type="button" id="loginBtn" value="login">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script>
	$("#loginBtn").click(function(){
	location.href="https://accounts.google.com/o/oauth2/auth?client_id="+
	"644232368968-lv79oheut1g7j0d26geqtvel3valll70.apps.googleusercontent.com"+
	"&redirect_uri="+
	"http://localhost:8787/redirect.jsp" +
	"&response_type=code&scope=https://www.googleapis.com/auth/userinfo.email&approval_prompt=force&access_type=offline";
	});
	
	/* OIWrELK_4w3_Xkx_desWJUbC */
</script>
</body>
</html>
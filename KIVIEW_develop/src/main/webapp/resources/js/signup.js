
$(function() {
	$('#signupIdChk').hide();
	$('#signupPwdChkMsg').hide();
});

//아이디 중복체크
function signupIdCkBtn(){
	var member_id = $("#member_id").val();
	var idChkVal = {
		"member_id" : member_id,
	};
	
	if (member_id == null || member_id == "") {
		$("#signupIdChk").show().html("");
		$("#signupIdChk").show().css("color","red").html("&nbsp;&nbsp;아이디를 입력해주세요");

	} else {
		$.ajax({
			type : "post",
			url : "kiviewsignupidchk.do",
			data : JSON.stringify(idChkVal),
			contentType : "application/json",
			dataType : "json",
			success : function(msg) {
					$("#signupIdChk").show().html("");
					$("#signupIdChk").show().css("color","red").html("&nbsp;&nbsp;사용 불가능한 아이디입니다");
			},
			error : function() {
				$("#signupIdChk").show().html("");
				$("#signupIdChk").show().css("color","blue").html("&nbsp;&nbsp;사용 가능한 아이디입니다");
			}
		});
	
	}
	
}



//회원가입 확인
function signupChk(){

	//비밀번호 확인
	var signupPwd = $("#signupPwd").val();
	var signupPwdChk = $("#signupPwdChk").val();
	
	if(signupPwd != signupPwdChk){
		$("#signupPwdChkMsg").show().html("");
		$("#signupPwdChkMsg").show().css('color', 'red').html("&nbsp;&nbsp;비밀번호가 일치하지 않습니다");
		return false;
		
	} else{

		//비밀번호 정규화
		if (!/^.*(?=^.{10,20}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$/.test(signupPwd)) {
			$("#signupPwdChkMsg").show().html("");
			$("#signupPwdChkMsg").show().css('color', 'red').html("&nbsp;&nbsp;영문, 숫자, 특수문자를 포함 10~20자리를 사용해야 합니다");
			return false;
		}

		var checkNumber = signupPwd.search(/[0-9]/g);
		var checkEnglish = signupPwd.search(/[a-z]/ig);
		var checkCharacter = signupPwd.search(/[~!@#$%^&*()_+|<>?:{}]/gi);

		if (checkNumber < 0 || checkEnglish < 0 || chaeckCharacter < 0) {
			$("#signupPwdChkMsg").show().html("");
			$("#signupPwdChkMsg").show().css('color', 'red').html("&nbsp;&nbsp;영문, 숫자, 특수문자를 포함 10~20자리를 사용해야 합니다");
			return false;
		}

		return false;

	}
}


function idChkChk(){
	alert(event.keycode);//삭제
	$('#idChkChk').val("idUnchecked");
	alert($('#idChkChk').val());//삭제
}







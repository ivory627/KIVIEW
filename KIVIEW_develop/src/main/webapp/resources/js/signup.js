
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
	
	//아이디 정규식
	var idReg =  /^[a-z]{1}[a-z0-9]{4,19}$/;
    if( !idReg.test( member_id ) ) {
        $("#signupIdChk").show().html("");
        $("#signupIdChk").show().css("color","red").html("&nbsp;&nbsp;영소문자로 시작하는 영소문자/숫자 조합, 5~20자리로 입력해주세요");
        return;
        
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
				$('#idChkChk').val("idChecked");
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
		$("#signupEmailChkMsg").hide();
		$("#signupPhoneChkMsg").hide();
		$("#signupPwdChkMsg").show().html("");
		$("#signupPwdChkMsg").show().css('color', 'red').html("&nbsp;&nbsp;비밀번호가 일치하지 않습니다");
		
		var member_name = $('#member_name').offset();
		$('html').animate({scrollTop : member_name.top}, 400);

		return false;
	}

	//비밀번호 정규식
	if (!/^.*(?=^.{10,20}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$/.test(signupPwd)) {
		$("#signupEmailChkMsg").hide();
		$("#signupPhoneChkMsg").hide();
		$("#signupPwdChkMsg").show().html("");
		$("#signupPwdChkMsg").show().css('color', 'red').html("&nbsp;&nbsp;영문, 숫자, 특수문자를 포함 10~20자리를 사용해야 합니다");
		
		var member_name = $('#member_name').offset();
		$('html').animate({scrollTop : member_name.top}, 400);

		return false;
	}
	
	//중복확인 여부
	if( $('#idChkChk').val() == "idUnchecked" ){
		var member_name = $('#member_name').offset();
		$('html').animate({scrollTop : member_name.top}, 400);
		
		return false;
	}
	
	//이메일 정규식
	var member_email = $("#member_email").val(); 
	var idReg = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
	if( !idReg.test( member_email ) ) {
    	$("#signupPwdChkMsg").hide();
    	$("#signupPhoneChkMsg").hide();
    	$("#signupEmailChkMsg").show().css('color', 'red').html("&nbsp;&nbsp;올바른 이메일형식으로 입력해주세요&nbsp;&nbsp;ex)test01@email.com");
    	
    	var member_addr = $('#member_addr').offset();
		$('html').animate({scrollTop : member_addr.top}, 200);
		
        return false;
    }
    
    //전화번호 정규식
	var member_phone = $("#member_phone").val(); 
	var idReg = /^[0-9]*$/;
    if( !idReg.test( member_phone ) ) {
    	$("#signupEmailChkMsg").hide();
    	$("#signupPwdChkMsg").hide();
    	$("#signupPhoneChkMsg").show().css('color', 'red').html("&nbsp;&nbsp;숫자만 입력해주세요&nbsp;&nbsp;ex)01011112222");
    	
    	var member_addr = $('#member_addr').offset();
		$('html').animate({scrollTop : member_addr.top}, 200);
		
        return false;
    }
    
    //도로명주소+상세주소
    var member_addrRes = $('#member_addr').val() + " " + $('#member_addrDetail').val();
    $('#member_addr').val(member_addrRes);
	
	alert("성공적으로 KIVIEW의 회원이 되셨습니다");

	return true;

	
}

//중복확인 여부
function idChk_chk(){
	$('#idChkChk').val("idUnchecked");
	$("#signupIdChk").show().css('color', 'red').html("&nbsp;&nbsp;중복확인을 해주세요");
}


//주소 api
function goPopup(){
	
	//팝업 크기/위치
	var winHeight = document.body.clientHeight;   // 현재창의 높이
    var winWidth = document.body.clientWidth;   // 현재창의 너비
    var winX = window.screenLeft;   // 현재창의 x좌표
    var winY = window.screenTop;   // 현재창의 y좌표
    var width = 434;
    var height = 569;
    var popX = winX + (winWidth - 434)/2;
    var popY = winY + (winHeight - 569)/2;
	
	// 호출된 페이지(jusopopup.jsp)에서 실제 주소검색URL(http://www.juso.go.kr/addrlink/addrLinkUrl.do)를 호출하게 됩니다.
	var pop = window.open("kiviewjusopopup.do","pop","width="+width+"px,height="+height+"px,top="+popY+",left="+popX+",scrollbars=no, resizable=yes");
	// 모바일 웹인 경우, 호출된 페이지(jusopopup.jsp)에서 실제 주소검색URL(http://www.juso.go.kr/addrlink/addrMobileLinkUrl.do)를 호출하게 됩니다.
	//var pop = window.open("/popup/jusoPopup.jsp","pop","scrollbars=yes, resizable=yes"); 
	
}
/** API 서비스 제공항목 확대 (2017.02) **/
function jusoCallBack(roadFullAddr,roadAddrPart1,addrDetail,roadAddrPart2,engAddr, jibunAddr, zipNo, admCd, rnMgtSn, bdMgtSn
        , detBdNmList, bdNm, bdKdcd, siNm, sggNm, emdNm, liNm, rn, udrtYn, buldMnnm, buldSlno, mtYn, lnbrMnnm, lnbrSlno, emdNo){
	// 팝업페이지에서 주소입력한 정보를 받아서, 현 페이지에 정보를 등록합니다.
	
	document.getElementById('member_addr').value = roadAddrPart1;
	document.getElementById('member_addrDetail').value = addrDetail;
}









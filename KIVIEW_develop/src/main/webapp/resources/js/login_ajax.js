$(function() {
	$('#loginChk').hide();
	$('#loginIdChk').hide();
	$('#loginPwdChk').hide();

	$("input").keydown(function(key) {
		// 키의 코드가 13번일 경우 (엔터의 키코드는 13)
		if (key.keyCode == 13) {
			login();
		}
	});

});

function login() {
	var member_id = $("#member_id").val().trim();
	var member_pwd = $('#member_pwd').val().trim();

	var loginVal = {
		"member_id" : member_id,
		"member_pwd" : member_pwd
	};

	if (member_id == null || member_id == "") {
		$('#loginChk').hide();
		$('#loginPwdChk').hide();
		$("#loginIdChk").show().html("ID를 입력해주세요.");
		$('input').eq(0).val("");
		$('input').eq(1).val("");

	} else if (member_pwd == null || member_pwd == "") {
		$('#loginChk').hide();
		$('#loginIdChk').hide();
		$("#loginPwdChk").show().html("PW를 입력해주세요.");
		$('input').eq(1).val("");

	} else {
		$.ajax({
			type : "post",
			url : "ajaxlogin.do",
			data : JSON.stringify(loginVal),
			contentType : "application/json",
			dataType : "json",
			success : function(msg) {

				if (msg.check == true) {
					location.href = "index.do";
				} else {
					$('#loginIdChk').hide();
					$('#loginPwdChk').hide();
					$("#loginChk").show().html("ID 혹은 PW가 잘못 되었습니다.");
					$('input').eq(0).val("");
					$('input').eq(1).val("");
				}
			},
			error : function() {
				alert("통신실패");
			}
		});
	}
}

function idCk(){
	location.href="kiviewidsearch.do";
}








$(function() {
	$("#mypagePwd").show().html("&nbsp;&nbsp;&nbsp;&nbsp;기존 비밀번호 혹은 변경할 비밀번호를 입력해주세요");
});

//회원 탈퇴 확인
function memberDel(){
   
   var result = confirm("정말 탈퇴하시겠습니까?")
   
   if(result){
      alert("탈퇴 되었습니다.");
      $("#deleteform").submit();
   }else{
      alert("취소 되었습니다.");
   }
   
   
   
}

//회원정보 수정 확인
function mypagePwdChk(){
	
	var mypagePwd = $('#mypagePwd').val(); 
	var mypagePwdChk = $('#mypagePwdChk').val(); 
	var mypageAddr = $('#mypageAddr').val(); 
	var mypagePhone = $('#mypagePhone').val(); 
	var mypageEmail = $('#mypageEmail').val();
	$('#mypagePwd').show().html('');
	$('#mypagePwdChk').show().html('');
	$('#mypageAddr').show().html('');
	$('#mypagePhone').show().html('');
	$('#mypageEmail').show().html('');
	if( mypagePwd == null || mypagePwd =="" || mypagePwdChk == null || mypagePwd =="" ){
		alert("!");
		$('#mypagePwd').show().html('');
		$('#mypagePwd').show().html('&nbsp;&nbsp;&nbsp;&nbsp;비밀번호를 입력해주세요');
		return false;
	} else if( mypageAddr == null || mypageAddr =="" ){
		$('#mypageAddr').show().html('');
		$('#mypageAddr').show().html('&nbsp;&nbsp;&nbsp;&nbsp;주소를 입력해주세요');
	} else if( mypagePhone == null || mypagePhone =="" ){
		$('#mypagePhone').show().html('');
		$('#mypagePhone').show().html('&nbsp;&nbsp;&nbsp;&nbsp;전화번호를 입력해주세요');
	} else if( mypageAddr == null || mypageAddr =="" ){
		$('#mypageEmail').show().html('');
		$('#mypageEmail').show().html('&nbsp;&nbsp;&nbsp;&nbsp;이메일를 입력해주세요');
	}
	
	//alert("회원정보가 수정되었습니다.");
	
	return false; //수정
}





//주소 api
function addrPopup(){
	
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

//검색된 도로명주소 해당 페이지에 출력
function jusoCallBack(roadFullAddr,roadAddrPart1,addrDetail,roadAddrPart2,engAddr, jibunAddr, zipNo, admCd, rnMgtSn, bdMgtSn
        , detBdNmList, bdNm, bdKdcd, siNm, sggNm, emdNm, liNm, rn, udrtYn, buldMnnm, buldSlno, mtYn, lnbrMnnm, lnbrSlno, emdNo){
	// 팝업페이지에서 주소입력한 정보를 받아서, 현 페이지에 정보를 등록합니다.
	
	document.getElementById('member_addr').value = roadAddrPart1 + " " + addrDetail;
}






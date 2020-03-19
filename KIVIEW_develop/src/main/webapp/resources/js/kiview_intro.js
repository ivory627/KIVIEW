function cafe(memberno, memberid){
	location.href = 'cafehome.do?member_no='+memberno+'&member_id='+memberid;
	
}

function cafe_not(){
	
	var result = confirm("로그인이 필요합니다. 로그인 하시겠습니까?")
	if(result){
		location.href = 'login.do';
	}else{
		return;
	}
	
}
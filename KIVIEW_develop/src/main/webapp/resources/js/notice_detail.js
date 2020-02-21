function notice_edit(notice_no) {

	location.href = "noticeUpdate.do?notice_no=" + notice_no;

}

function notice_del(notice_no){
	var result = confirm("정말 삭제하시겠습니까?");
	
	if(result){
		alert("삭제 완료");
		location.href = "kiviewdel.do?notice_no="+notice_no;
	}else{
		alert("취소");
		return;
	}
	
	
}

$(document).ready(function(){
	$("#btn1").click(function(){
		location.href = "kiviewnotice.do";
	});
});
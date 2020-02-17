$(function(){
	$("#menu01").click(function(){
		$("#menu01").css("color","rgb(255, 157, 31)");
		$("#menu02, #menu03").css("color","#000");
		
		location.href = "kiviewnotice.do";
	});
	
	$("#menu02").click(function(){
		$("#menu02").css("color","rgb(255, 157, 31)");
		$("#menu01, #menu03").css("color", "#000");
		
		location.href = "kiviewintro.do";
	});
	
	$("#menu03").click(function(){
		$("#menu03").css("color","rgb(255, 157, 31)");
		$("#menu01, #menu02").css("color", "#000");
		
		location.href = "kiviewfaq.do";
	});
	
	$("#searchbtn").click(function(){
		
		var searchTypeVal = $("#searchTypeSel option:selected").val();
		var keywordVal = $("#searchBtn").val();
		
		if(searchTypeVal == 'sel'){
			alert("검색 조건을 선택해주세요!");
		}else if(keywordVal == null || keywordVal == ""){
			alert("검색어를 입력해주세요!");
		}else{
			$("#searchform").submit();
		}
		
	});
	
});

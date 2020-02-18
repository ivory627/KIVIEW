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
			return;
		}
		if(keywordVal == null || keywordVal == ""){
			alert("검색어를 입력해주세요!");
			return;
		}
			$("#searchform").submit();
	});
	
	$("#sortsel").on('change', function(){
		$("#sortform").submit();
	})
	
	$("#selcatd").on('change', function(){
		$("#catdform").submit();
	})
	
	$("#btn01").click(function(){
		$("#btn01").addClass("active");
	})
	$("#btn02").click(function(){
		$("#btn02").addClass("active");
	})
	
});

/*function all(){
	
	$("#faqform").submit();
	
	var page = $("#page").val();
	var perPageNum = $("#perPageNum").val();
	var keyword = $("#btn01").val();
	
	var data = {"page":page,
				"perPageNum":perPageNum,
				 "keyword":keyword
				};
	
	var ajaxOption = {
			url:"kiviewfaq.do?page="+page+"&perPageNum="+perPageNum+"&keyword="+keyword,
			type:"get",
			data:data,
			dataType:"html"
		}
	
	$.ajax(ajaxOption).done(function(data){
		$("#faqul").remove();
		$("#faqul").html(data);
	});
	
}
function review(){
	
	$("#faqform").submit();
	
	$.ajax({
		type:"post",
		url:"kiviewfaq.do",
		dataType: "html",
		success:function(msg){
			alert("리뷰 alert");
			if($("#btn02").val() == '리뷰'){
				$("#btn02").css("color", "rgb(255, 157, 31)");
			}
			
		},
		error:function(){
			alert("통신 실패");
		}
	});
	
	
}
function member(){
	
	$("#faqform").submit();
	
	var page = $("#page").val();
	var perPageNum = $("#perPageNum").val();
	var keyword = $("#btn03").val();
	
	var data = {"page":page,
				"perPageNum":perPageNum,
				 "keyword":keyword
				};
	
	var ajaxOption = {
			url:"kiviewfaq.do",
			type:"get",
			data:data,
			dataType:"html"
		}
	
	$.ajax(ajaxOption).done(function(data){
		$("#faqul").remove();
		$("#faqul").html(data);
	});
	
	
}
function service(){
	
	$("#faqform").submit();
	
	
	
}*/



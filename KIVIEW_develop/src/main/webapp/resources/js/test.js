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
	
});


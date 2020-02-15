function notice(){
	$.ajax({
		type:"post",
		url:"kiviewnotice.do",
		dataType: "html",
		success:function(msg){
			history.pushState(null, null, url);
		},
		error:function(){
			alert("통신 실패");
		}
	});
}

function intro(){
	$.ajax({
		type:"post",
		url:"kiviewintro.do",
		dataType: "html",
		success:function(msg){
			history.pushState(null, null, url);
		},
		error:function(){
			alert("통신 실패");
		}
	});
}

function faq(){
	$.ajax({
		type:"post",
		url:"kiviewfaq.do",
		dataType: "html",
		success:function(msg){
			history.pushState(null, null, url);
		},
		error:function(){
			alert("통신 실패");
		}
	});
}

$(function(){

	$("#faqul li").find("#comment").hide(); 
	//#faqul id의 자식 li에서 #comment id를 가진 요소를 찾아서 hide
	
	
$("button[name='faq_no']").click(function(){
		
		var faq_no = $(this).val();
		
		if($(this).next().is(':visible')){ //button의 다음 요소인 div가 펼쳐져있으면
			$(this).next().hide(); //버튼을 누르면 div를 hide
		}else{
			$(this).next().show(); //div가 펼쳐져 있지 않으면 show(버튼을 눌렀을 때)
			
			$.ajax({ //show할 때 ajax 시작
				url:"kiviewone.do",
				data: {"faq_no":faq_no},
				type:"get",
				dataType: "json",
				success:function(result){
					
					$("#"+result.faq_no).html(result.faq_content);
					$("#"+"faqli"+result.faq_no).addClass("open");
					
					$("#"+"subbtn"+result.faq_no).click(function(){
						$("#"+"faqli"+result.faq_no).removeClass("open");
					})
					
				},error:function(){
					alert("통신 실패");
				}
			});
		}
	});

})
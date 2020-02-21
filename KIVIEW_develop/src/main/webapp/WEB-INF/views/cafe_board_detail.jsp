<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 

<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
   
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
   <%@ taglib prefix="fmf" uri="http://java.sun.com/jsp/jstl/fmt"%> 


<!DOCTYPE html>
<html lang="en">
  <head>
    <title>KIVIEW &mdash; Blog</title>
    
    <%@ include file = "head.jsp" %>


  </head>
  <body id = "body">
  
 <%@include file="cafe_modal.jsp" %> 
     <!-- @@ header 부분 @@ -->
     <%@ include file = "header.jsp" %>
    
     <!-- @@ <h1 class = "mb-2 bread"> sub title 이 부분 우선 header에서 따로 빼놨어요!!! </h1> @@ -->
    <section class="hero-wrap hero-wrap-2" style="background-image: url('images/bg_2.jpg');">
      <div class="overlay"></div>
      <div class="container">
        <div class="row no-gutters slider-text align-items-center justify-content-center">
          <div class="col-md-9 ftco-animate text-center">
            <h1 class="mb-2 bread">Our Blog</h1>
            <p class="breadcrumbs"><span class="mr-2"><a href="index.jsp">Home <i class="ion-ios-arrow-forward"></i></a></span> <span>Blog <i class="ion-ios-arrow-forward"></i></span></p>
          </div>
        </div>
      </div>
    </section>
     <!-- @@ header 끝 @@ -->
     
      
      <section class="ftco-section bg-light">
         <div class="container" style="margin-left:30px; ">   
         <div class="row" style="width:1400px; overflow:auto;"> 
            <!-- 카페 메뉴 -->
            <div class="col-lg-3 sidebar ftco-animate" style="padding:25px; margin-right:30px;  background-color:white; border:1px solid lightgray;" >
                 
               
               <%@include file="cafe_sidebar.jsp" %>

            </div>

            <!-- 카페 홈  -->
            
            <div id="home" class="col-lg-8 ftco-animate" style="padding:25px; margin-left:0px; background-color:white; border:1px solid lightgray; "> 
               <h2 class="mb-3"><b>#글 상세보기 </b></h2>
               <hr>
                              
               <label>제 목</label><br>
                  <input type="text" value="${cafe_board_detail.title }" name="title" size="70" readonly>  
               
               <span align=right>${cafe_board_detail.writer}  &nbsp;|&nbsp;  ${cafe_board_detail.regdate } &nbsp;|&nbsp; 조회수  ${cafe_board_detail.hit }</span> 
               <br><br>
               <label>내 용</label><br>  
                  <textarea cols="90" rows="10" name="content" readonly>${cafe_board_detail.content }</textarea>  
                  
               <br>
            
               <div align="right" style="margin-right:60px; margin-top:10px">
               <c:if test="${cafe_board_detail.writer eq login.member_id || cafe_list[0].admin eq login.member_id  }">
                  <input type="button" onclick="location.href='cafeboardupdateform.do?cafe_board_no=${cafe_board_detail.cafe_board_no}&cafe_menu_no=${cafe_menu_no}&cafe_no=${cafe_list[0].cafe_no }'" value="수 정" class="btn btn-primary" style="width:10%">
                  <input type="button" value="삭 제" class="btn btn-secondary" style="width:10%" onclick="location.href='cafeboarddelete.do?cafe_board_no=${cafe_board_detail.cafe_board_no}&cafe_menu_no=${cafe_menu_no}&cafe_no=${cafe_list[0].cafe_no }'">
               </c:if>
               <input type="button" value="목 록" class="btn btn-primary" style="width:10%" onclick="location.href='cafeboardlist.do?&cafe_menu_no=${cafe_menu_no}&cafe_no=${cafe_list[0].cafe_no }'"> 
               </div>
               
               
               <br>
               <br>
<!-- ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ -->                 
               <div id="replylist" style="width:100%;"> 
               <h5>댓글 <a style="color:#fda638">11</a>개</h5> 
               
               <hr>
               
               <!-- ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ -->
              
               
                  <div style="font-weight:bold; color:black" id="noreply"></div>                
               
              
               <hr>
               <!-- ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ -->     
               <div id="replylistthis"></div>
                  
               <hr>
              
               <!-- 페이징 관련 코드 여기에 넣어야 함. -->
               </div>
               
               <div id="reply" style="width:80%; border:0px solid lightgray" " > 
               
               <form action="#">
               <label style="font-weight:bold; color:black" >${cafe_board_detail.writer}</label> 
               <br>               
                  <input type="text" size="70" placeholder="상대방을 향한 욕설, 음담패설은 자제해주세요."  id="replycontent">
                  <input type="hidden" name="" value="${cafe_board_detail.cafe_board_no}" id="replyboard_no">
                  <input type="hidden" name="" value="${cafe_board_detail.writer}" id="writer">
                  <input type="hidden" name="" value="${login.member_id }" id="loginid">
                  <input type="hidden" name="" value="${cafe_list[0].admin}" id="adminid">
                  <input type="text" size="1" value="0"  id="replycount" >자
                  <input type="button" class="btn btn-primary" value="등록" onclick="replyinsert();">                  
               </form>         
        
             
               </div>
               
            </div>
 
         </div>

      </div>
      </section>

      
   <!-- @@ footer 영역 @@ -->
   <%@ include file="footer.jsp"%>

  
<script type="text/javascript">


$(document).on("keyup","#replycontent",function(){
   var content = $("#replycontent").val();   
   var length1 = content.length ;   
   $("#replycount").val(length1);   
});


function contentcount(num){
   $(document).on("keyup","#replycontent2",function(){
      
      var content = $("#replycontent2").val();   
      var length1 = content.length ;
      
      $("#replycount2").val(length1);   
   });   
}
contentcount();


function ajaxreplylist(){
   var cafe_board_no = $("#replyboard_no").val();
   console.log(cafe_board_no);
   
   jQuery.ajax({
          url : "ajaxreplylist.do",
          type : "post",
          dataType:"json",
          data : {"cafe_board_no" : cafe_board_no },
          success : function(data){
                         
             console.log(data.rlist.size==0 || data.rlist.size==null);
             if(data.rlist.size==0 && data.rlist.size==null ){                
                $("#noreply").html("작성된 댓글이 없습니다.");                
                
             }else{             
                $.each(data.rlist, function(key,value){                               
                   console.log(key);
                   console.log(value);
                   
                   var rlist1 = '';
                   rlist1 +=
                        
                    "<div id='comment"+value.cafe_reply+"' >"+
                    
                       "<div style='font-weight:bold; color:black'>"+value.writer+"</div>"+
                       "<div style='color:black'>"+value.content+"</div>"+
                       "<div style='font-size:smell'>"+value.regdate+"</div>"+                       
                       "<input type='button' value='삭 제' class='btn btn-secondary btnhide' onclick='replydelete("+value.cafe_reply+");' />"+
                         "<input type='button' value='수 정' class='btn btn-primary btnhide' onclick='replyupdate1("+value.cafe_reply+");'/>"+
                         
                      "</div><hr>"+
                      
                      "<div id='commentupdate"+value.cafe_reply+"' style='display:none'>"+
                      
                         "<div style='font-weight:bold; color:black'>"+value.writer+"</div>"+
                         "<input type='text' size='80' name='content' value='"+value.content+"' id='updatecontent"+value.cafe_reply+"'/> "+
                         "<div style='font-size:smell'>"+value.regdate+"</div>"+
                         "<input type='button' value='수정완료' class='btn btn-primary ' onclick='replyupdate2("+value.cafe_reply+");'/>"+
                         "<input type='button' value='수정취소' class='btn btn-secondary' onclick='replyupdatex("+value.cafe_reply+");'/>"+       
                                            
                      "</div>";                 
                   
                   console.log(rlist1);
                   
                   $("#replylistthis").append(rlist1);
                   
                   $(".btnhide").each(function(){
                        var writer = $("#writer").val();
                        var loginid = $("#loginid").val();
                        var adminid = $("#adminid").val();
                          console.log(writer);
                          console.log(loginid);
                          console.log(adminid);
                          

                          if( writer != loginid || loginid != adminid ){
                                $(this).hide();
                                $("#reply").hide();
                                 
                        }
                     })
                   
                });             
             }
          },
          error : function(request,status,error){
               alert("실패");               
           }       
    });
   
   
   

   
   
}
   
ajaxreplylist();   


   

function replyinsert(){
   alert("글등록 이벤트");
   var  content = $("#replycontent").val();
   var cafe_board_no= $("#replyboard_no").val();    
   var writer = $("#writer").val();   
   jQuery.ajax({
       url : "ajaxreplyinsert.do",
       type : "post",
       dataType:"json",
       contentType:"application/json",
       data : JSON.stringify({
              "cafe_board_no" : cafe_board_no,
             "writer"       : writer,
             "content"       : content
          
          }),
       success : function(data){
                   
         if(data.res==1){
            alert("댓글이 등록 되었습니다.");
            $("#replylistthis").empty();
            ajaxreplylist();
            $("#replycontent").val('');
            
         }else{
            alert("댓글 등록을 다시 시도 해 주세요.");
         }                    
       },
      
       error : function(request,status,error){
            alert("실패");               
        }       
});

}
function replydelete(cafe_reply){       
   console.log(cafe_reply);
   
   jQuery.ajax({   
      url : "ajaxreplydelete.do",
       type : "post",
       dataType:"json",       
       data : { "cafe_reply" : cafe_reply },
       success : function(data){
          
          if(data.res==1){
             alert("댓글이 삭제 되었습니다.");
             $("#replylistthis").empty();
               ajaxreplylist();
          }else{
             alert("댓글 삭제를 다시 시도 해 주세요.");
          }
          
       },
       error : function(request,status,error){
           alert("실패");
          
       }
   
   });
   
}


function replyupdate1(cafe_reply){
   console.log(cafe_reply);
   console.log("#comment"+cafe_reply);
   
   $("#comment"+cafe_reply).hide();
   $("#commentupdate"+cafe_reply).show();
}

 

function replyupdate2(cafe_reply){
   console.log(cafe_reply);
   console.log("#updatecontent"+cafe_reply);
   var content = $("#updatecontent"+cafe_reply).val();
   console.log(content);
   
   jQuery.ajax({
       url : "ajaxreplyupdate.do",
       type : "post",
       dataType:"json",
       contentType:"application/json",
       data : JSON.stringify({
              "cafe_reply" : cafe_reply,             
             "content"       : content          
          }),
       success : function(data){
                   
         if(data.res==1){
            alert("댓글이 수정 완료");
            $("#replylistthis").empty();
            ajaxreplylist();            
            
         }else{
            alert("댓글 수정을 다시 시도 해 주세요.");
         }                    
       },
      
       error : function(request,status,error){
            alert("실패");               
        }

       
   
   
});
}   

function replyupdatex(cafe_reply){
   $("#comment"+cafe_reply).show();
   $("#commentupdate"+cafe_reply).hide();
}



</script>   
  </body>
</html>
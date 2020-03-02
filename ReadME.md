## 📣 KIVIEW 기능 구현 설명<Spring framework final project>


>SEUNG HYE CHOI - NoticeBoard, Chatbot, UI총괄(BootStrap), index.jsp(Main), SNS Login(Naver, Kakao, Google -> 구현중)


📩 contact - motop68@gmail.com





🎈 사용 언어 및 IDE
  1. Java 8 / jre 1.8.0_202
  2. JavaScript, jQuery
  3. HTML5, CSS
  4. Eclipse
  
🎈 프레임워크
  1. Spring framework 3

🎈 Server --> 도메인 구매 후 AWS Route 53 배포 예정
  1. Apache Tomcat v9.0
 
🎈 협업/형상관리 Tool
  1. Slack
  2. Github / Github Desktop

🎈 DBMS 
  1. Mybatis
  
🎈 OS
  1. Chrome




* * *   
   
   
#### 1. NoticeBoard/FAQBoard (NoticeController, NoticeDao, NoticeDaoImpl, NoticeBiz, NoticeBizImpl, notice-mapper.xml)
  - kiview_notice.jsp 
    - selectList, sort, paging, search functions, 현재 page 나타내기 완료 
  - kiview_notice_detail.jsp
    - selectOne, delete, update(mapping 연결)
  - kiview_notice_write.jsp 
    - insert, smartEditor2(API)
  - kiview_notice_update.jsp
    - update, smartEditor2(API)
  - kiview_intro.jsp
    - view(구현중 - 이미지 제작)
  - kiview_FAQ.jsp // 답글 여부 ajax 완료, 현재 page 나타내기 완료
    - selectList, paging, ajax
  - kiview_faq_write.jsp
    - insert, smartEditor2(API)
  - kiview_faq_update.jsp // delete는 ajax로 구현
    - update, smartEditor2(API)
    
   
* * *

#### 2. JavaScript file 설명 - (notice.js, notice-write.js, notice-update.js, notice-detail.js, faq.js, faq-write.js, faq-update.js)
  - notice.js 
    - kiview_notice.jsp와 연결 된 javaScript, jQuery, ajax functions 
  - notice-write.js
    - kiview_notice_write.jsp와 연결 된 functions
  - notice-update.js 
    - kiview_notice_update.jsp와 연결 된 functions
  - notice-detail.js
    - kiview_notice_detail.jsp와 연결 된 functions 
  - faq와 관련 된 js는 notice js와 설명 동일
  
  
* * *

    
    
#### 3. Chatbot 
  - Danbi (LG) 
  

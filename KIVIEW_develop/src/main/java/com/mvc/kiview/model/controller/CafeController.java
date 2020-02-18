package com.mvc.kiview.model.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.WebUtils;

import com.mvc.kiview.common.validate.FileValidate;
import com.mvc.kiview.common.validate.uploadFile;
import com.mvc.kiview.model.biz.CafeBiz;
import com.mvc.kiview.model.vo.CafeBoardVo;
import com.mvc.kiview.model.vo.CafeCategoryVo;
import com.mvc.kiview.model.vo.CafeMemberVo;
import com.mvc.kiview.model.vo.CafeMenuVo;
import com.mvc.kiview.model.vo.CafeVo;

@Controller // 카페관련
public class CafeController {
   
   @Autowired
   private FileValidate filevalidate;

   @Autowired
   private CafeBiz biz;
   
   @RequestMapping("/cafehome.do")
   public String cafe_home(Model model, int member_no, String member_id) {

      List<CafeVo> Ulist = new ArrayList<CafeVo>();
      Ulist = biz.cafe_Ulist(member_no);
      
      List<CafeVo> Alist = new ArrayList<CafeVo>();
      Alist = biz.cafe_Alist(member_id);
      // 내가 가입한 카페 카페 목록
      model.addAttribute("Ulist", Ulist);
      
      // 내가 운영 중이 카페 목록
      model.addAttribute("Alist", Alist);
      
      
      return "cafe_home";
   }
 

   @RequestMapping("/cafeopen.do")
   public String cafe_open() {
      return "cafe_open";
   }
   
   
   
   @RequestMapping("cafemy.do") // session 번호를 매개변수로 받는다.
   public String cafe_my(Model model, int member_no) {

      List<CafeVo> list = new ArrayList();

      model.addAttribute("list", biz.cafe_Ulist(member_no));

     
      return "cafe_my";

   }

   @RequestMapping("/cafedetail.do")
   public String cafe_detail(HttpSession session,Model model, int cafe_no, int member_no) {
      // 상세페이지 카페 정보
      CafeVo cafe = biz.cafe_selectone(cafe_no);
      List<CafeMenuVo> menu = biz.menu_list(cafe_no);
      List<CafeMemberVo> member = biz.cafe_member_list(cafe_no);
      
      
      List list = new ArrayList();
      list.add(cafe);
      list.add(menu);
      list.add(member);
      session.setAttribute("cafe_list", list);
      System.out.println(list);
      
      // 카페 회원 여부 확인 -> 버튼 변경 여부 확인 용
      CafeMemberVo regyn = new CafeMemberVo();
      regyn.setCafe_member_no(member_no);
      regyn.setCafe_no(cafe_no);
      
      CafeMemberVo res = biz.cafe_regyn(regyn); 

      return "cafe_detail";
   }

   
   ////////////////////////////  카페 관리 ///////////////////////////////
   @RequestMapping("/cafeconfig.do")
   public String cafe_config(Model model, int cafe_no) {
      CafeVo cafe = biz.cafe_selectone(cafe_no);
      model.addAttribute("vo", cafe);
      
      List<CafeMenuVo> menu = biz.menu_list(cafe_no);
      model.addAttribute("menu", menu);
      return "cafe_config";
   }
   
   
   
   ///////////////////////// 게시판 관리 ///////////////////////////////////////
   @RequestMapping("/menuinsert.do")
   public void menu_insert(HttpServletResponse response, CafeMenuVo vo, @RequestParam("category1") String cat1,
         @RequestParam("category2") String cat2, @RequestParam("category3") String cat3) throws IOException {

	   System.out.println(vo+ cat1+ cat2+ cat3);

      int res = biz.menu_insert(vo, cat1, cat2, cat3);

      response.setContentType("text/html; charset=UTF-8");

      if (res > 0) {
         PrintWriter out = response.getWriter();
         out.print("<script> alert('게시판을 추가하였습니다.'); location.href='cafeconfig.do?cafe_no=" + vo.getCafe_no()
               + "'</script> ");

      } else {
         PrintWriter out = response.getWriter();
         out.print("<script> alert('명령 실행 중 오류'); location.href='cafeconfig.do?cafe_no=" + vo.getCafe_no()
               + "'</script> ");
         out.flush();

      }

   }
   
   @RequestMapping(value="/menuchk.do",method=RequestMethod.POST)
   @ResponseBody
   public Map<String, Boolean> menu_chk(@RequestBody CafeMenuVo menu){
	   boolean check = false;
	   CafeMenuVo vo = biz.menu_chk(menu);
	   
	   if(vo!=null) {
		   check=true;
	   }
	   
	   Map<String, Boolean> map = new HashMap<String, Boolean>();
	   map.put("check", check);
	   
	   return map;
   }
   
   @RequestMapping(value="/menudetail.do", method=RequestMethod.POST) 
   @ResponseBody
   public Map<String, Object> menu_detail(int no) { 
	   
	   CafeMenuVo vo1 = biz.menu_detail1(no);
	   List<CafeCategoryVo> vo2 = biz.menu_detail2(no);
	   
	   
	   Map<String, Object> map = new HashMap<String, Object>();
	   map.put("menu", vo1);
	   map.put("category",vo2);
	   
	   
	   return map;
   }
   
   @RequestMapping("/menudelete.do")
   public void menu_delete(HttpServletResponse response, int cafe_no, int cafe_menu_no) throws IOException {
	   
	   System.out.println(cafe_menu_no);
	   
	   int res = 0;
	   
	   res = category_delete_all(cafe_menu_no);
	   
	   //res = biz.menu_delete(cafe_menu_no);
	   
	   PrintWriter out = response.getWriter();
	   
	   if(res>0) {
		   
		   out.print("<script> alert('게시판을 삭제하였습니다.'); location.href='cafeconfig.do?'"+cafe_no
		   		+ "+</script>");
		   
	   } else {
		   out.print("<script> alert('명령 실행 중 오류.'); location.href='cafeconfig.do?'"+cafe_no
			   		+ "+</script>");
	   }
	   
	   
	   
	   
   }
   
   public int category_delete_all(int cafe_menu_no) {
	   int res = 0;
	   
	   res = biz.category_delete_all(cafe_menu_no);
	   
	   return res;
   }
   
   
   
   
   
   
   
   
   
   
   @RequestMapping("/cafejoinform.do")
   public String cafe_joinbefore(Model model, int cafe_no) {

      CafeVo vo = biz.cafe_selectone(cafe_no);

      model.addAttribute("cafevo", vo);

      return "cafe_join";
   }

   @RequestMapping("/cafejoin.do")
      public String cafe_join(Model model, int cafe_no, String answer,String signyn, int memberno) {
                  
         
          
          CafeMemberVo vo = new CafeMemberVo();
          vo.setAnswer(answer);
          vo.setCafe_no(cafe_no);
          vo.setMember_no(memberno);
          vo.setSignyn(signyn);
          
          int res = biz.cafe_join(vo);
          
          if(res>0) {
             System.out.println("성공");
             return "redirect:cafedetail.do?cafeno="+cafe_no;
             
          }else {
             System.out.println("실패");          
             return "redirect:insertform.do?cafeno="+cafe_no;
          }
   }
   
   

   @RequestMapping("/cafeinsert.do")
   public String cafe_insert(HttpServletRequest request, Model model, CafeVo cafe, uploadFile uploadfile,
         @RequestParam("member_no") int member_no, @RequestParam("admin") String admin, BindingResult result) {
      System.out.println(member_no);
      System.out.println(admin);

      filevalidate.validate(uploadfile, result);

      if (result.hasErrors()) { // 에러가 발생하였는지

         return "cafe_open";
      }

      int count1 = 1;
      int count2 = 1;

      MultipartFile thumb = uploadfile.getFile1(); // 업로드한 파일
      MultipartFile background = uploadfile.getFile2(); // 업로드한 파일
      String thumb_name = "thumb" + count1 + ".jpg";
      String bg_name = "bg" + count2 + ".jpg";

      uploadFile file = new uploadFile();

      InputStream inputStream1 = null;
      InputStream inputStream2 = null;
      OutputStream outputStream1 = null;
      OutputStream outputStream2 = null;

      try {
         inputStream1 = thumb.getInputStream();
         inputStream2 = background.getInputStream();

         // 경로 설정
         String path = WebUtils.getRealPath(request.getSession().getServletContext(), "/storage");
         System.out.println("업로드 될 실제 경로 : " + path);

         // 파일경로 존재확인
         File storage = new File(path);

         if (!storage.exists()) { // 존재여부
            storage.mkdirs(); // 해당 경로를 만들겠다.
         }

         // 썸네일 파일명 중복확인

         File newfile1 = new File(path + "/" + thumb_name);

         while (newfile1.exists()) {
            count1++;
            System.out.println("이미지1 이름 중복 : " + count1);
            thumb_name = "thumb" + count1 + ".jpg";
            newfile1 = new File(path + "/" + thumb_name);

            if (!newfile1.exists()) {
               newfile1.createNewFile();
               break;
            }

         }

         // 배경이미지 파일명 중복확인
         File newfile2 = new File(path + "/" + bg_name);

         while (newfile2.exists()) {
            count2++;
            System.out.println("이미지2 이름 중복 : " + count2);
            bg_name = "bg" + count2 + ".jpg";
            newfile2 = new File(path + "/" + bg_name + ".jpg");

            if (!newfile2.exists()) {
               newfile2.createNewFile();
               break;
            }
         }

         //
         outputStream1 = new FileOutputStream(newfile1);
         int read1 = 0;
         byte[] b1 = new byte[(int) thumb.getSize()]; // outputStream 은 byte단위이기 떄문

         while ((read1 = inputStream1.read(b1)) != -1) { // 업로드 하려는 파일 읽기
            outputStream1.write(b1, 0, read1);

         }

         outputStream2 = new FileOutputStream(newfile2);
         int read2 = 0;
         byte[] b2 = new byte[(int) background.getSize()]; // outputStream 은 byte단위이기 떄문

         while ((read2 = inputStream2.read(b2)) != -1) { // 업로드 하려는 파일 읽기
            outputStream2.write(b2, 0, read2);

         }

      } catch (IOException e) {

         e.printStackTrace();
      } finally {

         try {
            inputStream1.close();
            inputStream2.close();
            outputStream1.close();
            outputStream2.close();

         } catch (IOException e) {
            e.printStackTrace();
         }
      }

      CafeVo vo1 = new CafeVo(cafe.getTitle(), admin, cafe.getIntro(), thumb_name, bg_name, cafe.getRestriction(),
            cafe.getQuestion());
      
      CafeMemberVo vo2 = new CafeMemberVo(member_no, admin, "A");
      

      int res = 0;
      res = biz.cafe_insert(vo1,vo2);

      if (res > 0) {
    	  return "redirect:cafehome.do?member_no=" + member_no+"&member_id="+admin;
      } else {
         return "redirect:cafeopen.do";
      }

   }
   
   
   /////////////////////////////////////  검색  /////////////////////////////////////////
   @RequestMapping("/cafesearch.do")
   public String cafe_search(Model model,String keyword) {
      
      
      
      
      List<CafeVo> slist = biz.cafe_search(keyword);
      
      model.addAttribute("Slist",slist);      
      model.addAttribute("keyword",keyword);
      return "cafe_search";
   }

}
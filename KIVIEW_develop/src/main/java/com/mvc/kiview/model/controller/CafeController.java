package com.mvc.kiview.model.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.WebUtils;

import com.mvc.kiview.common.validate.FileValidate;
import com.mvc.kiview.common.validate.uploadFile;
import com.mvc.kiview.model.biz.CafeBiz;
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

      System.out.println(list);
      return "cafe_my";

   }

   @RequestMapping("/cafedetail.do")
   public String cafe_detail(Model model, int cafe_no, int member_no) {
      // 상세페이지 카페 정보
      CafeVo vo = biz.cafe_selectone(cafe_no);
      model.addAttribute("vo", vo);
      
      // 카페 회원 여부 확인 -> 버튼 변경 여부 확인 용
      CafeMemberVo regyn = new CafeMemberVo();
      regyn.setCafe_member_no(member_no);
      regyn.setCafe_no(cafe_no);
      
      CafeMemberVo res = biz.cafe_regyn(regyn);
      System.out.println(res);
      model.addAttribute("caferegyn",res);   

      return "cafe_detail";
   }

   @RequestMapping("/cafeconfig.do")
   public String cafe_config(Model model, int cafe_no) {
      CafeVo vo = biz.cafe_selectone(cafe_no);
      model.addAttribute("vo", vo);

      return "cafe_config";
   }

   @RequestMapping("/menuinsert.do")
   public void menu_insert(HttpServletResponse response, CafeMenuVo vo, @RequestParam("category1") String cat1,
         @RequestParam("category2") String cat2, @RequestParam("category3") String cat3) throws IOException {

      System.out.println(vo);
      System.out.println(cat1 + cat2 + cat3);

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

}
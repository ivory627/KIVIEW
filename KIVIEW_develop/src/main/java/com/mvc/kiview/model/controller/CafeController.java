package com.mvc.kiview.model.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;

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
import com.mvc.kiview.model.vo.CafeVo;

@Controller // 카페관련
public class CafeController {
	
	@Autowired
	private CafeBiz biz ;

	@RequestMapping("/cafehome.do")
	public String cafe_home() {

		return "cafe_home";
	}

	@RequestMapping("/cafeopen.do")
	public String cafe_open() {
		return "cafe_open";
	}

	@Autowired
	private FileValidate filevalidate;

	@RequestMapping("/cafeinsert.do")
	public String cafe_insert(HttpServletRequest request, Model model, CafeVo cafe, uploadFile uploadfile,
			BindingResult result
	) {

		filevalidate.validate(uploadfile, result);

		if (result.hasErrors()) { // 에러가 발생하였는지

			return "cafe_open";
		}
		
		int count1 = 1;
		int count2 = 1;

		MultipartFile thumb = uploadfile.getFile1(); // 업로드한 파일
		MultipartFile background = uploadfile.getFile2(); // 업로드한 파일
		String thumb_name = "thumb" + count1;
		String bg_name = "bg" + count2;

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

			if (!newfile1.exists()) {// 위의 파일이 없으면 새로 만들겠다.
				newfile1.createNewFile();

			} else {
				count1++;
				thumb_name = "thumb" + count1;
				newfile1.createNewFile();
			}
			
			// 배경이미지 파일명 중복확인
			File newfile2 = new File(path + "/" + bg_name);

			if (!newfile2.exists()) {// 위의 파일이 없으면 새로 만들겠다.
				newfile2.createNewFile();

			} else {
				count2++;
				bg_name = "bg" + count2;
				newfile2.createNewFile();
			}
			
			
			//
			outputStream1 = new FileOutputStream(newfile1);
			int read1 = 0;
			byte[] b1 = new byte[(int)thumb.getSize()]; //outputStream 은  byte단위이기 떄문
			
			while((read1 = inputStream1.read(b1)) != -1) { //업로드 하려는 파일 읽기
 				outputStream1.write(b1,0,read1);  
				
			}
			
			outputStream2 = new FileOutputStream(newfile2);
			int read2 = 0;
			byte[] b2 = new byte[(int)background.getSize()]; //outputStream 은  byte단위이기 떄문
			
			while((read2 = inputStream1.read(b2)) != -1) { //업로드 하려는 파일 읽기
 				outputStream1.write(b2,0,read2);  
				
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
		
		CafeVo vo = new CafeVo(cafe.getTitle(),"admin",cafe.getIntro(),
				thumb_name, bg_name,
				cafe.getRestriction(),cafe.getQuestion());
		
		
		int res=0;
		res = biz.cafe_insert(vo);
		
		
		if (res>0) {
			return "redirect:cafehome.do";
		} else {
			return "redirect:cafeopen.do";
		}
		
		
		
		
	}

}

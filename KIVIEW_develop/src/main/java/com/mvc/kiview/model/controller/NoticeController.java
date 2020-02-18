package com.mvc.kiview.model.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mvc.kiview.model.biz.NoticeBiz;
import com.mvc.kiview.model.vo.Criteria;
import com.mvc.kiview.model.vo.NoticeVo;
import com.mvc.kiview.model.vo.PageMaker;

@Controller // 공지관련
public class NoticeController {

	private static final Logger logger = LoggerFactory.getLogger(NoticeController.class);

	@Autowired
	private NoticeBiz n_biz;

	/* 키뷰안내, 공지사항 */
	@RequestMapping("/kiviewnotice.do")
	public String kiview_notice(Model model, Criteria cri) {

		logger.info("NOTICE LIST");

		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(n_biz.notice_count());

		model.addAttribute("noticelist", n_biz.noticeList(cri));
		model.addAttribute("pageMaker", pageMaker);

		return "kiview_notice";
	}

	/* 공지사항 selectOne */
	
	@RequestMapping("/kiviewdetail.do")
	public String kiview_detail(Model model, int notice_no) {

		logger.info("NOTICE DETAIL");
		model.addAttribute("noticedetail", n_biz.n_selectOne(notice_no));

		return "kiview_notice_detail";
	}

	/* admin 계정으로 로그인 - 글쓰기 버튼 클릭시 write 폼으로 */
	@RequestMapping("/kiviewwrite.do")
	public String kiview_write() {

		logger.info("NOTICE WRITE");

		return "kiview_notice_write";
	}

	/* 글 작성 insert redirect 부분 */
	@RequestMapping("/writeRes.do")
	public String kiview_insertRes(NoticeVo n_vo) {

		logger.info("NOTICE WRITE RESULT");

		int res = n_biz.notice_insert(n_vo);

		if (res > 0) {
			return "redirect:kiviewnotice.do";
		} else {
			return "redirect:kiviewwrite.do";
		}

	}

	/* 수정하기 버튼 클릭 시 update폼으로 */
	@RequestMapping("/noticeUpdate.do")
	public String notice_update(Model model, int notice_no) {

		logger.info("NOTICE UPDATE FORM");

		model.addAttribute("noticeupdate", n_biz.n_selectOne(notice_no));

		return "kiview_notice_update";
	}

	/* 수정완료 클릭 시 redirect */
	@RequestMapping("/noticeUpdateRes.do")
	public String notice_updateRes(NoticeVo n_vo) {

		logger.info("NOTICE UPDATE RESULT");

		int res = n_biz.notice_update(n_vo);

		if (res > 0) {
			return "redirect:kiviewdetail.do?notice_no=" + n_vo.getNotice_no();
		} else {
			return "redirect:noticeUpdate.do?notice_no" + n_vo.getNotice_no();
		}

	}

	/* 게시글 삭제 */
	@RequestMapping("/kiviewdel.do")
	public String kiview_delete(int notice_no) {

		logger.info("NOTICE DELETE");

		int res = n_biz.notice_delete(notice_no);

		if (res > 0) {
			return "redirect:kiviewnotice.do";
		} else {
			return "redirect:kiviewdetail.do?notice_no" + notice_no;
		}

	}

	@RequestMapping("/fileupload.do")
	public void multiplePhotoUpload(HttpServletRequest request, HttpServletResponse response) {

		try {
			
			String sFileInfo = "";
			String filename = request.getHeader("file-name");
			String filename_ext = filename.substring(filename.lastIndexOf(".") + 1);
			filename_ext = filename_ext.toLowerCase();
			String defaultFilePath = request.getSession().getServletContext().getRealPath("/");
			String filePath = defaultFilePath + "resources" + File.separator + "photo_upload" + File.separator;

			System.out.println("NoticeController filePath : " + filePath);

			File file = new File(filePath);

			if (!file.exists()) {
				file.mkdirs();
			}

			String realFileName = "";
			SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
			String today = formatter.format(new java.util.Date());
			realFileName = today + UUID.randomUUID().toString() + filename.substring(filename.lastIndexOf("."));

			String rlFileNm = filePath + realFileName;

			InputStream is = request.getInputStream();
			OutputStream os = new FileOutputStream(rlFileNm);

			int numRead;
			byte b[] = new byte[Integer.parseInt(request.getHeader("file-size"))];

			while ((numRead = is.read(b, 0, b.length)) != -1) {
				os.write(b, 0, numRead);
			}
			if (is != null) {
				is.close();
			}
			os.flush();
			os.close();

			sFileInfo += "&bNewLine=true";
			sFileInfo += "&sFileName=" + filename;
			sFileInfo += "&sFileURL=" + "resources/photo_upload/" + realFileName;

			PrintWriter print = response.getWriter();
			print.print(sFileInfo);
			print.flush();
			print.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@RequestMapping("/kiviewintro.do")
	public String kiview_intro() {
		return "kiview_intro";
	}

	@RequestMapping("/kiviewfaq.do")
	public String kiview_faq() {
		return "kiview_FAQ";
	}

}

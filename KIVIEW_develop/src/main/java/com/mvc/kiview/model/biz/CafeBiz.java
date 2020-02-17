package com.mvc.kiview.model.biz;

import java.util.List;

import com.mvc.kiview.model.vo.CafeBoardVo;
import com.mvc.kiview.model.vo.CafeCategoryVo;
import com.mvc.kiview.model.vo.CafeMemberVo;
import com.mvc.kiview.model.vo.CafeMenuVo;
import com.mvc.kiview.model.vo.CafeVo;

public interface CafeBiz {
	// ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ수정ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ

	public List<CafeVo> cafe_Ulist(int member_no);

	public List<CafeVo> cafe_Alist(String member_id);

	public CafeMemberVo cafe_regyn(CafeMemberVo regyn);

//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ   

	public int cafe_insert(CafeVo vo1, CafeMemberVo vo2);

	public CafeVo cafe_selectone(int cafe_no);

	public int menu_insert(CafeMenuVo vo, String cat1, String cat2, String cat3);

	public int category_insert(String cat);

	public int cafe_join(CafeMemberVo vo);

	public List<CafeMenuVo> menu_list(int cafe_no);

	public CafeMenuVo menu_detail1(int no);

	public List<CafeCategoryVo> menu_detail2(int no);

	public CafeMenuVo menu_chk(CafeMenuVo menu);
	
	public List<CafeVo> cafe_search(String keyword);

	public List<CafeMemberVo> cafe_member_list(int cafe_no);

	public int menu_delete(int cafe_menu_no);

}
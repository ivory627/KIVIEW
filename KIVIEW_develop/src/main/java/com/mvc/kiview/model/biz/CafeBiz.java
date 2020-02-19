package com.mvc.kiview.model.biz;

import java.util.List;

import com.mvc.kiview.model.vo.CafeBoardVo;
import com.mvc.kiview.model.vo.CafeCategoryVo;
import com.mvc.kiview.model.vo.CafeMemberVo;
import com.mvc.kiview.model.vo.CafeMenuVo;
import com.mvc.kiview.model.vo.CafeVo;

public interface CafeBiz {
	

	public List<CafeVo> cafe_Ulist(int member_no);

	public List<CafeVo> cafe_Alist(String member_id);

	public CafeMemberVo cafe_regyn(CafeMemberVo regyn);


	//--카페 CRUD--

	public int cafe_insert(CafeVo vo1, CafeMemberVo vo2);
	
	public CafeVo cafe_chk(String title);
	
	

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
	
	public int category_delete_all(int cafe_menu_no);
	
	public int menu_update(CafeMenuVo menu);
	
	public int category_update(CafeCategoryVo category);
	
	public int category_delete(int category_no);
	
	public int category_update_insert(CafeCategoryVo category);
	
	public int cafe_update(CafeVo cafe);
	
	//--게시판--//
	
	public List<CafeBoardVo> cafe_board(int cafe_no);

	public List<CafeBoardVo> cafe_boardlist(int cafe_menu_no);

	public String cafe_menu_name(int cafe_menu_no);
	
	public int cafe_board_insert(CafeBoardVo cafeboardvo);

	public CafeBoardVo cafe_board_detail(int cafe_board_no);

	public int cafe_board_delete(int cafe_board_no);

	public int cafe_board_update(CafeBoardVo cafeboardvo);
	
	
	//--멤버관리--//
	public int member_block(int cafe_member_no);
	
	public int member_sign(int cafe_member_no);
	
	public int member_cancle(int cafe_member_no);

	public List<CafeMemberVo> member_selectAll();

	

	

	

	

	
	
	

}
package com.mvc.kiview.model.dao;

import java.util.List;

import com.mvc.kiview.model.vo.CafeBoardVo;
import com.mvc.kiview.model.vo.CafeCategoryVo;
import com.mvc.kiview.model.vo.CafeMemberVo;
import com.mvc.kiview.model.vo.CafeMenuVo;
import com.mvc.kiview.model.vo.CafeVo;

public interface CafeDao {
   String namespace = "cafe."; 
// ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ   
   public List<CafeVo> cafe_Ulist(int member_no);
   
   public List<CafeVo> cafe_Alist(String member_id);
   
   public CafeMemberVo cafe_regyn(CafeMemberVo regyn);
// ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ   
   
   public int cafe_insert(CafeVo vo);
    
   public int cafe_insert2(CafeMemberVo vo);
   
   public CafeVo cafe_selectone(int cafe_no);
   
   public int menu_insert(CafeMenuVo vo);
   
   public int category_insert(String cat);
   
   public int cafe_join(CafeMemberVo vo);

   public List<CafeVo> cafe_search(String keyword);

	public List<CafeMenuVo> menu_list(int cafe_no);

	public CafeMenuVo menu_detail1(int no);

	public List<CafeCategoryVo> menu_detail2(int no);

	public CafeMenuVo menu_chk(CafeMenuVo menu);

	public List<CafeMemberVo> cafe_member_list(int cafe_no);

	public int menu_delete(int cafe_menu_no);

	public int category_delete_all(int cafe_menu_no);

	public int category_update(CafeCategoryVo category);
   
   //-------------------------------  게시판 --------------------------------
   
	public List<CafeBoardVo> cafe_board(int cafe_no);

	public List<CafeBoardVo> cafe_boardlist(int cafe_menu_no);

	public String cafe_menu_name(int cafe_menu_no);

	public int menu_update(CafeMenuVo menu);
	//------------------------------------------------------------------------
	
	public int category_delete(int category_no);

	public int category_update_insert(CafeCategoryVo category);

	
}
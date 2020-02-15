package com.mvc.kiview.model.dao;

import java.util.List;

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
   
   public CafeVo cafe_selectone(int cafe_no);
   
   public int menu_insert(CafeMenuVo vo);
   
   public int category_insert(String cat);
   
   public int cafe_join(CafeMemberVo vo);

   public List<CafeVo> cafe_search(String keyword);
   
   
   
}
package com.mvc.kiview.model.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mvc.kiview.model.dao.CafeDao;
import com.mvc.kiview.model.vo.CafeMemberVo;
import com.mvc.kiview.model.vo.CafeMenuVo;
import com.mvc.kiview.model.vo.CafeVo;

@Service
public class CafeBizImpl implements CafeBiz{
   
   @Autowired
   private CafeDao dao;
// ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ수정ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ   
   @Override
   public List<CafeVo> cafe_Ulist(int member_no) {
      
      return dao.cafe_Ulist(member_no);
   }
   @Override
   public List<CafeVo> cafe_Alist(String member_id){
      return dao.cafe_Alist(member_id);
   }   
   @Override
   public CafeMemberVo cafe_regyn(CafeMemberVo regyn) {
      
      return dao.cafe_regyn(regyn);
   }
// ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
   @Override
   public int cafe_insert(CafeVo vo) {
      
      return dao.cafe_insert(vo);
   }

   @Override
   public CafeVo cafe_selectone(int cafe_no) {
      
      return dao.cafe_selectone(cafe_no);
   }

   
   @Transactional
   @Override
   public int menu_insert(CafeMenuVo vo, String cat1, String cat2, String cat3) {
      
      int res = dao.menu_insert(vo);
      
      if(cat1!=null) {
         res += dao.category_insert(cat1);
         
      } 
      
      if(cat2!=null) {
         res += dao.category_insert(cat2);
         
      } 
      
      if(cat3!=null) {
         res += dao.category_insert(cat3);
         
      } 
      
      
      return res;
   }
   
   
   @Override
   public int category_insert(String cat) {
      
      return dao.category_insert(cat);
   }

   
   @Override
   public int cafe_join(CafeMemberVo vo) {
      
      return dao.cafe_join(vo);
   }
   
   
   

   

}
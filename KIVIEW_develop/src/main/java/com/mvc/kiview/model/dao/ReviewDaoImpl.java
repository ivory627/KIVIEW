package com.mvc.kiview.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mvc.kiview.model.vo.ReviewVo;

@Repository
public class ReviewDaoImpl implements ReviewDao{

   @Autowired
   private SqlSessionTemplate sqlSession;
   
   @Override
   public List<ReviewVo> reviewList() {
      
      List<ReviewVo> list = new ArrayList<ReviewVo>();
      
      try {
         list = sqlSession.selectList(namespace + "reviewList");
      } catch(Exception e) {
         System.out.println("error : 리뷰 리스트");
         e.printStackTrace();
      }
      
      return list;
   }

   @Override
   public int reviewInsert() {
      // TODO Auto-generated method stub
      return 0;
   }

   @Override
   public int reviewUpdate() {
      // TODO Auto-generated method stub
      return 0;
   }

   @Override
   public int reviewDelete() {
      // TODO Auto-generated method stub
      return 0;
   }

   @Override
   public int reviewSearch() {
      // TODO Auto-generated method stub
      return 0;
   }

}
package com.mvc.kiview.model.dao;

import java.util.List;
import java.util.Map;

import com.mvc.kiview.model.vo.CafeBoardVo;
import com.mvc.kiview.model.vo.CafeMenuVo;
import com.mvc.kiview.model.vo.FavoriteVo;
import com.mvc.kiview.model.vo.KinderVo;

import com.mvc.kiview.model.vo.LikeVo;
import com.mvc.kiview.model.vo.ReviewVo;

public interface LikeDao {
   String namespace = "like.";

   //좋아요
   public int selectLikeCount(LikeVo vo);
   public int likeInsert(LikeVo vo);
   public int likeDelete(LikeVo vo);

   
   public List<LikeVo> selectAll();
   public List<LikeVo> selectMy(int member_no);
   
   //내가 쓴 리뷰
   public List<ReviewVo> myReview(String member_id);
  
   //내가 쓴 카페 글
   public List<CafeBoardVo> myBoard(String member_id);
   public List<CafeBoardVo> myBoard_paging(Map boardMap);
   public List<CafeMenuVo> myMenu();
  
   //나의 즐겨찾기
   public List<KinderVo> myFavorite(String member_id);


 //즐겨찾기
   
   public int favoriteDeleteCount(FavoriteVo vo);
   public int favoriteInsertCount(FavoriteVo vo);

   //지민 추가
   
 public FavoriteVo selectFavorite(FavoriteVo vo);

   
}
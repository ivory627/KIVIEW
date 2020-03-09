package com.mvc.kiview.model.biz;


import java.util.List;

import com.mvc.kiview.model.vo.CafeBoardVo;
import com.mvc.kiview.model.vo.CafeMenuVo;
import com.mvc.kiview.model.vo.FavoriteVo;
import com.mvc.kiview.model.vo.KinderVo;

import com.mvc.kiview.model.vo.LikeVo;
import com.mvc.kiview.model.vo.ReviewVo;

public interface LikeBiz {
   
   //좋아요
   public int selectLikeCount(LikeVo vo);
   public int likeInsert(LikeVo vo);
   public int likeDelete(LikeVo vo);
   
   //즐겨찾기
   public int selectFavoriteCount(FavoriteVo vo);
   public int favoriteDelete(FavoriteVo vo);
   public int favoriteInsert(FavoriteVo vo);
   
   
   public List<LikeVo> selectAll();
   public List<LikeVo> selectMy(int member_no);
 
   //내가 쓴 리뷰
   public List<ReviewVo> myReview(String member_id);
   
   //내가 쓴 카페 글
   public List<CafeBoardVo> myBoard(String member_id);
   public List<CafeMenuVo> myMenu();
   
   //나의 즐겨찾기
   public List<KinderVo> myFavorite(String member_id);
	


   
   
}
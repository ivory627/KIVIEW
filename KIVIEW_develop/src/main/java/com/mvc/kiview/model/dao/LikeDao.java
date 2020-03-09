package com.mvc.kiview.model.dao;

import com.mvc.kiview.model.vo.FavoriteVo;
import com.mvc.kiview.model.vo.LikeVo;

public interface LikeDao {
   String namespace = "like.";

   public int selectLikeCount(LikeVo vo);
   public int likeInsert(LikeVo vo);
   public int likeDelete(LikeVo vo);

 //즐겨찾기
   public int selectFavoriteCount(FavoriteVo vo);
   public int favoriteDeleteCount(FavoriteVo vo);
   public int favoriteInsertCount(FavoriteVo vo);
   
}
package com.mvc.kiview.model.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.kiview.model.dao.LikeDao;
import com.mvc.kiview.model.vo.FavoriteVo;
import com.mvc.kiview.model.vo.LikeVo;

@Service
public class LikeBizImpl implements LikeBiz{
   
   @Autowired
   private LikeDao dao;

   @Override
   public int selectLikeCount(LikeVo vo) {
      return dao.selectLikeCount(vo);
   }
   
   @Override
   public int likeInsert(LikeVo vo) {
      return dao.likeInsert(vo);
   }

   @Override
   public int likeDelete(LikeVo vo) {
      return dao.likeDelete(vo);
   }
   
   @Override
   public int selectFavoriteCount(FavoriteVo vo) {
      return dao.selectFavoriteCount(vo);
   }
   
   @Override
   public int favoriteDelete(FavoriteVo vo) {
      return dao.favoriteDeleteCount(vo);
   }
   
   @Override
   public int favoriteInsert(FavoriteVo vo) {
      return dao.favoriteInsertCount(vo);
   }
   

}
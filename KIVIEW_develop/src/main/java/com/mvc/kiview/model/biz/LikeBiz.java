package com.mvc.kiview.model.biz;

import com.mvc.kiview.model.vo.LikeVo;

public interface LikeBiz {
   
   public int selectLikeCount(LikeVo vo);
   public int likeInsert(LikeVo vo);
   public int likeDelete(LikeVo vo);

   
   
}
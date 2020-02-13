package com.mvc.kiview.model.biz;

import java.util.List;

import com.mvc.kiview.model.vo.CafeVo;

public interface CafeBiz {
	public List<CafeVo> selectAll();
	
	public int cafe_insert(CafeVo vo);
	
	public List<CafeVo> cafe_my(String id);

}

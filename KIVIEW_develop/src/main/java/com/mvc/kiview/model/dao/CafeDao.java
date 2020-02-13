package com.mvc.kiview.model.dao;

import java.util.List;

import com.mvc.kiview.model.vo.CafeVo;

public interface CafeDao {
	String namespace = "cafe."; 
	
	public List<CafeVo> selectAll(String id);
	
	public int cafe_insert(CafeVo vo);
	
	public List<CafeVo> cafe_my(String id);
}

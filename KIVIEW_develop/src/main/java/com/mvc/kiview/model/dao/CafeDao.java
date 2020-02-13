package com.mvc.kiview.model.dao;

import java.util.List;

import com.mvc.kiview.model.vo.CafeVo;

public interface CafeDao {
	String namespace = "cafe."; 
	
	public List<CafeVo> selectAll(int member_no);
	
	public int cafe_insert(CafeVo vo);
	
	
}

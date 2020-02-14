package com.mvc.kiview.model.biz;

import java.util.List;

import com.mvc.kiview.model.vo.CafeMenuVo;
import com.mvc.kiview.model.vo.CafeVo;

public interface CafeBiz {
	public List<CafeVo> selectAll(int member_no);
	
	public int cafe_insert(CafeVo vo);
	
	public CafeVo cafe_selectone(int cafe_no);
	
	public int menu_insert(CafeMenuVo vo, String cat1, String cat2, String cat3);
	
	public int category_insert(String cat);
	
	
	
	

}

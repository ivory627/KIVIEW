package com.mvc.kiview.model.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.kiview.model.dao.CafeDao;
import com.mvc.kiview.model.vo.CafeVo;

@Service
public class CafeBizImpl implements CafeBiz{
	
	@Autowired
	private CafeDao dao;
	
	@Override
	public List<CafeVo> selectAll(int member_no) {
		
		return dao.selectAll(member_no);
	}

	@Override
	public int cafe_insert(CafeVo vo) {
		
		return dao.cafe_insert(vo);
	}

	

}

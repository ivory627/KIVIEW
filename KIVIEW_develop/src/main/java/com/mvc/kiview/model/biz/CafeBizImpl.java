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
	public List<CafeVo> selectAll() {
		
		return dao.selectAll();
	}

	@Override
	public int cafe_insert(CafeVo vo) {
		
		return dao.cafe_insert(vo);
	}

	@Override
	public List<CafeVo> cafe_my(String id) {
		
		return dao.cafe_my(id);
	}

}

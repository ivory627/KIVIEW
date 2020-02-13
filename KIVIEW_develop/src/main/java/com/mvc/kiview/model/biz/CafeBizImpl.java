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
		// TODO Auto-generated method stub
		return dao.selectAll();
	}

}

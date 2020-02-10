package com.mvc.kiview.model.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.kiview.model.dao.LikeDao;

@Service
public class LikeBizImpl implements LikeBiz{
	
	@Autowired
	private LikeDao dao;
	
	@Override
	public String SelectLike(int reviewno, String memberno) {
		// TODO Auto-generated method stub
		return dao.SelectLike(reviewno, memberno);
	}

	@Override
	public String UpdateLike(int reviewno, String memberno) {
		// TODO Auto-generated method stub
		return dao.UpdateLike(reviewno, memberno);
	}

	@Override
	public String DeleteLike(int reviewno, String memberno) {
		// TODO Auto-generated method stub
		return dao.DeleteLike(reviewno, memberno);
	}

}

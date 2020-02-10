package com.mvc.kiview.model.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.kiview.model.dao.KinderDao;
import com.mvc.kiview.model.vo.KinderVo;

@Service
public class KinderBizImpl implements KinderBiz {
	
	@Autowired
	private KinderDao dao;

	@Override
	public List<KinderVo> LocalSerach(String province, String city, String town) {
		
		return dao.LocalSerach(province, city, town);
	}

	@Override
	public List<KinderVo> TypeSearch(String type) {
		
		return dao.TypeSearch(type);
	}

	@Override
	public List<KinderVo> NameSearch(String name) {
		
		return dao.NameSearch(name);
	}

	@Override
	public List<KinderVo> Kinderdetail(String kinderno) {
		
		return dao.Kinderdetail(kinderno);
	}

}

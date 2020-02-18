package com.mvc.kiview.model.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.kiview.model.dao.KinderDao;
import com.mvc.kiview.model.vo.KinderVo;
import com.mvc.kiview.model.vo.ProvinceVo;

@Service
public class KinderBizImpl implements KinderBiz {
	
	@Autowired
	private KinderDao dao;

	@Override
	public List<KinderVo> LocalSerach(ProvinceVo vo) {
		
		return dao.LocalSerach(vo);
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
	public KinderVo Kinderdetail(int kinder_no) {
		
		return dao.Kinderdetail(kinder_no);
	}

	@Override
	public List<ProvinceVo> ProvinceList() {

		return dao.ProvinceList();
	}

	@Override
	public List<ProvinceVo> CityList(String province) {

		return dao.CityList(province);
	}

	@Override
	public List<ProvinceVo> TownList(String city) {

		return dao.TownList(city);
	}

}

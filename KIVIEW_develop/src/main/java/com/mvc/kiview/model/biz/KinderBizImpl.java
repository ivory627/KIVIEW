package com.mvc.kiview.model.biz;

import java.util.HashMap;
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
	public List<KinderVo> TypeSearch(HashMap<String, String> map) {
		
		return dao.TypeSearch(map);
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

	@Override
	public List<KinderVo> KinderList(String keyword) {

		return dao.KinderList(keyword);
	}

	@Override
	public List<KinderVo> KinderListAll() {

		return dao.KinderListAll();
	}

	@Override
	public KinderVo Kinderdetail(String keyword) {

		return dao.Kinderdetail(keyword);
	}

	@Override
	public List<KinderVo> mapSearch(HashMap<String, String> map) {
		return dao.mapSearch(map);
	}

}

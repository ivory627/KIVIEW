package com.mvc.kiview.model.dao;

import java.util.HashMap;
import java.util.List;

import com.mvc.kiview.model.vo.Criteria;
import com.mvc.kiview.model.vo.KinderVo;
import com.mvc.kiview.model.vo.ProvinceVo;
import com.mvc.kiview.model.vo.ReviewVo;

public interface KinderDao {
	String namespace = "kinder.";
	
	public List<KinderVo> LocalSerach(ProvinceVo vo);
	public List<KinderVo> TypeSearch(HashMap<String, String> map);
	public List<KinderVo> NameSearch(String name);
	public KinderVo Kinderdetail(int kinder_no);
	public List<ProvinceVo> ProvinceList();
	public List<ProvinceVo> CityList(String province);
	public List<ProvinceVo> TownList(String city);
	public List<KinderVo> KinderList(String keyword);
	public List<KinderVo> KinderListAll();
	public KinderVo Kinderdetail(String keyword);
	public List<KinderVo> mapSearch(HashMap<String, String> map);
	public List<ReviewVo> ReviewList(int kinder_no, Criteria cri);
	public int ReviewCnt(int kinder_no);
}

package com.mvc.kiview.model.dao;

import java.util.List;

import com.mvc.kiview.model.vo.KinderVo;

public interface KinderDao {
	String namespace = "kinder.";
	
	public List<KinderVo> LocalSerach(String province, String city, String town);
	public List<KinderVo> TypeSearch(String type);
	public List<KinderVo> NameSearch(String name);
	public List<KinderVo> Kinderdetail(String kinderno);
}

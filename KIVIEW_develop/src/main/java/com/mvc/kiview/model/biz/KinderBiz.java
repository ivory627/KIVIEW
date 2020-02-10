package com.mvc.kiview.model.biz;

import java.util.List;

import com.mvc.kiview.model.vo.KinderVo;

public interface KinderBiz {
	public List<KinderVo> LocalSerach(String province, String city, String town);
	public List<KinderVo> TypeSearch(String type);
	public List<KinderVo> NameSearch(String name);
	public List<KinderVo> Kinderdetail(String kinderno);


}

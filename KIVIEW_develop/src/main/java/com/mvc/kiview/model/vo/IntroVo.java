package com.mvc.kiview.model.vo;

import java.util.Date;

public class IntroVo {
	private int intro_no;
	private String cat_detail;
	private String intro_title;
	private String intro_content;
	private String intro_writer;
	private Date intro_date;
	private int intro_hit;
	
	public int getIntro_no() {
		return intro_no;
	}
	public void setIntro_no(int intro_no) {
		this.intro_no = intro_no;
	}
	public String getCat_detail() {
		return cat_detail;
	}
	public void setCat_detail(String cat_detail) {
		this.cat_detail = cat_detail;
	}
	public String getIntro_title() {
		return intro_title;
	}
	public void setIntro_title(String intro_title) {
		this.intro_title = intro_title;
	}
	public String getIntro_content() {
		return intro_content;
	}
	public void setIntro_content(String intro_content) {
		this.intro_content = intro_content;
	}
	public String getIntro_writer() {
		return intro_writer;
	}
	public void setIntro_writer(String intro_writer) {
		this.intro_writer = intro_writer;
	}
	public Date getIntro_date() {
		return intro_date;
	}
	public void setIntro_date(Date intro_date) {
		this.intro_date = intro_date;
	}
	public int getIntro_hit() {
		return intro_hit;
	}
	public void setIntro_hit(int intro_hit) {
		this.intro_hit = intro_hit;
	}
	@Override
	public String toString() {
		return "IntroVo [intro_no=" + intro_no + ", cat_detail=" + cat_detail + ", intro_title=" + intro_title
				+ ", intro_content=" + intro_content + ", intro_writer=" + intro_writer + ", intro_date=" + intro_date
				+ ", intro_hit=" + intro_hit + "]";
	}
	
	

}

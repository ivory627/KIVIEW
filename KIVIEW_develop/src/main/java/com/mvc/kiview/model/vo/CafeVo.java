package com.mvc.kiview.model.vo;

public class CafeVo {
	private int cafe_no;
	private String title;
	private String admin;
	private String intro;
	private String thumb;
	private String background;
	private String restriction;
	public int getCafe_no() {
		return cafe_no;
	}
	public void setCafe_no(int cafe_no) {
		this.cafe_no = cafe_no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAdmin() {
		return admin;
	}
	public void setAdmin(String admin) {
		this.admin = admin;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public String getThumb() {
		return thumb;
	}
	public void setThumb(String thumb) {
		this.thumb = thumb;
	}
	public String getBackground() {
		return background;
	}
	public void setBackground(String background) {
		this.background = background;
	}
	public String getRestriction() {
		return restriction;
	}
	public void setRestriction(String restriction) {
		this.restriction = restriction;
	}
	@Override
	public String toString() {
		return "CafeVo [cafe_no=" + cafe_no + ", title=" + title + ", admin=" + admin + ", intro=" + intro + ", thumb="
				+ thumb + ", background=" + background + ", restriction=" + restriction + "]";
	} 
	
	

}

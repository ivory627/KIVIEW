package com.mvc.kiview.model.vo;

public class FavoriteVo {
	private int favorite_no;
	private int kinder_no;
	private int member_no;
	private String favoriteyn;
	
	public int getFavorite_no() {
		return favorite_no;
	}
	public void setFavorite_no(int favorite_no) {
		this.favorite_no = favorite_no;
	}
	public int getKinder_no() {
		return kinder_no;
	}
	public void setKinder_no(int kinder_no) {
		this.kinder_no = kinder_no;
	}
	public int getMember_no() {
		return member_no;
	}
	public void setMember_no(int member_no) {
		this.member_no = member_no;
	}
	public String getFavoriteyn() {
		return favoriteyn;
	}
	public void setFavoriteyn(String favoriteyn) {
		this.favoriteyn = favoriteyn;
	}
	@Override
	public String toString() {
		return "FavoriteVo [favorite_no=" + favorite_no + ", kinder_no=" + kinder_no + ", member_no=" + member_no
				+ ", favoriteyn=" + favoriteyn + "]";
	}
	
	

}

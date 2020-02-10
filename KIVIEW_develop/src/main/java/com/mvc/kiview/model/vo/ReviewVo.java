package com.mvc.kiview.model.vo;

import java.util.Date;

public class ReviewVo {
	private int review_no;
	private String name;
	private int avg_score1;
	private int avg_score2;
	private int avg_score3;
	private String review_title;
	private String review_content;
	private String review_writer;
	private Date review_date;
	public int getReview_no() {
		return review_no;
	}
	public void setReview_no(int review_no) {
		this.review_no = review_no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAvg_score1() {
		return avg_score1;
	}
	public void setAvg_score1(int avg_score1) {
		this.avg_score1 = avg_score1;
	}
	public int getAvg_score2() {
		return avg_score2;
	}
	public void setAvg_score2(int avg_score2) {
		this.avg_score2 = avg_score2;
	}
	public int getAvg_score3() {
		return avg_score3;
	}
	public void setAvg_score3(int avg_score3) {
		this.avg_score3 = avg_score3;
	}
	public String getReview_title() {
		return review_title;
	}
	public void setReview_title(String review_title) {
		this.review_title = review_title;
	}
	public String getReview_content() {
		return review_content;
	}
	public void setReview_content(String review_content) {
		this.review_content = review_content;
	}
	public String getReview_writer() {
		return review_writer;
	}
	public void setReview_writer(String review_writer) {
		this.review_writer = review_writer;
	}
	public Date getReview_date() {
		return review_date;
	}
	public void setReview_date(Date review_date) {
		this.review_date = review_date;
	}
	@Override
	public String toString() {
		return "ReviewVo [review_no=" + review_no + ", name=" + name + ", avg_score1=" + avg_score1 + ", avg_score2="
				+ avg_score2 + ", avg_score3=" + avg_score3 + ", review_title=" + review_title + ", review_content="
				+ review_content + ", review_writer=" + review_writer + ", review_date=" + review_date + "]";
	}
	
	

}

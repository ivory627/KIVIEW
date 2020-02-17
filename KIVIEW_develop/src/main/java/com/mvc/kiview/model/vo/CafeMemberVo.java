package com.mvc.kiview.model.vo;

import java.util.Date;

public class CafeMemberVo {
	private int cafe_member_no;
	private int member_no;
	private int cafe_no;
	private String answer;
	private String signyn;
	private String blockyn;
	private Date signdate;
	
	
	
	public CafeMemberVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CafeMemberVo(int member_no, String answer, String signyn) {
		super();
		this.member_no = member_no;
		this.answer = answer;
		this.signyn = signyn;
		
	}
	public int getCafe_member_no() {
		return cafe_member_no;
	}
	public void setCafe_member_no(int cafe_member_no) {
		this.cafe_member_no = cafe_member_no;
	}
	public int getMember_no() {
		return member_no;
	}
	public void setMember_no(int member_no) {
		this.member_no = member_no;
	}
	public int getCafe_no() {
		return cafe_no;
	}
	public void setCafe_no(int cafe_no) {
		this.cafe_no = cafe_no;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getSignyn() {
		return signyn;
	}
	public void setSignyn(String signyn) {
		this.signyn = signyn;
	}
	public String getBlockyn() {
		return blockyn;
	}
	public void setBlockyn(String blockyn) {
		this.blockyn = blockyn;
	}
	public Date getSigndate() {
		return signdate;
	}
	public void setSigndate(Date signdate) {
		this.signdate = signdate;
	}
	@Override
	public String toString() {
		return "CafeMemberVo [cafe_member_no=" + cafe_member_no + ", member_no=" + member_no + ", cafe_no=" + cafe_no
				+ ", answer=" + answer + ", signyn=" + signyn + ", blockyn=" + blockyn + ", signdate=" + signdate + "]";
	}
	
	

}

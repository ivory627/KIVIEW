package com.mvc.kiview.model.vo;

import java.util.Date;

public class CafeChatVo {
	private int cafe_chat_no;
	private int cafe_no;
	private String writer;
	private String msg;
	private Date senddate;
	
	CafeChatVo(){}

	public int getCafe_chat_no() {
		return cafe_chat_no;
	}

	public void setCafe_chat_no(int cafe_chat_no) {
		this.cafe_chat_no = cafe_chat_no;
	}

	public int getCafe_no() {
		return cafe_no;
	}

	public void setCafe_no(int cafe_no) {
		this.cafe_no = cafe_no;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Date getSenddate() {
		return senddate;
	}

	public void setSenddate(Date senddate) {
		this.senddate = senddate;
	}

	@Override
	public String toString() {
		return "CafeChatVo [cafe_chat_no=" + cafe_chat_no + ", cafe_no=" + cafe_no + ", writer=" + writer + ", msg="
				+ msg + ", senddate=" + senddate + "]";
	}
	
	
	
	
}

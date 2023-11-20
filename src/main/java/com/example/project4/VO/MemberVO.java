package com.example.project4.VO;

import java.util.Date;

public class MemberVO {
	private int sid;
	private String userid;
	private String password;
	private String username;
	private String email;
	private String detail;
	private Date regdate;

	public int getSid() { return sid; }
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPassword() { return password; }
	public void setPassword(String password) { this.password = password; }
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDetail() { return detail; }
	public void setDetail(String detail) { this.detail = detail; }
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
}

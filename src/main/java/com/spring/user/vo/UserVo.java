package com.spring.user.vo;

public class UserVo {
	private String	memId;
	private String	memPwd;
	private String	memNick;
	private String	memPhone;
	private String	regdate;
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public String getMemPwd() {
		return memPwd;
	}
	public void setMemPwd(String memPwd) {
		this.memPwd = memPwd;
	}
	public String getMemNick() {
		return memNick;
	}
	public void setMemNick(String memNick) {
		this.memNick = memNick;
	}
	public String getMemPhone() {
		return memPhone;
	}
	public void setMemPhone(String memPhone) {
		this.memPhone = memPhone;
	}

	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public UserVo(String memId, String memPwd, String memNick, String memPhone,  String regdate) {
		this.memId = memId;
		this.memPwd = memPwd;
		this.memNick = memNick;
		this.memPhone = memPhone;
		
		this.regdate = regdate;
	}
	public UserVo() {
	}
	
}

 package com.spring.pds.vo;

public class PdsVo {
	//게시물fields
	private int	idx;
	private int	lookcnt;
	private String	title;
	private String	cntx;
	private String	memid;
	private String	mempwd;
	private int	likecnt;
	private String	regdate;
	//답글처리 
	private int	fnum;
	private int	lvl;
	private int	step;
	private int	pnum;
	
	private String	del_yn;

	private String	menuid;
	//메뉴
	private String  menuname;
	private int  menuidx;
	//파일관련 정보
	private String fileName;
	//페이징 관련자료 추후 추가예정

	//Getter&Setter
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public int getLookcnt() {
		return lookcnt;
	}
	public void setLookcnt(int lookcnt) {
		this.lookcnt = lookcnt;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCntx() {
		return cntx;
	}
	public void setCntx(String cntx) {
		this.cntx = cntx;
	}
	public String getMemid() {
		return memid;
	}
	public void setMemid(String memid) {
		this.memid = memid;
	}
	public String getMempwd() {
		return mempwd;
	}
	public void setMempwd(String mempwd) {
		this.mempwd = mempwd;
	}
	public int getLikecnt() {
		return likecnt;
	}
	public void setLikecnt(int likecnt) {
		this.likecnt = likecnt;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public int getFnum() {
		return fnum;
	}
	public void setFnum(int fnum) {
		this.fnum = fnum;
	}
	public int getLvl() {
		return lvl;
	}
	public void setLvl(int lvl) {
		this.lvl = lvl;
	}
	public int getStep() {
		return step;
	}
	public void setStep(int step) {
		this.step = step;
	}
	public int getPnum() {
		return pnum;
	}
	public void setPnum(int pnum) {
		this.pnum = pnum;
	}
	public String getDel_yn() {
		return del_yn;
	}
	public void setDel_yn(String del_yn) {
		this.del_yn = del_yn;
	}
	public String getMenuid() {
		return menuid;
	}
	public void setMenuid(String menuid) {
		this.menuid = menuid;
	}
	public String getMenuname() {
		return menuname;
	}
	public void setMenuname(String menuname) {
		this.menuname = menuname;
	}
	public int getMenuidx() {
		return menuidx;
	}
	public void setMenuidx(int menuidx) {
		this.menuidx = menuidx;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	//Constructor
	public PdsVo(int idx, int lookcnt, String title, String cntx, String memid, String mempwd, int likecnt,
			String regdate, int fnum, int lvl, int step, int pnum, String del_yn, String menuid, String menuname,
			int menuidx, String fileName) {
		this.idx = idx;
		this.lookcnt = lookcnt;
		this.title = title;
		this.cntx = cntx;
		this.memid = memid;
		this.mempwd = mempwd;
		this.likecnt = likecnt;
		this.regdate = regdate;
		this.fnum = fnum;
		this.lvl = lvl;
		this.step = step;
		this.pnum = pnum;
		this.del_yn = del_yn;
		this.menuid = menuid;
		this.menuname = menuname;
		this.menuidx = menuidx;
		this.fileName = fileName;
	}
	public PdsVo() {}
		
	
	
	
}

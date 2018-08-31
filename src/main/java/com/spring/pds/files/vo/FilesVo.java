package com.spring.pds.files.vo;

public class FilesVo {
	//fileds
	private int fileNum;
	private String fileName;
	private String fileExt;
	private String sfileName;
	//Getter Setter
	public int getFileNum() {
		return fileNum;
	}
	public void setFileNum(int fileNum) {
		this.fileNum = fileNum;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileExt() {
		return fileExt;
	}
	public void setFileExt(String fileExt) {
		this.fileExt = fileExt;
	}
	public String getSfileName() {
		return sfileName;
	}
	public void setSfileName(String sfileName) {
		this.sfileName = sfileName;
	}
	//Constructor
	public FilesVo(int fileNum, String fileName, String fileExt, String sfileName) {
		
		this.fileNum = fileNum;
		this.fileName = fileName;
		this.fileExt = fileExt;
		this.sfileName = sfileName;
	}
	public FilesVo() {
		
	}
	
}

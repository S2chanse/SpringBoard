package com.spring.menu.vo;

public class MenuVo {
	private String menuId;
	private String menuName;
	private int menuIdx;
	//getter&setter
	public String getMenuId() {
		return menuId;
	}
	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public int getMenuIdx() {
		return menuIdx;
	}
	public void setMenuIdx(int i) {
		this.menuIdx = i;
	}
	//Generator
	public MenuVo() {}
	public MenuVo(String menuId, String menuName, int menuIdx) {
		this.menuId = menuId;
		this.menuName = menuName;
		this.menuIdx = menuIdx;
	}
	
	//toString
	@Override
	public String toString() {
		return "MenuVo [menuId=" + menuId + ", menuName=" + menuName + ", menuIdx=" + menuIdx + "]";
	}
	
	
	
}

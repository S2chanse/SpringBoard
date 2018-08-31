package com.spring.menu.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;

import com.spring.menu.vo.MenuVo;

public interface MenuService {
	public List<MenuVo> getList();
	public void addMenu(@RequestParam HashMap<String, Object> map);
	public void delMenu(@RequestParam HashMap<String, Object> map);
	public void updMenu(@RequestParam HashMap<String, Object> map);
	public void cngMenuSeq(@RequestParam HashMap<String, Object> map);
}

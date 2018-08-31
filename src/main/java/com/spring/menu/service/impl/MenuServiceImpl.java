package com.spring.menu.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.menu.dao.MenuDao;
import com.spring.menu.service.MenuService;
import com.spring.menu.vo.MenuVo;

@Service("menuService")
public class MenuServiceImpl implements MenuService {

	@Autowired
	private MenuDao menuDao;

	@Override
	public List<MenuVo> getList() {
		List<MenuVo> list=menuDao.getList();
		return list;
	}

	@Override
	public void addMenu(HashMap<String, Object> map) {
		menuDao.addMenu(map);
		
	}

	@Override
	public void delMenu(HashMap<String, Object> map) {
		menuDao.delMenu(map);
		
	}

	@Override
	public void updMenu(HashMap<String, Object> map) {
		menuDao.updMenu(map);
		
	}

	@Override
	public void cngMenuSeq(HashMap<String, Object> map) {
		
		menuDao.cngMenuSeq(map);
		
	}

}

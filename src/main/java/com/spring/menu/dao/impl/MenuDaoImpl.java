package com.spring.menu.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.menu.dao.MenuDao;
import com.spring.menu.vo.MenuVo;

@Repository("menuDao")
public class MenuDaoImpl implements MenuDao {

	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<MenuVo> getList() {
		HashMap<String,Object>map=new HashMap<String,Object>();
		sqlSession.selectList("Menu.GetMenuList", map);	
		return (List<MenuVo>) map.get("result");
	}

	@Override
	public void addMenu(HashMap<String, Object> map) {
		sqlSession.insert("Menu.InMenu",map);
		
	}

	@Override
	public void delMenu(HashMap<String, Object> map) {
		sqlSession.delete("Menu.DelMenu",map);
		
	}

	@Override
	public void updMenu(HashMap<String, Object> map) {
		/*System.out.println("--------------------2"+map.get("menuName"));
		System.out.println("--------------------2"+map.get("menuId"));
		*/sqlSession.update("Menu.UpdMenu",map);
		
	}


	@Override
	public void cngMenuSeq(HashMap<String, Object> map) {
		
		sqlSession.update("Menu.CngMenuSeq",map);
		
	}

}

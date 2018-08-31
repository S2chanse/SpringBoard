package com.spring.board.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.board.dao.BoardDao;
import com.spring.board.vo.BoardVo;

@Repository("boardDao")
public class BoardDaoImpl implements BoardDao {

	@Autowired
	private SqlSession sqlSession;

	@Override
	public void addboard(HashMap<String, Object> map) {
		sqlSession.insert("Board.BoardInsert",map);		
	}

	@Override
	public List<BoardVo> getList(HashMap<String, Object> map) {
		sqlSession.selectList("Board.GetList",map);
		List<BoardVo>list=(List<BoardVo>) map.get("result");
		return list;
	}

	@Override
	public List<BoardVo> getRow(HashMap<String, Object> map) {
		/*System.out.println("아이디엑스"+map.get("idx"));
		System.out.println("메뉴아이디"+map.get("menuId"));*/
		sqlSession.selectOne("Board.GetRow",map);
		List<BoardVo>list=(List<BoardVo>) map.get("result");
		return list;
	}

	@Override
	public void updateBoard(HashMap<String, Object> map) {
		sqlSession.update("Board.UpdateBoard",map);
		
	}

	@Override
	public void deleteBoard(HashMap<String, Object> map) {
		sqlSession.delete("Board.DeleteBoard",map);
		
	}

	@Override
	public void addLookCnt(HashMap<String, Object> map) {
		sqlSession.update("Board.UpdateLookCnt",map);
		
	}

	@Override
	public int getRowCnt(HashMap<String, Object> map) {
		sqlSession.selectOne("Board.getRowCnt",map);
		int num=(int) map.get("allRowCnt");
		//System.out.println("------------------------"+num);
		return num;
	}
	

}

package com.spring.board.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;

import com.spring.board.vo.BoardVo;

public interface BoardDao {
	public void addboard(@RequestParam HashMap<String, Object> map);

	public List<BoardVo> getList(HashMap<String, Object> map);

	public List<BoardVo> getRow(HashMap<String, Object> map);

	public void updateBoard(HashMap<String, Object> map);

	public void deleteBoard(HashMap<String, Object> map);

	public void addLookCnt(HashMap<String, Object> map);
	
	public int getRowCnt(HashMap<String, Object> map);
}

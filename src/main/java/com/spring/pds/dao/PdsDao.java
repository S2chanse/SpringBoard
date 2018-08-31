package com.spring.pds.dao;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.spring.pds.files.vo.FilesVo;
import com.spring.pds.vo.PdsVo;

public interface PdsDao {
	public List<PdsVo> getPdsList(HashMap<String,Object> map);

	public void addPdsRow(HashMap<String, Object> map);

	List<PdsVo> getPdsRow(HashMap<String, Object> map);

	public List<FilesVo> getFilesList(HashMap<String, Object> map);

	public void deleteFiles(HashMap<String, Object> map);

	public void updatePds(HashMap<String, Object> map);

	public boolean delOnlyFiles(HashMap<String, Object> map);
}

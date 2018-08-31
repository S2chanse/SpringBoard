package com.spring.pds.service;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.pds.files.vo.FilesVo;
import com.spring.pds.vo.PdsVo;

public interface PdsService {
	public List<PdsVo> getPdsList(HashMap<String,Object> map);

	public void addPdsRow(HashMap<String, Object> map, HttpServletRequest req);

	List<PdsVo> getPdsRow(HashMap<String, Object> map);

	public List<FilesVo> getFilesList(HashMap<String, Object> map);

	public void delFiles(HashMap<String, Object> map);

	public void updatePds(HashMap<String, Object> map, HttpServletRequest req);

	public boolean delOnlyFiles(HashMap<String, Object> map);
}

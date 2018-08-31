package com.spring.pds.dao.imple;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.pds.dao.PdsDao;
import com.spring.pds.files.vo.FilesVo;
import com.spring.pds.vo.PdsVo;

@Repository("pdsDao")
public class PdsDaoImpl implements PdsDao {
	@Autowired
	private SqlSession sqlSession;
	@Override
	public List<PdsVo> getPdsList(HashMap<String, Object> map) {
		sqlSession.selectList("PDS.PdsGetList", map);
		List<PdsVo>list=(List<PdsVo>) map.get("result");
		return list;
	}
	@Override
	public void addPdsRow(HashMap<String, Object> map) {
		sqlSession.insert("PDS.PdsInsert",map);
		
	}
	@Override
	public List<PdsVo> getPdsRow(HashMap<String, Object> map) {
		System.out.println("1111111111111111111111");
		sqlSession.selectList("PDS.PdsGetRow", map);
		System.out.println(map);
		List<PdsVo>list=(List<PdsVo>) map.get("result");
		return list;
	}
	@Override
	public List<FilesVo> getFilesList(HashMap<String, Object> map) {
		sqlSession.selectList("PDS.GetFiles",map);
		List<FilesVo> list=(List<FilesVo>) map.get("result");
		return list;
	}
	@Override
	public void deleteFiles(HashMap<String, Object> map) {
		List<PdsVo>list=(List<PdsVo>) map.get("result");
		map.put("fnum", list.get(0).getFnum());
		sqlSession.delete("PDS.DelFiles",map);
		
	}
	@Override
	public void updatePds(HashMap<String, Object> map) {
		sqlSession.update("PDS.UpdatePds",map);
		
	}
	@Override
	public boolean delOnlyFiles(HashMap<String, Object> map) {
		sqlSession.delete("PDS.delOnlyFile",map);
		return (boolean) map.get("result");
	}

}

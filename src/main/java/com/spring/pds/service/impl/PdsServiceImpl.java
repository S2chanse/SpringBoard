package com.spring.pds.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.spring.board.dao.BoardDao;
import com.spring.board.vo.BoardVo;
import com.spring.menu.vo.MenuVo;
import com.spring.pds.dao.PdsDao;
import com.spring.pds.files.vo.FilesVo;
import com.spring.pds.service.PdsService;
import com.spring.pds.vo.PdsVo;

@Service("pdsService")
public class PdsServiceImpl implements PdsService{
	@Autowired
	private PdsDao pdsDao;
	@Autowired
	private BoardDao boardDao;
	@Override
	public List<PdsVo> getPdsList(HashMap<String, Object> map) {
		if(map.get("menuId")==null) {
			List<MenuVo> list=(List<MenuVo>) map.get("menuList");
			map.put("menuId", list.get(0).getMenuId());
		}
		if(map.get("pnum")==null) {
			map.put("pnum", 1);	}
	//페이지카운트 넣어주기
		if(map.get("rowcnt")==null) {
			map.put("rowcnt", 10);}
		if(map.get("bnum")==null) {
			map.put("bnum",1);}	
		List<PdsVo>list=pdsDao.getPdsList(map);
		boardDao.getRowCnt(map);
		
		return list;
	}
	@Override
	public List<PdsVo> getPdsRow(HashMap<String, Object> map) {
		List<PdsVo>list=pdsDao.getPdsRow(map);
		return list;
	}
	
	@Override
	public void addPdsRow(HashMap<String, Object> map, HttpServletRequest req) {
		//업로드될 파일명과 같은 파일이 있는지 확인		
		/*
		 * 파일 업로드 비지니스 로직 시작
		 * 1. 입력받은 문자들은 Boarder 테이블에 저장
		 * 
		 * 2.(MultipartHttpServletRequest 객체가 담당)
		 * file들을 disk(upload파일)에 저장
		 * 
		 * 3.DaoImple을 통해 업로드된 파일정보들을 Files 테이블에 저장
		 * 
		 * */
		CheckFileName checkFile=new CheckFileName();
		
		//파일저장위치= d:\\uploadFile\\
		String filePath="d:\\upload\\";
		
		//업로드된 파일의 처리(폴더의 저장)
		MultipartHttpServletRequest mhsr=(MultipartHttpServletRequest) req;
		Iterator<String> iterator=mhsr.getFileNames();//Iterator 갯수 체크
		MultipartFile mf=null; 
		
		List<String> fileNames=new ArrayList<String>();
		List<String> fileExts=new ArrayList<String>();
		List<String> sfileNames=new ArrayList<String>();
		
		String fileName	   ="";
		String orgFileName ="";
		String fileExt	   ="";
		String sFileName   ="";
		int i=0;
		
		while (iterator.hasNext()) {
			mf=mhsr.getFile(iterator.next());
			HashMap<String,Object> hashmap=new HashMap();
			if(!mf.isEmpty()) {
				fileName=mf.getOriginalFilename();
				orgFileName=fileName.substring(0, fileName.lastIndexOf("."));
				
				fileExt=fileName.substring(fileName.lastIndexOf("."));
				
				//중복파일 존재하면 번호추가 후 실제 파일명 처리;
				sFileName=checkFile.getCheckFileName(filePath,orgFileName,fileExt);
				fileNames.add(fileName);
				fileExts.add(fileExt);
				sfileNames.add(sFileName);
				
				map.put("fileNames", fileNames);
				map.put("fileExts",fileExts);
				map.put("sFileNames", sfileNames);
				
				File file=new File(filePath+sFileName);
				i+=1;
				try {
					mf.transferTo(file);//실제파일명으로 저장
				}catch(IOException e) {
					System.out.println("오류: "+e.getMessage());
					e.printStackTrace();
				}
			}
			
		}
		//db에 정보 저장(Table:Board,Files);
		if(map.get("idx").equals("")) {
			map.put("fnum", 0);
		}else{
			
		}
		if(map.get("fileNames")==null) {
			boardDao.addboard(map);
		}else {			
			pdsDao.addPdsRow(map);
		}
	}
	@Override
	public List<FilesVo> getFilesList(HashMap<String, Object> map) {
		List<FilesVo> list=pdsDao.getFilesList(map);
		return list;
	}
	@Override
	public void delFiles(HashMap<String, Object> map) {
		List<FilesVo> fileList=pdsDao.getFilesList(map);
		for (FilesVo filesVo : fileList) {
			File file=new File("d:\\upload\\"+filesVo.getSfileName());
			if(file.exists()) {
				file.delete();
			}
		}
		List<PdsVo> list=pdsDao.getPdsRow(map);
		map.put("fnum", list.get(0).getFnum());
		pdsDao.deleteFiles(map);
		
	}
	@Override
	public void updatePds(HashMap<String, Object> map,HttpServletRequest req) {
		//업로드될 파일명과 같은 파일이 있는지 확인		
				/*
				 * 파일 업로드 비지니스 로직 시작
				 * 1. 입력받은 문자들은 Boarder 테이블에 저장
				 * 
				 * 2.(MultipartHttpServletRequest 객체가 담당)
				 * file들을 disk(upload파일)에 저장
				 * 
				 * 3.DaoImple을 통해 업로드된 파일정보들을 Files 테이블에 저장
				 * 
				 * */
				CheckFileName checkFile=new CheckFileName();
				
				//파일저장위치= d:\\uploadFile\\
				String filePath="d:\\upload\\";
				
				//업로드된 파일의 처리(폴더의 저장)
				MultipartHttpServletRequest mhsr=(MultipartHttpServletRequest) req;
				Iterator<String> iterator=mhsr.getFileNames();//Iterator 갯수 체크
				MultipartFile mf=null; 
				
				List<String> fileNames=new ArrayList<String>();
				List<String> fileExts=new ArrayList<String>();
				List<String> sfileNames=new ArrayList<String>();
				
				String fileName	   ="";
				String orgFileName ="";
				String fileExt	   ="";
				String sFileName   ="";
				int i=0;
				
				while (iterator.hasNext()) {
					mf=mhsr.getFile(iterator.next());
					HashMap<String,Object> hashmap=new HashMap();
					if(!mf.isEmpty()) {
						fileName=mf.getOriginalFilename();
						orgFileName=fileName.substring(0, fileName.lastIndexOf("."));
						
						fileExt=fileName.substring(fileName.lastIndexOf("."));
						
						//중복파일 존재하면 번호추가 후 실제 파일명 처리;
						sFileName=checkFile.getCheckFileName(filePath,orgFileName,fileExt);
						fileNames.add(fileName);
						fileExts.add(fileExt);
						sfileNames.add(sFileName);
						
						map.put("fileNames", fileNames);
						map.put("fileExts",fileExts);
						map.put("sFileNames", sfileNames);
						
						File file=new File(filePath+sFileName);
						i+=1;
						try {
							mf.transferTo(file);//실제파일명으로 저장
						}catch(IOException e) {
							System.out.println("오류: "+e.getMessage());
							e.printStackTrace();
						}
					}
					
				}
				//db에 정보 저장(Table:Board,Files);
				if(map.get("idx").equals("")) {
					map.put("fnum", 0);
				}else{
					
				}
				if(map.get("fileNames")==null) {
					boardDao.updateBoard(map);
				}else {								
					pdsDao.updatePds(map);
				}
		
	}
	@Override
	public boolean delOnlyFiles(HashMap<String, Object> map) {
		boolean result=pdsDao.delOnlyFiles(map);
			File file=new File("d:\\upload\\"+map.get("fileName"));
			if(file.exists()) {
				file.delete();
			}
		return result;
	};
	
}

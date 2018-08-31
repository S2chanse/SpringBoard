package com.spring.pds.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.spring.menu.service.MenuService;
import com.spring.menu.vo.MenuVo;
import com.spring.pds.files.vo.FilesVo;
import com.spring.pds.service.PdsService;
import com.spring.pds.vo.PdsVo;

@Controller
public class PdsController {
	@Autowired
	private MenuService menuService;
	@Autowired
	private PdsService pdsService;
	@RequestMapping("/")
	public String goHome() {
		
		return "home";
	}
	
	@RequestMapping("/PDS/List")
	public ModelAndView getList(@RequestParam HashMap<String,Object> map) {
		ModelAndView mv=new ModelAndView();
		List<MenuVo> menuList = menuService.getList();
		map.put("menuList", menuList);
		List<PdsVo>  pdsList  = pdsService.getPdsList(map);
		mv.addObject("pdsList", pdsList);
		mv.addObject("menuList",menuList);
		mv.addObject("rowCntNum", (int) map.get("allRowCnt"));
		mv.addObject("pnum",map.get("pnum"));
		mv.addObject("rowcnt",map.get("rowcnt"));
		mv.addObject("bnum",map.get("bnum"));
		mv.addObject("menuId",map.get("menuId"));
		mv.setViewName("boarder/boardList");
		return mv;
	}
	
	@RequestMapping("/PDS/getView")
	public ModelAndView getView(@RequestParam HashMap<String,Object> map) {
		ModelAndView mv=new ModelAndView();
		 List<MenuVo> mlist=menuService.getList();
		 List<PdsVo> list=pdsService.getPdsRow(map);
		 List<FilesVo> flist=pdsService.getFilesList(map);
	 	 mv.addObject("menuList",mlist);
		 mv.addObject("PdsVo", list.get(0));
		 mv.addObject("FilesList",flist);
		 mv.addObject("pnum",map.get("pnum"));
		 mv.addObject("rowcnt",map.get("rowcnt"));
		 mv.addObject("bnum",map.get("bnum"));
		 mv.setViewName("boarder/view");
		return mv;
	}
	@RequestMapping("/PDS/WriteForm")
	 public ModelAndView pdsWriteForm(@RequestParam HashMap<String,Object> map) {
		 ModelAndView mv=new ModelAndView();
		 List<MenuVo> menuList=menuService.getList();
		 List<PdsVo> pdsList;
		 mv.setViewName("boarder/writeForm");
		 mv.addObject("menuList",menuList);
		 mv.addObject("menuLen",menuList.size());
		 mv.addObject("menuId",map.get("menuId"));
		 mv.addObject("idx",map.get("idx"));
		 mv.addObject("map",map);
		 mv.addObject("pnum",map.get("pnum"));
		 mv.addObject("rowcnt",map.get("rowcnt"));
		 mv.addObject("bnum",map.get("bnum"));
		 mv.addObject("menuId",map.get("menuId"));		 
		 return mv;
	 }
	 
	 @RequestMapping("/PDS/Write")
	 public ModelAndView pdsWrite(@RequestParam HashMap<String,Object> map
			 ,HttpServletRequest req) {
		 ModelAndView mv=new ModelAndView();
		 pdsService.addPdsRow(map,req);
		 mv.addObject("menuId",map.get("menuId"));
		 mv.setViewName("redirect:/PDS/List");
		 mv.addObject("pnum",map.get("pnum"));
		 mv.addObject("rowcnt",map.get("rowcnt"));
		 mv.addObject("bnum",map.get("bnum"));
		 mv.addObject("menuId",map.get("menuId"));
		 return mv;
	 }
	 @RequestMapping(value="/download/{type}/{sfile:.+}",method=RequestMethod.GET)
	 public void pdsFileDownload(HttpServletResponse resp
			 	,@PathVariable("type") String type,@PathVariable("sfile") String sfile) throws IOException 
	 {		 
		// System.out.println(sfile);
		 String INTERNAL_FILE		= sfile;
		 String EXTERNAL_FILE_PATH	= "d:\\upload\\"+sfile;
		 File file=null;
		 if(type.equalsIgnoreCase("internal")) {//위의 mapping에서 type에 있는 값을 통해 서
			 ClassLoader classLoader=Thread.currentThread().getContextClassLoader();
			 file=new File(ClassLoader.getSystemResource(INTERNAL_FILE).getFile());
		 }else {
			 //웹경로 알아내기
			 file=new File(EXTERNAL_FILE_PATH);
		 }
			 if(!file.exists()) {
				 String  errorMSG	="Sorry, this file does not exist";
				 System.out.println(errorMSG);
				 OutputStream outputStream	= resp.getOutputStream();
				 outputStream.write(errorMSG.getBytes(Charset.forName("UTF-8")));
				 outputStream.close();
				 return;
				 
			 }
		 
		 
		 String mimeType =URLConnection.guessContentTypeFromName(file.getName());
		/* if(mimeType==null) {
			 System.out.println("mimeType is not detectable, will take default");
		 }*/
		 mimeType="application/octet-stream";
		 System.out.println("mimeType"+mimeType);
		 
		 resp.setContentType(mimeType);
		 resp.setHeader("Content-Dispostition"
				 ,String.format("inline;filename=\""+file.getName()+"\""));//파일주소
		 
		 resp.setContentLength((int)file.length());//용량전달
		 
		 InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
		 
		 //Copy bytes from source to destination(outputStream)
		 FileCopyUtils.copy(inputStream, resp.getOutputStream());
		 
		 
	 }
	 @RequestMapping("/PDS/DeleteForm")
	 public ModelAndView pdsDelForm(@RequestParam HashMap<String,Object> map) {
		 ModelAndView mv=new ModelAndView();
		 List<PdsVo> list=pdsService.getPdsRow(map);
		 mv.addObject("boardVo",list.get(0));
		 mv.setViewName("boarder/deleteForm");
		 mv.addObject("pnum",map.get("pnum"));
		 mv.addObject("rowcnt",map.get("rowcnt"));
		 mv.addObject("bnum",map.get("bnum"));
		 mv.addObject("menuId",map.get("menuId"));
		 return mv;
	 }
	 @RequestMapping("PDS/DelOnlyFile")
	 @ResponseBody
	 public boolean pdsDelOnlyFile(@RequestParam HashMap<String,Object> map) {
		 boolean result=false;
		 result=pdsService.delOnlyFiles(map);
		 
		 return result;
	 }
	 @RequestMapping("/PDS/Delete")
	 public ModelAndView pdsDel(@RequestParam HashMap<String, Object> map) {
		 pdsService.delFiles(map);
		 ModelAndView mv=new ModelAndView();
		 mv.setViewName("redirect:/PDS/List?menuId="+map.get("menuId"));
		 mv.addObject("pnum",map.get("pnum"));
		 mv.addObject("rowcnt",map.get("rowcnt"));
		 mv.addObject("bnum",map.get("bnum"));
		 mv.addObject("menuId",map.get("menuId"));
		 return mv;
	 }

	 @RequestMapping("/PDS/UpdateForm")
	 public ModelAndView pdsUpForm(@RequestParam HashMap<String,Object> map) {
		 ModelAndView mv=new ModelAndView();
		 List<MenuVo> mlist=menuService.getList();
		 List<PdsVo> list=pdsService.getPdsRow(map);
		 List<FilesVo> flist=pdsService.getFilesList(map);
	 	 mv.addObject("menuList",mlist);
		 mv.addObject("PdsVo", list.get(0));
		 mv.addObject("FilesList",flist);
		 mv.addObject("pnum",map.get("pnum"));
		 mv.addObject("rowcnt",map.get("rowcnt"));
		 mv.addObject("bnum",map.get("bnum"));
		 mv.addObject("menuId",map.get("menuId"));
		 mv.setViewName("boarder/updateForm");
		 return mv;
	 }
	 @RequestMapping("/PDS/Update")
	 public ModelAndView pdsUp(@RequestParam HashMap<String,Object> map ,HttpServletRequest req) {
		 pdsService.updatePds(map,req);
		 ModelAndView mv=new ModelAndView();
		 List<MenuVo> mlist=menuService.getList();
		 List<PdsVo> list=pdsService.getPdsRow(map);
		 List<FilesVo> flist=pdsService.getFilesList(map);
		 mv.addObject("menuList",mlist);
		 mv.addObject("menuLen",mlist.size());
		 mv.addObject("PdsVo", list.get(0));
		 mv.addObject("FilesList",flist);
		 mv.addObject("pnum",map.get("pnum"));
		 mv.addObject("rowcnt",map.get("rowcnt"));
		 mv.addObject("bnum",map.get("bnum"));
		 mv.addObject("menuId",map.get("menuId"));
		 mv.setViewName("redirect:/PDS/getView?idx="+map.get("idx")+"&menuId="+map.get("menuId"));
		 return mv;
	 }
	
}

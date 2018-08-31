package com.spring.menu.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.menu.service.MenuService;
import com.spring.menu.vo.MenuVo;

@Controller
public class MenuController {
	@Autowired
	private MenuService menuService;
	
	@RequestMapping("/MENU/SELECT")
	public String selMenu(@RequestParam String menuId) {
		String link="redirect:/Board/List?menuId="+menuId;
		return link;
	}
	@RequestMapping("/MENU/ADD")
	public String writeMenu(Model model) {
		List<MenuVo> menuList=menuService.getList();
		model.addAttribute("menuList",menuList);
		return "menus/menuForm";
	}
	@RequestMapping("/MENU/INMENU")
	public String addMenu(@RequestParam HashMap<String, Object> map) {
		menuService.addMenu(map);
		return "redirect:/PDS/boardList";
	}
	@RequestMapping("/MENU/MODIFY")
	public ModelAndView modifyMenu() {	
		ModelAndView mv=new ModelAndView();
		List<MenuVo> menuList=menuService.getList();
		mv.addObject("menuList",menuList);
		mv.setViewName("menus/menuModify");	
		return mv;
	}
	@RequestMapping("/MENU/DelMenu")
	public String delMenu(@RequestParam HashMap<String, Object> map) {
		menuService.delMenu(map);
		return "redirect:/PDS/boardList";
	}
	@RequestMapping("/MENU/UpdMenu")
	public String updMenu(@RequestParam HashMap<String, Object> map) {
		return "redirect:/PDS/boardList";
	}
	@RequestMapping("/MENU/ChangeSeq")
	public String cngMenuSeq(@RequestParam HashMap<String, Object> map) {
		menuService.cngMenuSeq(map);
		return "redirect:/PDS/boardList";
	}
	
}

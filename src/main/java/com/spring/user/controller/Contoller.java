package com.spring.user.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.user.service.UserService;
import com.spring.user.vo.UserVo;

@Controller
public class Contoller {
private HttpSession session;
@Autowired
private UserService userService;
	
@RequestMapping("/LogIn/LogIn")
	public ModelAndView goLoginForm(@RequestParam HashMap<String,Object>map,
			HttpServletRequest req) {
		ModelAndView mv=new ModelAndView();
		UserVo vo=userService.getUserInfo(map);
		try {
			session=req.getSession();
			session.setAttribute("userId", vo.getMemNick());
			session.setAttribute("userPwd", vo.getMemPwd());
			mv.setViewName("");
		}catch(Exception e) {
			mv.setViewName("home");
		}
		return mv;  
	}
}

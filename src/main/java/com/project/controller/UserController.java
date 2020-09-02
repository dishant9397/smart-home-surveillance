package com.project.controller;
import java.io.BufferedOutputStream;


import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.project.model.RegisterVO;
import com.project.model.LoginVO;
import com.project.service.RegisterService;
import com.project.service.LoginService;
import com.project.util.BaseMethods;

@Controller
public class UserController 
{
	@Autowired
	RegisterService registerService;

	@Autowired
	LoginService loginService;
	
	@RequestMapping(value = "admin/viewUser", method=RequestMethod.GET)
	public ModelAndView viewUser(@ModelAttribute RegisterVO registerVO) 
	{
		List userList = registerService.searchUser(registerVO);
		return new ModelAndView ("admin/viewUser", "userList", userList);
	}
	
	@RequestMapping(value="admin/updateUser", method=RequestMethod.GET)
	public ModelAndView updateUser(@ModelAttribute RegisterVO registerVO, @RequestParam("flag") String flag, @RequestParam("loginId") int loginId)
	{
		if(flag.equals("block"))
		{
			loginService.blockUser(loginId);
		}
		else
		{
			loginService.unblockUser(loginId);
		}
		return new ModelAndView("redirect:viewUser");
	}	
}

package com.project.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.mail.Session;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.project.model.LoginVO;
import com.project.model.RegisterVO;
import com.project.service.LoginService;
import com.project.service.RegisterService;
import com.project.util.BaseMethods;

@Controller
public class LoginController 
{
	@Autowired
	LoginService loginService;
	
	@Autowired
	RegisterService registerService;
	
	@RequestMapping(value = "loadRegister", method = RequestMethod.GET)
	public ModelAndView loadRegister() 
	{
		return new ModelAndView("register", "registerVO", new RegisterVO());
	}
	
	@RequestMapping(value = "registerInsert", method = RequestMethod.POST)
	public ModelAndView registerInsert(@ModelAttribute RegisterVO registerVO, LoginVO loginVO, HttpServletRequest request, HttpSession session) 
	{
		loginVO.setEnabled(1);
		loginVO.setPackageEndDate("");
		loginVO.setPackageStatus("Pending");
		loginVO.setRole("ROLE_USER");	
		loginVO.setUsername(registerVO.getLoginVO().getUsername());
		loginVO.setPassword(registerVO.getLoginVO().getPassword());
		String Username = registerVO.getLoginVO().getUsername();
		List userList = loginService.getUsername(Username);
		if(userList.size()==0)
		{
			loginService.insertRegister(loginVO);
			registerVO.setLoginVO(loginVO);
			registerVO.setImagename("No Image.PNG");
			registerVO.setImagepath("C:\\Users\\DJ Patel\\eclipse\\SmartHomeSurveillance\\src\\main\\webapp\\documents\\profile\\"+Username);
			registerService.insertRegister(registerVO);
			String path = request.getSession().getServletContext().getRealPath("/");
			File dir = new File(path+"/documents/profile/"+Username);
			boolean exists = dir.exists();
			if(exists==false)
			{
				new File(path+"/documents/profile/"+Username).mkdir();
			}
			try 
			{
				BaseMethods.copyFile(Username);
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
			session.removeAttribute("reloadMessage");
			return new ModelAndView("login");
		}
		else
		{
			session.setAttribute("reloadMessage", "Username already exists");
			return new ModelAndView("redirect:loadRegister");	
		}
	}
}

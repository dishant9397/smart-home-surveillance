package com.project.controller;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
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

import com.project.model.LoginVO;
import com.project.model.RegisterVO;
import com.project.service.LoginService;
import com.project.service.RegisterService;
import com.project.util.BaseMethods;

@Controller
public class ProfileController 
{
	@Autowired
	RegisterService registerService;

	@Autowired
	LoginService loginService;
	
	@RequestMapping(value="user/viewProfile", method=RequestMethod.GET)
	public ModelAndView viewProfile(@ModelAttribute RegisterVO registerVO)
	{
		String username = BaseMethods.getUser();
		List loginList  = loginService.searchLoginId(username);
		LoginVO loginVO = (LoginVO) loginList.get(0);
		int loginId = loginVO.getLoginId();
		List registerList = registerService.imageName(loginId);
		registerVO = (RegisterVO)registerList.get(0);
		loginVO.setLoginId(loginId);
		registerVO.setLoginVO(loginVO);
		String image = registerVO.getImagename();
		List userList = registerService.editProfile(registerVO);
		return new ModelAndView ("user/editProfile", "RegisterVO", (RegisterVO) userList.get(0)).addObject("image", image).addObject("username", username);
	}

	@RequestMapping(value="admin/viewProfile", method=RequestMethod.GET)
	public ModelAndView viewP(@ModelAttribute RegisterVO registerVO)
	{
		String username = BaseMethods.getUser();
		List loginList  = loginService.searchLoginId(username);
		LoginVO loginVO = (LoginVO) loginList.get(0);
		int loginId = loginVO.getLoginId();
		List registerList = registerService.imageName(loginId);
		registerVO = (RegisterVO)registerList.get(0);
		loginVO.setLoginId(loginId);
		registerVO.setLoginVO(loginVO);
		String image = registerVO.getImagename();
		List userList = registerService.editProfile(registerVO);
		return new ModelAndView ("user/editProfile", "RegisterVO", (RegisterVO) userList.get(0)).addObject("image", image).addObject("username", username);
	}
	
	@RequestMapping(value="user/updateProfile", method=RequestMethod.POST)
	public ModelAndView updateProfile(@ModelAttribute RegisterVO registerVO, LoginVO loginVO, @RequestParam("profileImage") MultipartFile file, HttpServletRequest request)
	{
		String Username = BaseMethods.getUser();
		String path =request.getSession().getServletContext().getRealPath("/");
		String ImageName = file.getOriginalFilename();
		String ImagePath = path + "documents\\profile\\"+Username;
		try 
		{
			byte barr[]=file.getBytes();  
	        BufferedOutputStream bout=new BufferedOutputStream(new FileOutputStream(ImagePath+"/"+ImageName));
	        registerVO.setImagename(ImageName);
			registerVO.setImagepath(ImagePath);
	        bout.write(barr);  
	        bout.flush();  
	        bout.close();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		loginVO.setLoginId(registerVO.getLoginVO().getLoginId());
		loginVO.setUsername(registerVO.getLoginVO().getUsername());
		loginVO.setPassword(registerVO.getLoginVO().getPassword());
		loginVO.setRole(registerVO.getLoginVO().getRole());
		loginVO.setEnabled(registerVO.getLoginVO().getEnabled());
		loginVO.setPackageStatus(registerVO.getLoginVO().getPackageStatus());
		loginService.insertRegister(loginVO);		
		registerVO.setLoginVO(loginVO);
		registerService.insertRegister(registerVO);		
		return new ModelAndView("redirect:index");
	}

	@RequestMapping(value="admin/updateProfile", method=RequestMethod.POST)
	public ModelAndView updateP(@ModelAttribute RegisterVO registerVO, LoginVO loginVO ,@RequestParam("profileImage") MultipartFile file, HttpServletRequest request)
	{
		String path =request.getSession().getServletContext().getRealPath("/");
		String Username = BaseMethods.getUser();
		File dir = new File(path+"/documents/profile/"+Username);
		boolean exists = dir.exists();
		if(exists==false)
		{
			new File(path+"/documents/profile/"+Username).mkdir();
		}
		String ImageName = file.getOriginalFilename();
		String ImagePath = path + "documents\\profile\\"+Username;
		try 
		{
			byte barr[]=file.getBytes();  
	        BufferedOutputStream bout=new BufferedOutputStream(new FileOutputStream(ImagePath+"/"+ImageName));  
	        bout.write(barr);  
	        bout.flush();  
	        bout.close();
	        registerVO.setImagename(ImageName);
			registerVO.setImagepath(ImagePath);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}	
		loginVO.setLoginId(registerVO.getLoginVO().getLoginId());
		loginVO.setUsername(registerVO.getLoginVO().getUsername());
		loginVO.setPassword(registerVO.getLoginVO().getPassword());
		loginVO.setRole(registerVO.getLoginVO().getRole());
		loginVO.setEnabled(registerVO.getLoginVO().getEnabled());
		loginService.insertRegister(loginVO);		
		registerVO.setLoginVO(loginVO);
		registerService.insertRegister(registerVO);		
		return new ModelAndView("redirect:index");
	}	
}

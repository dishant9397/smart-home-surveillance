package com.project.controller;
import java.io.BufferedOutputStream;

import java.io.File;
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

import com.project.model.ComplainVO;
import com.project.model.LoginVO;
import com.project.model.PackageVO;
import com.project.service.ComplainService;
import com.project.service.LoginService;
import com.project.service.PackageService;
import com.project.util.BaseMethods;

@Controller
public class ComplainController 
{
	@Autowired
	ComplainService complainService;

	@Autowired
    LoginService loginService;
	
	@Autowired
	PackageService packageService;
	
	@RequestMapping(value = "user/loadComplain")
	public ModelAndView loadComplain(@ModelAttribute PackageVO packageVO) 
	{
		String username = BaseMethods.getUser();
       	List loginList  = loginService.searchLoginId(username);
        LoginVO loginVO = (LoginVO) loginList.get(0);
        String packageStatus = loginVO.getPackageStatus();
        if(packageStatus.equals("Inactive") || packageStatus.equals("Pending"))
        {
        	List packageList = packageService.searchPackage(packageVO);
    		return new ModelAndView ("user/viewPackage", "packageList", packageList);
        }
        else
        {
        	return new ModelAndView ("user/addComplain", "ComplainVO", new ComplainVO());
        }
	}
	
	@RequestMapping(value = "user/addComplain", method = RequestMethod.POST)
	public ModelAndView addComplain(@ModelAttribute ComplainVO complainVO, @RequestParam("complainImage")MultipartFile file, HttpServletRequest request)
	{
		String path =request.getSession().getServletContext().getRealPath("/");
		String Username = BaseMethods.getUser();
		File dir = new File(path+"/documents/complain/"+Username);
		boolean exists = dir.exists();
		if(exists==false)
		{
			new File(path+"/documents/complain/"+Username).mkdir();
		}
		String ComplainImage = file.getOriginalFilename();
		String ComplainPath = path + "documents\\complain\\"+Username;
		try 
		{
			byte barr[]=file.getBytes();  
	        BufferedOutputStream bout=new BufferedOutputStream(new FileOutputStream(ComplainPath+"/"+ComplainImage));  
	        bout.write(barr);  
	        bout.flush();  
	        bout.close();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		Date d = new Date();
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		DateFormat timeFormat = new SimpleDateFormat("hh:mm:ss");
		complainVO.setComplainInsertDate(dateFormat.format(d));
		complainVO.setComplainInsertTime(timeFormat.format(d));
       	List loginList  = loginService.searchLoginId(Username);
        LoginVO loginVO = (LoginVO) loginList.get(0);
        complainVO.setLoginVO(loginVO);
		complainVO.setComplainImageName(ComplainImage);
		complainVO.setComplainImagePath(ComplainPath);
		complainVO.setComplainStatus("Pending");
		complainService.insertComplain(complainVO);
		return new ModelAndView ("user/addComplain", "ComplainVO", new ComplainVO());
	}
	
	@RequestMapping(value = "user/viewComplain", method = RequestMethod.GET)
	public ModelAndView viewComplain(@ModelAttribute ComplainVO complainVO, PackageVO packageVO) 
	{
		String username = BaseMethods.getUser();
		List loginList  = loginService.searchLoginId(username);
		LoginVO loginVO = (LoginVO) loginList.get(0);
		String packageStatus = loginVO.getPackageStatus();
		if(packageStatus.equals("Inactive") || packageStatus.equals("Pending"))
        {
        	List packageList = packageService.searchPackage(packageVO);
    		return new ModelAndView ("user/viewPackage", "packageList", packageList);
        }
        else
        {
        	complainVO.setLoginVO(loginVO);
    		List complainList = complainService.viewComplain(complainVO);
    		return new ModelAndView ("user/viewComplain", "complainList", complainList).addObject("loginList", loginList);
        }
	}
	
	@RequestMapping(value = "user/searchComplain", method = RequestMethod.POST)
	public ModelAndView viewComplainByDate(@ModelAttribute ComplainVO complainVO, @RequestParam ("complainStatus") String complainStatus, @RequestParam ("dateType") String complainDateType, @RequestParam ("complainDate") String complainDate) 
	{
		String complainStartDate = complainDate.substring(0, 10);
		String complainEndDate = complainDate.substring(14, 24);
		String username = BaseMethods.getUser();
		List loginList  = loginService.searchLoginId(username);
		LoginVO loginVO = (LoginVO) loginList.get(0);
		complainVO.setLoginVO(loginVO);
		List complainList = complainService.viewComplainByDate(complainVO, complainStatus, complainDateType, complainStartDate, complainEndDate);
		return new ModelAndView ("user/viewComplain", "complainList", complainList).addObject("loginList", loginList);
	}
	
	@RequestMapping(value = "admin/searchComplain", method = RequestMethod.POST)
	public ModelAndView searchComplain(@ModelAttribute ComplainVO complainVO, LoginVO loginVO, @RequestParam ("complainStatus") String complainStatus, @RequestParam ("dateType") String complainDateType, @RequestParam ("complainDate") String complainDate) 
	{
		String complainStartDate = complainDate.substring(0, 10);
		String complainEndDate = complainDate.substring(14, 24);
		List complainList = complainService.searchComplainByDate(complainVO, complainStatus, complainDateType, complainStartDate, complainEndDate);
		List loginList = loginService.searchUser(loginVO);
		return new ModelAndView ("admin/viewComplain", "complainList", complainList).addObject("loginList", loginList);
	}
	
	@RequestMapping(value = "admin/viewComplain", method = RequestMethod.GET)
	public ModelAndView viewcomplain(@ModelAttribute ComplainVO complainVO, LoginVO loginVO) 
	{
		List complainList = complainService.searchComplain(complainVO);
		List loginList = loginService.searchUser(loginVO);
		return new ModelAndView ("admin/viewComplain", "complainList", complainList).addObject("loginList", loginList);
	}
	
	@RequestMapping(value="admin/replyComplain", method=RequestMethod.GET)
	public ModelAndView editComplain(@ModelAttribute ComplainVO complainVO, @RequestParam ("complainId") int complainId)
	{
		complainVO.setComplainId(complainId);
		List complainList = complainService.editComplain(complainVO);
		return new ModelAndView ("admin/replyComplain", "ComplainVO", (ComplainVO) complainList.get(0));
	}
	
	@RequestMapping(value="admin/updateComplain", method=RequestMethod.POST)
	public ModelAndView updateComplain(@ModelAttribute ComplainVO complainVO)
	{
		Date d = new Date();
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		DateFormat timeFormat = new SimpleDateFormat("hh:mm:ss");
		complainVO.setComplainReplyDate(dateFormat.format(d));
		complainVO.setComplainReplyTime(timeFormat.format(d));
		complainVO.setComplainStatus("Resolved");
		complainVO.setComplainInsertDate(complainVO.getComplainInsertDate());
		complainVO.setComplainInsertTime(complainVO.getComplainInsertTime());
		complainService.insertComplain(complainVO);
		return new ModelAndView("redirect:viewComplain");
	}	
}

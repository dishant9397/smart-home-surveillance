package com.project.controller;

import java.text.DateFormat;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.project.model.FeedbackVO;
import com.project.model.LoginVO;
import com.project.model.PackageVO;
import com.project.service.FeedbackService;
import com.project.service.LoginService;
import com.project.service.PackageService;
import com.project.util.BaseMethods;

@Controller
public class FeedbackController 
{
	@Autowired
	FeedbackService feedbackService;
	
	@Autowired
    LoginService loginService;
	
	@Autowired
	PackageService packageService;
	
	@RequestMapping(value = "user/loadFeedback")
	public ModelAndView loadFeedback(@ModelAttribute PackageVO packageVO) 
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
        	return new ModelAndView ("user/addFeedback", "feedbackVO", new FeedbackVO());
        }
	}
	
	@RequestMapping(value = "user/addFeedback", method = RequestMethod.POST)
	public ModelAndView addFeedback(@ModelAttribute FeedbackVO feedbackVO)
	{
		String username = BaseMethods.getUser();
       	List loginList  = loginService.searchLoginId(username);
        LoginVO loginVO = (LoginVO) loginList.get(0);
		Date d = new Date();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		feedbackVO.setFeedbackInsertDate(dateFormat.format(d));
        feedbackVO.setLoginVO(loginVO);
		feedbackService.insertFeedback(feedbackVO);
		return new ModelAndView ("user/addFeedback", "feedbackVO", new FeedbackVO());	
	}
	
	@RequestMapping(value = "admin/viewFeedback", method = RequestMethod.GET)
	public ModelAndView viewcomplain(@ModelAttribute FeedbackVO feedbackVO) 
	{
		List feedbackList = feedbackService.searchFeedback(feedbackVO);
		return new ModelAndView ("admin/viewFeedback", "feedbackList", feedbackList);
	}
}

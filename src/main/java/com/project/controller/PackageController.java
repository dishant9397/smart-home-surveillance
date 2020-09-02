package com.project.controller;

import java.text.DateFormat;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.model.LoginVO;
import com.project.model.PaymentVO;
import com.project.model.PackageVO;
import com.project.service.LoginService;
import com.project.service.PackageService;
import com.project.util.BaseMethods;

@Controller
public class PackageController 
{
	@Autowired
	PackageService packageService;
	
	@Autowired
    LoginService loginService;
	
	@RequestMapping(value = "admin/loadPackage")
	public ModelAndView loadPackage() 
	{
		return new ModelAndView ("admin/addPackage", "packageVO", new PackageVO());
	}
	
	@RequestMapping(value = "admin/addPackage", method = RequestMethod.POST)
	public ModelAndView addPackage(@ModelAttribute PackageVO packageVO) 
	{
		packageService.insertPackage(packageVO);	
		return new ModelAndView ("admin/addPackage", "packageVO", new PackageVO());
	}
	
	@RequestMapping(value = "admin/viewPackage", method = RequestMethod.GET)
	public ModelAndView searchPackage(@ModelAttribute PackageVO packageVO) 
	{
		List packageList = packageService.searchPackage(packageVO);
		return new ModelAndView ("admin/viewPackage", "packageList", packageList);
	}
	
	@RequestMapping(value="admin/editPackage", method=RequestMethod.GET)
	public ModelAndView editPackage(@ModelAttribute PackageVO packageVO, @RequestParam ("packageId") int packageId)
	{
		packageVO.setPackageId(packageId);
		List packageList = packageService.editPackage(packageVO);
		return new ModelAndView ("admin/editPackage", "packageVO", (PackageVO) packageList.get(0));
	}
	
	@RequestMapping(value="admin/updatePackage", method=RequestMethod.POST)
	public ModelAndView updatePackage(@ModelAttribute PackageVO packageVO)
	{
		packageService.insertPackage(packageVO);
		return new ModelAndView("redirect:viewPackage");
	}
	
	@RequestMapping(value = "admin/deletePackage", method = RequestMethod.GET)
	public ModelAndView deletePackage(@ModelAttribute PackageVO packageVO, @RequestParam ("packageId") int packageId) 
	{
		packageVO.setPackageId(packageId);
		List packageList = packageService.editPackage(packageVO);
		packageVO =(PackageVO) packageList.get(0);
		packageVO.setDeleteStatus(false);
		packageService.insertPackage(packageVO);
		return new ModelAndView("redirect:viewPackage");
	}

	@RequestMapping(value = "user/viewPackage", method = RequestMethod.GET)
	public ModelAndView viewPackage(@ModelAttribute PackageVO packageVO, HttpSession session) 
	{
		String username = BaseMethods.getUser();
		List loginList  = loginService.searchLoginId(username);
		LoginVO loginVO = (LoginVO) loginList.get(0);
		List packageList = packageService.searchPackage(packageVO);
		if(loginVO.getPackageStatus().equals("Inactive"))
		{
			String packageEndDateMessage = "The Package was expired on "+ loginVO.getPackageEndDate();
			session.setAttribute("packageEndDateMessage", packageEndDateMessage);
			return new ModelAndView ("user/viewPackage", "packageList", packageList);
		}
		else if(loginVO.getPackageStatus().equals("Pending"))
		{
			String packageEndDateMessage = "The Package is never bought. Please buy any of the listed Package to access all the features of the website";
			session.setAttribute("packageEndDateMessage", packageEndDateMessage);
			return new ModelAndView ("user/viewPackage", "packageList", packageList);
		}
		else if(loginVO.getPackageStatus().equals("Paid"))
		{
			String packageEndDateMessage = "Please wait for around 24 hours to verify your payment and activate the package.";
			session.setAttribute("packageEndDateMessage", packageEndDateMessage);
			return new ModelAndView ("user/viewPackage", "packageList", packageList);
		}
		else
		{
			String packageEndDateMessage = "The Package will expire on "+ loginVO.getPackageEndDate();
			session.setAttribute("packageEndDateMessage", packageEndDateMessage);
			return new ModelAndView ("user/viewPackage", "packageList", packageList);
		}
	}
	
	@RequestMapping(value = "user/openPurchasePackage")
	public ModelAndView openPurchasePackage(@RequestParam ("id") int packageId, HttpSession session) 
	{
		List packageList = packageService.viewPackage(packageId);
		session.setAttribute("packageList", packageList);
		return new ModelAndView ("redirect:loadPurchasePackage","packageList", packageList);
	}
	
	@RequestMapping(value = "user/loadPurchasePackage")
	public ModelAndView loadPurchasePackage(HttpSession session) 
	{
		List packageList = (List) session.getAttribute("packageList");
		return new ModelAndView ("user/purchasePackage", "PaymentVO", new PaymentVO()).addObject("packageList", packageList);
	}
	
	/*@RequestMapping(value = "admin/purchasePackage", method = RequestMethod.GET)
	public ModelAndView Package(@ModelAttribute PackageVO packageVO, @RequestParam ("packageEndDays") int packageEndDays, HttpSession session) 
	{
		String username = BaseMethods.getUser();
		Date date = new Date();
		Date newDate = BaseMethods.addDays(date, packageEndDays);
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String packageEndDate = dateFormat.format(newDate);		
		loginService.activatePackage(packageEndDate, username);
		List loginList  = loginService.searchLoginId(username);
		LoginVO loginVO = (LoginVO) loginList.get(0);
		List packageList = packageService.searchPackage(packageVO);
		String packageEndDateMessage = "The Package will expire on "+ loginVO.getPackageEndDate();
		session.setAttribute("packageEndDateMessage", packageEndDateMessage);
		return new ModelAndView ("redirect:viewPackage", "packageList", packageList);
	}*/
}

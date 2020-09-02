package com.project.controller;

import java.text.DateFormat;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.model.LoginVO;
import com.project.model.PackageVO;
import com.project.model.RegisterVO;
import com.project.service.CountService;
import com.project.service.DetectionService;
import com.project.service.LoginService;
import com.project.service.PackageService;
import com.project.service.RegisterService;
import com.project.util.BaseMethods;


@Controller
public class MainController extends BaseMethods 
{
	@Autowired
	RegisterService registerService;
	
	@Autowired
	LoginService loginService;
	
	@Autowired
	DetectionService detectionService;
	
	@Autowired
	PackageService packageService;
	
	@Autowired
	CountService countService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView loadLogin() 
	{
		return new ModelAndView("login");
	}
	
	@RequestMapping(value = "/admin/index", method = RequestMethod.GET)
	public ModelAndView adminIndex(HttpSession session) 
	{
		List activeUser = countService.activeUser();
		String activeUserList = activeUser.get(0).toString();
		List totalComplain = countService.totalComplain();
		String totalComplainList = totalComplain.get(0).toString();
		List totalPayment = countService.totalPayment();
		String totalPaymentList = totalPayment.get(0).toString();
		List totalFeedback = countService.totalFeedback();
		String totalFeedbackList = totalFeedback.get(0).toString();
		String un = BaseMethods.getUser();
		session.setAttribute("username", un);
		List loginList = loginService.getUsername(un);
		LoginVO loginVO = (LoginVO) loginList.get(0);
		int loginId = loginVO.getLoginId();
		List registerList = registerService.imageName(loginId);
		RegisterVO registerVO = (RegisterVO) registerList.get(0);
		session.setAttribute("imagename", registerVO.getImagename());
		session.setAttribute("firstName", registerVO.getFirstname());
		session.setAttribute("lastName", registerVO.getLastname());
		return new ModelAndView("admin/index").addObject("activeUserList", activeUserList).addObject("totalComplainList", totalComplainList).addObject("totalPaymentList", totalPaymentList).addObject("totalFeedbackList", totalFeedbackList);
	}
	
	@RequestMapping(value = "/user/index", method = RequestMethod.GET)
	public ModelAndView userIndex(@ModelAttribute PackageVO packageVO, HttpSession session) 
	{
		String username = BaseMethods.getUser();
       	List loginList  = loginService.searchLoginId(username);
        LoginVO loginVO = (LoginVO) loginList.get(0);
        int loginId = loginVO.getLoginId();
        List totalComplain = countService.totalComplain(loginId);
		String totalComplainList = totalComplain.get(0).toString();
		List pendingComplain = countService.pendingComplain(loginId);
		String pendingComplainList = pendingComplain.get(0).toString();
		List totalFamilyMember = countService.totalFamilyMember(loginVO);
		String totalFamilyMemberList = totalFamilyMember.get(0).toString();
		List totalDetectedPeople = countService.totalDetectedPeople(username);
		String detectionList = totalDetectedPeople.get(0).toString();
        session.setAttribute("username", username);
		List registerList = registerService.imageName(loginId);
		RegisterVO registerVO = (RegisterVO) registerList.get(0);
		session.setAttribute("imagename", registerVO.getImagename());
		session.setAttribute("firstName", registerVO.getFirstname());
		session.setAttribute("lastName", registerVO.getLastname());
        String packageStatus = loginVO.getPackageStatus();
        String packageEndDate = loginVO.getPackageEndDate();
        if(packageStatus.equals("Pending"))
        {
        	String packageEndDateMessage = "The Package is never bought. Please buy any of the listed Package to access all the features of the website";
        	session.setAttribute("packageEndDateMessage", packageEndDateMessage);
        	List packageList = packageService.searchPackage(packageVO);
    		return new ModelAndView ("user/viewPackage", "packageList", packageList);
        }
        else if(packageStatus.equals("Inactive"))
        {
        	String packageEndDateMessage = "The Package was expired on "+ packageEndDate;
        	session.setAttribute("packageEndDateMessage", packageEndDateMessage);
        	List packageList = packageService.searchPackage(packageVO);
    		return new ModelAndView ("user/viewPackage", "packageList", packageList);
        }
        else if(packageStatus.equals("Paid"))
        {
        	String packageEndDateMessage = "Please wait for around 24 hours to verify your payment and activate the package.";
        	session.setAttribute("packageEndDateMessage", packageEndDateMessage);
        	List packageList = packageService.searchPackage(packageVO);
    		return new ModelAndView ("user/viewPackage", "packageList", packageList);
        }
        else
        {
        	List graphList = this.countService.graph(username);
    		return new ModelAndView("user/index","graphList",graphList).addObject("totalComplainList", totalComplainList).addObject("pendingComplainList", pendingComplainList).addObject("totalFamilyMemberList", totalFamilyMemberList).addObject("detectionList", detectionList);
        }
	}
	
	@RequestMapping(value = "logout", method = {RequestMethod.POST, RequestMethod.GET})	
	public String viewUserDetails(ModelMap model,HttpServletResponse response,HttpServletRequest request) 
	{
		  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	        if (auth != null) 
	        {
	            new SecurityContextLogoutHandler().logout(request, response, auth);
	            request.getSession().invalidate();
	            request.getSession().setAttribute("tempStatus", "success");
	            request.getSession().setAttribute("statusText", "Logout Successfully!");
	        }
	        return "login";
	}
		
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView load() 
	{
		return new ModelAndView("login");
	}
	
	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public ModelAndView load403() 
	{
		return new ModelAndView("login");
	}
	
	@RequestMapping(value = "user/viewDetection", method = RequestMethod.GET)
	public ModelAndView viewDetection(@ModelAttribute PackageVO packageVO) 
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
        	List detectionList = detectionService.searchDetection(username);
    		return new ModelAndView("user/viewDetection", "detectionList", detectionList).addObject("username", username);
        }
	}
	
	@RequestMapping(value = "user/searchDetection", method = RequestMethod.POST)
	public ModelAndView searchDetection(@ModelAttribute PackageVO packageVO, @RequestParam ("detectedDate") String detectedDate) 
	{
		String detectedStartDate = detectedDate.substring(0,10); 
		System.out.println(detectedStartDate);
		String detectedEndDate = detectedDate.substring(14, 24);
		System.out.println(detectedEndDate);
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
        	List detectionList = detectionService.viewDetectionByDate(detectedStartDate, detectedEndDate, username);
    		return new ModelAndView("user/viewDetection", "detectionList", detectionList).addObject("username", username);
        }
	}
	
	@RequestMapping(value="forgotPassword", method= RequestMethod.GET)
	public ModelAndView forgotPassword(@ModelAttribute LoginVO loginVO)
	{
		return new ModelAndView("forgotPassword");
	}
	
	@RequestMapping(value="changePassword",method = RequestMethod.POST)
	public ModelAndView changePassword(@RequestParam("email") String email, RegisterVO registerVO, HttpSession session)
	{
		try
		{
			System.out.println("E-mail>>>"+email);
			session.setAttribute("email", email);
			registerVO.setEmail(email);
			List ls=this.registerService.forgotPassword(registerVO);
			registerVO = (RegisterVO) ls.get(0);
			String PhoneNumber = registerVO.getPhonenumber();
			System.out.println("List size>>>>>>>>>"+ls.size());
			if(ls!=null && !ls.isEmpty())
			{
				int OTP=generateOTP(6);
				sendOTP(PhoneNumber, OTP);
				sendMail(email, OTP);
				session.setAttribute("generatedOTP",OTP);
				return new ModelAndView("editPassword");
			}
			else 
			{	
				return new ModelAndView("redirect:forgotPassword");
			}
		}
		catch (Exception e) 
		{
			return new ModelAndView("redirect:forgotPassword");
		}
	}
	
	@RequestMapping(value="verifyPassword", method = RequestMethod.POST)
	public ModelAndView verifyPassword(@RequestParam("password") String pwd ,LoginVO loginVO,RegisterVO registerVO,HttpSession session)
	{
		String email= (String)session.getAttribute("email");
		registerVO.setEmail(email);
		List ls = this.registerService.forgotPassword(registerVO);
		registerVO = (RegisterVO) ls.get(0);
		int loginId = registerVO.getLoginVO().getLoginId();
		loginVO.setUsername(email);
		loginVO.setPassword(pwd);
		this.loginService.updatePassword(loginId, loginVO);
		return new ModelAndView("redirect:/");
	}
}

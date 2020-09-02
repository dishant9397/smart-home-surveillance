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
import com.project.model.RegisterVO;
import com.project.model.PackageVO;
import com.project.service.LoginService;
import com.project.service.PaymentService;
import com.project.service.RegisterService;
import com.project.service.PackageService;
import com.project.util.BaseMethods;

@Controller
public class PaymentController 
{
	@Autowired
	PaymentService paymentService;
	
	@Autowired
	PackageService packageService;
	
	@Autowired
	LoginService loginService;
	
	@Autowired
	RegisterService registerService;
	
	@RequestMapping(value = "user/purchasePackage", method = RequestMethod.POST)
	public ModelAndView purchasePackage(@ModelAttribute PaymentVO paymentVO, HttpSession session, @RequestParam ("paymentType") String paymentType, @RequestParam ("packageId") int packageId) 
	{
		Date d = new Date();
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		DateFormat timeFormat = new SimpleDateFormat("hh:mm:ss");
		paymentVO.setPaymentDate(dateFormat.format(d));
		paymentVO.setPaymentTime(timeFormat.format(d));
		String Username = BaseMethods.getUser();
		List loginList  = loginService.searchLoginId(Username);
        LoginVO loginVO = (LoginVO) loginList.get(0);
        loginVO.setPackageStatus("Paid");
        List packageList = packageService.viewPackage(packageId);
        PackageVO packageVO = (PackageVO) packageList.get(0);
        paymentVO.setLoginVO(loginVO);
        paymentVO.setPaymentAmount(packageVO.getPackageAmount());
        paymentVO.setPackageVO(packageVO);
        paymentVO.setPaymentStatus("Paid");
        paymentVO.setPaymentType(paymentType);
        paymentService.insertPayment(paymentVO);
        loginService.insertRegister(loginVO);	
        session.removeAttribute("packageList");
		return new ModelAndView ("redirect:viewPackage");
	}
	
	@RequestMapping(value = "admin/loadApprovePayment", method = RequestMethod.GET)
	public ModelAndView loadApprovePayment(@ModelAttribute PaymentVO paymentVO, RegisterVO registerVO, PackageVO packageVO) 
	{
		List packageList = packageService.searchPackage(packageVO);
		List registerList = registerService.viewUser(registerVO);
		List paymentList = paymentService.searchPayment(paymentVO);
		return new ModelAndView ("admin/approvePayment", "paymentList", paymentList).addObject("registerList", registerList).addObject("packageList", packageList);
	}
	
	@RequestMapping(value = "admin/searchPayment", method = RequestMethod.POST)
	public ModelAndView searchPayment(@ModelAttribute PaymentVO paymentVO, RegisterVO registerVO, PackageVO packageVO, @RequestParam ("paymentStatus") String paymentStatus, @RequestParam ("paymentType") String paymentType, @RequestParam ("dateType") String dateType, @RequestParam ("date") String date) 
	{
		String StartDate = date.substring(0, 10);
		String EndDate = date.substring(14, 24);
		System.out.println(dateType);
		List paymentList = paymentService.filterPayment(paymentStatus, paymentType, dateType, StartDate, EndDate);
		List packageList = packageService.searchPackage(packageVO);
		List registerList = registerService.viewUser(registerVO);
		return new ModelAndView ("admin/approvePayment", "paymentList", paymentList).addObject("registerList", registerList).addObject("packageList", packageList);
	}
	
	@RequestMapping(value = "admin/approvePayment", method = RequestMethod.GET)
	public ModelAndView approvePayment(@ModelAttribute PaymentVO paymentVO, LoginVO loginVO, PackageVO packageVO, @RequestParam ("paymentId") int paymentId, @RequestParam ("loginId") int loginId, @RequestParam ("packageId") int packageId) 
	{
		List paymentList = paymentService.viewPayment(paymentId);
		paymentVO = (PaymentVO) paymentList.get(0);
		Date d = new Date();
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		DateFormat timeFormat = new SimpleDateFormat("hh:mm:ss");
		paymentVO.setPaymentApprovedDate(dateFormat.format(d));
		paymentVO.setPaymentApprovedTime(timeFormat.format(d));
		paymentVO.setPaymentStatus("Approved");
		paymentService.insertPayment(paymentVO);
		List packageList = packageService.viewPackage(packageId);
		packageVO = (PackageVO) packageList.get(0);
		int packageEndDays = Integer.parseInt(packageVO.getPackageDuration());
		Date newDate = BaseMethods.addDays(d, packageEndDays);
		dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String packageEndDate = dateFormat.format(newDate);
		loginService.activatePackage(packageEndDate, loginId);
		return new ModelAndView ("redirect:loadApprovePayment");
	}
}

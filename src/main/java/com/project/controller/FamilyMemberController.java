package com.project.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
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

import com.project.model.FamilyMemberImageVO;
import com.project.model.FamilyMemberVO;
import com.project.model.LoginVO;
import com.project.model.PackageVO;
import com.project.service.FamilyMemberImageService;
import com.project.service.FamilyMemberService;
import com.project.service.LoginService;
import com.project.service.PackageService;
import com.project.util.BaseMethods;

@Controller
public class FamilyMemberController 
{
	@Autowired
	FamilyMemberService familymemberService;
	
	@Autowired
    LoginService loginService;
	
	@Autowired
	PackageService packageService;
	
	@Autowired
	FamilyMemberImageService familyMemberImageService;
	
	@RequestMapping(value = "user/loadFamilyMember")
	public ModelAndView loadFamilyMember(@ModelAttribute PackageVO packageVO) 
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
        	return new ModelAndView ("user/addFamilyMember", "FamilyMemberVO", new FamilyMemberVO());
        }
	}
	
	@RequestMapping(value = "user/addFamilyMember", method = RequestMethod.POST)
	public ModelAndView addFamilyMember(@ModelAttribute FamilyMemberVO familyMemberVO, PackageVO packageVO, FamilyMemberImageVO familyMemberImageVO, @RequestParam("FamilyMemberImage") List<MultipartFile>  file, HttpServletRequest request) 
	{
		String username = BaseMethods.getUser();
       	List loginList  = loginService.searchLoginId(username);
        LoginVO loginVO = (LoginVO) loginList.get(0);
        familyMemberVO.setLoginVO(loginVO);
		familymemberService.insertFamilyMember(familyMemberVO);
		for (MultipartFile multipartFile : file) 
		{
			String path =request.getSession().getServletContext().getRealPath("/");
			String FamilyMemberImageName= multipartFile.getOriginalFilename();
			File dir = new File(path+"/documents/familymemberimages/"+username);
			boolean exists = dir.exists();
			if(exists==false)
			{
				new File(path+"/documents/familymemberimages/"+username).mkdir();
				new File(path+"/documents/familymemberimages/"+username+"/Unauthorized Images").mkdir();
			}
			String FamilyMemberImagePath = path + "documents\\familymemberimages\\"+username;
			try 
			{
				byte barr[]=multipartFile.getBytes();  
		        BufferedOutputStream bout=new BufferedOutputStream(new FileOutputStream(FamilyMemberImagePath+"/"+FamilyMemberImageName));  
		        bout.write(barr);  
		        bout.flush();  
		        bout.close();
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
			familyMemberImageVO.setFamilymemberImageName(FamilyMemberImageName);
			familyMemberImageVO.setFamilyMemberImagePath(FamilyMemberImagePath);
			familyMemberImageVO.setFamilyMemberVO(familyMemberVO);
			this.familyMemberImageService.insertFamilyMemberImage(familyMemberImageVO);
		}
		return new ModelAndView ("user/addFamilyMember", "FamilyMemberVO", new FamilyMemberVO());
	}
	
	@RequestMapping(value = "user/viewFamilyMember", method = RequestMethod.GET)
	public ModelAndView searchFamilyMember(@ModelAttribute FamilyMemberImageVO familyMemberImageVO, PackageVO packageVO, FamilyMemberVO familyMemberVO) 
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
        	familyMemberVO.setLoginVO(loginVO);
    		List familymemberList = familymemberService.viewFamilyMember(familyMemberVO);
    		List familymemberimageList = familyMemberImageService.searchFamilyMemberImage(familyMemberImageVO);
    		return new ModelAndView ("user/viewFamilyMember", "familymemberList", familymemberList).addObject("familymemberimageList", familymemberimageList).addObject("username", username);
        }
	}
}

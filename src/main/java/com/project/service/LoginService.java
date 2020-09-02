package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.dao.LoginDAO;
import com.project.model.LoginVO;

@Service
public class LoginService 
{
	@Autowired
	LoginDAO loginDAO;

	@Transactional
	public void insertRegister(LoginVO loginVO)
	{
		this.loginDAO.insertRegister(loginVO);
	}
	
	@Transactional
	public List getUsername(String username) 
	{
		List ls = this.loginDAO.getUsername(username);
		return ls;
	}

	@Transactional
	public List searchLoginId(String username) 
	{
		List ls = this.loginDAO.getUsername(username);
		return ls;
	}

	@Transactional
	public List searchUser(LoginVO loginVO) 
	{
		List ls = this.loginDAO.searchUser(loginVO);
		return ls;
	}
	
	@Transactional
	public List blockUser(int loginId) 
	{
		List ls = this.loginDAO.blockUser(loginId);
		return ls;
	}
	
	@Transactional
	public List unblockUser(int loginId) 
	{
		List ls = this.loginDAO.unblockUser(loginId);
		return ls;
	}
	
	@Transactional
	public List activatePackage(String packageEndDate, int loginId)
	{
		List ls = this.loginDAO.activatePackage(packageEndDate, loginId);
		return ls;
	}
	
	@Transactional
	public void updatePassword(int loginId, LoginVO loginVO) 
	{
		this.loginDAO.updatePassword(loginId, loginVO);
	}
}

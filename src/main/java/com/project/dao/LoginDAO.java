package com.project.dao;

import java.util.List;

import com.project.model.LoginVO;

public interface LoginDAO 
{
	public void insertRegister(LoginVO loginVO);
	
	public List getUsername(String username);
	
	public List searchUser(LoginVO loginVO);
	
	public List blockUser(int loginId);
	
	public List unblockUser(int loginId);
	
	public List activatePackage(String packageEndDate, int loginId);
	
	public void updatePassword(int loginId,LoginVO loginVO);
}

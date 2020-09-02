package com.project.dao;

import java.util.List;

import com.project.model.RegisterVO;

public interface RegisterDAO 
{
	public void insertRegister(RegisterVO registerVO);

	public List searchUser(RegisterVO registerVO);
	
	public List viewUser(RegisterVO registerVO);

	public List editUser(RegisterVO registerVO);
	
	public List editProfile(RegisterVO registerVO);
	
	public List imageName(int loginId);
	
	public List forgotPassword(RegisterVO registerVO);
}

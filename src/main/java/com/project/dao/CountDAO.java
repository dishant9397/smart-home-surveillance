package com.project.dao;

import java.util.List;

import com.project.model.LoginVO;

public interface CountDAO 
{
	public List activeUser();
	
	public List totalComplain(int LoginId);
	
	public List pendingComplain(int LoginId);
	
	public List totalComplain();
	
	public List totalPayment();	
	
	public List totalFeedback();

	public List totalFamilyMember(LoginVO loginVO);
	
	public List totalDetectedPeople(String Username);
	
	public List graph(String Username);
}

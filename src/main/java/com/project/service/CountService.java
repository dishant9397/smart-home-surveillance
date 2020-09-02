package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.dao.CountDAO;
import com.project.model.LoginVO;

@Service
public class CountService 
{
	@Autowired
	CountDAO countDAO;

	@Transactional
	public List activeUser() 
	{
		List ls = countDAO.activeUser();
		return ls;
	}
	
	@Transactional
	public List totalComplain(int LoginId) 
	{
		List ls = countDAO.totalComplain(LoginId);
		return ls;
	}
	
	@Transactional
	public List totalComplain() 
	{
		List ls = countDAO.totalComplain();
		return ls;
	}
	
	@Transactional
	public List pendingComplain(int LoginId) 
	{
		List ls = countDAO.pendingComplain(LoginId);
		return ls;
	}
	
	@Transactional
	public List totalPayment() 
	{
		List ls = countDAO.totalPayment();
		return ls;
	}
	
	@Transactional
	public List totalFeedback() 
	{
		List ls = countDAO.totalFeedback();
		return ls;
	}

	@Transactional
	public List totalFamilyMember(LoginVO loginVO) 
	{
		List ls = countDAO.totalFamilyMember(loginVO);
		return ls;
	}
	
	@Transactional
	public List totalDetectedPeople(String Username) 
	{
		List ls = countDAO.totalDetectedPeople(Username);
		return ls;
	}
	
	@Transactional
	public List graph(String Username) 
	{
		List ls = countDAO.graph(Username);
		return ls;
	}
}

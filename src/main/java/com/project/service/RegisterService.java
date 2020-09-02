package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.dao.RegisterDAO;
import com.project.model.RegisterVO;

@Service
public class RegisterService 
{
	@Autowired
	RegisterDAO registerDAO;

	@Transactional
	public void insertRegister(RegisterVO registerVO) 
	{
		this.registerDAO.insertRegister(registerVO);
	}

	@Transactional
	public List searchUser(RegisterVO registerVO) 
	{
		List ls = registerDAO.searchUser(registerVO);
		return ls;
	}
	
	@Transactional
	public List viewUser(RegisterVO registerVO) 
	{
		List ls = registerDAO.viewUser(registerVO);
		return ls;
	}

	@Transactional
	public List editUser(RegisterVO registerVO) 
	{
		List ls = registerDAO.editUser(registerVO);
		return ls;
	}
	
	@Transactional
	public List editProfile(RegisterVO registerVO) 
	{
		List ls = registerDAO.editProfile(registerVO);
		return ls;
	}
	
	@Transactional
	public List imageName(int loginId) 
	{
		List ls = registerDAO.imageName(loginId);
		return ls;
	}
	
	@Transactional
	public List forgotPassword(RegisterVO registerVO) 
	{
		List ls = registerDAO.forgotPassword(registerVO);
		return ls;
	}
}

package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.dao.*;
import com.project.model.*;

@Service
public class ComplainService 
{
	@Autowired
	ComplainDAO complainDAO;

	@Transactional
	public void insertComplain(ComplainVO complainVO) 
	{
		this.complainDAO.insertComplain(complainVO);
	}

	@Transactional
	public List searchComplain(ComplainVO complainVO) 
	{
		List ls = complainDAO.searchComplain(complainVO);
		return ls;
	}
	
	@Transactional
	public List searchComplainByDate(ComplainVO complainVO, String complainStatus, String complainDateType, String complainStartDate, String complainEndDate)
	{
		List ls = complainDAO.searchComplainByDate(complainVO, complainStatus, complainDateType, complainStartDate, complainEndDate);
		return ls;
	}

	@Transactional
	public List viewComplain(ComplainVO complainVO) 
	{
		List ls = complainDAO.viewComplain(complainVO);
		return ls;
	}

	@Transactional
	public List viewComplainByDate(ComplainVO complainVO, String complainStatus,String complainDateType, String complainStartDate, String complainEndDate)
	{
		List ls = complainDAO.viewComplainByDate(complainVO, complainStatus, complainDateType, complainStartDate, complainEndDate);
		return ls;
	}
	
	@Transactional
	public List editComplain(ComplainVO complainVO) 
	{
		List ls = complainDAO.editComplain(complainVO);
		return ls;
	}
}

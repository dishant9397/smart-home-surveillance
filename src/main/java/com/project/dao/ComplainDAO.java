package com.project.dao;

import java.util.List;

import com.project.model.ComplainVO;

public interface ComplainDAO 
{
	void insertComplain(ComplainVO complainVO);

	public List searchComplain(ComplainVO complainVO);
	
	public List searchComplainByDate(ComplainVO complainVO, String complainStatus, String complainDateType, String complainStartDate, String complainEndDate);

	public List viewComplain(ComplainVO complainVO);
	
	public List viewComplainByDate(ComplainVO complainVO, String complainStatus, String complainDateType, String complainStartDate, String complainEndDate);

	public List editComplain(ComplainVO complainVO);
}

package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.dao.DetectionDAO;
import com.project.model.ComplainVO;

@Service
public class DetectionService 
{
	@Autowired
	DetectionDAO detectionDAO;
	
	@Transactional
	public List searchDetection(String Username) 
	{
		List ls = detectionDAO.viewDetection(Username);
		return ls;
	}
	
	@Transactional
	public List viewDetectionByDate(String detectedStartDate, String detectedEndDate, String Username) 
	{
		List ls = detectionDAO.viewDetectionByDate(detectedStartDate, detectedEndDate, Username);
		return ls;
	}
}

package com.project.dao;

import java.util.List;

public interface DetectionDAO 
{
	public List viewDetection(String Username);
	
	public List viewDetectionByDate(String detectedStartDate, String detectedEndDate, String Username);
}

package com.project.dao;

import java.util.List;

import com.project.model.PackageVO;

public interface PackageDAO 
{
	public void insertPackage(PackageVO packageVO);
	
	public List searchPackage(PackageVO packageVO);

	public List editPackage(PackageVO packageVO);
	
	public List viewPackage(int packageId);
}

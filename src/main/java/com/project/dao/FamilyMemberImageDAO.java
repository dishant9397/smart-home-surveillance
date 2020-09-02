package com.project.dao;

import java.util.List;

import com.project.model.FamilyMemberImageVO;
import com.project.model.FamilyMemberVO;

public interface FamilyMemberImageDAO 
{
	public void insertFamilyMemberImage(FamilyMemberImageVO familyMemberImageVO);
	
	public List searchFamilyMemberImage(FamilyMemberImageVO familyMemberImageVO);
	
	public List editFamilyMemberImage(FamilyMemberImageVO familyMemberImageVO);
}

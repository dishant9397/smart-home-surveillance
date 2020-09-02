package com.project.dao;

import java.util.List;

import com.project.model.FamilyMemberVO;

public interface FamilyMemberDAO 
{
	public void insertFamilyMember(FamilyMemberVO familyMemberVO);
	
	public List searchFamilyMember(FamilyMemberVO familyMemberVO);
	
	public List viewFamilyMember(FamilyMemberVO familyMemberVO);
	
	public List editFamilyMember(FamilyMemberVO familyMemberVO);
}

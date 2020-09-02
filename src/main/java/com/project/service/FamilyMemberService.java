package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.dao.FamilyMemberDAO;
import com.project.model.FamilyMemberVO;

@Service
public class FamilyMemberService 
{
	@Autowired
	FamilyMemberDAO familymemberDAO;

	@Transactional
	public void insertFamilyMember(FamilyMemberVO familyMemberVO) 
	{
		this.familymemberDAO.insertFamilyMember(familyMemberVO);
	}
	
	@Transactional
	public List searchFamilyMember(FamilyMemberVO familyMemberVO)
	{
		List ls = familymemberDAO.searchFamilyMember(familyMemberVO);
		return ls;
	}
	
	@Transactional
	public List viewFamilyMember(FamilyMemberVO familyMemberVO) 
	{
		List ls = familymemberDAO.viewFamilyMember(familyMemberVO);
		return ls;
	}
	
	@Transactional
	public List editFamilyMember(FamilyMemberVO familyMemberVO) 
	{
		List ls = familymemberDAO.editFamilyMember(familyMemberVO);
		return ls;
	}
}

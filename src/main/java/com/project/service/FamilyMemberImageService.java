package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.dao.FamilyMemberImageDAO;
import com.project.model.FamilyMemberImageVO;
import com.project.model.FamilyMemberVO;

@Service
public class FamilyMemberImageService 
{

	@Autowired
	FamilyMemberImageDAO familyMemberImageDAO;

	@Transactional
	public void insertFamilyMemberImage(FamilyMemberImageVO familyMemberImageVO) 
	{
		this.familyMemberImageDAO.insertFamilyMemberImage(familyMemberImageVO);
	}
	
	@Transactional
	public List searchFamilyMemberImage(FamilyMemberImageVO familyMemberImageVO)
	{
		List ls = familyMemberImageDAO.searchFamilyMemberImage(familyMemberImageVO);
		return ls;
	}
}

package com.project.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.model.FamilyMemberVO;

@Repository
public class FamilyMemberDAOImp implements FamilyMemberDAO
{

	@Autowired
	private SessionFactory sessionFactory;

	public void insertFamilyMember(FamilyMemberVO familyMemberVO) 
	{
		Session session = this.sessionFactory.getCurrentSession();
		session.saveOrUpdate(familyMemberVO);
	}
	
	public List searchFamilyMember(FamilyMemberVO familyMemberVO)
	{
	    List list = new ArrayList();
	    try 
	    {
	    	Session session = this.sessionFactory.getCurrentSession();
    		Query q = session.createQuery("from FamilyMemberVO where deleteStatus=true");
    		list = q.list();
	    }
	    catch (Exception ex)
	    {
			ex.printStackTrace();
		} 
		return list;
	}
	
	public List viewFamilyMember(FamilyMemberVO familyMemberVO) 
	{
		List list = new ArrayList();
	    try 
	    {
	    	Session session = this.sessionFactory.getCurrentSession();
	    	Query q = session.createQuery("from FamilyMemberVO where loginVO.loginId = '"+familyMemberVO.getLoginVO().getLoginId()+"'");
    		list = q.list();
	    }
	    catch (Exception ex)
	    {
			ex.printStackTrace();
		} 
		return list;
	}
	
	public List editFamilyMember(FamilyMemberVO familyMemberVO)
	{
	    List list = new ArrayList();
	    try 
	    {
	    	Session session = this.sessionFactory.getCurrentSession();
    		Query q = session.createQuery("from FamilyMemberVO where familymemberId='"+familyMemberVO.getFamilymemberId()+"'");
    		list = q.list();
	    }
	    catch (Exception ex)
	    {
			ex.printStackTrace();
		} 
		return list;
	}
}

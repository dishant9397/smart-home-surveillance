package com.project.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.model.FamilyMemberImageVO;
import com.project.model.FamilyMemberVO;

@Repository
public class FamilyMemberImageDAOImp implements FamilyMemberImageDAO
{
	@Autowired
	private SessionFactory sessionFactory;

	public void insertFamilyMemberImage(FamilyMemberImageVO familyMemberImageVO) 
	{
		Session session = this.sessionFactory.getCurrentSession();
		session.save(familyMemberImageVO);
	} 
	
	public List searchFamilyMemberImage(FamilyMemberImageVO familyMemberImageVO)
	{
	    List list = new ArrayList();
	    try 
	    {
	    	Session session = this.sessionFactory.getCurrentSession();
    		Query q = session.createQuery("from FamilyMemberImageVO where deleteStatus=true");
    		list = q.list();
	    }
	    catch (Exception ex)
	    {
			ex.printStackTrace();
		} 
		return list;
	}

	public List editFamilyMemberImage(FamilyMemberImageVO familyMemberImageVO)
	{
	    List list = new ArrayList();
	    try 
	    {
	    	Session session = this.sessionFactory.getCurrentSession();
    		Query q = session.createQuery("from FamilyMemberVO where familymemberId='"+familyMemberImageVO.getFamilyMemberVO()+"'");
    		list = q.list();
	    }
	    catch (Exception ex)
	    {
			ex.printStackTrace();
		} 
		return list;
	}
}

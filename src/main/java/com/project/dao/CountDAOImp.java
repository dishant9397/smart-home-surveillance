package com.project.dao;

import java.util.ArrayList;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.model.LoginVO;

@Repository
public class CountDAOImp implements CountDAO
{	
	@Autowired
	private SessionFactory sessionFactory;

	public List activeUser()
	{
	    List list = new ArrayList();
	    try 
	    {
	    	Session session = this.sessionFactory.getCurrentSession();
    		Query q = session.createQuery("SELECT COUNT(registerId) FROM RegisterVO");
    		list = q.list();
	    }
	    catch (Exception ex)
	    {
			ex.printStackTrace();
		} 
		return list;
	}
	
	public List totalComplain(int loginId)
	{
	    List list = new ArrayList();
	    try 
	    {
	    	Session session = this.sessionFactory.getCurrentSession();
    		Query q = session.createQuery("SELECT COUNT(complainId) FROM ComplainVO where loginVO.loginId="+loginId+"");
    		list = q.list();
	    }
	    catch (Exception ex)
	    {
			ex.printStackTrace();
		} 
		return list;
	}
	
	public List pendingComplain(int loginId)
	{
	    List list = new ArrayList();
	    try 
	    {
	    	Session session = this.sessionFactory.getCurrentSession();
    		Query q = session.createQuery("SELECT COUNT(complainId) FROM ComplainVO where complainStatus='Pending' and loginVO.loginId="+loginId+"");
    		list = q.list();
	    }
	    catch (Exception ex)
	    {
			ex.printStackTrace();
		} 
		return list;
	}
	
	public List totalComplain()
	{
	    List list = new ArrayList();
	    try 
	    {
	    	Session session = this.sessionFactory.getCurrentSession();
    		Query q = session.createQuery("SELECT COUNT(complainId) FROM ComplainVO");
    		list = q.list();
	    }
	    catch (Exception ex)
	    {
			ex.printStackTrace();
		} 
		return list;
	}
	
	public List totalPayment()
	{
	    List list = new ArrayList();
	    try 
	    {
	    	Session session = this.sessionFactory.getCurrentSession();
    		Query q = session.createQuery("SELECT COUNT(paymentId) FROM PaymentVO");
    		list = q.list();
	    }
	    catch (Exception ex)
	    {
			ex.printStackTrace();
		} 
		return list;
	}
	
	public List totalFeedback()
	{
	    List list = new ArrayList();
	    try 
	    {
	    	Session session = this.sessionFactory.getCurrentSession();
    		Query q = session.createQuery("SELECT COUNT(feedbackId) FROM FeedbackVO");
    		list = q.list();
	    }
	    catch (Exception ex)
	    {
			ex.printStackTrace();
		} 
		return list;
	}

	public List totalFamilyMember(LoginVO loginVO)
	{
	    List list = new ArrayList();
	    try 
	    {
	    	Session session = this.sessionFactory.getCurrentSession();
    		Query q = session.createQuery("SELECT COUNT(familymemberId) FROM FamilyMemberVO where loginVO.loginId='"+loginVO.getLoginId()+"'");
    		list = q.list();
	    }
	    catch (Exception ex)
	    {
			ex.printStackTrace();
		} 
		return list;
	}
	
	public List totalDetectedPeople(String Username)
	{
	    List list = new ArrayList();
	    try 
	    {
	    	Session session = this.sessionFactory.getCurrentSession();
    		Query q = session.createQuery("SELECT COUNT(id) FROM DetectionVO where username='"+Username+"'");
    		list = q.list();
	    }
	    catch (Exception ex)
	    {
			ex.printStackTrace();
		} 
		return list;
	}
	
	public List graph(String Username)
	{
	    List list = new ArrayList();
	    try 
	    {
	    	Session session = this.sessionFactory.getCurrentSession();
    		Query q = session.createSQLQuery("SELECT COUNT( username ),  DATE( date ) FROM detection WHERE username='"+Username+"' and date >= ( CURDATE() - INTERVAL 9 DAY ) GROUP BY DATE( DATE ) LIMIT 0 , 30;");
    		list = q.list();
	    }
	    catch (Exception ex)
	    {
			ex.printStackTrace();
		} 
		return list;
	}
}

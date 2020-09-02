package com.project.dao;

import java.util.ArrayList;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.model.ComplainVO;
import com.project.model.FeedbackVO;

@Repository
public class FeedbackDAOImp implements FeedbackDAO 
{
    @Autowired
	private SessionFactory sessionFactory;
	
	public void insertFeedback(FeedbackVO feedbackVO) 
	{
		Session session = this.sessionFactory.getCurrentSession();
		session.saveOrUpdate(feedbackVO);	
	}

	public List searchFeedback(FeedbackVO feedbackVO)
	{
	    List list = new ArrayList();
	    try 
	    {
	    	Session session = this.sessionFactory.getCurrentSession();
    		Query q = session.createQuery("from FeedbackVO");
    		list = q.list();
	    }
	    catch (Exception ex)
	    {
			ex.printStackTrace();
		} 
		return list;
	}
}

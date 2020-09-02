package com.project.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DetectionDAOImp implements DetectionDAO 
{
	@Autowired
	private SessionFactory sessionFactory;
	
	public List viewDetection(String Username)
	{
	    List list = new ArrayList();
	    try 
	    {
	    	Session session = this.sessionFactory.getCurrentSession();
    		Query q = session.createQuery("from DetectionVO where username='"+Username+"' ORDER BY Id DESC");
    		list = q.list();
	    }
	    catch (Exception ex)
	    {
			ex.printStackTrace();
		} 
		return list;
	}
	
	public List viewDetectionByDate(String detectedStartDate, String detectedEndDate, String Username)
	{
	    List list = new ArrayList();
	    try 
	    {
	    	Session session = this.sessionFactory.getCurrentSession();
    		Query q = session.createQuery("from DetectionVO where username='"+Username+"' and indiandate >= '"+detectedStartDate+"' and indiandate <= '"+detectedEndDate+"' ORDER BY Id DESC");
    		list = q.list();
	    }
	    catch (Exception ex)
	    {
			ex.printStackTrace();
		} 
		return list;
	}
}

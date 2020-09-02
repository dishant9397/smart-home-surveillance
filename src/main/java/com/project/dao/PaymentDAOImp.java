package com.project.dao;

import java.util.ArrayList;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.model.ComplainVO;
import com.project.model.PaymentVO;
import com.project.model.RegisterVO;
import com.project.model.PackageVO;

@Repository
public class PaymentDAOImp implements PaymentDAO 
{	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void insertPayment(PaymentVO paymentVO) 
    {
        Session session = this.sessionFactory.getCurrentSession();
        session.saveOrUpdate(paymentVO);
    }
	
	public List searchPayment(PaymentVO paymentVO)
	{
	    List list = new ArrayList();
	    try 
	    {
	    	Session session = this.sessionFactory.getCurrentSession();
    		Query q = session.createQuery("from PaymentVO where paymentStatus = 'Paid'");
    		list = q.list();
	    }
	    catch (Exception ex)
	    {
			ex.printStackTrace();
		} 
		return list;
	}
	
	public List viewPayment(int paymentId)
	{
	    List list = new ArrayList();
	    try 
	    {
	    	Session session = this.sessionFactory.getCurrentSession();
    		Query q = session.createQuery("from PaymentVO where paymentid = "+paymentId+"");
    		list = q.list();
	    }
	    catch (Exception ex)
	    {
			ex.printStackTrace();
		} 
		return list;
	}
	
	public List filterPayment(String paymentStatus, String paymentType, String dateType, String StartDate, String EndDate)
	{
	    List list = new ArrayList();
	    try 
	    {
	    	Session session = this.sessionFactory.getCurrentSession();
	    	if(paymentStatus.equals("All") && paymentType.equals("All"))
	    	{
	    		System.out.println("1st if");
	    		Query q = session.createQuery("from PaymentVO where "+dateType+" >= '"+StartDate+"' and "+dateType+" <= '"+EndDate+"'");
	    		list = q.list();
	    	}	
	    	else if (paymentStatus.equals("All") && paymentType != "All") 
	    	{
	    		System.out.println("2nd if");
	    		Query q = session.createQuery("from PaymentVO where paymentType = '"+paymentType+"' and "+dateType+" >= '"+StartDate+"' and "+dateType+" <= '"+EndDate+"'");
	    		list = q.list();
			}
	    	else if (paymentStatus != "All" && paymentType.equals("All")) 
	    	{
	    		System.out.println("3rd if");
	    		Query q = session.createQuery("from PaymentVO where paymentStatus = '"+paymentStatus+"' and "+dateType+" >= '"+StartDate+"' and "+dateType+" <= '"+EndDate+"'");
	    		list = q.list();
			}
	    	else
	    	{
	    		System.out.println("4th if");
	    		Query q = session.createQuery("from PaymentVO where paymentStatus = '"+paymentStatus+"' and paymentType = '"+paymentType+"' and "+dateType+" >= '"+StartDate+"' and "+dateType+" <= '"+EndDate+"'");
	    		list = q.list();
			}
	    }
	    catch (Exception ex)
	    {
			ex.printStackTrace();
		} 
		return list;
	}
}

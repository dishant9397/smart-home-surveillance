package com.project.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.model.ComplainVO;
import com.project.model.PackageVO;

@Repository
public class ComplainDAOImp implements ComplainDAO 
{	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void insertComplain(ComplainVO complainVO) 
	{
		Session session = this.sessionFactory.getCurrentSession();
		session.saveOrUpdate(complainVO);		
	}

	public List searchComplain(ComplainVO complainVO) {
		List list = new ArrayList();
	    try 
	    {
	    	Session session = this.sessionFactory.getCurrentSession();
    		Query q = session.createQuery("from ComplainVO where deleteStatus=true and complainStatus = 'Pending'");
    		list = q.list();
	    }
	    catch (Exception ex)
	    {
			ex.printStackTrace();
		} 
		return list;
	}
	
	public List searchComplainByDate(ComplainVO complainVO, String complainStatus, String complainDateType, String complainStartDate, String complainEndDate) 
	{
		List list = new ArrayList();
	    try 
	    {
	    	Session session = this.sessionFactory.getCurrentSession();
	    	if(complainStatus.equals("All"))
	    	{
	    		Query q = session.createQuery("from ComplainVO where loginVO.loginId = '"+complainVO.getLoginVO().getLoginId()+"' and "+complainDateType+" >= '"+complainStartDate+"' and "+complainDateType+" <= '"+complainEndDate+"'");
	    		list = q.list();
	    	}
	    	else
	    	{
	    		Query q = session.createQuery("from ComplainVO where loginVO.loginId = '"+complainVO.getLoginVO().getLoginId()+"' and complainStatus = '"+complainStatus+"' and "+complainDateType+" >= '"+complainStartDate+"' and "+complainDateType+" <= '"+complainEndDate+"'");
	    		list = q.list();
	    	}
	    }
	    catch (Exception ex)
	    {
			ex.printStackTrace();
		} 
		return list;
	}
	
	public List viewComplain(ComplainVO complainVO) 
	{
		List list = new ArrayList();
	    try 
	    {
	    	Session session = this.sessionFactory.getCurrentSession();
	    	Query q = session.createQuery("from ComplainVO where loginVO.loginId = '"+complainVO.getLoginVO().getLoginId()+"' and complainStatus = 'Pending'");
    		list = q.list();
	    }
	    catch (Exception ex)
	    {
			ex.printStackTrace();
		} 
		return list;
	}
	
	public List viewComplainByDate(ComplainVO complainVO, String complainStatus, String complainDateType, String complainStartDate, String complainEndDate) 
	{
		List list = new ArrayList();
	    try 
	    {
	    	Session session = this.sessionFactory.getCurrentSession();
	    	if(complainStatus.equals("All"))
	    	{
	    		Query q = session.createQuery("from ComplainVO where loginVO.loginId = '"+complainVO.getLoginVO().getLoginId()+"' and "+complainDateType+" >= '"+complainStartDate+"' and "+complainDateType+" <= '"+complainEndDate+"'");
	    		list = q.list();
	    	}
	    	else
	    	{
	    		Query q = session.createQuery("from ComplainVO where loginVO.loginId = '"+complainVO.getLoginVO().getLoginId()+"' and complainStatus = '"+complainStatus+"' and "+complainDateType+" >= '"+complainStartDate+"' and "+complainDateType+" <= '"+complainEndDate+"'");
	    		list = q.list();
	    	}
	    }
	    catch (Exception ex)
	    {
			ex.printStackTrace();
		} 
		return list;
	}

	public List editComplain(ComplainVO complainVO) 
	{
		 List list = new ArrayList();
		    try 
		    {
		    	Session session = this.sessionFactory.getCurrentSession();
	    		Query q = session.createQuery("from ComplainVO where complainId='"+complainVO.getComplainId()+"'");
	    		list = q.list();
		    }
		    catch (Exception ex)
		    {
				ex.printStackTrace();
			} 
			return list;	
	}
}

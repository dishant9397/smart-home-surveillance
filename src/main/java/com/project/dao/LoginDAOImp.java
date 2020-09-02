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
public class LoginDAOImp implements LoginDAO
{
	@Autowired
	private SessionFactory sessionFactory;

	public void insertRegister(LoginVO loginVO) 
	{
		Session session = this.sessionFactory.getCurrentSession();
		session.saveOrUpdate(loginVO);
	}
	
	public List getUsername(String username)
	{
	    List list = new ArrayList();
	    try 
	    {
	    	Session session = this.sessionFactory.getCurrentSession();
    		Query q = session.createQuery("from LoginVO where username ='"+username+"'");
    		list = q.list();
	    }
	    catch (Exception ex)
	    {
			ex.printStackTrace();
		} 
		return list;
	}
	
	public List searchUser(LoginVO loginVO)
	{
	    List list = new ArrayList();
	    try 
	    {
	    	Session session = this.sessionFactory.getCurrentSession();
    		Query q = session.createQuery("from LoginVO");
    		list = q.list();
	    }
	    catch (Exception ex)
	    {
			ex.printStackTrace();
		} 
		return list;
	}
	
	public List blockUser(int loginId)
	{
	    List list = new ArrayList();
	    try 
	    {
	    	Session session = this.sessionFactory.getCurrentSession();
    		Query q = session.createQuery("Update LoginVO set enabled=0 where loginId='"+loginId+"'");
    		q.executeUpdate();
	    }
	    catch (Exception ex)
	    {
			ex.printStackTrace();
		} 
		return list;
	}
	
	public List unblockUser(int loginId)
	{
	    List list = new ArrayList();
	    try 
	    {
	    	Session session = this.sessionFactory.getCurrentSession();
    		Query q = session.createQuery("Update LoginVO set enabled=1 where loginId='"+loginId+"'");
    		q.executeUpdate();
	    }
	    catch (Exception ex)
	    {
			ex.printStackTrace();
		} 
		return list;
	}
	
	public List activatePackage(String packageEndDate, int loginId)
	{
	    List list = new ArrayList();
	    try 
	    {
	    	Session session = this.sessionFactory.getCurrentSession();
    		Query q = session.createQuery("Update LoginVO set packageEndDate = DATE_FORMAT('"+packageEndDate+"', '%d-%m-%Y'), packageStatus = 'Active' where loginId="+loginId+"");
    		q.executeUpdate();
	    }
	    catch (Exception ex)
	    {
			ex.printStackTrace();
		} 
		return list;
	}
	
	public void updatePassword(int loginId, LoginVO loginVO)
	{
	    try 
	    {
	    	Session session = this.sessionFactory.getCurrentSession();
    		Query q = session.createQuery("Update LoginVO set password='"+loginVO.getPassword()+"' where email='"+loginId+"'");
    		q.executeUpdate();
	    }
	    catch (Exception ex)
	    {
			ex.printStackTrace();
		} 
	}
}

package com.project.dao;

import java.util.ArrayList;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.model.RegisterVO;
import com.project.model.LoginVO;

@Repository
public class RegisterDAOImp implements RegisterDAO 
{
	@Autowired
	private SessionFactory sessionFactory;

	public void insertRegister(RegisterVO registerVO) 
	{
		Session session = this.sessionFactory.getCurrentSession();
		session.saveOrUpdate(registerVO);
	}

	public List searchUser(RegisterVO registerVO)
	{
	    List list = new ArrayList();
	    try 
	    {
	    	Session session = this.sessionFactory.getCurrentSession();
    		Query q = session.createQuery("from RegisterVO");
    		list = q.list();
	    }
	    catch (Exception ex)
	    {
			ex.printStackTrace();
		} 
		return list;
	}
	
	public List viewUser(RegisterVO registerVO)
	{
	    List list = new ArrayList();
	    try 
	    {
	    	Session session = this.sessionFactory.getCurrentSession();
    		Query q = session.createQuery("from RegisterVO");
    		list = q.list();
	    }
	    catch (Exception ex)
	    {
			ex.printStackTrace();
		} 
		return list;
	}
	
	public List editUser(RegisterVO registerVO)
	{
	    List list = new ArrayList();
	    try 
	    {
	    	Session session = this.sessionFactory.getCurrentSession();
    		Query q = session.createQuery("from RegisterVO where registerId='"+registerVO.getRegisterId()+"'");
    		list = q.list();
	    }
	    catch (Exception ex)
	    {
			ex.printStackTrace();
		} 
		return list;
	}
	
	public List editProfile(RegisterVO registerVO)
	{
	    List list = new ArrayList();
	    try 
	    {
	    	Session session = this.sessionFactory.getCurrentSession();
    		Query q = session.createQuery("from RegisterVO where loginVO.loginId='"+registerVO.getLoginVO().getLoginId()+"'");
    		list = q.list();
	    }
	    catch (Exception ex)
	    {
			ex.printStackTrace();
		} 
		return list;
	}
	
	public List imageName(int loginId)
	{
	    List list = new ArrayList();
	    try 
	    {
	    	Session session = this.sessionFactory.getCurrentSession();
    		Query q = session.createQuery("from RegisterVO where loginVO.loginId='"+loginId+"'");
    		list = q.list();
	    }
	    catch (Exception ex)
	    {
			ex.printStackTrace();
		} 
		return list;
	}
	
	public List forgotPassword(RegisterVO registerVO)
	{
	    List list = new ArrayList();
	    try 
	    {
	    	Session session = this.sessionFactory.getCurrentSession();
    		Query q = session.createQuery("from RegisterVO where email='"+registerVO.getEmail()+"'");
    		list = q.list();
	    }
	    catch (Exception ex)
	    {
			ex.printStackTrace();
		} 
		return list;
	}
}

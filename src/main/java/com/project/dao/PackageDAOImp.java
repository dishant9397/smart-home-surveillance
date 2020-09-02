package com.project.dao;
 
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.model.PackageVO;
 
@Repository
public class PackageDAOImp implements PackageDAO
{
    @Autowired
    private SessionFactory sessionFactory;
 
    public void insertPackage(PackageVO packageVO) 
    {
        Session session = this.sessionFactory.getCurrentSession();
        session.saveOrUpdate(packageVO);
    }
     
    public List searchPackage(PackageVO packageVO)
    {
        List list = new ArrayList();
        try
        {
            Session session = this.sessionFactory.getCurrentSession();
            Query q = session.createQuery("from PackageVO where deleteStatus=true");
            list = q.list();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        } 
        return list;
    }
     
    public List editPackage(PackageVO packageVO)
    {
        List list = new ArrayList();
        try
        {
            Session session = this.sessionFactory.getCurrentSession();
            Query q = session.createQuery("from PackageVO where packageId='"+packageVO.getPackageId()+"'");
            list = q.list();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        } 
        return list;
    }
    
    public List viewPackage(int packageId)
    {
        List list = new ArrayList();
        try
        {
            Session session = this.sessionFactory.getCurrentSession();
            Query q = session.createQuery("from PackageVO where packageId='"+packageId+"'");
            list = q.list();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        } 
        return list;
    }
}
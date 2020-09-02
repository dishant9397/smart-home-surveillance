package com.project.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.dao.*;
import com.project.model.*;

@Service
public class PaymentService 
{
	@Autowired
	PaymentDAO paymentDAO;

	@Transactional
	public void insertPayment(PaymentVO paymentVO) 
	{
		this.paymentDAO.insertPayment(paymentVO);
	}
	
	@Transactional
	public List searchPayment(PaymentVO paymentVO)
	{
		List ls = paymentDAO.searchPayment(paymentVO);
		return ls;
	}
	
	@Transactional
	public List viewPayment(int paymentId)
	{
		List ls = paymentDAO.viewPayment(paymentId);
		return ls;
	}
	
	@Transactional
	public List filterPayment(String paymentStatus, String paymentType, String dateType, String StartDate, String EndDate)
	{
		List ls = paymentDAO.filterPayment(paymentStatus, paymentType, dateType, StartDate, EndDate);
		return ls;
	}
}


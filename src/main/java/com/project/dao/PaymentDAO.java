package com.project.dao;

import java.util.List;


import com.project.model.PaymentVO;
import com.project.model.RegisterVO;

public interface PaymentDAO 
{
	public void insertPayment(PaymentVO paymentVO);
	
	public List searchPayment(PaymentVO paymentVO);
	
	public List viewPayment(int paymentId);
	
	public List filterPayment(String paymentStatus, String paymentType, String dateType, String StartDate, String EndDate);
}

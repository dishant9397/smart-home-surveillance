package com.project.model;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="payment")
public class PaymentVO 
{
	@Id
	@Column(name="paymentId")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int paymentId;
		
	@Column(name="paymentTransactionId")
	private String paymentTransactionId;
	
	@Column(name="paymentDate")
	private String paymentDate; 
	
	@Column(name="paymentTime")
	private String paymentTime;

	@Column(name="paymentAmount")
	private String paymentAmount;
	
	@Column(name="paymentType")
	private String paymentType;

	@Column(name="paymentStatus")
	private String paymentStatus;
	
	@Column(name="paymentApprovedDate")
	private String paymentApprovedDate;
	
	@Column(name="paymentApprovedTime")
	private String paymentApprovedTime;
	
	@ManyToOne
	private LoginVO loginVO;
	
	@ManyToOne
	private PackageVO packageVO;

	public PackageVO getPackageVO() {
		return packageVO;
	}

	public void setPackageVO(PackageVO packageVO) {
		this.packageVO = packageVO;
	}

	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public String getPaymentTransactionId() {
		return paymentTransactionId;
	}

	public void setPaymentTransactionId(String paymentTransactionId) {
		this.paymentTransactionId = paymentTransactionId;
	}

	public String getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}

	public String getPaymentTime() {
		return paymentTime;
	}

	public void setPaymentTime(String paymentTime) {
		this.paymentTime = paymentTime;
	}

	public String getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(String paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public String getPaymentApprovedDate() {
		return paymentApprovedDate;
	}

	public void setPaymentApprovedDate(String paymentApprovedDate) {
		this.paymentApprovedDate = paymentApprovedDate;
	}

	public String getPaymentApprovedTime() {
		return paymentApprovedTime;
	}

	public void setPaymentApprovedTime(String paymentApprovedTime) {
		this.paymentApprovedTime = paymentApprovedTime;
	}

	public LoginVO getLoginVO() {
		return loginVO;
	}

	public void setLoginVO(LoginVO loginVO) {
		this.loginVO = loginVO;
	}
}

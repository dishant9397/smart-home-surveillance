package com.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="complain")
public class ComplainVO 
{
	@Id
	@Column(name="complainId")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int complainId;
		
	@Column(name="complainSubject")
	private String complainSubject; 

	@Column(name="complainDescription")
	private String complainDescription;
	
	@Column(name="complainImageName")
	private String complainImageName;

	@Column(name="complainImagePath")
	private String complainImagePath;
	
	@Column(name="complainReply")
	private String complainReply;
	
	@Column(name="complainStatus")
	private String complainStatus;
	
	@Column(name="deleteStatus")
	private boolean deleteStatus=true;
	
	@Column(name="complainInsertDate")
	private String complainInsertDate;
	
	@Column(name="complainInsertTime")
	private String complainInsertTime;

	@Column(name="complainReplyDate")
	private String complainReplyDate;
	
	@Column(name="complainReplyTime")
	private String complainReplyTime;
	
	@ManyToOne
	private LoginVO loginVO;

	public String getComplainInsertTime() {
		return complainInsertTime;
	}

	public void setComplainInsertTime(String complainInsertTime) {
		this.complainInsertTime = complainInsertTime;
	}

	public String getComplainReplyTime() {
		return complainReplyTime;
	}

	public void setComplainReplyTime(String complainReplyTime) {
		this.complainReplyTime = complainReplyTime;
	}

	public String getComplainInsertDate() {
		return complainInsertDate;
	}

	public void setComplainInsertDate(String complainInsertDate) {
		this.complainInsertDate = complainInsertDate;
	}

	public String getComplainReplyDate() {
		return complainReplyDate;
	}

	public void setComplainReplyDate(String complainReplyDate) {
		this.complainReplyDate = complainReplyDate;
	}

	public LoginVO getLoginVO() {
		return loginVO;
	}

	public void setLoginVO(LoginVO loginVO) {
		this.loginVO = loginVO;
	}

	public boolean isDeleteStatus() {
		return deleteStatus;
	}

	public void setDeleteStatus(boolean deleteStatus) {
		this.deleteStatus = deleteStatus;
	}

	public String getComplainReply() {
		return complainReply;
	}

	public void setComplainReply(String complainReply) {
		this.complainReply = complainReply;
	}

	public String getComplainStatus() {
		return complainStatus;
	}

	public void setComplainStatus(String complainStatus) {
		this.complainStatus = complainStatus;
	}

	public int getComplainId() {
		return complainId;
	}

	public void setComplainId(int complainId) {
		this.complainId = complainId;
	}

	public String getComplainSubject() {
		return complainSubject;
	}

	public void setComplainSubject(String complainSubject) {
		this.complainSubject = complainSubject;
	}

	public String getComplainDescription() {
		return complainDescription;
	}

	public void setComplainDescription(String complainDescription) {
		this.complainDescription = complainDescription;
	}

	public String getComplainImageName() {
		return complainImageName;
	}

	public void setComplainImageName(String complainImageName) {
		this.complainImageName = complainImageName;
	}

	public String getComplainImagePath() {
		return complainImagePath;
	}

	public void setComplainImagePath(String complainImagePath) {
		this.complainImagePath = complainImagePath;
	}


}

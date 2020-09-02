package com.project.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="familymember")
public class FamilyMemberVO 
{
	@Id
	@Column(name="familymemberId")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int familymemberId;
		
	@Column(name="familymemberFirstName")
	private String familymemberFirstName; 

	@Column(name="familymemberLastName")
	private String familymemberLastName;
	
	@Column(name="familymemberPhoneNumber")
	private String familymemberPhoneNumber;
	
	@Column(name="familymemberEmail")
	private String familymemberEmail;

	@Column(name="deleteStatus")
	private boolean deleteStatus=true;
	
	@ManyToOne
	private LoginVO loginVO;
	
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
	
	public int getFamilymemberId() {
		return familymemberId;
	}
	public void setFamilymemberId(int familymemberId) {
		this.familymemberId = familymemberId;
	}

	public String getFamilymemberFirstName() {
		return familymemberFirstName;
	}

	public void setFamilymemberFirstName(String familymemberFirstName) {
		this.familymemberFirstName = familymemberFirstName;
	}

	public String getFamilymemberLastName() {
		return familymemberLastName;
	}

	public void setFamilymemberLastName(String familymemberLastName) {
		this.familymemberLastName = familymemberLastName;
	}

	public String getFamilymemberPhoneNumber() {
		return familymemberPhoneNumber;
	}

	public void setFamilymemberPhoneNumber(String familymemberPhoneNumber) {
		this.familymemberPhoneNumber = familymemberPhoneNumber;
	}

	public String getFamilymemberEmail() {
		return familymemberEmail;
	}

	public void setFamilymemberEmail(String familymemberEmail) {
		this.familymemberEmail = familymemberEmail;
	}

}

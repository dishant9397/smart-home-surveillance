package com.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="familymemberimage")
public class FamilyMemberImageVO 
{
	@Id
	@Column(name="familymemberImageId")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int familyMemberImageId;

	@Column(name="familymemberImageName")
	private String familymemberImageName;

	@Column(name="familymemberImagePath")
	private String familyMemberImagePath;

	@Column(name="deleteStatus")
	private boolean deleteStatus=true;

	@ManyToOne
	private FamilyMemberVO familyMemberVO;
	
	public boolean isDeleteStatus() {
		return deleteStatus;
	}

	public void setDeleteStatus(boolean deleteStatus) {
		this.deleteStatus = deleteStatus;
	}
	
	public int getFamilyMemberImageId() {
		return familyMemberImageId;
	}

	public void setFamilyMemberImageId(int familyMemberImageId) {
		this.familyMemberImageId = familyMemberImageId;
	}

	public String getFamilymemberImageName() {
		return familymemberImageName;
	}

	public void setFamilymemberImageName(String familymemberImageName) {
		this.familymemberImageName = familymemberImageName;
	}

	public String getFamilyMemberImagePath() {
		return familyMemberImagePath;
	}

	public void setFamilyMemberImagePath(String familyMemberImagePath) {
		this.familyMemberImagePath = familyMemberImagePath;
	}

	public FamilyMemberVO getFamilyMemberVO() {
		return familyMemberVO;
	}

	public void setFamilyMemberVO(FamilyMemberVO familyMemberVO) {
		this.familyMemberVO = familyMemberVO;
	}

	
	
	
}

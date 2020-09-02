package com.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="package")
public class PackageVO 
{
	@Id
	@Column(name="packageId")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int packageId;
		
	@Column(name="packageName")
	private String packageName; 

	@Column(name="packageDuration")
	private String packageDuration;
	
	@Column(name="packageDurationType")
	private String packageDurationType;
	
	@Column(name="packageDescription")
	private String packageDescription;
	
	@Column(name="packageAmount")
	private String packageAmount;
	
	@Column(name="deleteStatus")
	private boolean deleteStatus=true;
	
	public String getPackageDurationType() {
		return packageDurationType;
	}

	public void setPackageDurationType(String packageDurationType) {
		this.packageDurationType = packageDurationType;
	}

	public int getPackageId() {
		return packageId;
	}

	public void setPackageId(int packageId) {
		this.packageId = packageId;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getPackageDuration() {
		return packageDuration;
	}

	public void setPackageDuration(String packageDuration) {
		this.packageDuration = packageDuration;
	}

	public String getPackageDescription() {
		return packageDescription;
	}

	public void setPackageDescription(String packageDescription) {
		this.packageDescription = packageDescription;
	}

	public String getPackageAmount() {
		return packageAmount;
	}

	public void setPackageAmount(String packageAmount) {
		this.packageAmount = packageAmount;
	}

	public boolean isDeleteStatus() {
		return deleteStatus;
	}

	public void setDeleteStatus(boolean deleteStatus) {
		this.deleteStatus = deleteStatus;
	}
}

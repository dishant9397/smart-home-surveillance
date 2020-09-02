package com.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="login")
public class LoginVO 
{
	@Id
	@Column(name="loginId")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int loginId;
		
	@Column(name="username")
	private String username; 

	@Column(name="password")
	private String password;
	
	@Column(name="enabled")
	private int enabled;

	@Column(name="role")
	private String role;
	
	@Column(name="packageStatus")
	private String packageStatus;
	
	@Column(name="packageEndDate")
	private String packageEndDate;

	public String getPackageEndDate() {
		return packageEndDate;
	}

	public void setPackageEndDate(String packageEndDate) {
		this.packageEndDate = packageEndDate;
	}

	public int getEnabled() {
		return enabled;
	}

	public String getPackageStatus() {
		return packageStatus;
	}

	public void setPackageStatus(String packageStatus) {
		this.packageStatus = packageStatus;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}
	
	public int getLoginId() {
		return loginId;
	}

	public void setLoginId(int loginId) {
		this.loginId = loginId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}

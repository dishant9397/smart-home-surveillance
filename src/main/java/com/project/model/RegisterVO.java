package com.project.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="register")
public class RegisterVO 
{
	@Id
	@Column(name="registerId")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int registerId;
		
	@Column(name="firstname")
	private String firstname; 

	@Column(name="lastname")
	private String lastname;
	
	@Column(name="phonenumber")
	private String phonenumber;
	
	@Column(name="email")
	private String email;
	
	@Column(name="homename")
	private String homename;
	
	@Column(name="address")
	private String address;
	
	@Column(name="imagename")
	private String imagename;
	
	@Column(name="imagepath")
	private String imagepath;
	
	@ManyToOne
	private LoginVO loginVO;

	public String getHomename() {
		return homename;
	}

	public void setHomename(String homename) {
		this.homename = homename;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getImagename() {
		return imagename;
	}

	public void setImagename(String imagename) {
		this.imagename = imagename;
	}

	public String getImagepath() {
		return imagepath;
	}

	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}

	public int getRegisterId() {
		return registerId;
	}

	public void setRegisterId(int registerId) {
		this.registerId = registerId;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LoginVO getLoginVO() {
		return loginVO;
	}

	public void setLoginVO(LoginVO loginVO) {
		this.loginVO = loginVO;
	}
	
}

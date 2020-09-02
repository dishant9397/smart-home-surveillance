package com.project.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="detection")
public class DetectionVO 
{
	@Id
	@Column(name="Id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Id;
		
	@Column(name="date")
	private String date; 
	
	@Column(name="indiandate")
	private String indiandate; 

	@Column(name="time")
	private String time;
	
	@Column(name="imageName")
	private String imageName;
	
	@Column(name="username")
	private String username;

	public String getIndiandate() {
		return indiandate;
	}

	public void setIndiandate(String indiandate) {
		this.indiandate = indiandate;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
}

package com.project.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="feedback")
public class FeedbackVO 
{
	@Id
	@Column(name="feedbackId")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int feedbackId;
	
	@Column(name="feedbackRating")
	private String feedbackRating;	
	
	@Column(name="feedbackDescription")
	private String feedbackDescription;
	
	@Column(name="feedbackInsertDate")
	private String feedbackInsertDate;
	
	@ManyToOne
	private LoginVO loginVO;

	public String getFeedbackInsertDate() {
		return feedbackInsertDate;
	}

	public void setFeedbackInsertDate(String feedbackInsertDate) {
		this.feedbackInsertDate = feedbackInsertDate;
	}

	public LoginVO getLoginVO() {
		return loginVO;
	}

	public void setLoginVO(LoginVO loginVO) {
		this.loginVO = loginVO;
	}

	public int getFeedbackId() {
		return feedbackId;
	}

	public void setFeedbackId(int feedbackId) {
		this.feedbackId = feedbackId;
	}

	public String getFeedbackRating() {
		return feedbackRating;
	}

	public void setFeedbackRating(String feedbackRating) {
		this.feedbackRating = feedbackRating;
	}

	public String getFeedbackDescription() {
		return feedbackDescription;
	}

	public void setFeedbackDescription(String feedbackDescription) {
		this.feedbackDescription = feedbackDescription;
	}

}

package com.capgemini.onlinetestmanagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="online_test")
public class Exam {
	
	@Id
	@Column(name="exam_id")
	private int examId;
	@Column(name="exam_name", length=20)
	private String examName;
	@Column(name="minutes")
	private int minutes;
	
	
	public Exam() {	}
	public Exam(int examId, String examName, int minutes) {
		this.examId = examId;
		this.examName = examName;
		this.minutes = minutes;
	}
	
	public int getExamId() {
		return examId;
	}
	public void setExamId(int examId) {
		this.examId = examId;
	}
	public String getExamName() {
		return examName;
	}
	public void setExamName(String examName) {
		this.examName = examName;
	}
	public int getMinutes() {
		return minutes;
	}
	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}
	
	
	@Override
	public String toString() {
		return "Exam [examId=" + examId + ", examName=" + examName + ", minutes=" + minutes + "]";
	}
	
	
}


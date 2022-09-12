package com.capgemini.onlinetestmanagement.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="assign_exam_to_user")
public class AssignExamToUser implements Serializable{
	
	@Id
	@Column(name="assigned_id")
	private int assignedId;   //
	
	@Column(name="marks")
	private int marks;
	
	@Column(name="status")
	private boolean status;
	
	@Column(name="date_of_exam")
	private LocalDate dateOfExam;
	
	@ManyToOne
	@JoinColumn(name="user_id" , referencedColumnName = "user_id")
	private User user ;
	
	@ManyToOne
	@JoinColumn(name="exam_id" , referencedColumnName = "exam_id")
	private Exam exam ;

	
	
	public AssignExamToUser() {	}
	public AssignExamToUser(int assignedId, int marks, boolean status, LocalDate dateOfExam, User user, Exam exam) {
		this.assignedId = assignedId;
		this.marks = marks;
		this.status = status;
		this.dateOfExam = dateOfExam;
		this.user = user;
		this.exam = exam;
	}

	
	
	public int getAssignedId() {
		return assignedId;
	}

	public void setAssignedId(int assignedId) {
		this.assignedId = assignedId;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public LocalDate getDateOfExam() {
		return dateOfExam;
	}

	public void setDateOfExam(LocalDate dateOfExam) {
		this.dateOfExam = dateOfExam;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Exam getExam() {
		return exam;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
	}

	@Override
	public String toString() {
		return "AssignExamToUser [assignedId=" + assignedId + ", marks=" + marks + ", status=" + status
				+ ", dateOfExam=" + dateOfExam + ", user=" + user + ", exam=" + exam + "]";
	}
	
}

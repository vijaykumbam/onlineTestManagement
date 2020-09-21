package com.capgemini.onlinetestmanagement.service;

import java.util.List;
import java.util.Optional;

import com.capgemini.onlinetestmanagement.entity.AssignExamToUser;
import com.capgemini.onlinetestmanagement.entity.Exam;
import com.capgemini.onlinetestmanagement.entity.User;

public interface AssignExamToUserServiceI {
	
	    //User details.......
		public boolean addUser(User user);
		public boolean editUser(User user);
		public Optional<User> getUserById(int userId);
		public List<User> getAllUsers();
		
		
		
		//Exam details.......
		public boolean addExam(Exam exam);
		public boolean editExam(Exam exam);
		public List<Exam> viewExams();
		public Optional<Exam> getExamById(int examId);
		
		
		
		//Assign Exam to Users(Admin Functions)
		
		//Queries Started..........
		
		public List<AssignExamToUser> viewExamsForUserToTake(int userId);
		
		
		//Vijay
		public AssignExamToUser assignExamToUser(int userId, int examId);
		public String editAssignExamToUser(AssignExamToUser editAssignExamToUser ,int examId);
		public Optional<AssignExamToUser> viewAssignExamById(int assignedId);
		public List<AssignExamToUser> viewExamHistoryForUserAttended(int userId);
		public Boolean checkDateConflict(int userId,int year,int month,int date );
}

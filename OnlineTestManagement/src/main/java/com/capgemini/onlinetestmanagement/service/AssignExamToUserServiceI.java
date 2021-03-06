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
		public User getUserById(long userId);
		public List<User> getAllUsers();
		
		
		
		//Exam details.......
		public boolean addExam(Exam exam);
		public boolean editExam(Exam exam);
		public List<Exam> viewExams();
		public Optional<Exam> getExamById(int examId);
		
		
		
		//Assign Exam to Users(Admin Functions)
		
		//Queries Started..........
		
		public List<AssignExamToUser> viewExamsForUserToTake(long userId);
		
		
		//Vijay
		public AssignExamToUser assignExamToUser(long userId, int examId);
		public String editAssignExamToUser(int assignedId ,int examId);
		public Optional<AssignExamToUser> viewAssignExamById(int assignedId);
		public List<AssignExamToUser> viewExamHistoryForUserAttended(long userId);
		public String checkDateConflict(long userId,int year,int month,int date );
}

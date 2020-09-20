package com.capgemini.onlinetestmanagement.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.onlinetestmanagement.dao.AssignExamToUserDaoI;
import com.capgemini.onlinetestmanagement.dao.ExamDaoI;
import com.capgemini.onlinetestmanagement.dao.UserDaoI;
import com.capgemini.onlinetestmanagement.entity.AssignExamToUser;
import com.capgemini.onlinetestmanagement.entity.Exam;
import com.capgemini.onlinetestmanagement.entity.User;

@Service
@Transactional
public class AssignExamToUserServiceImpl implements AssignExamToUserServiceI{

	
	@Autowired
	private AssignExamToUserDaoI assignExamToUserDaoI;
	
	@Autowired
	private ExamDaoI examDaoI;
	
	@Autowired
	private UserDaoI userDaoI;
	
	

	@Override
	public boolean addUser(User user) {
		userDaoI.save(user);
		return true;
	}

	@Override
	public boolean editUser(User user) {
		userDaoI.saveAndFlush(user);
		return true;
	}

	@Override
	public Optional<User> getUserById(int userId) {
		Optional<User> user = userDaoI.findById(userId);
		return user;
	}

	@Override
	public List<User> getAllUsers() {
		List<User> user =userDaoI.findAll();
		return user;
	}

	@Override
	public boolean addExam(Exam exam) {
		examDaoI.save(exam);
		return true;
	}

	@Override
	public boolean editExam(Exam exam) {
		examDaoI.saveAndFlush(exam);
		return true;
	}

	@Override
	public List<Exam> viewExams() {
		List<Exam> obj = examDaoI.findAll();
		return obj;
	}

	@Override
	public Optional<Exam> getExamById(int examId) {
		Optional<Exam> obj=examDaoI.findById(examId);
		return obj;
	}

	
	
	
	
	
	//Done
	@Override
	public AssignExamToUser assignExamToUser(int userId, int examId) {
		
		Optional<Exam> exam=examDaoI.findById(examId);
		Optional<User> user = userDaoI.findById(userId);
		
		if(exam!=null && user!= null) {
			System.out.println("Userid and examId both are present ");
			int lastId = assignExamToUserDaoI.getLastExamUserAssignId() ;
			int maxId = lastId+1;
			Exam examObj = new Exam();
			examObj.setExamId(examId);
			
			User userObj = new User();
			userObj.setUserId(userId);
			
			AssignExamToUser obj = new AssignExamToUser();
			obj.setAssignedId(maxId);
			obj.setDateOfExam((LocalDate.now()));
			obj.setStatus(true);
			obj.setExam(examObj);
			obj.setUser(userObj);
			System.out.println("Exam is assigned");
			return assignExamToUserDaoI.save(obj);
		}
		else
		{
			return null;
		}
	
	}
	



	//Done
	@Override
	public String editAssignExamToUser(AssignExamToUser assign,int examId) {
		Optional<AssignExamToUser> status = assignExamToUserDaoI.findById(assign.getAssignedId());
		if(status != null) {			
			Exam obj = assign.getExam();
			obj.setExamId(examId);
			obj.setExamName(assign.getExam().getExamName());
			obj.setMinutes(assign.getExam().getMinutes());
			
			assign.setExam(obj);
			assignExamToUserDaoI.saveAndFlush(assign);
			return "Successfully Edited";
		}
		else
		return "Unsuccessfully Edited"; 
	}
	
	//Done
	@Override
	public Optional<AssignExamToUser> viewAssignExamById(int assignedId) {
		Optional<AssignExamToUser> status = assignExamToUserDaoI.findById(assignedId);
		return status;
	}
	

	/*
	 * 
	 * By using the comparing the local date an
	 */
	
	@Override
	public List<AssignExamToUser> viewExamHistoryForUserAttended(int userId) {
		 List<AssignExamToUser> list = assignExamToUserDaoI.getListOfExamsAssignToUser(userId);
		 
		 System.out.println(list);
		 
		 List<AssignExamToUser> assignedList = list.stream()
				 								  .filter(assignedexam-> !assignedexam.isStatus())
				 								  .collect(Collectors.toList());
		 assignedList.sort((e1,e2)->e2.getDateOfExam().compareTo(e1.getDateOfExam()));
			return assignedList;
	}

	
	
	@Override
	public List<AssignExamToUser> viewExamForUserToTake(int userId) {
		 List<AssignExamToUser> list = assignExamToUserDaoI.getListOfExamsAssignToUser(userId);
		 List<AssignExamToUser> assignedList = list.stream()
				 								  .filter(assignedexam->assignedexam.isStatus())
				 								  .collect(Collectors.toList());
		 assignedList.sort((e1,e2)->e2.getDateOfExam().compareTo(e1.getDateOfExam()));
			return assignedList;
	}



	


	



	
	
}

package com.capgemini.onlinetestmanagement.service;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

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
 
	LocalDate datee;
	
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
	public User getUserById(int userId) {
		Optional<User> user = userDaoI.findById(userId);
		if(user.isPresent())
		{
			User userobj = user.get();
			return userobj;
		}
		return null;
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
		
		Optional<Exam>examObj = examDaoI.findById(examId);
		Optional<AssignExamToUser> status = assignExamToUserDaoI.findById(assign.getAssignedId());
		if(status != null && examObj!= null) {			
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
	 * 
	 */
	//Done
	@Override
	public List<AssignExamToUser> viewExamHistoryForUserAttended(int userId) {
		 List<AssignExamToUser> list = assignExamToUserDaoI.getListOfExamsAssignToUser(userId); 
		 System.out.println(list);
			return list;
	}

	
	
	@Override
	public List<AssignExamToUser> viewExamsForUserToTake(int userId) {
		 List<AssignExamToUser> list = assignExamToUserDaoI.getListOfExamsAssignToUser(userId);
			return list;
	}

	@Override
	public String checkDateConflict(int userId, int year, int month, int date) {		
			List<AssignExamToUser> listObj = viewExamHistoryForUserAttended(userId);
			if(listObj.isEmpty()!=true ) 
			{
				Iterator<AssignExamToUser> itr = listObj.iterator();
				while(itr.hasNext())
				{
					AssignExamToUser obj = itr.next();
					LocalDate dateOfPreviousExams = obj.getDateOfExam();
					try
					{
						datee = LocalDate.of(year, month, date);
						System.out.println(datee);
						if(datee.isEqual(dateOfPreviousExams))
							return "Conflict is Found on this date";
					}
					catch(Exception dateFormateException)
					{
						
						System.out.println(datee);
						return "Date Format Exception";
					}
					
				}
				return "Assign the Exam on this Date";
			}
			else
				return "Can't assign to the Exam to Unknow";
	}




	



	
	
}

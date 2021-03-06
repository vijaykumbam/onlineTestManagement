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
	public User getUserById(long userId) {
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

	
	
	
	/********************************************************************************************************************
	*       @author           VijayVenkatReddy Kumbam
	*       Parameter         userId, examId
	*       version           0.1
	*       Description       This method will assign the Exam to the User, By Verifying the both userId,examId 
	*       				  is present. If it is not present then it will null, If both are valid then it will return the 
	*       				  AssignExamToUser Object.
	*       Created date      20-SEP-2020
	********************************************************************************************************************/
	@Override
	public AssignExamToUser assignExamToUser(long userId, int examId) {
		
		Optional<Exam> exam=examDaoI.findById(examId);
		Optional<User> user = userDaoI.findById(userId);
		System.out.println(exam.get().getExamName());
		
		if(exam.isPresent() && user.isPresent()) {
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
			return assignExamToUserDaoI.save(obj);
		}
		else
		{
			return null;
		}
	}

	
	/********************************************************************************************************************
	*       @author           VijayVenkatReddy Kumbam
	*       Parameter         assign[Object], examId
	*       version           0.1
	*       Description       This method will edit the assigned Exam to the User, By Verifying the examId 
	*       				  is present. If it is not present then it will return "Unsuccessfully Edited", 
	*       				  If object is edited then it will return "Successfully Edited" .
	*       Created date      20-SEP-2020
	********************************************************************************************************************/
	@Override
	public String editAssignExamToUser(int assignedId,int examId) {
		Optional<Exam>examObj = examDaoI.findById(examId);
		Optional<AssignExamToUser> status = assignExamToUserDaoI.findById(assignedId);
		
		Exam eObj = new Exam();
		AssignExamToUser assignObj = new AssignExamToUser();
		if(status.isPresent() && examObj.isPresent()) {
			assignObj = status.get();
			eObj=examObj.get();
			
			eObj.setExamId(examId);
			eObj.setExamName(eObj.getExamName());
			eObj.setMinutes(eObj.getMinutes());
			
			assignObj.setExam(eObj);
			assignExamToUserDaoI.saveAndFlush(assignObj);
			return "Successfully Edited";
		}
		else
		return "Unsuccessfully Edited"; 
	}
	
	/********************************************************************************************************************
	*       @author           VijayVenkatReddy Kumbam
	*       Parameter         assignedId
	*       version           0.1
	*       Description       This method will return the AssignExamToUser if the assignedId is present
	*       Created date      20-SEP-2020
	********************************************************************************************************************/
	@Override
	public Optional<AssignExamToUser> viewAssignExamById(int assignedId) {
		Optional<AssignExamToUser> assignExamToUserObj = assignExamToUserDaoI.findById(assignedId);
		return assignExamToUserObj;
	}
	
	
	
	/********************************************************************************************************************
	*       @author           VijayVenkatReddy Kumbam
	*       Parameter         userId
	*       version           0.1
	*       Description       This method will return the List<AssignExamToUser> if it is empty then it will return he 
	*       				  null or else it will return the list of the AssignExamToUsers.
	*       Created date      20-SEP-2020
	********************************************************************************************************************/
	@Override
	public List<AssignExamToUser> viewExamHistoryForUserAttended(long userId) {
		 List<AssignExamToUser> list = assignExamToUserDaoI.getListOfExamsAssignToUser(userId); 
			return list;
	}

	
	
	/********************************************************************************************************************
	*       @author           VijayVenkatReddy Kumbam
	*       Parameter         userId
	*       version           0.1
	*       Description       This method will give list of Exams which are taken by the User by using the UserId.
	*       				  Incase if he had not taken then it will return null
	*       Created date      20-SEP-2020
	********************************************************************************************************************/
	@Override
	public List<AssignExamToUser> viewExamsForUserToTake(long userId) {
		 List<AssignExamToUser> list = assignExamToUserDaoI.getListOfExamsAssignToUser(userId);
			return list;
	}

	/********************************************************************************************************************
	*       @author           VijayVenkatReddy Kumbam
	*       Parameter         userId,year,month,date
	*       version           0.1
	*       Description       This method will check dateConflict. If it found any conflict it return the Date conflict 
	*       				  is found. else it will return the "We can Assign the Exam".
	*       Created date      20-SEP-2020
	********************************************************************************************************************/
	@Override
	public String checkDateConflict(long userId, int year, int month, int date) {		
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
						if(datee.isEqual(dateOfPreviousExams))
							return "Conflict is Found on this date";
					}
					catch(Exception dateFormateException)
					{
						
						return "Date Format Exception";
					}
					
				}
				return "Assign the Exam on this Date";
			}
			else
				return "Can't assign to the Exam to Unknow";
	}



	
}

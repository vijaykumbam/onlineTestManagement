package com.capgemini.onlinetestmanagement.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.onlinetestmanagement.entity.AssignExamToUser;
import com.capgemini.onlinetestmanagement.entity.Exam;
import com.capgemini.onlinetestmanagement.entity.User;
import com.capgemini.onlinetestmanagement.exceptions.AssignExamUserException;
import com.capgemini.onlinetestmanagement.exceptions.ExamException;
import com.capgemini.onlinetestmanagement.exceptions.UserExceptions;
import com.capgemini.onlinetestmanagement.service.AssignExamToUserServiceI;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/onlineTestManagement")
public class Controller {
	
	@Autowired
	private AssignExamToUserServiceI service;
	
	
	
	/********************************************************************************************************************
	*       @author           VijayVenkatReddy Kumbam
	*       Method            addUser()
	*       Parameter         zero
	*       version           0.1
	*       Description       This method will save the user object by getting the body from the cilent. .
	*       Created date      20-SEP-2020
	********************************************************************************************************************/
	
	@PostMapping("/user/addUser")
	public ResponseEntity<Boolean> addUser(@RequestBody User user) throws UserExceptions{
		boolean status = service.addUser(user);
		if(status == true)
		{
			return new ResponseEntity<Boolean>(true,HttpStatus.OK);
		}
		else
		  throw new UserExceptions("Unable to Create the User ");
	}
	
	
	/********************************************************************************************************************
	*       @author           VijayVenkatReddy Kumbam
	*       Method            getUserById()
	*       Parameter         userId
	*       version           0.1
	*       Description       This method will return the User object by using the userId .
	*       Created date      20-SEP-2020
	********************************************************************************************************************/
	
	@GetMapping("/user/getUser/{userId}")
	public ResponseEntity<List<User>>getUserById(@PathVariable("userId") int userId) throws UserExceptions{
		User status = service.getUserById(userId);
		List<User> obj = new ArrayList<User>();
		if(status!=null)
		{
			obj.add(status);
			return new ResponseEntity<List<User>>(obj,HttpStatus.OK);
		}
		else
		{
			throw new UserExceptions(userId+"Unable to find the User! Please try again");
		}
	}
	
	
	/********************************************************************************************************************
	*       @author           VijayVenkatReddy Kumbam
	*       Method            getAllUsers()
	*       Parameter         zero
	*       version           0.1
	*       Description       This method will return the List<User> by fetching in the User Entity.
	*       Created date      20-SEP-2020
	********************************************************************************************************************/
	
	@GetMapping("/user/getAllUsers")
	public ResponseEntity<List<User>>getAllUsers() throws UserExceptions{
		List<User> status = service.getAllUsers();
		if(status!=null)
		{
			return new ResponseEntity<List<User>>(status,HttpStatus.OK);
		}
		else
		{
			throw new UserExceptions("User Data is Empty! Ouch");
		}
	}
	
	
	/********************************************************************************************************************
	*       @author           VijayVenkatReddy Kumbam
	*       Method            addExam()
	*       Parameter         @RequestBody (Exam)
	*       version           0.1
	*       Description       This method will save the exam object by getting the body from the cilent.
	*       Created date      20-SEP-2020
	********************************************************************************************************************/
	@PostMapping("/exam/addExam")
	public ResponseEntity<Boolean> addExam(@RequestBody Exam exam) throws ExamException{
		boolean status = service.addExam(exam);
		if(status ==true)
		{
			return new ResponseEntity<Boolean>(true,HttpStatus.OK);
		}
		else
		{
			throw new ExamException("Unable to create the Exam! Check it once again");
		}
	}
	
	
	/********************************************************************************************************************
	*       @author           VijayVenkatReddy Kumbam
	*       Method            getExamById()
	*       Parameter         examId
	*       version           0.1
	*       Description       This method will get the particular Exam details by using the ExamID .
	*       Created date      20-SEP-2020
	********************************************************************************************************************/
	@GetMapping("/exam/getExam/{examId}")
	public ResponseEntity<List<Exam>>getExamById(@PathVariable("examId") int examId) throws ExamException{
		Optional<Exam>status = service.getExamById(examId);
		List<Exam> obj = new ArrayList<Exam>();
		if(status.isPresent()==true)
		{
			Exam exam = status.get();
			obj.add(exam);
			return new ResponseEntity<List<Exam>>(obj,HttpStatus.OK);
		}
		else
		{
			throw new ExamException(examId+" was not Found! Please try Again");
		}
	}
	
	
	
	/********************************************************************************************************************
	*       @author           VijayVenkatReddy Kumbam
	*       Method            getAllExams()
	*       Parameter         zero
	*       version           0.1
	*       Description       This method will return the List<Exam> objects.
	*       Created date      20-SEP-2020
	********************************************************************************************************************/
	@GetMapping("/exam/getAllExams")
	public ResponseEntity<List<Exam>>getAllExams() throws UserExceptions{
		List<Exam> status = service.viewExams();
		if(status!=null)
		{
			return new ResponseEntity<List<Exam>>(status,HttpStatus.OK);
		}
		else
		{
			throw new UserExceptions("Exam Data is Empty! Ouch");
		}
	}
	
	/********************************************************************************************************************
	*       @author           VijayVenkatReddy Kumbam
	*       Method            assignExamToUser()
	*       Parameter         userId, examId
	*       version           0.1
	*       Description       This method will assign the Exam to the User, By Verifying the both userId,examId 
	*       				  is present. If it is not present then it will null, If both are valid then it will return the 
	*       				  AssignExamToUser Object.
	*       Created date      20-SEP-2020
	********************************************************************************************************************/
	@PostMapping("/admin/assignExam/{userId}/{examId}")
	public ResponseEntity<String> assignExamToUser(@PathVariable("examId") int examId, @PathVariable("userId") int userId) throws AssignExamUserException{
		String status ="Success";
		AssignExamToUser obj = service.assignExamToUser(userId,examId);
		if(obj != null) {
			return new ResponseEntity<String>(status,HttpStatus.OK);
		}
		else {
			throw new AssignExamUserException("Something Gone Wrong! Please check the "+userId+" and "+examId +" is exist or not before Assign the exam" );
		}
		
	}
	
	/********************************************************************************************************************
	*       @author           VijayVenkatReddy Kumbam
	*       Method            editAssignedExam()
	*       Parameter         assignedId, examId
	*       version           0.1
	*       Description       This method will update the exmaId incase if the ExamId is miss saved.
	*       Created date      20-SEP-2020
	********************************************************************************************************************/
	@PutMapping("/admin/editAssignedExam/{examId}/{assignedId}")
	public ResponseEntity<String> editAssignedExam(@PathVariable("assignedId") int assignedId, @PathVariable("examId") int examId) throws AssignExamUserException{
		String str = "Successfully Edited";
		String status = service.editAssignExamToUser(assignedId, examId);
		if(status.contentEquals(str)) {
			return new ResponseEntity<String>(str,HttpStatus.OK);
		}
		else
			throw new AssignExamUserException("Something Gone Wrong! Please check the examId "+examId );
	}
	
	
	/********************************************************************************************************************
	*       @author           VijayVenkatReddy Kumbam
	*       Method            viewAssignedExamById()
	*       Parameter         assignedId
	*       version           0.1
	*       Description       This method will return the AssignExamToUser Object by using the AssignedId
	*       				  as the parameter.Exceptions were handled.
	*       Created date      20-SEP-2020
	********************************************************************************************************************/
	@GetMapping("/admin/viewAssignedExamById/{assignedId}")
	public ResponseEntity<List<AssignExamToUser>> viewAssignedExamById(@PathVariable("assignedId") int assignedId) throws AssignExamUserException{
		Optional<AssignExamToUser>status =service.viewAssignExamById(assignedId);
		List<AssignExamToUser> obj = new ArrayList<AssignExamToUser>();
		if(status.isPresent())
		{
			AssignExamToUser assignExamToUserobj = status.get();
			obj.add(assignExamToUserobj);
			return new ResponseEntity<List<AssignExamToUser>>(obj,HttpStatus.OK);
		}
		else
		throw new AssignExamUserException(assignedId+" is not found");
	}
		
	
	/********************************************************************************************************************
	*       @author           VijayVenkatReddy Kumbam
	*       Method            viewAllExamsOfUser()
	*       Parameter         userId
	*       version           0.1
	*       Description       This method will return the List<AssignExamToUser> objects by using the UserId in the
	*       				  AssignedExamToUser Entity.
	*       Created date      20-SEP-2020
	********************************************************************************************************************/
	@GetMapping("/user/viewAllExamsOfUser/{userId}")
	public ResponseEntity<List<AssignExamToUser>> viewAllExamsOfUser(@PathVariable("userId") int userId) throws AssignExamUserException{
		List<AssignExamToUser> listObj=service.viewExamHistoryForUserAttended(userId);
		if(listObj.isEmpty() !=true)
		return new ResponseEntity<List<AssignExamToUser>>(listObj,HttpStatus.OK);
		else
			throw new AssignExamUserException(userId+" is not found");
	}
	
	
	/********************************************************************************************************************
	*       @author           VijayVenkatReddy Kumbam
	*       Method            checkDateConflict()
	*       Parameter         userId, year,month,date
	*       version           0.1
	*       Description       This method will check the Date conflict before assign the Exam to the User by using the UserId.
	* 
	*       Created date      20-SEP-2020
	********************************************************************************************************************/
	@GetMapping("/admin/checkDateConflict/{userId}/{year}/{month}/{date}")
	public ResponseEntity<String> checkDateConflict(@PathVariable("userId") int userId ,@PathVariable("year")int year ,@PathVariable("month")int month,@PathVariable("date")int date) {		
		
		String conflictDateMsg = "Conflict is Found on this date";
		String successMsg ="Assign the Exam on this Date";
		String dateFormateException ="Date Format Exception";
		String userNotFoundMsg ="Can't assign to the Exam to Unknow";
		
		String status = service.checkDateConflict(userId, year, month, date);
		
		if(status.contentEquals(successMsg)) {
			return new ResponseEntity<String>("No conflict is found, Assign the Exam ",HttpStatus.OK);
		}
		else if(status.contentEquals(dateFormateException))
			return new ResponseEntity<String>(dateFormateException,HttpStatus.OK);
		else if(status.contentEquals(userNotFoundMsg))
			return new ResponseEntity<String>(userNotFoundMsg,HttpStatus.OK);
		else
			return new ResponseEntity<String>(conflictDateMsg,HttpStatus.OK);
	}
	
}

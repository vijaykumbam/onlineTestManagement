package com.capgemini.onlinetestmanagement.controller;

import java.time.LocalDate;
import java.time.Month;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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


@RestController
@RequestMapping("/onlineTestManagement")
public class Controller {
	
	@Autowired
	private AssignExamToUserServiceI service;
	
	
	
	@PostMapping("/user/addUser")
	public ResponseEntity<Boolean> addUser(@RequestBody User user) throws UserExceptions{
		boolean status = service.addUser(user);
		if(status == true)
		{
			System.out.println("user is added");
			return new ResponseEntity<Boolean>(true,HttpStatus.OK);
		}
		else
		  throw new UserExceptions("Unable to Create the User ");
		
	}
	
	
	
	@GetMapping("/user/getUser/{userId}")
	public ResponseEntity<User>getUserById(@PathVariable("userId") int userId) throws UserExceptions{
		Optional<User>status = service.getUserById(userId);
		if(status.isPresent())
		{
			User user = status.get();
			return new ResponseEntity<User>(user,HttpStatus.OK);
		}
		else
		{
			throw new UserExceptions(userId+"Unable to find the User! Please try again");
		}
	}
	
	
	
	@PostMapping("/exam/addExam")
	public ResponseEntity<Boolean> addExam(@RequestBody Exam exam) throws ExamException{
		boolean status = service.addExam(exam);
		if(status ==true)
		{
			System.out.println("exam is added");
			return new ResponseEntity<Boolean>(true,HttpStatus.OK);
		}
		else
		{
			throw new ExamException("Unable to create the Exam! Check it once again");
		}
	}
	
	
	
	@GetMapping("/exam/getExam/{examId}")
	public ResponseEntity<Exam>getExamById(@PathVariable("examId") int examId) throws ExamException{
		Optional<Exam>status = service.getExamById(examId);
		if(status.isPresent()==true)
		{
			Exam exam = status.get();
			return new ResponseEntity<Exam>(exam,HttpStatus.OK);
		}
		else
		{
			throw new ExamException(examId+" was not Found! Please try Again");
		}
	}
	
	
	
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
	
	
	
	@PutMapping("/admin/editAssignedExam/{examId}")
	public ResponseEntity<String> editAssignedExam(@RequestBody AssignExamToUser assign, @PathVariable("examId") int examId) throws AssignExamUserException{
		String str = "Successfully Edited";
		String status = service.editAssignExamToUser(assign, examId);
		if(status.contentEquals(str)) {
			return new ResponseEntity<String>(str,HttpStatus.OK);
		}
		else
			throw new AssignExamUserException("Something Gone Wrong! Please check the examId "+examId );
	}
	
	
	
	@GetMapping("/admin/viewAssignedExamById/{assignedId}")
	public ResponseEntity<AssignExamToUser> viewAssignedExamById(@PathVariable("assignedId") int assignedId) throws AssignExamUserException{
		Optional<AssignExamToUser>status =service.viewAssignExamById(assignedId);
		if(status.isPresent())
		{
			AssignExamToUser obj = status.get();
			return new ResponseEntity<AssignExamToUser>(obj,HttpStatus.OK);
		}
		else
		throw new AssignExamUserException(assignedId+" is not found");
	}
		
	
	
	@GetMapping("/user/viewAllExamsOfUser/{userId}")
	public ResponseEntity<List<AssignExamToUser>> viewAllExamsOfUser(@PathVariable("userId") int userId) throws AssignExamUserException{
		List<AssignExamToUser> listObj=service.viewExamHistoryForUserAttended(userId);
		if(listObj.isEmpty() !=true)
		return new ResponseEntity<List<AssignExamToUser>>(listObj,HttpStatus.OK);
		else
			throw new AssignExamUserException(userId+" is not found");
	}
	
	
	@GetMapping("/admin/checkDateConflict/{userId}/{year}/{month}/{date}")
	public ResponseEntity<String> checkDateConflict(@PathVariable("userId") int userId ,@PathVariable("year")int year ,@PathVariable("month")int month,@PathVariable("date")int date) {
		boolean status = service.checkDateConflict(userId, year, month, date);
		if(status ==true) {
			System.out.println("We can assign the Exam to "+userId);
			return new ResponseEntity<String>("No conflict is found, Assign the Exam ",HttpStatus.OK);
		}
		else
			return new ResponseEntity<String>("Error! Conflict is found ",HttpStatus.OK);
	}
	
}

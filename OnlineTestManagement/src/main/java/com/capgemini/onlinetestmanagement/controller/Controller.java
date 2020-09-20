package com.capgemini.onlinetestmanagement.controller;

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
import com.capgemini.onlinetestmanagement.service.AssignExamToUserServiceI;


@RestController
@RequestMapping("/onlineTestManagement")
public class Controller {
	
	@Autowired
	private AssignExamToUserServiceI service;
	
	
	
	@PostMapping("/user/addUser")
	public ResponseEntity<Boolean> addUser(@RequestBody User user){
		boolean status = service.addUser(user);
		if(status ==true)
		{
			System.out.println("user is added");
		}
		else
			System.out.println("sry ssomething is gone wrong");
		return new ResponseEntity<Boolean>(true,HttpStatus.OK);
	}
	
	
	@GetMapping("/user/getUser/{userId}")
	public ResponseEntity<String>getUserById(@PathVariable("userId") int userId){
		Optional<User>status = service.getUserById(userId);
		if(status!= null)
		{
			return new ResponseEntity<String>("success",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Something gone wrong",HttpStatus.OK);
		}
	}
	
	@PostMapping("/exam/addExam")
	public ResponseEntity<Boolean> addExam(@RequestBody Exam exam){
		boolean status = service.addExam(exam);
		if(status ==true)
		{
			System.out.println("exam is added");
		}
		else
			System.out.println("sry ssomething is gone wrong");
		return new ResponseEntity<Boolean>(true,HttpStatus.OK);
	}
	
	
	
	@GetMapping("/exam/getExam/{examId}")
	public ResponseEntity<String>getExamById(@PathVariable("examId") int examId){
		Optional<Exam>status = service.getExamById(examId);
		if(status!= null)
		{
			return new ResponseEntity<String>("success",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Something gone wrong",HttpStatus.OK);
		}
	}
	
	
	
	@PostMapping("/admin/assignExam/{userId}/{examId}")
	public ResponseEntity<String> assignExamToUser(@PathVariable("examId") int examId, @PathVariable("userId") int userId){
		String status ="Success";
		AssignExamToUser obj = service.assignExamToUser(userId,examId);
		if(obj != null) {
			return new ResponseEntity<String>(status,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<String>("Something gone wrong",HttpStatus.OK);
		}
		
	}
	
	@PutMapping("/admin/editAssignExam/{examId}")
	public ResponseEntity<String> editAssignExam(@RequestBody AssignExamToUser assign, @PathVariable("examId") int examId){
		String str = "Successfully Edited";
		String status = service.editAssignExamToUser(assign, examId);
		if(status.contentEquals(str)) {
			return new ResponseEntity<String>(str,HttpStatus.OK);
		}
		else
		return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/admin/getAssignedExamById/{assignedId}")
	public ResponseEntity<Optional<AssignExamToUser>> getAssignedExamById(@PathVariable("assignedId") int assignedId){
		Optional<AssignExamToUser>status =service.viewAssignExamById(assignedId);
		
	
		if(status != null)
		{
			return new ResponseEntity<Optional<AssignExamToUser>>(status,HttpStatus.OK);
		}
		return new ResponseEntity<Optional<AssignExamToUser>>(HttpStatus.NOT_FOUND);
	}
		
	
	@PostMapping("/user/viewExamHistory/{userId}")
	public ResponseEntity<List<AssignExamToUser>> viewExamHistory(@PathVariable("userId") int userId){
		List<AssignExamToUser> obj=service.viewExamHistoryForUserAttended(userId);
		return new ResponseEntity<List<AssignExamToUser>>(obj,HttpStatus.OK);
	}
	

}

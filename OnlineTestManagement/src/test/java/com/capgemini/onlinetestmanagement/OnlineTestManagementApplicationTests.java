package com.capgemini.onlinetestmanagement;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.onlinetestmanagement.dao.AssignExamToUserDaoI;
//import com.capgemini.onlinetestmanagement.dao.ExamDaoI;
//import com.capgemini.onlinetestmanagement.dao.UserDaoI;
import com.capgemini.onlinetestmanagement.entity.AssignExamToUser;
import com.capgemini.onlinetestmanagement.entity.User;
import com.capgemini.onlinetestmanagement.service.AssignExamToUserServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
class OnlineTestManagementApplicationTests {

	@Autowired
	private AssignExamToUserDaoI assignExamToUserDaoI;
	
//	@Autowired
//	private ExamDaoI examDaoI;
//	
//	@Autowired
//	private UserDaoI userDaoI;
	
	@Autowired
	private AssignExamToUserServiceImpl assignExamToUserServiceImpl;

	
	@Test
	void contextLoads() {
		
	}
	
	
	@Test
	@DisplayName("Testing the User by UniqueId :Valid Credits")
	void getUserByIdValidCreditsTest() {
		User userObjTest = new User(1,"vijay","passs","user");
		User userObj = assignExamToUserServiceImpl.getUserById(userObjTest.getUserId());
		System.out.println(" Hello i am from Test :"+userObj.getRole());
		assertEquals(userObjTest.getRole(),userObj.getRole());
	}

	@Test
	@DisplayName("Testing the User by UniqueId :InValid Credits")
	void getUserByIdInValidCreditsTest() {
		User userObjTest = new User(55,"vijay","passs","user");
		User userObj = assignExamToUserServiceImpl.getUserById(userObjTest.getUserId());
		System.out.println(" Hello i am from Test :"+userObj);
		assertEquals(null,userObj);
	}
	
	@Test
	@DisplayName("Testing the List<User> if List is notEmpty")
	void getAllUsersForNonEmptyListTest() {
		List<User> userList = assignExamToUserServiceImpl.getAllUsers();
		System.out.println("The UserList Size is :"+userList.size());
		int excpectedSize  = 3;
		assertEquals(excpectedSize,userList.size());
	}
	
	
	@Test
	@DisplayName("Testing the List<User if the List is Empty")
	void getAllUsersForEmptyListTest() {
		List<User> userList = assignExamToUserServiceImpl.getAllUsers();
		System.out.println("The UserList Size is :"+userList.size());
		int excepectedSize =0;
		if(userList.size() !=0) 
		{
			excepectedSize = 3;
			assertEquals(excepectedSize,userList.size());
		}
		else
		{
			System.out.println("UserList size is Zero: 0");
			assertEquals(excepectedSize,userList.size());
		}
	}
	
	
	@Test
	@DisplayName("Testing the Assign Feature with valid UserID and ExamId")
	void assignExamToUserTest() {
		int userId =1;
		int examId =11;
		List<AssignExamToUser> totalRecordBeforeInsert = assignExamToUserDaoI.findAll();
		int totalRecordBeforeInsertSize = totalRecordBeforeInsert.size();
		System.out.println("Previous total records in AssignExamTable:" +totalRecordBeforeInsertSize);
		
		AssignExamToUser assignExamToUser = assignExamToUserServiceImpl.assignExamToUser(userId, examId);
		System.out.println("AssignedId "+assignExamToUser.getAssignedId());
		List<AssignExamToUser> totalRecordAfterInsert = assignExamToUserDaoI.findAll();
		int totalRecordAfterInsertSize = totalRecordAfterInsert.size();
		System.out.println("Previous total records in AssignExamTable:" +totalRecordAfterInsertSize);
		
		assertEquals(totalRecordAfterInsertSize,totalRecordBeforeInsertSize+1);
	
	}
	
	
	@Test
	@DisplayName("Testing the Assign Feature with Invalid UserID and ExamId")
	void assignExamToUserWithInvalidDetailsTest() {
		int userId =13;
		int examId =11;
		List<AssignExamToUser> totalRecordBeforeInsert = assignExamToUserDaoI.findAll();
		int totalRecordBeforeInsertSize = totalRecordBeforeInsert.size();
		System.out.println("Previous total records in AssignExamTable:" +totalRecordBeforeInsertSize);
		
		AssignExamToUser assignExamToUser = assignExamToUserServiceImpl.assignExamToUser(userId, examId);
		
		List<AssignExamToUser> totalRecordAfterInsert = assignExamToUserDaoI.findAll();
		int totalRecordAfterInsertSize = totalRecordAfterInsert.size();
		System.out.println("Previous total records in AssignExamTable:" +totalRecordAfterInsertSize);
		
		if(assignExamToUser==null)
			
			
		assertEquals(totalRecordBeforeInsertSize,totalRecordAfterInsertSize);
	}
	
	
	@Test
	@DisplayName("Testing the assignId for Valid assignedId")
	void viewAssignExamByIdTest() {
		int assignedExamId = 1232;
		Optional<AssignExamToUser> assignExamToUserObject  = assignExamToUserServiceImpl.viewAssignExamById(assignedExamId);
		if(assignExamToUserObject.isPresent())
			assertEquals(assignedExamId,assignExamToUserObject.get().getAssignedId());
		else
		{
			System.out.println(" Invalid AssignedExamId "+assignedExamId);
			assertEquals(null,assignExamToUserObject);
		}
		
	}
	
	
	
	
}

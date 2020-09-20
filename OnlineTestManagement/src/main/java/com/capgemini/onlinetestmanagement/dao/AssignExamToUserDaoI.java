package com.capgemini.onlinetestmanagement.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capgemini.onlinetestmanagement.entity.AssignExamToUser;

@Repository
public interface AssignExamToUserDaoI extends JpaRepository<AssignExamToUser,Integer> {
	//https://www.baeldung.com/spring-data-jpa-query
	
	
	@Query("select max(assignedId) from AssignExamToUser")
	int getLastExamUserAssignId();
	
	
	@Query("from AssignExamToUser examuser inner join fetch examuser.exam e inner join fetch examuser.user u where u.userId=:userId")
	 List<AssignExamToUser> getListOfExamsAssignToUser(int userId);
	
	//from ExamUserAssign examuser inner join fetch examuser.exam e inner join fetch examuser.user u where u.userId=:userid
}

package com.capgemini.onlinetestmanagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.onlinetestmanagement.entity.User;


@Repository
public interface UserDaoI extends JpaRepository<User,Long>{
	
}

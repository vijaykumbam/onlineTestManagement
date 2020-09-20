package com.capgemini.onlinetestmanagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.onlinetestmanagement.entity.Exam;

@Repository
public interface ExamDaoI extends JpaRepository<Exam,Integer>{

}

package com.mahesh.quiztestapp.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mahesh.quiztestapp.DTO.Quiz;

public interface QuizDAO extends JpaRepository<Quiz, Integer> {

	
}

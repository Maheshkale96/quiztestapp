package com.mahesh.quiztestapp.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mahesh.quiztestapp.DTO.Question;

@Repository
public interface QuestionDAO extends JpaRepository<Question, Integer> {
	
	List<Question> findByCategory(String category);

}

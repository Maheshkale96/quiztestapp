package com.mahesh.quiztestapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mahesh.quiztestapp.DAO.QuestionDAO;
import com.mahesh.quiztestapp.DAO.QuizDAO;
import com.mahesh.quiztestapp.DTO.Question;
import com.mahesh.quiztestapp.DTO.Quiz;

@Service
public class QuizService {
	
	@Autowired
	QuizDAO quizDAO;
	
	@Autowired
	QuestionDAO questionDAO;

	public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
		
		List<Question> questions = questionDAO.findRandomQuestionsByCategory(category,numQ); 
		
		Quiz quiz = new Quiz();
		quiz.setTitle(title);
		quiz.setQuestions(questions);
		
		quizDAO.save(quiz);
		
		return new ResponseEntity<>("Success",HttpStatus.CREATED);
		
	}

}

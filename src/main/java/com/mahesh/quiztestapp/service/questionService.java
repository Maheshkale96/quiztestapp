package com.mahesh.quiztestapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mahesh.quiztestapp.DAO.QuestionDAO;
import com.mahesh.quiztestapp.DTO.Question;

@Service
public class questionService {

	@Autowired
	QuestionDAO questionDAO;
	public ResponseEntity<List<Question>> getAllQuestions() {
		try {
			return new ResponseEntity<>( questionDAO.findAll(),HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<>( new ArrayList<>(),HttpStatus.BAD_REQUEST);
	}
	
	public ResponseEntity<List<Question>> getQuestionByCategory(String cat) {
		try {
			return new ResponseEntity<>( questionDAO.findByCategory(cat),HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<>( new ArrayList<>(),HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity< String> addQuestion(Question question) {

		try {
			questionDAO.save(question);
			return new ResponseEntity<String>("Success", HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>( "Failed",HttpStatus.BAD_REQUEST);
		
	}

}

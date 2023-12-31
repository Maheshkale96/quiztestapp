package com.mahesh.quiztestapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mahesh.quiztestapp.DTO.Question;
import com.mahesh.quiztestapp.service.questionService;

@RestController
@RequestMapping("question")
public class QuestionController {
	
	@Autowired
	questionService questionService;

	@GetMapping("allQuestions")
	public ResponseEntity<List<Question>> getAllQuestions() {
		
		return questionService.getAllQuestions();
	}
	
	@GetMapping("category/{cat}")
	public ResponseEntity<List<Question>> getQuestionByCategory(@PathVariable String cat){
		return questionService.getQuestionByCategory(cat);
		
	}
	
	
	@PostMapping("addQuestion")
	public ResponseEntity<String>  addQuestion(@RequestBody Question question) {
		
		return questionService.addQuestion(question);
		
	}
	
	
}

package com.mahesh.quiztestapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mahesh.quiztestapp.DAO.QuestionDAO;
import com.mahesh.quiztestapp.DTO.Question;

@Service
public class questionService {

	@Autowired
	QuestionDAO questionDAO;
	public List<Question> getAllQuestions() {
		
		return questionDAO.findAll();
	}
	
	public List<Question> getQuestionByCategory(String cat) {
		// TODO Auto-generated method stub
		return questionDAO.findByCategory(cat);
	}

	public String addQuestion(Question question) {
		// TODO Auto-generated method stub
		questionDAO.save(question);
		return "success";
	}

}

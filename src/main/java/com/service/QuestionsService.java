package com.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Questions;
import com.repository.QuestionsRepository;

@Service
public class QuestionsService {
	@Autowired
	QuestionsRepository questionsRepository;
	
	public String storeQuestion(Questions questions) {
		Optional<Questions> op = questionsRepository.findById(questions.getQid());
		if(op.isPresent()) {
			return "Question id must be unique";
		}else {
			questionsRepository.save(questions);
			return "Question added successfully";
		}
	}
	
	
	public Questions findQuestion(int qid) {
		Optional<Questions> op = questionsRepository.findById(qid);
		if(op.isPresent()) {
			Questions question = op.get();
			return question;
		}else {
			
			return null;
		}
	}

}
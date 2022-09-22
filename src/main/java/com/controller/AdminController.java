package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.Login;
import com.bean.Questions;
import com.bean.Quizes;
import com.bean.Result;
import com.repository.ResultRepository;
import com.service.LoginService;
import com.service.ParticipantsService;
import com.service.QuestionsService;
import com.service.QuizesService;
import com.service.ResultService;

//	http://localhost:9091/admin

@RestController
@RequestMapping("admin")
public class AdminController {
	@Autowired
	LoginService loginService;
	@Autowired
	QuestionsService questionsService;
	@Autowired
	QuizesService quizesService;
	@Autowired
	ResultService resultService;
	
//	http://localhost:9091/admin/print
	@GetMapping (value = "print")
	public String print() {
		return "Welcome to the Quiz rest API --> ADMIN Controller";
	}
	
	
//	http://localhost:9091/admin/signIn
	@PostMapping (value = "signIn", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String signIn(@RequestBody Login login) {
		return loginService.signIn(login);
	}
	
	
//	http://localhost:9091/admin/changePassword
	@PostMapping (value = "changePassword", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String changePassword(@RequestBody Login login) {
		return loginService.updatePassword(login);
	}
	
//	http://localhost:9091/admin/addQuestion
	@PostMapping (value = "addQuestion", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String addQuestion(@RequestBody Questions ques) {
		return questionsService.storeQuestion(ques);
	}
	
	
//	http://localhost:9091/admin/findQuestionById/2
	@GetMapping (value = "findQuestionById/{qid}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Questions findQuestionById(@PathVariable("qid") int qid) {
		return questionsService.findQuestion(qid);
	}
	
//	http://localhost:9091/admin/createQuiz
	@PostMapping(value = "createQuiz", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String createQuiz(@RequestBody Quizes quiz) {
		return quizesService.addQuiz(quiz);
	}
	
	
//	http://localhost:9091/admin/checkUserResult
	@GetMapping(value = "checkUserResult", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Result> checkResult(){
		return resultService.getAllResult();
	}
	
	
	
}
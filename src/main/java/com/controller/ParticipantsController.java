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
import com.bean.Participants;
import com.bean.Quizes;
import com.bean.Result;
import com.service.LoginService;
import com.service.ParticipantsService;
import com.service.QuestionsService;
import com.service.QuizesService;
import com.service.ResultService;


//	http://localhost:9091/participants

@RestController
@RequestMapping("participants")
public class ParticipantsController {
	
	@Autowired
	LoginService loginService;
	@Autowired
	ParticipantsService participantsService;
	@Autowired
	QuizesService quizesService;
	@Autowired
	ResultService resultService;
	
	
//	http://localhost:9091/participants/signup
	@PostMapping(value = "signup", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String signup(@RequestBody Participants participants) {
		return participantsService.addParticipant(participants);
	}
	
//	http://localhost:9091/participants/takeQuiz/1
	@GetMapping(value = "takeQuiz/{id}")
	public String takeQuiz(@PathVariable("id") Quizes quiz) {
		return quizesService.findQuiz(quiz);
	}
	
	
//	http://localhost:9091/participants/signIn
	@PostMapping (value = "signIn", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String signIn(@RequestBody Login login) {
		return loginService.signInUser(login);
	}
	
	
//	http://localhost:9091/participants/checkAllQuizDetails
	@GetMapping(value = "checkAllQuizDetails", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Quizes> checkAllQuizDetails(){
		return quizesService.getAllQuizes();
	}

	
//	http://localhost:9091/participants/checkResult
	@GetMapping(value = "checkResult", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Result> checkResult(){
		return resultService.getAllResult();
	}
	
//	http://localhost:9091/participants/checkResult1
	@PostMapping(value = "checkResult1", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String checkResult1(@RequestBody Result result) {
		return resultService.findByIdUser(result);
	}

}
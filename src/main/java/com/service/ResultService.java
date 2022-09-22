package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Quizes;
import com.bean.Result;
import com.repository.ResultRepository;


@Service
public class ResultService {
	@Autowired
	ResultRepository resultRepository;
	

	public String findByIdUser(Result result) {
		Optional<Result> op = resultRepository.findById(result.getEmailid());
		if(op.isEmpty()) {
			return "You have not attempted any test";
			
		}else {
			Result r = op.get();
			return r.toString();
		}
	}
	
	public List<Result> getAllResult(){
		return resultRepository.findAll();
	}

}
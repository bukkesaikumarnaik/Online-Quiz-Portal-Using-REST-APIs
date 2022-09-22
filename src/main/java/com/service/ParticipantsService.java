package com.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Participants;
import com.repository.ParticipantsRepository;

@Service
public class ParticipantsService {
	@Autowired
	ParticipantsRepository participantsRepository;
	
	public String addParticipant(Participants participants) {
		Optional<Participants> op = participantsRepository.findById(participants.getPid());
		if(op.isPresent()) {
			return "Participant id must be unique";
		}else {
			participantsRepository.save(participants);
			return "Participant details added successfully";
		}
	}
	
	
	
}
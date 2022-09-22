package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bean.Participants;

@Repository
public interface ParticipantsRepository extends JpaRepository<Participants, Integer> {

}
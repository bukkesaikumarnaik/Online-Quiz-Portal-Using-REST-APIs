package com.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bean.Quizes;

@Repository
public interface QuizesRepository extends JpaRepository<Quizes, Integer>{


}
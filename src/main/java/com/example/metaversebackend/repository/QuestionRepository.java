package com.example.metaversebackend.repository;

import com.example.metaversebackend.model.question.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {

}

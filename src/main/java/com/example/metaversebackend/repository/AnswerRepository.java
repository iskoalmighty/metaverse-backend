package com.example.metaversebackend.repository;

import com.example.metaversebackend.model.answer.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
    Answer findByQuestionId(Long id);
}

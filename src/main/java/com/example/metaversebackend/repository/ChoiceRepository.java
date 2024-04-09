package com.example.metaversebackend.repository;

import com.example.metaversebackend.model.choice.Choice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface ChoiceRepository extends JpaRepository<Choice, Long> {
    Set<Choice> findByQuestionId(Long id);
}

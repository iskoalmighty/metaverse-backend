package com.example.metaversebackend.service;

import com.example.metaversebackend.model.answer.Answer;
import com.example.metaversebackend.model.answer.AnswerDto;
import com.example.metaversebackend.repository.AnswerRepository;
import com.example.metaversebackend.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AnswerService {
    private final AnswerRepository answerRepository;
    private final QuestionRepository questionRepository;

    public Optional<AnswerDto> get(final Long id) {
        return answerRepository.findById(id).map(Answer::toDto);
    }
}

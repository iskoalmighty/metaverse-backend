package com.example.metaversebackend.service;

import com.example.metaversebackend.http.request.question.AnswerQuestionRequest;
import com.example.metaversebackend.http.request.question.CreateQuestionRequest;
import com.example.metaversebackend.http.request.question.UpdateQuestionRequest;
import com.example.metaversebackend.model.answer.Answer;
import com.example.metaversebackend.model.lesson.Lesson;
import com.example.metaversebackend.model.question.Question;
import com.example.metaversebackend.model.question.QuestionDto;
import com.example.metaversebackend.repository.AnswerRepository;
import com.example.metaversebackend.repository.ChoiceRepository;
import com.example.metaversebackend.repository.LessonRepository;
import com.example.metaversebackend.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class QuestionService {

    private final QuestionRepository questionRepository;
    private final LessonRepository lessonRepository;
    private final ChoiceRepository choiceRepository;
    private final AnswerRepository answerRepository;


    public List<QuestionDto> getList() {
        return questionRepository.findAll().stream()
                .map(Question::toDto)
                .collect(Collectors.toList());
    }

    public Optional<QuestionDto> get(final Long id) {
        return questionRepository.findById(id)
                .map(question -> {
                    if(question.getId() == 2) {
                        question = this.getAnswer(question);
                    }
                    question.setChoices(choiceRepository.findByQuestionId(question.getId()));
                    question.setAnswer(answerRepository.findByQuestionId(question.getId()));
                    return Optional.of(question.toDto());
                })
                .orElse(Optional.empty());
//        return questionRepository.findById(id).map(Question::toDto);
    }

    public Optional<QuestionDto> create(final CreateQuestionRequest createQuestionRequest) {
        Lesson lesson = lessonRepository.findById(createQuestionRequest.getLessonId()).orElse(null);
        Question question = Question.builder()
                .question(createQuestionRequest.getQuestion())
                .lesson(lesson)
                .build();
        question = questionRepository.save(question);
        return Optional.of(question.toDto());
    }

    public Optional<QuestionDto> update(final Long id, final UpdateQuestionRequest updateQuestionRequest) {
        Lesson lesson = lessonRepository.findById(updateQuestionRequest.getLessonId()).orElse(null);
        Question question = Question.builder()
                .id(id)
                .question(updateQuestionRequest.getQuestion())
                .lesson(lesson)
                .build();
        question = questionRepository.save(question);
        return Optional.of(question.toDto());
    }

    public boolean deleteById(Long id) {
        questionRepository.deleteById(id);
        return true;
    }

    public Optional<QuestionDto> answerQuestion(Long questionId, AnswerQuestionRequest request) {
        if(questionId > 0) {
            Answer answer = answerRepository.findByQuestionId(questionId);
            if(answer == null) {
                answer = new Answer();
            }
            answer.setAnswer(request.getAnswer());
            answer.setQuestion(questionRepository.findById(questionId).orElse(null));
            if(request.getChoiceId() != null) {
                answer.setChoice(choiceRepository.findById(request.getChoiceId()).orElse(null));
            }
            answer = answerRepository.save(answer);
        }
        return this.get(++questionId);
    }

    public Question getAnswer(Question question) {
        Answer answer = answerRepository.findByQuestionId(question.getId() - 1);
        question.setQuestion(
                String.format(question.getQuestion(),
                        answer.getChoice() != null ? answer.getChoice().getChoice() : answer.getAnswer())
        );
        return question;
    }


}

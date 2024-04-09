package com.example.metaversebackend.controller;

import com.example.metaversebackend.http.annotation.Exist;
import com.example.metaversebackend.http.request.question.AnswerQuestionRequest;
import com.example.metaversebackend.http.request.question.CreateQuestionRequest;
import com.example.metaversebackend.http.request.question.UpdateQuestionRequest;
import com.example.metaversebackend.model.question.QuestionDto;
import com.example.metaversebackend.service.QuestionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/openai/question")
public class QuestionController {

    private final QuestionService questionService;

    @GetMapping
    public List<QuestionDto> getList() {
        return questionService.getList();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<QuestionDto> getQuestion(@PathVariable @Valid @Exist(entityName = "Question") Long id) {
        return questionService.get(id)
                .map(questionDto -> new ResponseEntity<>(questionDto, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    @PostMapping
    public ResponseEntity<QuestionDto> createQuestion(@Valid @RequestBody CreateQuestionRequest request) {
        return questionService.create(request)
                .map(questionDto -> new ResponseEntity<>(questionDto, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    @PutMapping("/{id}")
    public ResponseEntity<QuestionDto> update(
            @Valid @PathVariable Long id,
            @Valid @RequestBody UpdateQuestionRequest request) {
        return questionService.update(id, request)
                .map(questionDto -> new ResponseEntity<>(questionDto, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable @Valid Long id) {
        questionService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }




    @PostMapping(path = "/{id}/answer")
    public ResponseEntity<QuestionDto> answerQuestion(
            @PathVariable Long id,
            @RequestBody AnswerQuestionRequest request
            ) {
        return questionService.answerQuestion(id, request)
                .map(questionDto -> new ResponseEntity<>(questionDto, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

}

package com.example.metaversebackend.controller;

import com.example.metaversebackend.http.annotation.Exist;
import com.example.metaversebackend.http.request.lesson.CreateLessonRequest;
import com.example.metaversebackend.http.request.lesson.UpdateLessonRequest;
import com.example.metaversebackend.model.lesson.LessonDto;
import com.example.metaversebackend.service.LessonService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/openai/lesson")
public class LessonController {

    private final LessonService lessonService;

    @PostMapping
    public ResponseEntity<LessonDto> createLesson(@Valid @RequestBody final CreateLessonRequest request) {
        return lessonService.create(request)
                .map(lessonDto -> new ResponseEntity<>(lessonDto, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<LessonDto> getLesson(@PathVariable @Valid @Exist(entityName = "Lesson") final Long id) {
        return lessonService.get(id)
                .map(lessonDto -> new ResponseEntity<>(lessonDto, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    @GetMapping
    public List<LessonDto> getList() {
        return lessonService.getList();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable @Valid @Exist(entityName = "Lesson") final Long id) {
        lessonService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LessonDto> update(
            @Valid @PathVariable @Exist(entityName = "Lesson") Long id,
            @Valid @RequestBody final UpdateLessonRequest updateLessonRequest) {
        return lessonService.update(id, updateLessonRequest)
                .map(lessonDto -> new ResponseEntity<>(lessonDto, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

}

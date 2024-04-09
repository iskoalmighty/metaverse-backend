package com.example.metaversebackend.service;

import com.example.metaversebackend.http.request.lesson.CreateLessonRequest;
import com.example.metaversebackend.http.request.lesson.UpdateLessonRequest;
import com.example.metaversebackend.model.lesson.Lesson;
import com.example.metaversebackend.model.lesson.LessonDto;
import com.example.metaversebackend.repository.LessonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class LessonService {

    private final LessonRepository lessonRepository;

    public Optional<LessonDto> create(final CreateLessonRequest createLessonRequest) {
        Lesson lesson = Lesson.builder()
                .code(createLessonRequest.getCode())
                .name(createLessonRequest.getName())
                .build();
        lesson = lessonRepository.save(lesson);
        return Optional.of(lesson.toDto());
    }

    public Optional<LessonDto> get(Long id) {
        return lessonRepository.findById(id).map(Lesson::toDto);
    }

    public List<LessonDto> getList() {
        return lessonRepository.findAll().stream()
                .map(Lesson::toDto)
                .collect(Collectors.toList());
    }

    public boolean deleteById(Long id) {
        lessonRepository.deleteById(id);
        return true;
    }

    public Optional<LessonDto> update(final Long id, final UpdateLessonRequest updateLessonRequest) {
        Lesson lesson = Lesson.builder()
                .id(id)
                .code(updateLessonRequest.getCode())
                .name(updateLessonRequest.getName())
                .build();

        lesson = lessonRepository.save(lesson);
        return Optional.of(lesson.toDto());
    }
}

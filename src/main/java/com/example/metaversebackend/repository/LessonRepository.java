package com.example.metaversebackend.repository;

import com.example.metaversebackend.model.lesson.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonRepository extends JpaRepository<Lesson, Long> {



}

package com.example.metaversebackend.model.question;

import com.example.metaversebackend.model.BaseEntity;
import com.example.metaversebackend.model.answer.Answer;
import com.example.metaversebackend.model.choice.Choice;
import com.example.metaversebackend.model.lesson.Lesson;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "questions")
public class Question extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String question;
    @ManyToOne
    @JoinColumn(name = "lesson_id")
    private Lesson lesson;
    @OneToMany(mappedBy="question")
    private Set<Choice> choices = new HashSet<>();
    @OneToOne(mappedBy="question")
    private Answer answer;

    @Override
    public QuestionDto toDto() {
        return new QuestionDto().parseModel(this);
    }
}

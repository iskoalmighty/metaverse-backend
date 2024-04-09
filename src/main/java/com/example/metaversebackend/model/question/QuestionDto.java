package com.example.metaversebackend.model.question;

import com.example.metaversebackend.model.BaseDto;
import com.example.metaversebackend.model.answer.Answer;
import com.example.metaversebackend.model.answer.AnswerDto;
import com.example.metaversebackend.model.choice.Choice;
import com.example.metaversebackend.model.choice.ChoiceDto;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QuestionDto extends BaseDto<Question> {

    private Long id;
    private String question;
    private Long lesson_id;
    private String lessonName;
    private List<ChoiceDto> choices = new ArrayList<>();
//    private List<AnswerDto> answers = new ArrayList<>();
    private AnswerDto answer;

    @Override
    public QuestionDto parseModel(Question entity) {
        QuestionDto questionDto = new QuestionDto();
        questionDto.id = entity.getId();;
        questionDto.question = entity.getQuestion();
        questionDto.lesson_id = entity.getLesson().getId();;
        questionDto.lessonName = entity.getLesson().getName();;
        questionDto.choices = entity.getChoices().stream().map(Choice::toDto).collect(Collectors.toList());
//        questionDto.answers = entity.getAnswers().stream().map(Answer::toDto).collect(Collectors.toList());
        Answer answer = entity.getAnswer();
        if(answer != null) {
            questionDto.answer = entity.getAnswer().toDto();
        }
        return questionDto;
    }

    @Override
    public Question toEntity() {
//        return Question.builder()
//                .id(this.id)
//                .question(this.question)
//                .lesson(lessonRepository.findById(lesson_id).orElse(null))
//                .build();
        return null;
    }
}

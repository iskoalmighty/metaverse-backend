package com.example.metaversebackend.model.answer;

import com.example.metaversebackend.model.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AnswerDto extends BaseDto<Answer> {

    private Long id;
    private String answer;
    private Long question_id;

    @Override
    public AnswerDto parseModel(Answer entity) {
        AnswerDto answerDto = new AnswerDto();
        answerDto.id = entity.getId();
        answerDto.answer = entity.getAnswer();
        answerDto.question_id = entity.getQuestion().getId();
        return answerDto;
    }

    @Override
    public Answer toEntity() {
        return null;
    }
}

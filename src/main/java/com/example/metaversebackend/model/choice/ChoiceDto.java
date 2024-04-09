package com.example.metaversebackend.model.choice;

import com.example.metaversebackend.model.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChoiceDto extends BaseDto<Choice> {

    private Long id;
    private String choice;
    private Long question_id;

    @Override
    public ChoiceDto parseModel(Choice entity) {
        ChoiceDto choiceDto = new ChoiceDto();
        choiceDto.id = entity.getId();
        choiceDto.choice = entity.getChoice();
        choiceDto.question_id = entity.getQuestion().getId();
        return choiceDto;
    }

    @Override
    public Choice toEntity() {
        return null;
    }
}

package com.example.metaversebackend.model.lesson;

import com.example.metaversebackend.model.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LessonDto extends BaseDto<Lesson> {

    private Long id;
    private String code;
    private String name;

    public LessonDto(Lesson entity) {
        this.id = entity.getId();
        this.code = entity.getCode();
        this.name = entity.getName();
    }

    @Override
    public LessonDto parseModel(Lesson entity) {
        return new LessonDto(entity);
    }

    @Override
    public Lesson toEntity() {
        return Lesson.builder()
                .code(this.code)
                .name(this.name)
                .build();
    }
}

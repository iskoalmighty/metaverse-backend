package com.example.metaversebackend.http.request.lesson;

import com.example.metaversebackend.http.annotation.Unique;
import com.example.metaversebackend.http.request.BaseRequest;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateLessonRequest implements BaseRequest {

    private String code;

    @NotNull
    @NotBlank
    @Unique(entityName = "Lesson", columnName = "name", columnException = "id")
    private String name;

}

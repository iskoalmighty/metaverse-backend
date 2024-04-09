package com.example.metaversebackend.http.request.question;

import com.example.metaversebackend.http.request.BaseRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateQuestionRequest implements BaseRequest {

    private String question;
    private Long lessonId;

}

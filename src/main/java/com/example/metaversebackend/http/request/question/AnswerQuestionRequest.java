package com.example.metaversebackend.http.request.question;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AnswerQuestionRequest {
    private String answer;
    private Long choiceId;
}

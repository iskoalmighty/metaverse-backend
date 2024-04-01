package com.example.metaversebackend.http.request.openai;

import com.example.metaversebackend.http.request.BaseRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateAssistantRequest implements BaseRequest {
    private String model;
    private String instructions;
}

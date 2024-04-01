package com.example.metaversebackend.http.request.messageRun;

import com.example.metaversebackend.http.annotation.Exist;
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
public class MessageRunRequest {
    @NotNull @NotBlank @Exist(entityName = "Thread", message = "Thread Does not Exists!!")
    private String threadId;
    @NotNull @NotBlank @Exist(entityName = "Assistant", message = "Thread Does not Exists!!")
    private String assistantId;
}

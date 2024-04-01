package com.example.metaversebackend.http.request.message;

import com.example.metaversebackend.http.annotation.Exist;
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
public class MessageRequest implements BaseRequest {
    @NotNull @NotBlank @Exist(entityName = "Thread", message = "Thread Does not Exists!!")
    private String threadId;
    private String role;
    private String content;
}

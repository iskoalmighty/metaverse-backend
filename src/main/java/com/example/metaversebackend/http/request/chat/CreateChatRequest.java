package com.example.metaversebackend.http.request.chat;

import com.example.metaversebackend.http.request.BaseRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateChatRequest implements BaseRequest {

    private String role;
    private String content;

}

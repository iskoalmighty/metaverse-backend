package com.example.metaversebackend.service;

import com.example.metaversebackend.config.OpenApiConfig;
import com.example.metaversebackend.http.request.BaseRequest;
import com.example.metaversebackend.http.request.chat.CreateChatRequest;
import com.example.metaversebackend.model.BaseDto;
import com.example.metaversebackend.model.BaseEntity;
import com.example.metaversebackend.model.chat.ChatDto;
import com.example.metaversebackend.repository.ChatRepository;
import lombok.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ChatService {

    private final OpenApiConfig openApiConfig;
    private final OpenAIClientService openAIClientService;
    private final ChatRepository chatRepository;

    public List<BaseDto> findAll() {
        return chatRepository.findAll().stream()
                .map(BaseEntity::toDto)
                .collect(Collectors.toList());
    }

    public Optional<ChatDto> chatCompletion(final CreateChatRequest createChatRequest) {
        return openAIClientService.sendRequest(
                        openApiConfig.getChatUrl(),
                new ChatClientRequest(createChatRequest.getRole(), createChatRequest.getContent()),
                "POST")
                .map(responseString -> {
                    ChatDto chatDto = openAIClientService.parseDto(responseString, ChatDto.class);
                    chatRepository.save(chatDto.toEntity());
                    return Optional.of(chatDto);
                }).orElse(Optional.empty());
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    private class ChatClientRequest implements BaseRequest {
        private String model = openApiConfig.getModel();
        private List<Message> messages = new ArrayList<>();
        private int temperature = 1;
        private int top_p = 1;
        private int n = 1;
        private boolean stream = false;
        private int max_tokens = 250;
        private int presence_penalty = 0;
        private int frequency_penalty = 0;

        public ChatClientRequest(String role, String content) {
            messages.add(new Message(role, content));
        }

        @Data
        @AllArgsConstructor
        @NoArgsConstructor
        private class Message {
            String role;
            String content;
        }
    }
}

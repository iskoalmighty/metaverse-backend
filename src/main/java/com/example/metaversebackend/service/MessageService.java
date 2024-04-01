package com.example.metaversebackend.service;

import com.example.metaversebackend.config.OpenApiConfig;
import com.example.metaversebackend.http.request.BaseRequest;
import com.example.metaversebackend.http.request.message.MessageRequest;
import com.example.metaversebackend.model.BaseDto;
import com.example.metaversebackend.model.BaseEntity;
import com.example.metaversebackend.model.message.MessageDto;
import com.example.metaversebackend.model.message.MessageListDto;
import com.example.metaversebackend.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class MessageService {

    private final OpenApiConfig openApiConfig;
    private final OpenAIClientService openAIClientService;
    private final MessageRepository messageRepository;

    public Optional<MessageDto> createMessage(final MessageRequest messageRequest) {
        String url = String.format("%s/%s/messages",
                openApiConfig.getThreadsUrl(),
                messageRequest.getThreadId());

        return openAIClientService.sendRequest(
                url,
                new MessageClientRequest("user", messageRequest.getContent()),
                "POST").map(responseString -> {
                    MessageDto messageDto = openAIClientService.parseDto(responseString, MessageDto.class);
                    messageRepository.save(messageDto.toEntity());
                    return Optional.of(messageDto);
                }).orElse(Optional.empty());
    }

    public List<BaseDto> findAll() {
        return messageRepository.findAll().stream()
                .map(BaseEntity::toDto)
                .collect(Collectors.toList());
    }

    public Optional<MessageListDto> getMessages(String threadId) {
        String url = String.format("%s/%s/messages",
                openApiConfig.getThreadsUrl(),
                threadId);
        return openAIClientService.sendRequest(
                url,
                null, "GET").map(responseString -> {
                    MessageListDto messageListDto = openAIClientService.parseDto(responseString, MessageListDto.class);
                    return Optional.of(messageListDto);
                }).orElse(Optional.empty());
    }

    private record MessageClientRequest(String role, String content) implements BaseRequest {}
}

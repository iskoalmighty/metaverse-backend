package com.example.metaversebackend.service;

import com.example.metaversebackend.config.OpenApiConfig;
import com.example.metaversebackend.http.request.BaseRequest;
import com.example.metaversebackend.http.request.messageRun.MessageRunRequest;
import com.example.metaversebackend.model.messageRun.MessageRunDto;
import com.example.metaversebackend.repository.MessageRunRepository;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MessageRunService {

    private final OpenApiConfig openApiConfig;
    private final OpenAIClientService openAIClientService;
    private final MessageRunRepository messageRunRepository;

    public Optional<MessageRunDto> createMessageRun(final MessageRunRequest messageRunRequest) {
        String url = String.format("%s/%s/runs",
                openApiConfig.getThreadsUrl(),
                messageRunRequest.getThreadId());
        return openAIClientService.sendRequest(
                url,
                new MessageRunClientRequest(messageRunRequest.getAssistantId()),
                "POST"
        ).map(responseString -> {
            MessageRunDto messageRunDto = openAIClientService.parseDto(responseString, MessageRunDto.class);
            messageRunRepository.save(messageRunDto.toEntity());
            return Optional.of(messageRunDto);
        }).orElse(Optional.empty());
    }

    public Optional<MessageRunDto> getRunStatus(final String threadId, final String runId) {
        String url = String.format("%s/%s/runs/%s", openApiConfig.getThreadsUrl(), threadId, runId);
        return openAIClientService.sendRequest(url, null, "GET")
                .map(responseString -> {
                    MessageRunDto messageRunDto = openAIClientService.parseDto(responseString, MessageRunDto.class);
                    messageRunRepository.save(messageRunDto.toEntity());
                    return Optional.of(messageRunDto);
                }).orElse(Optional.empty());
    }

    public record MessageRunClientRequest(@JsonProperty("assistant_id") String assistantId) implements BaseRequest {}
}

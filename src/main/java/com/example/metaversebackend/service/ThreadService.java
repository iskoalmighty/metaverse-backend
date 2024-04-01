package com.example.metaversebackend.service;

import com.example.metaversebackend.config.OpenApiConfig;
import com.example.metaversebackend.model.BaseDto;
import com.example.metaversebackend.model.BaseEntity;
import com.example.metaversebackend.model.thread.ThreadDto;
import com.example.metaversebackend.repository.ThreadRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ThreadService {

    private final OpenApiConfig openApiConfig;
    private final OpenAIClientService openAIClientService;
    private final ThreadRepository threadRepository;

    public List<BaseDto> findAll() {
        return threadRepository.findAll().stream()
                .map(BaseEntity::toDto)
                .collect(Collectors.toList());
    }

    public Optional<ThreadDto> createThread() {
        return openAIClientService.sendRequest(openApiConfig.getThreadsUrl(), null, "POST")
                .map(responseString -> {
                    ThreadDto threadDto = openAIClientService.parseDto(responseString, ThreadDto.class);
                    threadRepository.save(threadDto.toEntity());
                    return Optional.of(threadDto);
                })
                .orElse(Optional.empty());
    }
}

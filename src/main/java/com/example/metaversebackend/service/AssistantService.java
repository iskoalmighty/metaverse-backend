package com.example.metaversebackend.service;

import com.example.metaversebackend.config.OpenApiConfig;
import com.example.metaversebackend.http.request.openai.CreateAssistantRequest;
import com.example.metaversebackend.model.BaseDto;
import com.example.metaversebackend.model.BaseEntity;
import com.example.metaversebackend.model.assistant.AssistantDto;
import com.example.metaversebackend.repository.AssistantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@RequiredArgsConstructor
@Service
public class AssistantService {

    private final OpenApiConfig openApiConfig;
    private final OpenAIClientService openAIClientService;
    private final AssistantRepository assistantRepository;

    public List<BaseDto> findAll() {
        return assistantRepository.findAll().stream()
                .map(BaseEntity::toDto)
                .collect(Collectors.toList());
    }


    public Optional<AssistantDto> createAssistant() {
        return openAIClientService.sendRequest(
                        openApiConfig.getAssistantsUrl(),
                        new CreateAssistantRequest(openApiConfig.getModel(), openApiConfig.getAssistantInstruction()),
                        "POST"
                ).map(responseString -> {
                    AssistantDto assistantDto = openAIClientService.parseDto(responseString, AssistantDto.class);
                    assistantRepository.save(assistantDto.toEntity());
                    return Optional.of(assistantDto);
                }).orElse(Optional.empty());

    }

}

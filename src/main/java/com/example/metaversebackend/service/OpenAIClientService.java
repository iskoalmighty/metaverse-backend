package com.example.metaversebackend.service;

import com.example.metaversebackend.config.OpenApiConfig;
import com.example.metaversebackend.http.request.BaseRequest;
import com.example.metaversebackend.model.BaseDto;
import com.example.metaversebackend.utils.ObjectMapperUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Log
public class OpenAIClientService {

    private final OpenApiConfig openApiConfig;
    private final ObjectMapperUtil objectMapperUtil;

    public Optional<String> sendRequest(final String url, final BaseRequest request, final String method) {
        String json = objectMapperUtil.objectToString(request);

        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest.Builder httpRequestBuilder = HttpRequest.newBuilder(URI.create(url))
                .header("Authorization", "Bearer " + openApiConfig.getApiKey())
                .header("OpenAI-Beta", "assistants=v1")
                .header("Content-Type", "application/json");

        switch (method) {
            case "GET" -> httpRequestBuilder.GET();
            case "POST", default -> httpRequestBuilder.POST(HttpRequest.BodyPublishers.ofString(json));
        }

        HttpRequest httpRequest = httpRequestBuilder.build();

        try {
            String responseBody = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString()).body();
            log.info("************************************************************************");
            log.info("URL: " + url);
            log.info("RESPONSE BODY: " + responseBody);
            log.info("************************************************************************");
            return Optional.of(responseBody);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }


    public <T extends BaseDto> T parseDto(final String responseBody, Class<T> valueType) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(responseBody, valueType);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}

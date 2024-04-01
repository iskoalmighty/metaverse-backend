package com.example.metaversebackend.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "openai")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OpenApiConfig {
    private String apiKey;
    private String model;
    private String threadsUrl;
    private String assistantsUrl;
    private String assistantInstruction;
}

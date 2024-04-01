package com.example.metaversebackend.model.assistant;

import com.example.metaversebackend.http.serializer.ArrayToJsonStringDeserializer;
import com.example.metaversebackend.http.serializer.ObjectToStringDeserializer;
import com.example.metaversebackend.http.serializer.UnixTimeStampDeserializer;
import com.example.metaversebackend.model.BaseDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AssistantDto extends BaseDto<Assistant> {

    private String id;

    private String object;

    @JsonProperty("created_at")
    @JsonDeserialize(using = UnixTimeStampDeserializer.class)
    private LocalDateTime createdAt;
    private String name;
    private String description;
    private String model;
    private String instructions;
    @JsonDeserialize(using = ArrayToJsonStringDeserializer.class)
    private String tools;

    @JsonDeserialize(using = ArrayToJsonStringDeserializer.class)
    @JsonProperty("file_ids")
    private String fileIds;
    @JsonDeserialize(using = ObjectToStringDeserializer.class)
    private String metadata;

    @Override
    public Assistant toEntity() {
        return Assistant.builder()
                .id(this.getId())
                .object(this.getObject())
                .createdAt(this.getCreatedAt())
                .name(this.getName())
                .description(this.getDescription())
                .model(this.getModel())
                .instructions(this.getInstructions())
                .tools(this.getTools())
                .fileIds(this.getFileIds())
                .metadata(this.getMetadata())
                .build();
    }

    @Override
    public BaseDto parseModel(Assistant entity) {
        return builder()
                .id(entity.getId())
                .object(entity.getObject())
                .createdAt(entity.getCreatedAt())
                .name(entity.getName())
                .description(entity.getDescription())
                .model(entity.getModel())
                .instructions(entity.getInstructions())
                .tools(entity.getTools())
                .fileIds(entity.getFileIds())
                .metadata(entity.getMetadata())
                .build();
    }
}

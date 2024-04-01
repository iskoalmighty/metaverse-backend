package com.example.metaversebackend.model.assistant;

import com.example.metaversebackend.model.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "assistants")
public class Assistant extends BaseEntity {

    @Id
    private String id;
    private String object;
    private LocalDateTime createdAt;
    private String name;
    private String description;
    private String model;
    private String instructions;
    private String tools;
    private String fileIds;
    private String metadata;


    @Override
    public AssistantDto toDto() {
        return AssistantDto.builder()
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
}

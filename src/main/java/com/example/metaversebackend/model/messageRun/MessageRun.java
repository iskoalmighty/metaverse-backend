package com.example.metaversebackend.model.messageRun;

import com.example.metaversebackend.model.BaseDto;
import com.example.metaversebackend.model.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
@Table(name = "message_runs")
public class MessageRun extends BaseEntity {

    @Id
    private String id;
    private String object;
    private LocalDateTime createdAt;
    private String assistantId;
    private String threadId;
    private String status;
    private LocalDateTime startedAt;
    private LocalDateTime expiresAt;
    private LocalDateTime cancelledAt;
    private LocalDateTime failedAt;
    private LocalDateTime completedAt;
    private String requiredAction;
    private String lastError;
    private String model;
    private String instructions;
    private String tools;
    private String fileIds;
    private String metadata;
    private String temperature;
    private String consumption;

    @Override
    public BaseDto toDto() {
        return new MessageRunDto(this);
    }
}
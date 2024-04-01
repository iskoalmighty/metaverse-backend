package com.example.metaversebackend.model.message;

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
@Table(name = "messages")
public class Message extends BaseEntity {

    @Id
    private String id;
    private String object;
    private LocalDateTime createdAt;
    private String threadId;
    private String role;
    private String content;
    private String fileIds;
    private String assistantId;
    private String runId;
    private String metadata;
    @Override
    public MessageDto toDto() {
        return new MessageDto(this);
    }
}

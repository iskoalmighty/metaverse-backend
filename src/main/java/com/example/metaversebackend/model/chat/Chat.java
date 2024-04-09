package com.example.metaversebackend.model.chat;

import com.example.metaversebackend.model.BaseDto;
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
@Table(name = "chats")
public class Chat extends BaseEntity {

    @Id
    private String id;
    private String object;
    private LocalDateTime createdAt;
    private String model;
    @Column(columnDefinition = "TEXT")
    private String choices;
    private String consumption;
    private String systemFingerprint;


    @Override
    public BaseDto toDto() {
        return new ChatDto(this);
    }
}

package com.example.metaversebackend.model.thread;

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
@Table(name = "threads")
public class Thread extends BaseEntity {

    @Id
    private String id;
    private String object;
    private LocalDateTime createdAt;
    private String metadata;
    @Override
    public BaseDto toDto() {
        return ThreadDto.builder()
                .id(this.id)
                .object(this.object)
                .createdAt(this.createdAt)
                .metadata(this.metadata)
                .build();
    }
}

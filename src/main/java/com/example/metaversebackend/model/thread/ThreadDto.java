package com.example.metaversebackend.model.thread;

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
public class ThreadDto extends BaseDto<Thread> {

    private String id;
    private String object;

    @JsonProperty("created_at")
    @JsonDeserialize(using = UnixTimeStampDeserializer.class)
    private LocalDateTime createdAt;

    @JsonDeserialize(using = ObjectToStringDeserializer.class)
    private String metadata;

    @Override
    public BaseDto parseModel(Thread entity) {
        return null;
    }

    @Override
    public Thread toEntity() {
        return Thread.builder()
                .id(this.id)
                .object(this.object)
                .createdAt(this.createdAt)
                .metadata(this.metadata)
                .build();
    }
}

package com.example.metaversebackend.model.message;

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
public class MessageDto extends BaseDto<Message> {

    private String id;
    private String object;
    @JsonProperty("created_at")
    @JsonDeserialize(using = UnixTimeStampDeserializer.class)
    private LocalDateTime createdAt;
    @JsonProperty("thread_id")
    private String threadId;
    private String role;
    @JsonDeserialize(using = ArrayToJsonStringDeserializer.class)
    private String content;
    @JsonDeserialize(using = ArrayToJsonStringDeserializer.class)
    @JsonProperty("file_ids")
    private String fileIds;
    @JsonProperty("assistant_id")
    private String assistantId;
    @JsonProperty("run_id")
    private String runId;
    @JsonDeserialize(using = ObjectToStringDeserializer.class)
    private String metadata;

    public MessageDto(Message message) {
        this.id = message.getId();
        this.object = message.getObject();
        this.createdAt = message.getCreatedAt();
        this.threadId = message.getThreadId();
        this.role = message.getRole();
        this.content = message.getContent();
        this.fileIds = message.getFileIds();
        this.assistantId = message.getAssistantId();
        this.runId = message.getRunId();
        this.metadata = message.getMetadata();
    }

    @Override
    public MessageDto parseModel(Message message) {
        return new MessageDto(message);
    }

    @Override
    public Message toEntity() {
        return Message.builder()
                .id(this.getId())
                .object(this.getObject())
                .createdAt(this.getCreatedAt())
                .threadId(this.getThreadId())
                .role(this.getRole())
                .content(this.getContent())
                .fileIds(this.getFileIds())
                .assistantId(this.getAssistantId())
                .runId(this.getRunId())
                .metadata(this.getMetadata())
                .build();
    }
}

package com.example.metaversebackend.model.messageRun;

import com.example.metaversebackend.http.serializer.ArrayToJsonStringDeserializer;
import com.example.metaversebackend.http.serializer.ObjectToStringDeserializer;
import com.example.metaversebackend.http.serializer.UnixTimeStampDeserializer;
import com.example.metaversebackend.model.BaseDto;
import com.example.metaversebackend.model.BaseEntity;
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
public class MessageRunDto extends BaseDto<MessageRun> {

    private String id;
    private String object;
    @JsonProperty("created_at")
    @JsonDeserialize(using = UnixTimeStampDeserializer.class)
    private LocalDateTime createdAt;
    @JsonProperty("assistant_id")
    private String assistantId;
    @JsonProperty("thread_id")
    private String threadId;
    private String status;
    @JsonProperty("started_at")
    @JsonDeserialize(using = UnixTimeStampDeserializer.class)
    private LocalDateTime startedAt;
    @JsonProperty("expires_at")
    @JsonDeserialize(using = UnixTimeStampDeserializer.class)
    private LocalDateTime expiresAt;
    @JsonProperty("cancelled_at")
    @JsonDeserialize(using = UnixTimeStampDeserializer.class)
    private LocalDateTime cancelledAt;
    @JsonProperty("failed_at")
    @JsonDeserialize(using = UnixTimeStampDeserializer.class)
    private LocalDateTime failedAt;
    @JsonProperty("completed_at")
    @JsonDeserialize(using = UnixTimeStampDeserializer.class)
    private LocalDateTime completedAt;
    @JsonProperty("required_action")
    private String requiredAction;
    @JsonProperty("last_error")
    @JsonDeserialize(using = ObjectToStringDeserializer.class)
    private String lastError;
    private String model;
    private String instructions;
    @JsonDeserialize(using = ArrayToJsonStringDeserializer.class)
    private String tools;
    @JsonDeserialize(using = ArrayToJsonStringDeserializer.class)
    @JsonProperty("file_ids")
    private String fileIds;
    @JsonDeserialize(using = ObjectToStringDeserializer.class)
    private String metadata;
    private String temperature;
    @JsonDeserialize(using = ObjectToStringDeserializer.class)
    private String usage;
    public MessageRunDto(MessageRun messageRun) {
        this.id = messageRun.getId();
        this.object = messageRun.getObject();
        this.createdAt = messageRun.getCreatedAt();
        this.assistantId = messageRun.getAssistantId();
        this.threadId = messageRun.getThreadId();
        this.status = messageRun.getStatus();
        this.startedAt = messageRun.getStartedAt();
        this.expiresAt = messageRun.getExpiresAt();
        this.cancelledAt = messageRun.getCancelledAt();
        this.failedAt = messageRun.getFailedAt();
        this.completedAt = messageRun.getCompletedAt();
        this.requiredAction = messageRun.getRequiredAction();
        this.lastError = messageRun.getLastError();
        this.model = messageRun.getModel();
        this.instructions = messageRun.getInstructions();
        this.tools = messageRun.getTools();
        this.fileIds = messageRun.getFileIds();
        this.metadata = messageRun.getMetadata();
        this.temperature = messageRun.getTemperature();
        this.usage = messageRun.getConsumption();
    }

    @Override
    public BaseDto parseModel(MessageRun messageRun) {
        return new MessageRunDto(messageRun);
    }

    @Override
    public MessageRun toEntity() {
        return MessageRun.builder()
                .id(this.getId())
                .object(this.getObject())
                .createdAt(this.getCreatedAt())
                .assistantId(this.getAssistantId())
                .threadId(this.getThreadId())
                .status(this.getStatus())
                .startedAt(this.getStartedAt())
                .expiresAt(this.getExpiresAt())
                .cancelledAt(this.getCancelledAt())
                .failedAt(this.getFailedAt())
                .completedAt(this.getCompletedAt())
                .requiredAction(this.getRequiredAction())
                .lastError(this.getLastError())
                .model(this.getModel())
                .instructions(this.getInstructions())
                .tools(this.getTools())
                .fileIds(this.getFileIds())
                .metadata(this.getMetadata())
                .temperature(this.getTemperature())
                .consumption(this.getUsage())
                .build();
    }
}

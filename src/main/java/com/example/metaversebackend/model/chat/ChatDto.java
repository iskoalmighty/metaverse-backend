package com.example.metaversebackend.model.chat;

import com.example.metaversebackend.http.serializer.ObjectToStringDeserializer;
import com.example.metaversebackend.http.serializer.UnixTimeStampDeserializer;
import com.example.metaversebackend.model.BaseDto;
import com.example.metaversebackend.utils.ObjectMapperUtil;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChatDto extends BaseDto<Chat> {

    private String id;
    private String object;
    @JsonProperty("created")
    @JsonDeserialize(using = UnixTimeStampDeserializer.class)
    private LocalDateTime createdAt;
    private String model;
    private List<Choice> choices;
    @JsonDeserialize(using = ObjectToStringDeserializer.class)
    private String usage;
    @JsonProperty("system_fingerprint")
    private String systemFingerPrint;

    private final ObjectMapperUtil objectMapperUtil = new ObjectMapperUtil();

    public ChatDto(Chat entity) {
        this.id = entity.getId();
        this.object = entity.getObject();
        this.createdAt = entity.getCreatedAt();
        this.model = entity.getModel();
        this.choices = objectMapperUtil.stringToObject(entity.getChoices(), List.class);
        this.usage = entity.getConsumption();
        this.systemFingerPrint = entity.getSystemFingerprint();
    }

    @Override
    public ChatDto parseModel(Chat entity) {
        return new ChatDto(entity);
    }

    @Override
    public Chat toEntity() {
        return Chat.builder()
                .id(this.id)
                .object(this.object)
                .createdAt(this.createdAt)
                .model(this.model)
                .choices(objectMapperUtil.objectToString(this.choices))
                .consumption(this.usage)
                .systemFingerprint(this.systemFingerPrint)
                .build();
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    private static class Choice {
        private int index;
        private Message message;
        private String logprobs;
        private String finish_reason;

        private record Message(String role, String content) {}
    }

}

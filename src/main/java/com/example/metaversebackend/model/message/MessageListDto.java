package com.example.metaversebackend.model.message;

import com.example.metaversebackend.model.BaseDto;
import com.example.metaversebackend.model.BaseEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MessageListDto extends BaseDto {

    private String object;
//    @JsonProperty("data")
    List<MessageDto> data;
    @JsonProperty("first_id")
    private String firstId;
    @JsonProperty("last_id")
    private String lastId;
    @JsonProperty("has_more")
    boolean hasMore;

    @Override
    public BaseDto parseModel(BaseEntity entity) {
        return null;
    }

    @Override
    public BaseEntity toEntity() {
        return null;
    }
}

package com.example.metaversebackend.controller;

import com.example.metaversebackend.http.annotation.Exist;
import com.example.metaversebackend.http.request.message.MessageRequest;
import com.example.metaversebackend.model.BaseDto;
import com.example.metaversebackend.model.message.MessageDto;
import com.example.metaversebackend.model.message.MessageListDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Tag(name = "Open API Message Controller", description = "Create and retrieves messages from Open API")
public interface MessageApi {

    @Operation(summary = "Gets all the list of messages generated from Open API")
    @ApiResponse(responseCode = "200",
            content = @Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = MessageDto.class, type = "List")))
    List<BaseDto> listMessage();

    @Operation(
            summary = "Requests message from Open API base on the given thread id",
            description = "The requested message will saved to database and returns serialized version",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = @Content(schema = @Schema(implementation = MessageRequest.class))))
    @ApiResponse(responseCode = "200",
            content = @Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = MessageDto.class)))
    ResponseEntity<MessageDto> createMessage(@Valid @RequestBody MessageRequest messageRequest);

    ResponseEntity<MessageListDto> getMessage(
            @Valid
            @Exist(entityName = "Thread", message = "Thread not Exists!!")
            String threadId);

}

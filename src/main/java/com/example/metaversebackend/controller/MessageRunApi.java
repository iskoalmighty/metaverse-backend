package com.example.metaversebackend.controller;

import com.example.metaversebackend.http.annotation.Exist;
import com.example.metaversebackend.http.request.messageRun.MessageRunRequest;
import com.example.metaversebackend.model.messageRun.MessageRunDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "Open API Message Run Controller", description = "Create and retrieves message run from Open API")
public interface MessageRunApi {

    @Operation(
            summary = "Requests message run from Open API base on the given thread id",
            description = "The requested message run will saved to database and returns serialized version",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = @Content(schema = @Schema(implementation = MessageRunRequest.class))))
    @ApiResponse(responseCode = "200",
            content = @Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = MessageRunDto.class)))
    ResponseEntity<MessageRunDto> createMessageRun(@Valid @RequestBody MessageRunRequest messageRunRequest);

    ResponseEntity<MessageRunDto> getRunStatus(
            @Valid @Exist(entityName = "Thread", message = "Thread not Exists!!") String threadId,
            @Valid @Exist(entityName = "MessageRun", message = "Thread not Exists!!") String runId);


}

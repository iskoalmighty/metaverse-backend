package com.example.metaversebackend.controller;

import com.example.metaversebackend.model.BaseDto;
import com.example.metaversebackend.model.thread.ThreadDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Tag(name = "Open API Thread Controller", description = "Creates and retrieves threads from Open API")
public interface ThreadApi {

    @Operation(summary = "Gets all the list of threads generated from Open API")
    @ApiResponse(responseCode = "200",
            content = @Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = ThreadDto.class, type = "List")))
    List<BaseDto> listThread();


    @Operation(
            summary = "Requests thread from Open API base on the given thread id",
            description = "The requested thread will saved to database and returns serialized version")
    @ApiResponse(responseCode = "200",
            content = @Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = ThreadDto.class)))
    ResponseEntity<ThreadDto> createThread();
}

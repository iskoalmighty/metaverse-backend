package com.example.metaversebackend.controller;

import com.example.metaversebackend.http.annotation.Exist;
import com.example.metaversebackend.model.message.MessageDto;
import com.example.metaversebackend.model.user.UserDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Tag(name = "User/Player Controller", description = "CRUD resource for user/player")
public interface UserApi {
    @Operation(summary = "Gets the list of user/players saved on the database")
    @ApiResponse(responseCode = "200",
            content = @Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = UserDto.class, type = "List")))
    List<UserDto> getUsers();

    @Operation(
            summary = "Gets the single instance of user/player record with the given id",
            description = "Returns serialized record of user/player, will return error message if user id is not valid",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = @Content(schema = @Schema(implementation = UserDto.class))))
    @ApiResponse(responseCode = "200",
            content = @Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = MessageDto.class)))
    ResponseEntity<UserDto> getUser(
            @PathVariable
            @Valid
            @Exist(entityName = "User", message = "User not Exists!!")
            Long id);

}

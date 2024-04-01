package com.example.metaversebackend.controller;

import com.example.metaversebackend.http.request.user.AuthenticationRequest;
import com.example.metaversebackend.model.user.AuthenticationResponse;
import com.example.metaversebackend.model.user.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

@Tag(name = "Authentication in API", description = "User Registration and Authentication")
public interface AuthenticationApi {

    @Operation(
            summary = "Accepts user registration request and automatically authenticates by returning valid token",
            description = "User information will save to database",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = @Content(schema = @Schema(implementation = User.class)))
    )
    @ApiResponse(responseCode = "200",
            content = @Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = AuthenticationResponse.class)))
    @ApiResponse(responseCode = "500",
            content = @Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = Map.class))
    )
    ResponseEntity<AuthenticationResponse> register(@RequestBody User request);

    @Operation(
            summary = "Accepts user login request returns valid token if authenticated",
            description = "Validates user credentials and returns error message if unauthenticated",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = @Content(schema = @Schema(implementation = AuthenticationRequest.class)))
    )
    @ApiResponse(responseCode = "200",
            content = @Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = AuthenticationResponse.class)))
    @ApiResponse(responseCode = "500",
            content = @Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = Map.class))
    )
    ResponseEntity<AuthenticationResponse> login(@Valid @RequestBody AuthenticationRequest request);
}

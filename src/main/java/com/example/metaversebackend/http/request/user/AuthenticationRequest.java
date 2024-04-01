package com.example.metaversebackend.http.request.user;

import com.example.metaversebackend.http.annotation.Exist;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationRequest {

    @NotNull
    @NotBlank
    @Exist(entityName = "User", columnName = "username", message = "Username not found!")
    private String username;

    @NotNull @NotBlank
    private String password;

}

package com.example.metaversebackend.model.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    @JsonProperty(index = 1)
    private Long id;
    @JsonProperty(value = "last_name", index = 2)
    private String lastName;
    @JsonProperty(value = "first_name", index = 3)
    private String firstName;
    @JsonProperty(value = "middle_name", index = 4)
    private String middleName;
    private String suffix;
    private String email;
    private String username;
    private String role;

    public static UserDto build(User user) {
        UserDto userDto = new UserDto();
        userDto.id = user.getId();
        userDto.lastName = user.getLastName();
        userDto.firstName = user.getFirstName();
        userDto.middleName = user.getMiddleName();
        userDto.suffix = user.getSuffix();
        userDto.email = user.getEmail();
        userDto.username = user.getUsername();
        userDto.role = String.valueOf(user.getRole());
        return userDto;
    }

}

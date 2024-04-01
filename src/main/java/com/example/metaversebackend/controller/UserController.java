package com.example.metaversebackend.controller;

import com.example.metaversebackend.model.user.UserDto;
import com.example.metaversebackend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController implements UserApi {

    private final UserService userService;

    @Override
    @GetMapping
    public List<UserDto> getUsers() {
        return userService.getUsers();
    }

    @Override
    @GetMapping(path = "/{id}")
    public ResponseEntity<UserDto> getUser(Long id) {
        return userService.getUser(id)
                .map(user -> new ResponseEntity<>(UserDto.build(user), HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}

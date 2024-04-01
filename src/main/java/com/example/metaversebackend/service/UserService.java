package com.example.metaversebackend.service;

import com.example.metaversebackend.model.user.User;
import com.example.metaversebackend.model.user.UserDto;
import com.example.metaversebackend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDto> getUsers() {
        return userRepository.findAll().stream().map(UserDto::build).collect(Collectors.toList());
    }

    public Optional<User> getUser(Long id) {
        return userRepository.findById(id);
    }

}

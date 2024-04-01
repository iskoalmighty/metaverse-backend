package com.example.metaversebackend.controller;

import com.example.metaversebackend.model.BaseDto;
import com.example.metaversebackend.model.thread.ThreadDto;
import com.example.metaversebackend.service.ThreadService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/openai/thread")
public class ThreadController implements ThreadApi{

    private final ThreadService threadService;

    @Override
    @GetMapping
    public List<BaseDto> listThread() {
        return threadService.findAll();
    }

    @Override
    @PostMapping
    public ResponseEntity<ThreadDto> createThread() {
        return threadService.createThread()
                .map(threadDto -> new ResponseEntity<>(threadDto, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

}

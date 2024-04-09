package com.example.metaversebackend.controller;

import com.example.metaversebackend.http.request.chat.CreateChatRequest;
import com.example.metaversebackend.model.BaseDto;
import com.example.metaversebackend.model.chat.ChatDto;
import com.example.metaversebackend.service.ChatService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/openai/chat")
public class ChatController {

    private final ChatService chatService;

    @GetMapping
    public List<BaseDto> listThread() {
        return chatService.findAll();
    }

    @PostMapping
    public ResponseEntity<ChatDto> chatCompletion(@Valid @RequestBody CreateChatRequest request) {
        return chatService.chatCompletion(request)
                .map(chatDto -> new ResponseEntity<>(chatDto, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

}

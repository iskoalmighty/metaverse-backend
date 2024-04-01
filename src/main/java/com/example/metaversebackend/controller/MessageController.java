package com.example.metaversebackend.controller;

import com.example.metaversebackend.http.annotation.Exist;
import com.example.metaversebackend.http.request.message.MessageRequest;
import com.example.metaversebackend.model.BaseDto;
import com.example.metaversebackend.model.message.MessageDto;
import com.example.metaversebackend.model.message.MessageListDto;
import com.example.metaversebackend.service.MessageService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/openai/message")
public class MessageController implements MessageApi {
    private final MessageService messageService;

    @Override
    @GetMapping
    public List<BaseDto> listMessage() {
        return messageService.findAll();
    }

    @Override
    @PostMapping
    public ResponseEntity<MessageDto> createMessage(MessageRequest messageRequest) {
        return messageService.createMessage(messageRequest)
                .map(messageDto -> new ResponseEntity<>(messageDto, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    @Override
    @GetMapping(path = "/{id}")
    public ResponseEntity<MessageListDto> getMessage(@PathVariable String id) {
        return messageService.getMessages(id)
                .map(messageListDto -> new ResponseEntity<>(messageListDto, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }
}

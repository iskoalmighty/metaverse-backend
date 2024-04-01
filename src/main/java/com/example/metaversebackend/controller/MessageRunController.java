package com.example.metaversebackend.controller;

import com.example.metaversebackend.http.request.messageRun.MessageRunRequest;
import com.example.metaversebackend.model.messageRun.MessageRunDto;
import com.example.metaversebackend.service.MessageRunService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/openai/message-run")
public class MessageRunController implements MessageRunApi {

    private final MessageRunService messageRunService;

    @Override
    @PostMapping
    public ResponseEntity<MessageRunDto> createMessageRun(MessageRunRequest messageRunRequest) {
        return messageRunService.createMessageRun(messageRunRequest)
                .map(messageRunDto -> new ResponseEntity<>(messageRunDto, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));

    }
    @GetMapping(path = "/{threadId}/{runId}")
    public ResponseEntity<MessageRunDto> getRunStatus(@PathVariable String threadId, @PathVariable String runId) {
        return messageRunService.getRunStatus(threadId, runId)
                .map(messageRunDto -> new ResponseEntity<>(messageRunDto, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));

    }
}

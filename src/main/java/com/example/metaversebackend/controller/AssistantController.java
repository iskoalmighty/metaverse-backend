package com.example.metaversebackend.controller;

import com.example.metaversebackend.model.BaseDto;
import com.example.metaversebackend.model.assistant.AssistantDto;
import com.example.metaversebackend.service.AssistantService;
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
@RequestMapping("/openai/assistant")
public class AssistantController {

    private final AssistantService assistantService;

    @GetMapping
    public List<BaseDto> listAssistants() {
        return assistantService.findAll();
    }

    @PostMapping
    public ResponseEntity<AssistantDto> createAssistant() {
        return assistantService.createAssistant()
                .map(assistantDto -> new ResponseEntity<>(assistantDto, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

}

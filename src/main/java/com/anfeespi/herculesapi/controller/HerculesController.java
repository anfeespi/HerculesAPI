package com.anfeespi.herculesapi.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/model")
@SecurityRequirement(name = "bearer-key")
public class HerculesController {
    private final OllamaChatModel chatModel;

    @Value("${config.hercules.system}")
    private String system;

    public HerculesController(OllamaChatModel chatModel) {
        this.chatModel = chatModel;
    }

    @GetMapping
    public String chat(@RequestParam String message) {
        return chatModel.call(message);
    }

    @GetMapping("/category")
    public String category(@RequestParam String problem) {
        return this.chatModel.call(system + problem);
    }
}

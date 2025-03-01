package io.gocklkatz.schnoeschnoebe.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class PromptController {

    @GetMapping(path = "/prompt")
    public String prompt(String question) {
        LocalDateTime now = LocalDateTime.now();
        return "You were here. " + now;
    }
}

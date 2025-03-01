package io.gocklkatz.schnoeschnoebe.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class PromptController {

    Logger logger = LoggerFactory.getLogger(PromptController.class);

    @GetMapping(path = "/prompt")
    public String prompt(String question) {
        LocalDateTime now = LocalDateTime.now();
        logger.info("It is {}", now);
        return "You were here. " + now;
    }
}

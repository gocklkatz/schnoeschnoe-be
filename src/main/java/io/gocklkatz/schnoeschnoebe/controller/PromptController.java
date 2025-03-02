package io.gocklkatz.schnoeschnoebe.controller;

import io.gocklkatz.schnoeschnoebe.service.OpenAIService;
import io.gocklkatz.schnoeschnoebe.service.PersistenceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@CrossOrigin(origins = {"http://localhost:4200", "https://schnoeschnoe.onrender.com"})
public class PromptController {

    Logger logger = LoggerFactory.getLogger(PromptController.class);

    private final OpenAIService openAIService;
    private final PersistenceService persistenceService;

    public PromptController(OpenAIService openAIService,
                            PersistenceService persistenceService) {
        this.openAIService = openAIService;
        this.persistenceService = persistenceService;

    }

    @GetMapping(path = "/time")
    public String time() {
        LocalDateTime now = LocalDateTime.now();
        logger.info("You were here at {}", now);
        return "You were here at " + now;
    }

    @GetMapping(path = "/prompt")
    public String prompt(@RequestParam("question") String question) {
        logger.info("Question: {}", question);
        String answer = openAIService.getAnswer(question);
        logger.info("Answer: {}", answer);

        persistenceService.saveQuestionAndAnswer(question, answer);

        return answer;
    }

}

package io.gocklkatz.schnoeschnoebe.controller;

import io.gocklkatz.schnoeschnoebe.model.Question;
import io.gocklkatz.schnoeschnoebe.service.OpenAIService;
import io.gocklkatz.schnoeschnoebe.service.PersistenceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

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

    @GetMapping(path = "/question")
    public List<Question> getAllQuestions() {
        List<Question> questions = persistenceService.getAllQuestions();
        logger.info("Questions: {}", questions);
        return questions;
    }

    @GetMapping("/question/{id}")
    public Question getQuestion(@PathVariable Long id) {
        Question question = persistenceService.getOneQuestion(id);
        logger.info("Question: {}", question);
        return question;
    }

}

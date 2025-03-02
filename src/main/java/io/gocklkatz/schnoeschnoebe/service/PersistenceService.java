package io.gocklkatz.schnoeschnoebe.service;

import io.gocklkatz.schnoeschnoebe.model.Question;

import java.util.List;

public interface PersistenceService {
    void saveQuestionAndAnswer(String question, String answer);
    List<Question> getAllQuestions();
    Question getOneQuestion(Long id);
}

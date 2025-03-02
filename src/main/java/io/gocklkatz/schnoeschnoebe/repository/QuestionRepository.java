package io.gocklkatz.schnoeschnoebe.repository;

import io.gocklkatz.schnoeschnoebe.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    List<Question> findByQuestion(String question);
}

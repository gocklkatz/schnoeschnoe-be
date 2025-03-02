package io.gocklkatz.schnoeschnoebe.repository;

import io.gocklkatz.schnoeschnoebe.model.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
}

package io.gocklkatz.schnoeschnoebe.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Question {

    @Id
    @GeneratedValue
    private Long id;

    @OneToMany( mappedBy = "question", fetch = FetchType.EAGER)
    private List<Answer> answers = new ArrayList<>();

    private String question;

    public Question() {
    }

    public Question(String question, List<Answer> answers) {
        this.question = question;
        this.answers = answers;
    }

    public Long getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<Answer> getAnswers() {
        return new ArrayList<>(answers);
    }

    public void addAnswer(Answer answer) {
        answers.add(answer);
    }
}

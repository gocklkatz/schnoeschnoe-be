package io.gocklkatz.schnoeschnoebe.service;

import io.gocklkatz.schnoeschnoebe.model.Answer;
import io.gocklkatz.schnoeschnoebe.model.Question;
import io.gocklkatz.schnoeschnoebe.repository.AnswerRepository;
import io.gocklkatz.schnoeschnoebe.repository.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersistenceServiceImpl implements PersistenceService {

    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;

    public PersistenceServiceImpl(QuestionRepository questionRepository,
                                  AnswerRepository answerRepository) {
        this.questionRepository = questionRepository;
        this.answerRepository = answerRepository;
    }

    @Override
    public void saveQuestionAndAnswer(String question, String answer) {
        List<Question> questions = questionRepository.findByQuestion(question);

        Question questionEntity;
        if (questions.isEmpty()) {
            questionEntity = new Question();
            questionEntity.setQuestion(question);
            questionRepository.save(questionEntity);
        } else {
            questionEntity = questions.getFirst();
        }

        Answer answerEntity = new Answer();
        answerEntity.setAnswer(answer);
        answerEntity.setQuestion(questionEntity);
        answerRepository.save(answerEntity);
    }

    @Override
    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    @Override
    public Question getOneQuestion(Long id) {
        Optional<Question> questionOptional = questionRepository.findById(id);
        return questionOptional.orElseGet(Question::new);
    }
}

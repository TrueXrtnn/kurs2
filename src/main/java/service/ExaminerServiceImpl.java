package service;

import com.example.kurs2.Question;
import exception.NotEnoughQuestions;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final List<QuestionService> services;
    private final Random random = new Random();

    public ExaminerServiceImpl(List<QuestionService> services) {
        this.services = services;
    }

    public Collection<Question> getQuestions(int amount) {
        List<QuestionService> availableQuestionService = services.stream()
                .filter(service -> service.getAvailableQuestions() > 0)
                .toList();
        if (availableQuestionService.isEmpty()) {
            throw new IllegalStateException("not question!");
        }
        int totalAvailableQuestions = services.stream()
                .mapToInt(QuestionService::getAvailableQuestions)
                .sum();
        if (totalAvailableQuestions < amount) {
            throw new NotEnoughQuestions("Не достаточно вопросов в сборнике!");
        }
        if (totalAvailableQuestions == amount) {
            var collect = services.stream().map(QuestionService::getAll)
                    .flatMap(Collection::stream)
                    .toList();
        }
        var question = new HashSet<Question>();
        while (question.size() < amount) {
            int nextInt = random.nextInt(availableQuestionService.size());
            QuestionService randomService = availableQuestionService.get(nextInt);
            Question randomQuestion = randomService.getRandomQuestion();
            question.add(randomQuestion);
        }
        return Collections.unmodifiableCollection(question);

    }
}


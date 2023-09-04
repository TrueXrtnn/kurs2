package com.example.kurs2.service;

import com.example.kurs2.Question;
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


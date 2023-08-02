package com.example.kurs2.service;

import com.example.kurs2.Question;

import java.util.Collection;

public interface QuestionService {
    Question add(String question, String answer);
    Question add(Question question);
    Question remove(Question question);
    Collection <Question> getAll();
    Question getRandomQuestion();
    int getAvailableQuestions();
}

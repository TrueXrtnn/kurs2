package com.example.kurs2.service;

import com.example.kurs2.Question;

import java.util.Collection;

public interface ExaminerService {
    public Collection<Question> getQuestions(int amount);
}

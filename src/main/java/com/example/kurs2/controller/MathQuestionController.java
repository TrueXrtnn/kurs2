package com.example.kurs2.controller;

import com.example.kurs2.Question;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.kurs2.service.QuestionService;

import java.util.Collection;

@RestController
@RequestMapping("/exam/match")
public class MathQuestionController {
    private final QuestionService service;

    public MathQuestionController(@Qualifier("mathQuestion") QuestionService service) {
        this.service = service;
    }
    @GetMapping("/remove")
    public Question remove(@RequestParam String question, @RequestParam String answer) {
        return service.remove(new Question(question, answer));
    }

    @GetMapping("/add")
    public Question add(@RequestParam String question, @RequestParam String answer) {
        return service.add(question, answer);
    }

    @GetMapping
    public Collection<Question> all() {
        return service.getAll();
    }
}

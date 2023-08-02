package service;

import com.example.kurs2.Question;
import com.example.kurs2.service.JavaQuestionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import com.example.kurs2.repository.JavaQuestionRepository;

import java.util.HashSet;
import java.util.Set;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static service.TestData.*;


class JavaQuestionServiceTest {
    @Mock
    private JavaQuestionRepository repository;

    JavaQuestionService service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        service = new JavaQuestionService(repository);
    }

    @Test
    void testAdd() {
        var questions = FULL_SET;
        when(repository.getAll()).thenReturn(questions);
        var question = service.getRandomQuestion();
        assertThat(questions).containsAnyOf(question);
        Set<Question> all = new HashSet<>();
        while (all.size() < questions.size()) {
            all.add(service.getRandomQuestion());
        }
        assertThat(all.size()).isEqualTo(questions.size());
        assertThat(all).containsExactlyElementsOf(all);
    }

    @Test
    void remove() {
        when(repository.remove(Q1)).thenReturn(Q1);
        service.add(Q1);
        assertEquals(Q1,service.remove(Q1));
    }

    @Test
    void getAll() {
        service.add(Q1);
        service.add(Q2);
        service.add(Q3);
        service.add(Q4);
        service.add(Q5);
        when(repository.getAll()).thenReturn(FULL_SET);
        assertEquals(service.getAll(),FULL_SET);
    }



    @Test
    void getAvailableQuestions() {
        var questions = FULL_SET;
        when(repository.getAll()).thenReturn(questions);
        service.add(Q1);
        service.add(Q2);
        service.add(Q3);
        service.add(Q4);
        service.add(Q5);
        assertEquals(questions.size(),service.getAvailableQuestions());
    }
}
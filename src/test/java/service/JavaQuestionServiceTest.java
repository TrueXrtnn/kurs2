package service;

import com.example.kurs2.Question;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import repository.JavaQuestionRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class JavaQuestionServiceTest {
    @Mock
    JavaQuestionRepository repository;

    JavaQuestionService service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        service = new JavaQuestionService(repository);
    }

    @Test
    void testAdd() {
        var questions = List.of(new Question("q1", "a1"), new Question("q2", "a2"));
        when(repository.getAll()).thenReturn(questions);
        var question = service.getRandomQuestion();
        assertThat(questions).containsExactly(question);
        Set<Question> all = new HashSet<>();
        while (all.size() < questions.size()) {
            all.add(service.getRandomQuestion());
        }
        assertThat(all.size()).isEqualTo(questions.size());
        assertThat(questions).containsExactlyElementsOf(all);
    }

    @Test
    void remove() {
    }

    @Test
    void getAll() {
    }

    @Test
    void getRandomQuestion() {
    }

    @Test
    void getAvailableQuestions() {
    }
}
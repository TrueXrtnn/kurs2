package service;

import com.example.kurs2.service.ExaminerServiceImpl;
import com.example.kurs2.service.QuestionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import static org.assertj.core.api.Assertions.assertThat;
import static service.TestData.*;

class ExaminerServiceImplTest {
    private ExaminerServiceImpl examinerService;
    @Mock
    private QuestionService examinerMock;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        examinerService = new ExaminerServiceImpl(Collections.singletonList(examinerMock));
    }

    @Test
    void getQuestions() {
        when(examinerMock.getAvailableQuestions()).thenReturn(FULL_SET.size());
        when(examinerMock.getRandomQuestion()).thenReturn(Q1);
        assertEquals(1, examinerService.getQuestions(1).size());

    }
}
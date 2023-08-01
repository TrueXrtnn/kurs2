package service;

import com.example.kurs2.Question;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatException;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static service.TestData.*;
import static service.TestData.Q5;

class ExaminerServiceImplTest {
    private ExaminerServiceImpl examinerService;
    @Mock
    private List<QuestionService> examinerMock;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        examinerService = new ExaminerServiceImpl(examinerMock);
    }

    @Test
    void getQuestions() {
       assertThrows(IllegalStateException.class, () -> examinerService.getQuestions(1));

    }
}
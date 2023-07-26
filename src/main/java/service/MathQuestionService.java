package service;

import com.example.kurs2.Question;
import exception.QuestionUnsupportedOperationException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import repository.QuestionRepository;

import java.util.*;
@Service("mathQuestion")
public class MathQuestionService implements QuestionService {
    private final QuestionRepository repository;
    private final Random random = new Random();

    public MathQuestionService(@Qualifier("javaRepository")QuestionRepository repository) {
        this.repository = repository;
    }

    @Override
    public Question add(String question, String answer) {
        throw new QuestionUnsupportedOperationException();
    }

    @Override
    public Question add(Question question) {

        throw new QuestionUnsupportedOperationException();

    }

    @Override
    public Question remove(Question question) {
        throw new QuestionUnsupportedOperationException();

    }

    @Override
    public Collection<Question> getAll() {
        throw new QuestionUnsupportedOperationException();

    }

    @Override
    public Question getRandomQuestion() {
        int x = (random.nextInt(3212) + 1) * (random.nextBoolean() ? 1 : -1);
        int y = (random.nextInt(212) + 1) * (random.nextBoolean() ? 1 : -1);
        int z = (random.nextInt(1212) + 1) * (random.nextBoolean() ? 1 : -1);
        var answer = new StringBuilder(String.valueOf(x));
        int result = exec(x, y, answer);
        result = exec(result,z,answer);

        return new Question(answer.toString(), String.valueOf(result));
    }

    private int exec(int first, int second, StringBuilder answer) {
        switch (random.nextInt(4)) {
            case 0:
                answer.append(" * ").append(second);
                return first * second;
            case 1:
                answer.append(" / ").append(second);
                return first / second;
            case 2:
                answer.append(" + ").append(second);
                return first + second;
            case 3:
                answer.append(" - ").append(second);
                return first - second;
            default:
                throw new UnsupportedOperationException();
        }
    }
    @Override
    public int getAvailableQuestions() {
        return Integer.MAX_VALUE;
    }
}

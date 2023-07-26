package service;

import com.example.kurs2.Question;
import exception.QuestionUnsupportedOperationException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import repository.JavaQuestionRepository;
import repository.QuestionRepository;

import javax.naming.OperationNotSupportedException;
import java.util.*;

@Service("javaQuestion")
public class JavaQuestionService implements QuestionService {
    private final QuestionRepository repository;
    private final Set<Question> storage = new HashSet<>();
    private final Random random = new Random();

    public JavaQuestionService(@Qualifier("mathRepository") QuestionRepository repository) {
        this.repository = repository;
    }

    @Override
    public Question add(String question, String answer) {
        return add(new Question(question, answer));
    }

    @Override
    public Question add(Question question) {
        return repository.add(question);
    }

    @Override
    public Question remove(Question question) {
        return repository.remove(question);
    }

    @Override
    public Collection<Question> getAll() {
        return repository.getAll();
    }

    @Override
    public Question getRandomQuestion() {
        var allQuestion = repository.getAll();
        var index = random.nextInt(allQuestion.size());
        int i =0;
        for (Question question : allQuestion) {
            if (i==index){
                return question;
            }
            i++;
        }
        return null;
    }

    @Override
    public int getAvailableQuestions() {
        return repository.getAll().size();
    }
}



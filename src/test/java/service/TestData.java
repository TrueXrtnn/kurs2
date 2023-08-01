package service;

import com.example.kurs2.Question;

import java.util.HashSet;
import java.util.Set;

public class TestData {
    public static final Question Q1 = new Question("q1","a1");
    public static final Question Q2 = new Question("q2","a2");
    public static final Question Q3 = new Question("q3","a3");
    public static final Question Q4 = new Question("q4","a4");
    public static final Question Q5 = new Question("q5","a5");
    public static final Set EMPTY_SET = new HashSet();
    public static final Set FULL_SET = new HashSet<>(Set.of(
            new Question(Q1.getQuestion(), Q1.getAnswer()),
            new Question(Q2.getQuestion(), Q2.getAnswer()),
            new Question(Q3.getQuestion(), Q3.getAnswer()),
            new Question(Q4.getQuestion(), Q4.getAnswer()),
            new Question(Q5.getQuestion(), Q5.getAnswer())
    ));
}

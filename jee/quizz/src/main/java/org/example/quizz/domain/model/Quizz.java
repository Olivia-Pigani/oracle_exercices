package org.example.quizz.domain.model;

import java.util.HashSet;
import java.util.Set;

public class Quizz {

    private static long idIncrementor = 0;

    private long id;

    private Set<Question> questionSet =new HashSet<>();

    public Quizz(Set<Question> questionSet) {
        this.id = ++idIncrementor;
        this.questionSet = questionSet;
    }

    public long getId() {
        return id;
    }

    public Set<Question> getQuestionSet() {
        return questionSet;
    }

    public void setQuestionSet(Set<Question> questionSet) {
        this.questionSet = questionSet;
    }
}

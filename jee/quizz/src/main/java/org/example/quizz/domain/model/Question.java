package org.example.quizz.domain.model;

import java.util.HashSet;
import java.util.Set;

public class Question {

    private static long idIncrementor = 0;

    private long id;

    private String title;

    private Set<String> answerSet = new HashSet<>();

    private int correctAnswer;

    public Question(long id, Set<String> answerSet, String question, int correctAnswer) {
        this.id = ++idIncrementor;
        this.answerSet = answerSet;
        this.title = question;
        this.correctAnswer = correctAnswer;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<String> getAnswerSet() {
        return answerSet;
    }

    public void setAnswerSet(Set<String> answerSet) {
        this.answerSet = answerSet;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(int correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
}

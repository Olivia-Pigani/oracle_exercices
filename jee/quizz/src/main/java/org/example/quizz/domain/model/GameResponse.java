package org.example.quizz.domain.model;

public class GameResponse {

    private static long idIncrementor = 0;

    private long id;

    private String quizzId;

    private String userId;

    private String questionId;

    private String chosenAnswer;

    public GameResponse(String id, String quizzId, String userId, String chosenAnswer, String questionId) {
        this.quizzId = quizzId;
        this.id = ++idIncrementor;
        this.userId = userId;
        this.chosenAnswer = chosenAnswer;
        this.questionId = questionId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public String getChosenAnswer() {
        return chosenAnswer;
    }

    public void setChosenAnswer(String chosenAnswer) {
        this.chosenAnswer = chosenAnswer;
    }
}

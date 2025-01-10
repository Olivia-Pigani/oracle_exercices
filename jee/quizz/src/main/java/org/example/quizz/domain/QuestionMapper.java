package org.example.quizz.domain;

import org.example.quizz.domain.dto.QuestionDto;
import org.example.quizz.domain.model.Question;

import java.util.Set;
import java.util.stream.Collectors;

public class QuestionMapper {

    public static Question toQuestion(QuestionDto questionDto){
        return new Question(questionDto.id(), questionDto.answerSet(), questionDto.question(), questionDto.correctAnswer());
    }

    public static QuestionDto toQuestionDto(Question question){
        return new QuestionDto(question.getId(), question.getTitle(), question.getAnswerSet(), question.getCorrectAnswer());
    }

    public static Set<QuestionDto> toQuestionDtoSet(Set<Question> questionSet){
        return questionSet.stream()
                .map(QuestionMapper::toQuestionDto)
                .collect(Collectors.toSet());
    }

    public static Set<Question> toQuestionSet(Set<QuestionDto> questionSetDto){
        return questionSetDto.stream()
                .map(QuestionMapper::toQuestion)
                .collect(Collectors.toSet());
    }

}

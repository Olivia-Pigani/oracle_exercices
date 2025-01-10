package org.example.quizz.domain;

import org.example.quizz.domain.dto.QuestionDto;
import org.example.quizz.domain.dto.QuizzDto;
import org.example.quizz.domain.model.Question;
import org.example.quizz.domain.model.Quizz;

import java.util.Set;
import java.util.stream.Collectors;

public class QuizzMapper {

    public static QuizzDto toQuizzDto(Quizz quizz){

        Set<QuestionDto> questionDtoSet = QuestionMapper.toQuestionDtoSet(quizz.getQuestionSet());

        return new QuizzDto(quizz.getId(),questionDtoSet);
    }

    public static Set<QuizzDto> toQuizzDtoSet(Set<Quizz> quizzSet){
        return quizzSet.stream()
                .map(QuizzMapper::toQuizzDto)
                .collect(Collectors.toSet());
    }

}

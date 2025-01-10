package org.example.quizz.domain.dto;

import java.util.Set;

public record QuizzDto(

        long id,

        Set<QuestionDto> questionDtoSet
) {
}

package org.example.quizz.domain.dto;

import java.util.Set;

public record QuestionDto(

        long id,

        String question,

        Set<String> answerSet,

        int correctAnswer
) {
}

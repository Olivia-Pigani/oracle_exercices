package org.example.quizz.domain.dto;

public record GameResponseDto(

        String userId,

        String questionId,

        int chosenAnswer
) {
}

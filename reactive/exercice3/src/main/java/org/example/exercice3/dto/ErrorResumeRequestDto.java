package org.example.exercice3.dto;

import java.util.List;

public record ErrorResumeRequestDto(
        List<String> stringList,

        String error
) {
}

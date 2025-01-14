package org.example.ms_class.dto;

import java.util.List;

public record SchoolClassRequestDto(

        long professorId,

        List<Long> studentIdList
) {
}

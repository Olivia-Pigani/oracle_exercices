package org.example.ms_class.dto;

import java.util.List;

public record SchoolClassResponseDto(

        long id,

        String professor,

        List<String> studentList
) {
}

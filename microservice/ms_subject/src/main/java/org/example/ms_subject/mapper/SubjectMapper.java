package org.example.ms_subject.mapper;

import org.example.ms_subject.dto.SubjectRequestDto;
import org.example.ms_subject.dto.SubjectResponseDto;
import org.example.ms_subject.entity.Subject;

import java.util.List;

public class SubjectMapper {

    public static SubjectResponseDto toSubjectResponseDto (Subject subject){
        return new SubjectResponseDto(subject.getId(), subject.getName());
    }

    public static Subject toSubject (SubjectRequestDto subjectRequestDto){
        return new Subject(subjectRequestDto.name());
    }

    public static List<SubjectResponseDto> toSubjectResponseDtosList(List<Subject> subjectList){
        return subjectList.stream()
                .map(SubjectMapper::toSubjectResponseDto)
                .toList();
    }
}

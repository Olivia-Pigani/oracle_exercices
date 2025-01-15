package org.example.ms_subject.service;

import org.example.ms_subject.dto.SubjectRequestDto;
import org.example.ms_subject.dto.SubjectResponseDto;
import org.example.ms_subject.entity.Subject;
import org.example.ms_subject.mapper.SubjectMapper;
import org.example.ms_subject.repository.SubjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectService {

    private SubjectRepository subjectRepository;

    public SubjectService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    public void saveSubject(SubjectRequestDto subjectRequestDto) {
        Optional<Subject> subjectOpt = subjectRepository.findSubjectByName(subjectRequestDto.name());

        if (subjectOpt.isPresent()) {
            Subject subject = SubjectMapper.toSubject(subjectRequestDto);
            subjectRepository.save(subject);
        }
    }

    public List<SubjectResponseDto> getAllSubjects() {
        List<Subject> subjectList = subjectRepository.findAll();
        return SubjectMapper.toSubjectResponseDtosList(subjectList);
    }
}

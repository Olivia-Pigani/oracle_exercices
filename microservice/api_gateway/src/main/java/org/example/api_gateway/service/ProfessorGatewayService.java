package org.example.api_gateway.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.io.SegmentedStringWriter;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.api_gateway.dto.ProfessorRequestDto;
import org.example.api_gateway.dto.ProfessorResponseDto;
import org.example.api_gateway.util.RestClient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorGatewayService {

    private static final String PROFESSOR_API = "http://localhost:8086/professor";

    private static final ObjectMapper objectMapper = new ObjectMapper();


    public List<ProfessorResponseDto> getAllProfessors() {

        RestClient<ProfessorResponseDto[]> professorRestClient = new RestClient<>(PROFESSOR_API);

        ProfessorResponseDto[] professorsArray = professorRestClient.getRequest(ProfessorResponseDto[].class);

        List<ProfessorResponseDto> professorList = List.of(professorsArray);
        return professorList;

    }

    public ProfessorResponseDto getProfessorById(long id) {

        RestClient<ProfessorResponseDto> professorRestClient = new RestClient<>(PROFESSOR_API + "/" + id);

        ProfessorResponseDto professor = professorRestClient.getRequest(ProfessorResponseDto.class);

        return professor;
    }
}

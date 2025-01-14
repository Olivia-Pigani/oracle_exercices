package org.example.api_gateway.service;

import org.example.api_gateway.dto.ProfessorResponseDto;
import org.example.api_gateway.util.RestClient;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class GateWayService {

    private static final String PROFESSOR_API = "http://localhost:8086/professor";


    public List<ProfessorResponseDto> getAllProfessors() {

        RestClient<ProfessorResponseDto[]> professorRestClient = new RestClient<>(PROFESSOR_API);

        ProfessorResponseDto[] professorsArray = professorRestClient.getRequest(ProfessorResponseDto[].class);

        List<ProfessorResponseDto> professorList = List.of(professorsArray);
        return professorList;

    }
}

package org.example.api_gateway.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.example.api_gateway.dto.ProfessorRequestDto;
import org.example.api_gateway.dto.ProfessorResponseDto;
import org.example.api_gateway.service.ProfessorGatewayService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/professor")
public class ProfessorGatewayController {

    private ProfessorGatewayService gateWayService;

    public ProfessorGatewayController(ProfessorGatewayService gateWayService) {
        this.gateWayService = gateWayService;
    }

    @GetMapping()
    public ResponseEntity<List<ProfessorResponseDto>> getAllProfessors() {
        return new ResponseEntity<>(gateWayService.getAllProfessors(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfessorResponseDto> getProfessorById(@PathVariable("id") long id){
        return new ResponseEntity<>(gateWayService.getProfessorById(id), HttpStatus.OK);
    }
}

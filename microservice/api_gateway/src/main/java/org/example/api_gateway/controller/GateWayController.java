package org.example.api_gateway.controller;

import org.example.api_gateway.dto.ProfessorResponseDto;
import org.example.api_gateway.service.GateWayService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class GateWayController {

    private GateWayService gateWayService;

    public GateWayController(GateWayService gateWayService) {
        this.gateWayService = gateWayService;
    }

    @GetMapping("/professor")
    public ResponseEntity<List<ProfessorResponseDto>> getAllProfessors(){
        return new ResponseEntity<>(gateWayService.getAllProfessors(), HttpStatus.OK);
    }


}

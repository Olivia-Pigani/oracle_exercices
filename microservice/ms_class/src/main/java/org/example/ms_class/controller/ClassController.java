package org.example.ms_class.controller;

import org.example.ms_class.dto.SchoolClassRequestDto;
import org.example.ms_class.dto.SchoolClassResponseDto;
import org.example.ms_class.entity.SchoolClass;
import org.example.ms_class.service.SchoolClassService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/class")
public class ClassController {

    private final SchoolClassService schoolClassService;

    public ClassController(SchoolClassService schoolClassService) {
        this.schoolClassService = schoolClassService;
    }

    @PostMapping
    public ResponseEntity<String> createClass(@RequestBody SchoolClassRequestDto schoolClassRequestDto) {
        return new ResponseEntity<>(schoolClassService.saveAClass(schoolClassRequestDto),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getClassDetailsById(@PathVariable("id") long id){
        return new ResponseEntity<>(schoolClassService.getClassDetailsById(id),HttpStatus.OK);
    }


}

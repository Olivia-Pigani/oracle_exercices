package org.example.exercice3;

import org.example.exercice3.dto.ErrorContinueRequestDto;
import org.example.exercice3.dto.ErrorResumeRequestDto;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import java.util.List;

@RestController
@RequestMapping("api")
public class ErrorHandlingController {

    private final ErrorHandlingService errorHandlingService;

    public ErrorHandlingController(ErrorHandlingService errorHandlingService) {
        this.errorHandlingService = errorHandlingService;
    }

    @PostMapping("error-resume")
    public Flux<String> getErrorResume(@RequestBody ErrorResumeRequestDto error){
        return errorHandlingService.getErrorResume(error);
    }

    @PostMapping("error-continue")
    public Flux<Integer> getErrorContinue(@RequestBody ErrorContinueRequestDto error){
        return errorHandlingService.getErrorContinue(error);
    }
}

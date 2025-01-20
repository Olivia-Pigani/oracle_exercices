package org.example.exercice3;

import org.example.exercice3.dto.ErrorContinueRequestDto;
import org.example.exercice3.dto.ErrorResumeRequestDto;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.Objects;

@Service
public class ErrorHandlingService {

    public Flux<String> getErrorResume(ErrorResumeRequestDto errorResumeRequestDto) {
        return Flux.fromIterable(errorResumeRequestDto.stringList())
                .map(value -> {
                    if (Objects.equals(value, errorResumeRequestDto.error())) {
                        throw new RuntimeException("error");
                    }
                    return value;
                })
                .onErrorResume(e -> Flux.just("Default 1 ", "Default 2"));

    }

    public Flux<Integer> getErrorContinue(ErrorContinueRequestDto errorContinueRequestDto) {
        return Flux.range(1, errorContinueRequestDto.amountNb())
                .map(value -> {
                    if (value == errorContinueRequestDto.error()) {
                        throw new RuntimeException("error");
                    }
                    return value;
                })
                .onErrorContinue((e, value) -> {
                    System.err.println("Erreur avec : " + value + " -> : " + e.getMessage());
                });
    }
}

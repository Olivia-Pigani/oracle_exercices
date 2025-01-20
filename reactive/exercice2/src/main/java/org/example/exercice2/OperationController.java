package org.example.exercice2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("api")
public class OperationController {

    @GetMapping("processed-numbers")
    public Flux<String> getProcessedNumbers() {
        return Flux.range(1, 10)
                .filter(nb -> nb % 2 == 0)
                .map(evenNb -> "Processed " + evenNb + " : " + evenNb * 10);
    }
}

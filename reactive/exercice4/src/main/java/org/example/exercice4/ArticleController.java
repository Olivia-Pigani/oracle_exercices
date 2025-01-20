package org.example.exercice4;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/article")
public class ArticleController {

    private List<Article> articles = Arrays.asList(
            new Article("Introduction to Spring WebFlux"),
            new Article("Reactive Programming with Project Reactor"),
            new Article("Building APIs with Spring Boot")
    );

    @GetMapping
    public Flux<Article> getAllArticles(){
        return Flux.fromIterable(articles);
    }
}

package org.example.exercice5.configuration;

import org.example.exercice5.handler.TaskHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class TaskRouter {

    @Bean
    public RouterFunction<ServerResponse> taskRoute(TaskHandler taskHandler) {
        return route(GET("api/task"), taskHandler::getAllTasks)
                .andRoute(GET("api/task/{id}"), taskHandler::getTaskById)
                .andRoute(POST("api/task"), taskHandler::saveTask)
                .andRoute(PUT("api/task/{id}"), taskHandler::updateTask)
                .andRoute(DELETE("api/task/{id}"), taskHandler::deleteTask);
    }
}

package org.example.exercice5.handler;

import org.example.exercice5.pojo.Task;
import org.example.exercice5.service.TaskService;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.ServerResponse.*;

@Component
public class TaskHandler {

    private final TaskService taskService;

    public TaskHandler(TaskService taskService) {
        this.taskService = taskService;
    }

    public Mono<ServerResponse> getAllTasks(ServerRequest serverRequest) {
        return ok().body(taskService.getAllTasks(), Task.class);
    }

    public Mono<ServerResponse> getTaskById(ServerRequest serverRequest) {
        int id = Integer.parseInt(serverRequest.pathVariable("id"));
        return taskService.getTaskById(id)
                .flatMap(product -> ok().bodyValue(product))
                .switchIfEmpty(notFound().build());
    }

    public Mono<ServerResponse> saveTask(ServerRequest request) {
        return request.bodyToMono(Task.class)
                .flatMap(taskService::saveTask)
                .flatMap(product -> created(request.uri()).bodyValue(product));
    }

    public Mono<ServerResponse> updateTask(ServerRequest serverRequest) {
        int id = Integer.parseInt(serverRequest.pathVariable("id"));
        return serverRequest.bodyToMono(Task.class)
                .flatMap(updatedTask -> taskService.updateTask(id, updatedTask))
                .flatMap(t -> ok().bodyValue(t))
                .switchIfEmpty(notFound().build());
    }

    public Mono<ServerResponse> deleteTask(ServerRequest serverRequest) {
        int id = Integer.parseInt(serverRequest.pathVariable("id"));
        return taskService.deleteTask(id)
                .then(noContent().build())
                .switchIfEmpty(notFound().build());
    }


}

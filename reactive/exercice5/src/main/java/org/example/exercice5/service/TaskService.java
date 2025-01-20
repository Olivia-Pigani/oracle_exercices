package org.example.exercice5.service;

import org.example.exercice5.pojo.Task;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {

    private List<Task> taskList = new ArrayList<>();

    public TaskService(List<Task> taskList) {
        this.taskList.add(new Task("my task one", false));
        this.taskList.add(new Task("my task two", true));
    }

    public Flux<Task> getAllTasks() {
        return Flux.fromIterable(taskList);
    }

    public Mono<Task> getTaskById(int id) {
        return Mono.justOrEmpty(
                taskList.stream()
                        .filter(t -> t.getId() == id)
                        .findFirst()
        );
    }

    public Mono<Task> saveTask(Task newTask) {
        taskList.add(newTask);
        return Mono.just(newTask);
    }


    public Mono<Task> updateTask(int id, Task updatedTask) {
        return Mono.justOrEmpty(
                        taskList.stream()
                                .filter(t -> t.getId() == id)
                                .findFirst()
                )
                .switchIfEmpty(Mono.error(new RuntimeException("There is no such task in the database")))
                .map(existingTask -> {
                    existingTask.setDescription(updatedTask.getDescription());
                    existingTask.setCompleted(updatedTask.isCompleted());
                    return existingTask;
                });
    }

    public Mono<Task> deleteTask(int id) {
        return Mono.justOrEmpty(
                        taskList.stream()
                                .filter(t -> t.getId() == id)
                                .findFirst()
                )
                .switchIfEmpty(Mono.error(new RuntimeException("There is no such task in the database")))
                .doOnNext(taskList::remove);
    }
}

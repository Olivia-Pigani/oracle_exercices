package controller;

import entity.Project;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import service.ProjectService;

@RestController
@RequestMapping("api/v1/project")
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping
    public ResponseEntity<Flux<Project>> getAllProjects() {
        return new ResponseEntity<>(projectService.getAllProjects(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Mono<Project>> qsaveAProject(@RequestBody Project newProject) {
        return new ResponseEntity<>(projectService.saveAProject(newProject), HttpStatus.CREATED);
    }
}

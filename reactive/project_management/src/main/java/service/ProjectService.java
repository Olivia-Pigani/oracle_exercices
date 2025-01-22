package service;

import entity.Project;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import repository.ProjectRepository;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public Flux<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public Mono<Project> saveAProject(Project newProject) {
        return projectRepository.save(newProject);
    }
}

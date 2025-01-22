package repository;

import entity.Project;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ProjectRepository extends ReactiveCrudRepository<Project, Long> {
}

package org.example.ms_subject.repository;

import org.example.ms_subject.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SubjectRepository extends JpaRepository<Subject,Long> {

    Optional<Subject> findSubjectByName(String name);
}

package org.example.ms_class.repository;

import org.example.ms_class.entity.SchoolClass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolClassRepository extends JpaRepository<SchoolClass,Long> {
}

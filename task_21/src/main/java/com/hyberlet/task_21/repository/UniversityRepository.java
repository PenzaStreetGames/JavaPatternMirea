package com.hyberlet.task_21.repository;

import com.hyberlet.task_21.model.University;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface UniversityRepository extends JpaRepository<University, Long> {
    List<University> getUniversitiesByCreationDate(LocalDate creationDate);
    List<University> getUniversitiesByName(String name);
}

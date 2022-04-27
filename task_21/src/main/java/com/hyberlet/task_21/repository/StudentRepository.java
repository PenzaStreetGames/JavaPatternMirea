package com.hyberlet.task_21.repository;

import com.hyberlet.task_21.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findAllByFirstName(String firstName);
    List<Student> findAllByLastName(String lastName);
    List<Student> findAllByUniversityId(Long universityId);
}

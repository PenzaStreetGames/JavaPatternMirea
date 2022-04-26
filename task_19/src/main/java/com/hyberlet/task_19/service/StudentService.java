package com.hyberlet.task_19.service;

import com.hyberlet.task_19.model.Student;
import com.hyberlet.task_19.model.University;
import com.hyberlet.task_19.repository.StudentRepository;
import com.hyberlet.task_19.repository.UniversityRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class StudentService {
    @Autowired
    private final StudentRepository studentRepository;
    @Autowired
    private final UniversityRepository universityRepository;

    public List<Student> getStudents() {
        log.info("Request: find all students");
        return studentRepository.findAll();
    }

    public Student saveStudent(Student student) {
        log.info("Request: save student: {}", student);
        return studentRepository.save(student);
    }

    public void deleteStudentById(Long id) {
        log.info("Request: delete student by id {}", id);
        studentRepository.deleteById(id);
    }

    public University getUniversity(Long studentId) {
        Student student = studentRepository.getById(studentId);
        University university = universityRepository.getById(student.getUniversityId());
        log.info("Request: get university by student {}: {}", student.getId(), university.getId());
        return university;
    }

    public List<Student> getStudentsByFirstName (String firstName) {
        log.info("Request: get students by first name {}", firstName);
        return studentRepository.findAllByFirstName(firstName);
    }

    public List<Student> getStudentsByLastName (String lastName) {
        log.info("Request: get studetns by last name {}", lastName);
        return studentRepository.findAllByLastName(lastName);
    }

    public List<Student> getStudentsByUniversityId (Long universityId) {
        log.info("Request: get students by university id {}", universityId);
        return studentRepository.findAllByUniversityId(universityId);
    }
}

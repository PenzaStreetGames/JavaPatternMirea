package com.hyberlet.task_20.service;

import com.hyberlet.task_20.model.Student;
import com.hyberlet.task_20.model.University;
import com.hyberlet.task_20.repository.StudentRepository;
import com.hyberlet.task_20.repository.UniversityRepository;
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
        return studentRepository.findAll();
    }

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public void deleteStudentById(Long id) {
        studentRepository.deleteById(id);
    }

    public University getUniversity(Long studentId) {
        Student student = studentRepository.getById(studentId);
        University university = universityRepository.getById(student.getUniversityId());
        return university;
    }

    public List<Student> getStudentsByFirstName (String firstName) {
        return studentRepository.findAllByFirstName(firstName);
    }

    public List<Student> getStudentsByLastName (String lastName) {
        return studentRepository.findAllByLastName(lastName);
    }

    public List<Student> getStudentsByUniversityId (Long universityId) {
        return studentRepository.findAllByUniversityId(universityId);
    }
}

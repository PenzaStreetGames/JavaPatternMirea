package com.hyberlet.task_24.service;

import com.hyberlet.task_24.annotations.Mailable;
import com.hyberlet.task_24.model.Student;
import com.hyberlet.task_24.model.University;
import com.hyberlet.task_24.repository.StudentRepository;
import com.hyberlet.task_24.repository.UniversityRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class StudentService {
    @Autowired
    private final StudentRepository studentRepository;
    @Autowired
    private final UniversityRepository universityRepository;

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    @Mailable
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

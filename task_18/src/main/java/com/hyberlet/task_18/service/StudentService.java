package com.hyberlet.task_18.service;

import com.hyberlet.task_18.model.Student;
import com.hyberlet.task_18.model.University;
import com.hyberlet.task_18.repository.StudentRepository;
import com.hyberlet.task_18.repository.UniversityRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    @Autowired
    private final StudentRepository studentRepository;
    @Autowired
    private final UniversityRepository universityRepository;
//    @Autowired
//    private final SessionFactory sessionFactory;
//    private Session session;

//    @PostConstruct
//    void init() {
//        session = sessionFactory.openSession();
//    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public void saveStudent(Student student) {
        studentRepository.save(student);
    }

    public void deleteStudentById(Long id) {
        studentRepository.deleteById(id);
    }

    public University getUniversity(Long studentId) {
        Student student = studentRepository.getById(studentId);
        University university = universityRepository.getById(student.getUniversityId());
        System.out.println(university);
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

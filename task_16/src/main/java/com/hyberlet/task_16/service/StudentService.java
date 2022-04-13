package com.hyberlet.task_16.service;

import com.hyberlet.task_16.model.Student;
import com.hyberlet.task_16.model.University;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
@Component
@Repository
@RequiredArgsConstructor
@Transactional
public class StudentService {
    @Autowired
    private final SessionFactory sessionFactory;
    private Session session;

    @PostConstruct
    void init() {
        session = sessionFactory.openSession();
    }

    public List<Student> getStudents() {
        return session.createQuery("select s from Student s", Student.class).getResultList();
    }

    public void saveStudent(Student student) {
        var transaction = session.beginTransaction();
        session.saveOrUpdate(student);
        transaction.commit();
    }

    public void deleteStudentById(Long id) {
        var transaction = session.beginTransaction();
        session.createQuery("delete from Student s where s.id = :id")
                .setParameter("id", id).executeUpdate();
        transaction.commit();
    }

    public University getUniversity(Long studentId) {
        var transaction = session.beginTransaction();
        University university = session.createQuery("select s from Student s where s.id = :id", Student.class)
                .setParameter("id", studentId).getSingleResult().getUniversity();
        transaction.commit();
        return university;
    }
}

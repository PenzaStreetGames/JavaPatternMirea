package com.hyberlet.task_17.service;

import com.hyberlet.task_17.model.Student;
import com.hyberlet.task_17.model.University;
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
@Component
@Repository
@RequiredArgsConstructor
@Transactional
public class StudentService {
    @Autowired
    private final SessionFactory sessionFactory;
    private Session session;

    @Autowired
    UniversityService universityService;

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
        Student student = session.createQuery("select s from Student s where s.id = :id", Student.class)
                .setParameter("id", studentId).getSingleResult();
        University university = universityService.getUniversityById(student.getUniversityId());
        transaction.commit();
        return university;
    }

    public <T> List<Student> getStudentsBy (String attribute, T value) {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Student> studentCriteriaQuery = builder.createQuery(Student.class);
        Root<Student> root = studentCriteriaQuery.from(Student.class);

        studentCriteriaQuery.select(root).where(builder.equal(root.get(attribute), value));
        Query<Student> query = session.createQuery(studentCriteriaQuery);
        return query.getResultList();
    }
}

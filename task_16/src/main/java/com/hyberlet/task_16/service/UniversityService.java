package com.hyberlet.task_16.service;

import com.hyberlet.task_16.model.University;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
@RequiredArgsConstructor
public class UniversityService {

    private final SessionFactory sessionFactory;
    private Session session;

    @PostConstruct
    void init() {
        session = sessionFactory.openSession();
    }

    public List<University> getUniversities() {
        var transaction = session.beginTransaction();
        List<University> universities = session.createQuery("select u from University u", University.class).getResultList();
        transaction.commit();
        return universities;
    }

    public University getUniversityById(Long universityId) {
        var transaction = session.beginTransaction();
        University university = session.createQuery("select u from University u where u.id = :id", University.class)
                        .setParameter("id", universityId).getSingleResult();
        transaction.commit();
        return university;
    }

    public void saveUniversity(University university) {
        var transaction = session.beginTransaction();
        session.saveOrUpdate(university);
        transaction.commit();
    }

    public void deleteUniversityById(Long id) {
        var transaction = session.beginTransaction();
        session.createQuery("delete from University u where u.id = :id")
                .setParameter("id", id).executeUpdate();
        transaction.commit();
    }

}

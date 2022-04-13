package com.hyberlet.task_15.service;

import com.hyberlet.task_15.model.University;
import com.hyberlet.task_15.model.User;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
@Repository
@RequiredArgsConstructor
public class UniversityService {

    private final SessionFactory sessionFactory;
    private Session session;

    @PostConstruct
    void init() {
        session = sessionFactory.openSession();
    }

    public List<University> getUniversities() {
        return session.createQuery("select u from University u", University.class).getResultList();
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

package com.hyberlet.task_17.service;

import com.hyberlet.task_17.model.Student;
import com.hyberlet.task_17.model.University;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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

    public <T> List<University> getUniversitiesBy (String attribute, T value) {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<University> universityCriteriaQuery = builder.createQuery(University.class);
        Root<University> root = universityCriteriaQuery.from(University.class);

        universityCriteriaQuery.select(root).where(builder.equal(root.get(attribute), value));
        Query<University> query = session.createQuery(universityCriteriaQuery);
        return query.getResultList();
    }

}

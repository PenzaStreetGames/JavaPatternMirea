package com.hyberlet.task_18.service;

import com.hyberlet.task_18.model.University;
import com.hyberlet.task_18.repository.UniversityRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.time.LocalDate;
import java.util.List;

@Component
@RequiredArgsConstructor
public class UniversityService {

//    private final SessionFactory sessionFactory;
//    private Session session;
//
//    @PostConstruct
//    void init() {
//        session = sessionFactory.openSession();
//    }

    @Autowired
    private final UniversityRepository universityRepository;

    public List<University> getUniversities() {
        return universityRepository.findAll();
    }

    public University getUniversityById(Long universityId) {
        return universityRepository.getById(universityId);
    }

    public University saveUniversity(University university) {
        return universityRepository.save(university);
    }

    public void deleteUniversityById(Long id) {
        universityRepository.deleteById(id);
    }

    public List<University> getUniversitiesByName(String name) {
        return universityRepository.getUniversitiesByName(name);
    }

    public List<University> getUniversitiesByCreationDate(LocalDate creationDate) {
        return universityRepository.getUniversitiesByCreationDate(creationDate);
    }

}

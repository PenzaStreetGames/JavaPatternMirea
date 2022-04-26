package com.hyberlet.task_19.service;

import com.hyberlet.task_19.model.University;
import com.hyberlet.task_19.repository.UniversityRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class UniversityService {

    @Autowired
    private final UniversityRepository universityRepository;

    public List<University> getUniversities() {
        log.info("Request: find all universities");
        return universityRepository.findAll();
    }

    public University getUniversityById(Long universityId) {
        log.info("Request: get university by id {}", universityId);
        return universityRepository.getById(universityId);
    }

    public University saveUniversity(University university) {
        log.info("Request: save university: {}", university);
        return universityRepository.save(university);
    }
    public void deleteUniversityById(Long id) {
        log.info("Request: delete university by id {}", id);
        universityRepository.deleteById(id);
    }

    public List<University> getUniversitiesByName(String name) {
        log.info("Request: get universities by name {}", name);
        return universityRepository.getUniversitiesByName(name);
    }

    public List<University> getUniversitiesByCreationDate(LocalDate creationDate) {
        log.info("Request: get universities by creation date {}", creationDate);
        return universityRepository.getUniversitiesByCreationDate(creationDate);
    }

}

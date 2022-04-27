package com.hyberlet.task_21.service;

import com.hyberlet.task_21.annotations.Mailable;
import com.hyberlet.task_21.model.University;
import com.hyberlet.task_21.repository.UniversityRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
@Transactional
public class UniversityService {

    @Autowired
    private final UniversityRepository universityRepository;

    public List<University> getUniversities() {
        return universityRepository.findAll();
    }

    public University getUniversityById(Long universityId) {
        return universityRepository.getById(universityId);
    }

    @Mailable
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

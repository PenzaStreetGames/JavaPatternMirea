package com.hyberlet.task_17.controller;

import com.hyberlet.task_17.model.University;
import com.hyberlet.task_17.service.UniversityService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class UniversityController {

    @Data
    static class DeleteQueryBody {
        long id;
    }

    @Autowired
    private UniversityService universityService;

    @GetMapping("/universities")
    public List<University> getAll() {
        return universityService.getUniversities();
    }

    @PostMapping("/universities")
    public boolean create(@RequestBody University university) {
        universityService.saveUniversity(university);
        return true;
    }

    @DeleteMapping("/universities")
    public boolean delete(@RequestBody StudentController.DeleteQueryBody body) {
        universityService.deleteUniversityById(body.getId());
        return true;
    }

    @GetMapping("/universities/name/{name}")
    public List<University> getUniversitiesByName(@PathVariable String name) {
        return universityService.getUniversitiesBy("name", name);
    }

    @GetMapping("/universities/creation_date/{creationDate}")
    public List<University> getUniversityByName(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate creationDate) {
        return universityService.getUniversitiesBy("creationDate", creationDate);
    }
}

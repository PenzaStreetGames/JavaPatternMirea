package com.hyberlet.task_16.controller;

import com.hyberlet.task_16.model.University;
import com.hyberlet.task_16.service.UniversityService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

}

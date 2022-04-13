package com.hyberlet.task_15.controller;

import com.hyberlet.task_15.model.University;
import com.hyberlet.task_15.model.User;
import com.hyberlet.task_15.service.UniversityService;
import com.hyberlet.task_15.service.UserService;
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
    public boolean delete(@RequestBody UserController.DeleteQueryBody body) {
        universityService.deleteUniversityById(body.getId());
        return true;
    }

}

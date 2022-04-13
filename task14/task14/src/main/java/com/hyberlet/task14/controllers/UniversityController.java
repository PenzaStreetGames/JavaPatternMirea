package com.hyberlet.task14.controllers;

import com.hyberlet.task14.entities.University;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;

@Controller
public class UniversityController {
    public ArrayList<University> universities = new ArrayList<>();

    @GetMapping(value="/universities_list")
    @ResponseBody
    public University[] universityList() {
        return universities.toArray(new University[0]);
    }

    @RequestMapping(value = "/add_university/{name}/{creationDate}", method = RequestMethod.GET)
    @ResponseBody
    public University addUniversity(@PathVariable String name, @PathVariable LocalDate creationDate) {
        University university = new University(name, creationDate);
        universities.add(university);
        return university;
    }

    @RequestMapping(value = "/delete_university/{name}/{creationDate}", method = RequestMethod.GET)
    @ResponseBody
    public University deleteStudent(@PathVariable String name, @PathVariable LocalDate creationDate) {
        University university = new University(name, creationDate);
        if (universities.remove(university))
            return university;
        return null;
    }
}

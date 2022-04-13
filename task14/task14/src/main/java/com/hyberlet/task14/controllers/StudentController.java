package com.hyberlet.task14.controllers;

import com.hyberlet.task14.entities.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class StudentController {

    public ArrayList<Student> students = new ArrayList<>();

    @GetMapping(value="/student_list")
    public Student[] studentList() {
        return students.toArray(new Student[0]);
    }

    @RequestMapping(value = "/add_student/{firstName}/{middleName}/{lastName}", method = RequestMethod.GET)
    public Student addStudent(@RequestBody Student student) {
        students.add(student);
        return student;
    }

    @RequestMapping(value = "/delete_student/{firstName}/{middleName}/{lastName}", method = RequestMethod.GET)
    public Student deleteStudent(@PathVariable String firstName,
                                 @PathVariable String middleName, @PathVariable String lastName) {
        Student student = new Student(firstName, middleName, lastName);
        if (students.remove(student))
            return student;
        return null;
    }
}

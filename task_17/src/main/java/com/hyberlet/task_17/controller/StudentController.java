package com.hyberlet.task_17.controller;

import com.hyberlet.task_17.model.Student;
import com.hyberlet.task_17.model.University;
import com.hyberlet.task_17.service.StudentService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Data
    static class DeleteQueryBody {
        private Long id;
    }

    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public List<Student> getAll() {
        return studentService.getStudents();
    }

    @PostMapping("/students")
    public boolean create(@RequestBody Student student) {
        System.out.println(student.getFirstName() + " " + student.getLastName());
        studentService.saveStudent(student);
        return true;
    }

    @DeleteMapping("/students")
    public boolean delete(@RequestBody DeleteQueryBody body) {
        System.out.println(body.getId());
        studentService.deleteStudentById(body.getId());
        return true;
    }

    @GetMapping("/students/{studentId}/university")
    public University getUniversityByStudentId(@PathVariable Long studentId) {
        return studentService.getUniversity(studentId);
    }

    @GetMapping("/students/first_name/{firstName}")
    public List<Student> getStudentsByFirstName(@PathVariable String firstName) {
        return studentService.getStudentsBy("firstName", firstName);
    }

    @GetMapping("/students/last_name/{lastName}")
    public List<Student> getStudentsByLastName(@PathVariable String lastName) {
        return studentService.getStudentsBy("lastName", lastName);
    }

    @GetMapping("/students/university_id/{universityId}")
    public List<Student> getStudentsByLastName(@PathVariable Long universityId) {
        return studentService.getStudentsBy("universityId", universityId);
    }
}

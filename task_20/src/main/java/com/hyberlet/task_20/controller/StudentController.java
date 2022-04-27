package com.hyberlet.task_20.controller;

import com.hyberlet.task_20.model.Student;
import com.hyberlet.task_20.model.dto.UniversityDto;
import com.hyberlet.task_20.service.StudentService;
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
    public Student create(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    @DeleteMapping("/students")
    public boolean delete(@RequestBody DeleteQueryBody body) {
        studentService.deleteStudentById(body.getId());
        return true;
    }

    @GetMapping("/students/{studentId}/university")
    public UniversityDto getUniversityByStudentId(@PathVariable Long studentId) {
        return studentService.getUniversity(studentId).getDto();
    }

    @GetMapping("/students/first_name/{firstName}")
    public List<Student> getStudentsByFirstName(@PathVariable String firstName) {
        return studentService.getStudentsByFirstName(firstName);
    }

    @GetMapping("/students/last_name/{lastName}")
    public List<Student> getStudentsByLastName(@PathVariable String lastName) {
        return studentService.getStudentsByLastName(lastName);
    }

    @GetMapping("/students/university_id/{universityId}")
    public List<Student> getStudentsByLastName(@PathVariable Long universityId) {
        return studentService.getStudentsByUniversityId(universityId);
    }
}

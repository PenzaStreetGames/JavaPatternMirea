package com.hyberlet.task_24.service;

import com.hyberlet.task_24.model.Student;
import com.hyberlet.task_24.repository.StudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTests {

    @Mock
    private MailService mailService;
    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentService studentService;

    @Test
    public void createStudent() {
        Student student = new Student();
        student.setFirstName("Aboba");
        student.setLastName("Abobov");
        Mockito.when(studentRepository.findAllByFirstName(student.getFirstName()))
                .thenReturn(List.of(student));

        Student aboba = new Student();
        aboba.setFirstName("Aboba");
        aboba.setLastName("Abobov");
        studentService.saveStudent(aboba);
        Mockito.verify(studentRepository).save(aboba);
        Student isAboba = studentService.getStudentsByFirstName("Aboba").get(0);
        Mockito.verify(studentRepository).findAllByFirstName("Aboba");
        Assertions.assertEquals(aboba.getFirstName(), isAboba.getFirstName());
        Assertions.assertEquals(aboba.getLastName(), isAboba.getLastName());
    }

    @Test
    public void getAllStudents() {
        Student student = new Student();
        student.setFirstName("Aboba");
        student.setLastName("Abobov");
        Student student1 = new Student();
        student1.setFirstName("Pavel");
        student1.setLastName("Solomatin");
        Mockito.when(studentRepository.findAll())
                .thenReturn(List.of(student, student1));

        List<Student> students = studentService.getStudents();
        Mockito.verify(studentRepository).findAll();
        Assertions.assertEquals(2, students.size());
        Assertions.assertEquals(List.of(student, student1), students);
    }

}

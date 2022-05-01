package com.hyberlet.task_24.service;

import com.hyberlet.task_24.model.Student;
import com.hyberlet.task_24.model.University;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.File;
import java.io.FileWriter;
import java.time.LocalDate;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class SchedulerServiceTests {

    @Mock
    private StudentService studentService;
    @Mock
    private UniversityService universityService;
    @Mock
    private FileWriter fileWriter;
    @Mock
    private File file;
    @InjectMocks
    private SchedulerService schedulerService;


    @Test
    public void doBackup() {
        Student student = new Student();
        student.setFirstName("Aboba");
        student.setLastName("Abobov");
        Student student1 = new Student();
        student1.setFirstName("Pavel");
        student1.setLastName("Solomatin");
        Mockito.when(studentService.getStudents())
                .thenReturn(List.of(student, student1));

        University university = new University();
        university.setName("mirea");
        university.setCreationDate(LocalDate.parse("1947-05-28"));
        University university1 = new University();
        university1.setName("pgu");
        university1.setCreationDate(LocalDate.parse("1943-07-03"));
        Mockito.when(universityService.getUniversities())
                .thenReturn(List.of(university.getDto(), university1.getDto()));

        schedulerService.BACKUP_DIR = "src/test/resources/backups";

//        Mockito.when(file.delete()).thenReturn(true);

        schedulerService.doBackup();
        Mockito.verify(studentService).getStudents();
        Mockito.verify(universityService).getUniversities();
//        Mockito.verify(file).delete();
    }

}

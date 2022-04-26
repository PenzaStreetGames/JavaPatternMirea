package com.hyberlet.task_18.model.dto;

import com.hyberlet.task_18.model.Student;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
public class UniversityDto {
    private Long id;
    private String name;
    private LocalDate creationDate;
    private List<StudentDto> students;
}

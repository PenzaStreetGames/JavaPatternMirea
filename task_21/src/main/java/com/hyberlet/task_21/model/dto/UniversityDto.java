package com.hyberlet.task_21.model.dto;

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

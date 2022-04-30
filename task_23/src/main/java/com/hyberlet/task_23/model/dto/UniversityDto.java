package com.hyberlet.task_23.model.dto;

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

    @Override
    public String toString() {
        return "UniversityDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", creationDate=" + creationDate +
                ", students=" + students +
                '}';
    }
}

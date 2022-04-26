package com.hyberlet.task_19.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StudentDto {
    private String firstName;
    private String lastName;
    private Long universityId;
}

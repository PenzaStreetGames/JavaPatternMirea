package com.hyberlet.task_24.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StudentDto {
    private Long id;
    private String firstName;
    private String lastName;
    private Long universityId;

    @Override
    public String toString() {
        return "StudentDto{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", universityId=" + universityId +
                '}';
    }
}

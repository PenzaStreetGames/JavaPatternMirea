package com.hyberlet.task14.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Student {
    private String firstName;
    private String middleName;
    private String lastName;

    @Override
    public String toString() {
        return firstName + ' ' + middleName + ' ' + lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(getFirstName(), student.getFirstName()) && Objects.equals(getMiddleName(), student.getMiddleName()) && Objects.equals(getLastName(), student.getLastName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getMiddleName(), getLastName());
    }
}

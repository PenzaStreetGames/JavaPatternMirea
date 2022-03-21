package com.hyberlet.task14.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

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
}

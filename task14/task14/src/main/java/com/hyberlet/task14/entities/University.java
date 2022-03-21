package com.hyberlet.task14.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class University {
    private String name;
    private LocalDate creationDate;

    @Override
    public String toString() {
        return name + " est. " + creationDate.toString();
    }
}

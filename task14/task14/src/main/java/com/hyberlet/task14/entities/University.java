package com.hyberlet.task14.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        University that = (University) o;
        return Objects.equals(getName(), that.getName()) && Objects.equals(getCreationDate(), that.getCreationDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getCreationDate());
    }
}

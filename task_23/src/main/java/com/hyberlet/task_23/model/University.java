package com.hyberlet.task_23.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hyberlet.task_23.model.dto.StudentDto;
import com.hyberlet.task_23.model.dto.UniversityDto;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Table(name = "university")
@Entity
public class University {
    @Id
    @SequenceGenerator(name = "university_sequence", sequenceName = "university_sequence", allocationSize = 1)
    @GeneratedValue(generator = "university_sequence", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "creation_date")
    private LocalDate creationDate;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "university")
    private List<Student> students = new ArrayList<>();

    @Override
    public String toString() {
        return getDto().toString();
    }

    @JsonIgnore
    public UniversityDto getDto() {
        List<StudentDto> studentDtos = students.stream().map(Student::getDto).toList();
        return new UniversityDto(id, name, creationDate, studentDtos);
    }
}

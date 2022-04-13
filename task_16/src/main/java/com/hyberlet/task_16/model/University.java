package com.hyberlet.task_16.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
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
    private List<Student> students;
}

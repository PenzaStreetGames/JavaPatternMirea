package com.hyberlet.task_16.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;

@Data
@Table(name = "student")
@Entity
public class Student {
    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "students_sequence", sequenceName = "students_sequence", allocationSize = 1)
    @GeneratedValue(generator = "students_sequence", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "university_id")
    @JsonIgnore
    private University university;

    @Column(name = "university_id")
    private Long universityId;
}

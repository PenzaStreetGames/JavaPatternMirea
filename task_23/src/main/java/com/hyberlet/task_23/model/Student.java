package com.hyberlet.task_23.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hyberlet.task_23.model.dto.StudentDto;
import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "student")
@Entity
public class Student {
    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "student_sequence", sequenceName = "student_sequence", allocationSize = 1)
    @GeneratedValue(generator = "student_sequence", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "university_id", insertable = false, updatable = false)
    @JsonIgnore
    private University university;

    @Column(name = "university_id")
    private Long universityId;

    @Override
    public String toString() {
        return getDto().toString();
    }

    @JsonIgnore
    public StudentDto getDto() {
        return new StudentDto(id, firstName, lastName, universityId);
    }

}

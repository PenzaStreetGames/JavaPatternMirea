package com.hyberlet.study_1.model;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name = "user", schema = "public")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String login;
    private String password;
}

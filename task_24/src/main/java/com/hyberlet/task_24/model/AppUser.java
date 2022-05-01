package com.hyberlet.task_24.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "app_user")
@Entity
public class AppUser {
    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "app_user_sequence", sequenceName = "app_user_sequence", allocationSize = 1)
    @GeneratedValue(generator = "app_user_sequence", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Override
    public String toString() {
        return "AppUser{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

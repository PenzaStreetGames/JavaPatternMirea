package com.penzastreetstudios.task2;

import java.time.LocalDate;

public class Human {
    public int age;
    public String firstName;
    public String lastName;
    public LocalDate birthDate;
    public int weight;

    public Human() {
    }

    public Human(int age, String firstName, String lastName, LocalDate birthDate, int weight) {
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.weight = weight;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " " + birthDate + " (" + age + ") " +
                "вес: " + weight + " кг";
    }
}

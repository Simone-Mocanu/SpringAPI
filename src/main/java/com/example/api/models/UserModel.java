package com.example.api.models;

import jakarta.persistence.*;

@Entity @Table(name="Users")
public class UserModel {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String surname;

    protected UserModel() {}

    public UserModel(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    @Override
    public String toString() {
        return String.format(
                "User[id=%d, name='%s', surname='%s']",
                id, name, surname);
    }

    public long getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public String getSurname()
    {
        return surname;
    }
}
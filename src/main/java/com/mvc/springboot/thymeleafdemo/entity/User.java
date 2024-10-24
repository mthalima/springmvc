package com.mvc.springboot.thymeleafdemo.entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
public class User {

    @Id
    @GeneratedValue
    private UUID id;

    private String name;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String username;

    private String password;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> roles;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Habit> habits;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Habit> getHabits() {
        return habits;
    }

    public void setHabits(List<Habit> habits) {
        this.habits = habits;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
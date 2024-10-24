package com.mvc.springboot.thymeleafdemo.dto;

import java.time.LocalDate;
import java.util.UUID;

public class HabitDTO {

    private UUID id;
    private String name;
    private String description;
    private LocalDate startDate;

    // Getters e Setters

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }
}
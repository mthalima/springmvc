package com.mvc.springboot.thymeleafdemo.entity;


import jakarta.persistence.*;


import java.util.UUID;

@Entity
public class Habit {

    @Id
    @GeneratedValue
    private UUID habitId;

    private String habitName;

    private String habitDescription;

    private boolean habitStatus;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    // Getters e Setters

    public String getHabitDescription() {
        return habitDescription;
    }

    public void setHabitDescription(String habitDescription) {
        this.habitDescription = habitDescription;
    }

    public UUID getHabitId() {
        return habitId;
    }

    public void setHabitId(UUID habitId) {
        this.habitId = habitId;
    }

    public String getHabitName() {
        return habitName;
    }

    public void setHabitName(String habitName) {
        this.habitName = habitName;
    }

    public boolean isHabitStatus() {
        return habitStatus;
    }

    public void setHabitStatus(boolean habitStatus) {
        this.habitStatus = habitStatus;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

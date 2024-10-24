package com.mvc.springboot.thymeleafdemo.repository;

import com.mvc.springboot.thymeleafdemo.entity.Habit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface HabitRepository extends JpaRepository<Habit, UUID> {

    List<Habit> findByUserId(UUID userId);

}

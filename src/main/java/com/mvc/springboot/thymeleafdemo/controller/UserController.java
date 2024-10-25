package com.mvc.springboot.thymeleafdemo.controller;

import com.mvc.springboot.thymeleafdemo.dto.HabitDTO;
import com.mvc.springboot.thymeleafdemo.service.HabitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private HabitService habitService;

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<HabitDTO>> getHabitsByUserId(@PathVariable UUID userId) {
        return ResponseEntity.ok(habitService.getHabitsByUserId(userId));
    }

    // Outros endpoints (criar, atualizar, deletar hábitos)
}

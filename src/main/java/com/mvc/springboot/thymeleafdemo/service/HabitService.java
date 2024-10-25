package com.mvc.springboot.thymeleafdemo.service;

import com.mvc.springboot.thymeleafdemo.dto.HabitDTO;
import com.mvc.springboot.thymeleafdemo.entity.Habit;
import com.mvc.springboot.thymeleafdemo.entity.User;
import com.mvc.springboot.thymeleafdemo.repository.HabitRepository;
import com.mvc.springboot.thymeleafdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class HabitService {

    @Autowired
    private HabitRepository habitRepository;

    @Autowired
    private UserRepository userRepository;

    // Método para criar um novo hábito
    public HabitDTO createHabit(UUID userId, HabitDTO habitDTO) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Habit habit = new Habit();
        habit.setName(habitDTO.getName());
        habit.setDescription(habitDTO.getDescription());
        habit.setStartDate(habitDTO.getStartDate());
        habit.setFrequency(Habit.Frequency.valueOf(habitDTO.getFrequency().toUpperCase()));
        habit.setUser(user);

        habitRepository.save(habit);
        habitDTO.setId(habit.getId());

        return habitDTO;
    }

    // Método para buscar todos os hábitos de um usuário
    public List<HabitDTO> getHabitsByUserId(UUID userId) {
        List<Habit> habits = habitRepository.findByUserId(userId);
        return habits.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Método para buscar um hábito específico pelo ID
    public HabitDTO getHabitById(UUID habitId) {
        Habit habit = habitRepository.findById(habitId)
                .orElseThrow(() -> new RuntimeException("Habit not found"));

        return convertToDTO(habit);
    }

    // Método para atualizar um hábito
    public HabitDTO updateHabit(UUID habitId, HabitDTO habitDTO) {
        Habit habit = habitRepository.findById(habitId)
                .orElseThrow(() -> new RuntimeException("Habit not found"));

        habit.setName(habitDTO.getName());
        habit.setDescription(habitDTO.getDescription());
        habit.setStartDate(habitDTO.getStartDate());
        habit.setFrequency(Habit.Frequency.valueOf(habitDTO.getFrequency().toUpperCase()));

        habitRepository.save(habit);

        return convertToDTO(habit);
    }

    // Método para deletar um hábito
    public void deleteHabit(UUID habitId) {
        habitRepository.deleteById(habitId);
    }

    // Método utilitário para converter uma entidade Habit em HabitDTO
    private HabitDTO convertToDTO(Habit habit) {
        HabitDTO dto = new HabitDTO();
        dto.setId(habit.getId());
        dto.setName(habit.getName());
        dto.setDescription(habit.getDescription());
        dto.setStartDate(habit.getStartDate());
        dto.setFrequency(habit.getFrequency().toString());

        return dto;
    }
}
package com.mvc.springboot.thymeleafdemo.service;

import com.mvc.springboot.thymeleafdemo.dto.UserDTO;
import com.mvc.springboot.thymeleafdemo.entity.User;
import com.mvc.springboot.thymeleafdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserDTO createUser(UserDTO userDTO){
        User user = new User();
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setUsername(userDTO.getUsername());

        userRepository.save(user);
        userDTO.setId(user.getId());
        return userDTO;
    }

    public List<UserDTO> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(user -> new UserDTO())
                .collect(Collectors.toList());
    }

    public UserDTO getUserById(UUID id) {
        return userRepository.findById(id)
                .map(user -> new UserDTO())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado!"));
    }

    public void deleteUser(UUID id) {
        userRepository.deleteById(id);
    }
}

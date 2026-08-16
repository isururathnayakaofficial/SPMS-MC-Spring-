package lk.sritechcomputers.userservice.service.impl;


import lk.sritechcomputers.userservice.dto.UserDTO;
import lk.sritechcomputers.userservice.repository.UserRepository;
import org.jspecify.annotations.Nullable;
//import org.springframework.security.core.userdetails.User;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import lk.sritechcomputers.userservice.entity.User;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class UserService implements lk.sritechcomputers.userservice.service.UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void createUser(UserDTO userDTO) {

        User user = new User();
        user.setName(userDTO.getName());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        user.setEmail(userDTO.getEmail());

        User savedUser = userRepository.save(user);

        if (savedUser != null) {
            System.out.println(savedUser.toString());
        }

    }

    @Override
    public void updateUser(Long userId, Long user) {
        User users = userRepository.findById(Long.valueOf(String.valueOf(userId)))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "user not found"));

        users.setName(users.getName());
        users.setPassword(passwordEncoder.encode(users.getPassword()));
        users.setEmail(users.getEmail());
        userRepository.save(users);
    }



    @Override
    public void deleteUser(String username) {

    }

    @Override
    public org.springframework.security.core.userdetails.User getUser(String username) {
        return null;
    }

    @Override
    public @Nullable List<org.springframework.security.core.userdetails.User> getAllUsers() {
        return List.of();
    }

    @Override
    public org.springframework.security.core.userdetails.@Nullable User getUserById(Long userId) {
        return null;
    }
}
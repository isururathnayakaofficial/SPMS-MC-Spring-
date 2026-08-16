package lk.sritechcomputers.userservice.service.impl;


import lk.sritechcomputers.userservice.dto.UserDTO;
import lk.sritechcomputers.userservice.repository.UserRepository;
import org.jspecify.annotations.Nullable;
//import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import lk.sritechcomputers.userservice.entity.User;

import java.util.List;

@Service
public class UserService implements lk.sritechcomputers.userservice.service.UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void createUser(UserDTO userDTO) {

        User user = new User();
        user.setName(userDTO.getName());
        user.setPassword(userDTO.getPassword());
        user.setEmail(userDTO.getEmail());
        admin.

    }

    @Override
    public void updateUser(Long userId, org.springframework.security.core.userdetails.User user) {

    }



    @Override
    public void deleteUser(String username) {

    }

    @Override
    public org.springframework.security.core.userdetails.User getUser(String username) {
        return null;
    }

    @Override
    public @Nullable List<User> getAllUsers() {
        return List.of();
    }

    @Override
    public @Nullable User getUserById(Long userId) {
        return null;
    }
}
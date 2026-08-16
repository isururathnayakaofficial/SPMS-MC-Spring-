package lk.sritechcomputers.userservice.service.impl;


import lk.sritechcomputers.userservice.repository.UserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

@Service
public class UserService implements lk.sritechcomputers.userservice.service.UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User user) {

        return user;
    }

    @Override
    public void updateUser(Long userId, User user) {

    }

    @Override
    public void deleteUser(String username) {

    }

    @Override
    public org.springframework.security.core.userdetails.User getUser(String username) {
        return null;
    }
}
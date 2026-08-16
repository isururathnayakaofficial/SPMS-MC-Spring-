package lk.sritechcomputers.userservice.service;

import org.jspecify.annotations.Nullable;
import org.springframework.security.core.userdetails.User;

import java.util.List;

public interface UserService {
    User createUser(User user);
    void updateUser(Long userId, User user);
    void deleteUser(String username);
    User getUser(String username);

    @Nullable List<User> getAllUsers();

    @Nullable User getUserById(Long userId);
}

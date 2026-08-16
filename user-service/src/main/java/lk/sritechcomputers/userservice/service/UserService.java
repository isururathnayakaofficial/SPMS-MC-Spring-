package lk.sritechcomputers.userservice.service;

import lk.sritechcomputers.userservice.dto.UserDTO;
import org.jspecify.annotations.Nullable;
import org.springframework.security.core.userdetails.User;

import java.util.List;

public interface UserService {
    void createUser(UserDTO user);
    void updateUser(Long userId);
    void deleteUser(Long userId);
    List<UserDTO> getAllUsers();


}

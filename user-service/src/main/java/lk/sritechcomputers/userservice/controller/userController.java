package lk.sritechcomputers.userservice.controller;

import jakarta.ws.rs.POST;
import lk.sritechcomputers.userservice.dto.UserDTO;
import lk.sritechcomputers.userservice.repository.UserRepository;
import lk.sritechcomputers.userservice.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class userController {

    private final UserService userService;
    private final UserRepository userRepository;

    public userController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }
    @POST
    public  void createUser(@RequestBody UserDTO userdto) {
       userService.createUser(userdto);
    }
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    // Get User by ID
    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable Long userId) {
        return ResponseEntity.ok(userService.getUserById(userId));
    }

    // Update User
    @PutMapping("/{userId}")
    public ResponseEntity<?> updateUser(Long userdto, @PathVariable Long userId) {
     userService.updateUser(userdto,userId);
     return ResponseEntity.ok().build();
    }


    // Delete User
    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId) {
        userService.deleteUser(String.valueOf(userId));
        return ResponseEntity.noContent().build();
    }
}

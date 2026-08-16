package lk.sritechcomputers.userservice.repository;

import lk.sritechcomputers.userservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
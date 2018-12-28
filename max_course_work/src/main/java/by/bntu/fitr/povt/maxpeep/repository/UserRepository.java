package by.bntu.fitr.povt.maxpeep.repository;

import by.bntu.fitr.povt.maxpeep.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}

package co.cstad.pringsecurity.repository;

import co.cstad.pringsecurity.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    boolean existsByEmail(String email);



}

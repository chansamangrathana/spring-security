package co.cstad.pringsecurity.repository;

import co.cstad.pringsecurity.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, String > {
    Optional<Role> findByName(String name);
}

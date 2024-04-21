package co.cstad.pringsecurity.repository;

import co.cstad.pringsecurity.model.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthorityRepository extends JpaRepository<Authority, String > {
    Optional<Authority> findByName(String name);
}

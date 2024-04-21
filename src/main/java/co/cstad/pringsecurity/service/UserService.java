package co.cstad.pringsecurity.service;

import co.cstad.pringsecurity.model.dto.UserRequest;
import co.cstad.pringsecurity.model.dto.UserResponse;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService {
    UserResponse createUser(UserRequest userRequest);
}

package co.cstad.pringsecurity.service;

import co.cstad.pringsecurity.Mapper.UserMapper;
import co.cstad.pringsecurity.model.Role;
import co.cstad.pringsecurity.model.User;
import co.cstad.pringsecurity.model.dto.UserRequest;
import co.cstad.pringsecurity.model.dto.UserResponse;
import co.cstad.pringsecurity.repository.RoleRepository;
import co.cstad.pringsecurity.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserMapper userMapper;
    private final RoleRepository repository;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Override
    public UserResponse createUser(UserRequest userRequest) {
        //  email address
        if (userRepository.existsByEmail(userRequest.email())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email already exists");
        }

        Set<Role> roles = new HashSet<>();
        //  roles
        userRequest.roles().forEach(
                r -> {
                    var roleObject = roleRepository
                            .findByName(r)
                            .orElseThrow(() -> new ResponseStatusException(
                                    HttpStatus.BAD_REQUEST,
                                    "Role " + r + "not found"
                            ));
                    roles.add(roleObject);
                }
        );

        User newUser = userMapper.toUser(userRequest, roles);
        newUser.setPassword(new BCryptPasswordEncoder().encode(userRequest.password()));
        userRepository.save(newUser);
        return userMapper.toUserResponse(newUser);

    }
}


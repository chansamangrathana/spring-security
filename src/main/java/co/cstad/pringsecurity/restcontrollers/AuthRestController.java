package co.cstad.pringsecurity.restcontrollers;

import co.cstad.pringsecurity.model.dto.UserRequest;
import co.cstad.pringsecurity.service.UserService;
import co.cstad.pringsecurity.utils.BaseResponse;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthRestController {
    private final UserService userService;


    @PostMapping("/register")
    public BaseResponse<Object> createNewUser(@RequestBody UserRequest userRequest) {
        return BaseResponse.createSuccess()
                .setPayload(userService.createUser(userRequest));
    }
}

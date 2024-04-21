package co.cstad.pringsecurity.restcontrollers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class AuthRestController {
    @GetMapping("/login")
    public String login() {
        return "login successful";
    }

    @GetMapping("/sign-up")
    public String signUp() {
        return "signUp successful";
    }
}

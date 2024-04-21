package co.cstad.pringsecurity.restcontrollers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;



@RestController("api/v1/admins")
public class AdminRestController {
    @GetMapping
    public String getAdmins() {
        return "all user";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable int id) {
        return "Delete the user with id " + id + " successfully!";
    }

    }

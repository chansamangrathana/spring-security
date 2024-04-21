package co.cstad.pringsecurity.model.dto;

import java.util.Set;

public record UserRequest (String email,
                           String password,
                           Set<String> roles
){

}

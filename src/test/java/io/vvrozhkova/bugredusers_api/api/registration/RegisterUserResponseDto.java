package io.vvrozhkova.bugredusers_api.api.registration;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class RegisterUserResponseDto {
    private String email;
    private String name;
    private String password;
}

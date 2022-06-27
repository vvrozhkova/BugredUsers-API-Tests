package io.vvrozhkova.bugredusers_api.api.users;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateUserResponseDto {
    private String name;
    private String email;
}

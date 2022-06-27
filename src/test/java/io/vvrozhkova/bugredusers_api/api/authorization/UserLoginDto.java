package io.vvrozhkova.bugredusers_api.api.authorization;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserLoginDto {
    private String email;
    private String password;
}

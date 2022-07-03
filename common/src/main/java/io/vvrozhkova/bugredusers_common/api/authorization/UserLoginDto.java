package io.vvrozhkova.bugredusers_common.api.authorization;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserLoginDto {
    private String email;
    private String password;
}

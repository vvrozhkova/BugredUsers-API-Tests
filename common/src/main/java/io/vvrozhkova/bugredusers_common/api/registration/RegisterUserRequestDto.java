package io.vvrozhkova.bugredusers_common.api.registration;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterUserRequestDto {
    private String email;
    private String name;
    private String password;
}

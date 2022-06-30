package io.vvrozhkova.bugredusers_api.api.users;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor @AllArgsConstructor
public class CreateUserRequestDto {

    private String name;
    private String email;
    private String password;
    private int[] companies;
    private int[] tasks;

}

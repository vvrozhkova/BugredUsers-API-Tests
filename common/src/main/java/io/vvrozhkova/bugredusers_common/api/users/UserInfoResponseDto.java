package io.vvrozhkova.bugredusers_common.api.users;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserInfoResponseDto {

    private String name;
    private String email;
}

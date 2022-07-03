package io.vvrozhkova.bugredusers_common.api.users;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserWithTasksRequestDto {

    private String name;
    private String email;
    private String password;
    private List<TaskInfoDto> tasks;

}

package io.vvrozhkova.bugredusers_common.api.users;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TaskInfoDto {

    private String title;
    private String description;
}

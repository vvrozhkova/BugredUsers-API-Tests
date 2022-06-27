package io.vvrozhkova.bugredusers_api.api.tasks;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateTaskRequestDto {
    @JsonProperty("task_title")
    private String title;
    @JsonProperty("task_description")
    private String description;
    @JsonProperty("email_owner")
    private String owner;
    @JsonProperty("email_assign")
    private String email;
}

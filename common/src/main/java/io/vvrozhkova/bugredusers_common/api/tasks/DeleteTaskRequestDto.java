package io.vvrozhkova.bugredusers_common.api.tasks;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeleteTaskRequestDto {

    @JsonProperty("task_id")
    private String id;
    @JsonProperty("email_owner")
    private String owner;
}

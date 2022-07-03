package io.vvrozhkova.bugredusers_common.api.tasks;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateTaskResponseDto {
    @JsonProperty("id_task")
    private String id;
    private String message;
}

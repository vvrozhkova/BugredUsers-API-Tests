package io.vvrozhkova.bugredusers_api.api.tasks;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpdateTaskResponseDto {
    private String message;
}

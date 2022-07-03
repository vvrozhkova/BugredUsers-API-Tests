package io.vvrozhkova.bugredusers_common.helpers.youtrack;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class YoutrackUpdateStatusRequestDto {

    private StatusInfo event;

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class StatusInfo {
        private String presentation;
        private String id;
        @JsonProperty("$type")
        private String type;
    }
}

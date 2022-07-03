package io.vvrozhkova.bugredusers_common.helpers.youtrack;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class YoutrackLinksResponseDto {

    private YoutrackIssueInfoDto[] issues;
    @JsonProperty("$type")
    private String type;
}

package io.vvrozhkova.bugredusers_api.helpers.youtrack;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class YoutrackIssueInfoDto {
    private String summary;
    @JsonProperty("idReadable")
    private String youtrackId;
    private String id;
    @JsonProperty("$type")
    private String type;

}

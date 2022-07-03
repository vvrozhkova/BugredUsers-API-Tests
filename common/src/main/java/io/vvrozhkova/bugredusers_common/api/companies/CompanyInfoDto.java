package io.vvrozhkova.bugredusers_common.api.companies;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class CompanyInfoDto {

    private String name;
    private String type;
    @JsonProperty("users")
    private String[] emails;
}

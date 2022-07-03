package io.vvrozhkova.bugredusers_common.api.companies;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class CompanyResponseDto {

    @JsonProperty("id_company")
    private String id;
    private String name;
    private String type;
}

package io.vvrozhkova.bugredusers_common.api.companies;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateCompanyResponseDto {
    @JsonProperty("id_company")
    private String id;
    private CompanyInfoDto company;
}

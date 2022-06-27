package io.vvrozhkova.bugredusers_api.api.companies;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateCompanyRequestDto {

    @JsonProperty("company_name")
    private String name;
    @JsonProperty("company_type")
    private String type;
    @JsonProperty("company_users")
    private String[] emails;
    @JsonProperty("email_owner")
    private String owner;
}

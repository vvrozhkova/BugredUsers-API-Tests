package io.vvrozhkova.bugredusers_common.api.companies;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CompanyRequestDto {
    @JsonProperty("id_company")
    private String id;
}

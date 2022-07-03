package io.vvrozhkova.bugredusers_api.tests.companies;

import io.vvrozhkova.bugredusers_api.tests.BaseTest;
import io.vvrozhkova.bugredusers_common.api.companies.*;
import io.vvrozhkova.bugredusers_common.config.App;
import org.junit.jupiter.api.Test;

import static io.vvrozhkova.bugredusers_common.helpers.Assertions.checkValueIsEqualTo;
import static org.junit.jupiter.api.Assertions.assertAll;

public class CompanyTests extends BaseTest {

    CreateCompanyRequestDto company = CreateCompanyRequestDto.builder()
            .name(faker.company().name())
            .type(CompanyType.OAO.getType())
            .owner(App.config.userEmail())
            .emails(new String[]{App.config.userEmail()})
            .build();

    @Test
    void createCompanyTest() {
        CreateCompanyResponseDto companyInfo = companiesApi.createCompany(company);
        assertAll(
                () -> checkValueIsEqualTo("name",
                        companyInfo.getCompany().getName(), company.getName()),
                () -> checkValueIsEqualTo("type",
                        companyInfo.getCompany().getType(), company.getType()),
                () -> checkValueIsEqualTo("user emails",
                        companyInfo.getCompany().getEmails(), company.getEmails())
        );
    }

    @Test
    void getCompanyTest() {
        CreateCompanyResponseDto companyToSearch = companiesApi.createCompany(company);

        CompanyRequestDto company = CompanyRequestDto.builder()
                .id(companyToSearch.getId())
                .build();
        CompanyResponseDto companyInfo = companiesApi.getCompany(company);

        assertAll(
                () -> checkValueIsEqualTo("name",
                        companyToSearch.getCompany().getName(), companyInfo.getName()),
                () -> checkValueIsEqualTo("type",
                        companyToSearch.getCompany().getType(), companyInfo.getType())
        );
    }


}

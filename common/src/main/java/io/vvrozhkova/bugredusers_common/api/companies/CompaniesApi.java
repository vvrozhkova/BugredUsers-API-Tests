package io.vvrozhkova.bugredusers_common.api.companies;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import io.vvrozhkova.bugredusers_common.api.BaseApi;
import io.vvrozhkova.bugredusers_common.api.endpoint.CompanyEndPoint;

public class CompaniesApi  extends BaseApi {

    @Step("get info for company with id = '{company.id}'")
    public CompanyResponseDto getCompany(CompanyRequestDto company){
        ExtractableResponse<Response> response = RestAssured.given().spec(defaultRequestSpec)
                .body(company)
                .when()
                .post(CompanyEndPoint.GET_COMPANY)
                .then()
                .statusCode(200).extract();
        checkResponseError(response);
        return response.as(CompanyResponseDto.class);
    }

    @Step("create company '{company.name}'")
    public CreateCompanyResponseDto createCompany(CreateCompanyRequestDto company){
        ExtractableResponse<Response> response = RestAssured.given().spec(defaultRequestSpec)
                .body(company)
                .when()
                .post(CompanyEndPoint.CREATE)
                .then()
                .statusCode(200).extract();
        checkResponseError(response);
        return response.as(CreateCompanyResponseDto.class);
    }


}

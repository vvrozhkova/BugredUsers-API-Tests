package io.vvrozhkova.bugredusers_api.api.companies;

import io.qameta.allure.Step;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import io.vvrozhkova.bugredusers_api.api.BaseApi;
import io.vvrozhkova.bugredusers_api.api.endpoint.CompanyEndPoint;

import static io.restassured.RestAssured.given;

public class CompaniesApi  extends BaseApi {

    @Step("get info for company with id = '{company.id}'")
    public CompanyResponseDto getCompany(CompanyRequestDto company){
        ExtractableResponse<Response> response = given().spec(defaultRequestSpec)
                .body(company)
                .when()
                .post(CompanyEndPoint.GET_COMPANY)
                .then()
                .statusCode(200).extract();
        checkResponseError(response);
        System.out.println(response.asString());
        return response.as(CompanyResponseDto.class);
    }

    @Step("create company '{company.name}'")
    public CreateCompanyResponseDto createCompany(CreateCompanyRequestDto company){
        ExtractableResponse<Response> response = given().spec(defaultRequestSpec)
                .body(company)
                .when()
                .post(CompanyEndPoint.CREATE)
                .then()
                .statusCode(200).extract();
        checkResponseError(response);
        System.out.println(response.asString());
        return response.as(CreateCompanyResponseDto.class);
    }


}

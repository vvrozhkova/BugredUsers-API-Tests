package io.vvrozhkova.bugredusers_common.api.registration;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import io.vvrozhkova.bugredusers_common.api.BaseApi;
import io.vvrozhkova.bugredusers_common.api.endpoint.AuthorizationEndPoint;

public class RegistrationApi extends BaseApi {

    @Step("register user '{regUser.name}'")
    public RegisterUserResponseDto registerUser(RegisterUserRequestDto regUser) {
        ExtractableResponse<Response> response = RestAssured.given().spec(defaultRequestSpec)
                .body(regUser)
                .when()
                .post(AuthorizationEndPoint.DO_REGISTER)
                .then()
                .statusCode(200)
                .extract();
        System.out.println(response.asString());
        return response.as(RegisterUserResponseDto.class);
    }
}

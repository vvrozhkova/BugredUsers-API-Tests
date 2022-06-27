package io.vvrozhkova.bugredusers_api.api.registration;

import io.qameta.allure.Step;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import io.vvrozhkova.bugredusers_api.api.BaseApi;
import io.vvrozhkova.bugredusers_api.api.endpoint.AuthorizationEndPoint;

import static io.restassured.RestAssured.given;

public class RegistrationApi extends BaseApi {

    @Step("register user '{regUser.name}'")
    public RegisterUserResponseDto registerUser(RegisterUserRequestDto regUser) {
        ExtractableResponse<Response> response = given().spec(defaultRequestSpec)
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

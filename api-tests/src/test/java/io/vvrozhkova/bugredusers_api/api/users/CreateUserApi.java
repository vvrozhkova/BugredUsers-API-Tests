package io.vvrozhkova.bugredusers_api.api.users;

import io.qameta.allure.Step;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import io.vvrozhkova.bugredusers_api.api.BaseApi;
import io.vvrozhkova.bugredusers_api.api.endpoint.UserEndPoint;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.not;

public class CreateUserApi extends BaseApi {

    @Step
    public CreateUserResponseDto createUser(CreateUserRequestDto user) {
        ExtractableResponse<Response> response = given().spec(defaultRequestSpec)
                .body(user)
                .when()
                .post(UserEndPoint.CREATE)
                .then()
                .statusCode(200)
                .extract();

        checkResponseError(response);
        return response.as(CreateUserResponseDto.class);
    }
}

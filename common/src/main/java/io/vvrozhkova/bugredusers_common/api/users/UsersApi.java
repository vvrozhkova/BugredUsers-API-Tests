package io.vvrozhkova.bugredusers_common.api.users;

import com.sun.tools.javac.util.List;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import io.vvrozhkova.bugredusers_common.api.BaseApi;
import io.vvrozhkova.bugredusers_common.api.endpoint.UserEndPoint;

public class UsersApi extends BaseApi {

    @Step
    public CreateUserResponseDto createUser(CreateUserRequestDto user) {
        ExtractableResponse<Response> response = RestAssured.given().spec(defaultRequestSpec)
                .body(user)
                .when()
                .post(UserEndPoint.CREATE)
                .then()
                .statusCode(200)
                .extract();

        checkResponseError(response);
        return response.as(CreateUserResponseDto.class);
    }
    @Step
    public CreateUserWithTasksResponseDto createUserWithTasks(CreateUserWithTasksRequestDto user) {
        ExtractableResponse<Response> response = RestAssured.given().spec(defaultRequestSpec)
                .body(user)
                .when()
                .post(UserEndPoint.CREATE_USER_WITH_TASKS)
                .then()
                .statusCode(200)
                .extract();

        checkResponseError(response);
        return response.as(CreateUserWithTasksResponseDto.class);
    }
    public CreateUserWithTasksRequestDto prepareUserWithTasksRq(String name, String email) {
        return CreateUserWithTasksRequestDto.builder()
                .name(name)
                .email(email)
                .tasks(List.of(
                        TaskInfoDto.builder()
                                .title("Task")
                                .description("Description of task")
                                .build()
                ))
                .build();
    }

    public CreateUserWithTasksResponseDto createUserWithTasks(String name, String email) {
        CreateUserWithTasksRequestDto user = prepareUserWithTasksRq(name, email);
        return createUserWithTasks(user);
    }

    @Step
    public ExtractableResponse<Response> deleteUser(DeleteUserRequestDto user){
        return RestAssured.given().spec(defaultRequestSpec)
                .body(user)
                .when()
                .post(UserEndPoint.DELETE)
                .then()
                .statusCode(200)
                .extract();
    }
    public ExtractableResponse<Response> deleteUser(String name, String email) {
        DeleteUserRequestDto userToDelete = DeleteUserRequestDto.builder()
                .name(name)
                .email(email)
                .build();

        return deleteUser(userToDelete);
    }

    public DeleteUserResponseDto checkDeleteUserResponse(ExtractableResponse<Response> response){
        System.out.println(response.asString());
        checkResponseError(response);
        return response.as(DeleteUserResponseDto.class);
    }

    public UserInfoResponseDto getUserFullInfo(UserInfoRequestDto user){
        ExtractableResponse<Response> response = RestAssured.given().spec(defaultRequestSpec)
                .body(user)
                .when()
                .post(UserEndPoint.GET_USER_FULL)
                .then()
                .statusCode(200)
                .extract();

        checkResponseError(response);
        return response.as(UserInfoResponseDto.class);
    }

    public UserInfoResponseDto getUserInfo(UserInfoRequestDto user){
        ExtractableResponse<Response> response = RestAssured.given().spec(defaultRequestSpec)
                .body(user)
                .when()
                .post(UserEndPoint.GET_USER)
                .then()
                .statusCode(200)
                .extract();

        checkResponseError(response);
        return response.as(UserInfoResponseDto.class);
    }

}

package io.vvrozhkova.bugredusers_common.api.tasks;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import io.vvrozhkova.bugredusers_common.api.BaseApi;
import io.vvrozhkova.bugredusers_common.api.endpoint.TaskEndPoint;

public class TasksApi extends BaseApi {

    @Step("create task '{task.title}'")
    public CreateTaskResponseDto createTask(CreateTaskRequestDto task){
        ExtractableResponse<Response> response = RestAssured.given().spec(defaultRequestSpec)
                .body(task)
                .when()
                .post(TaskEndPoint.CREATE)
                .then()
                .statusCode(200).extract();
        checkResponseError(response);
        return response.as(CreateTaskResponseDto.class);
    }

    @Step("delete task with id = '{task.id}'")
    public DeleteTaskResponseDto deleteTask(DeleteTaskRequestDto task){
        ExtractableResponse<Response> response = RestAssured.given().spec(defaultRequestSpec)
                .body(task)
                .when()
                .post(TaskEndPoint.DELETE)
                .then()
                .statusCode(200).extract();
        checkResponseError(response);
        return response.as(DeleteTaskResponseDto.class);
    }

    @Step("update task with id = '{task.id}'")
    public UpdateTaskResponseDto updateTask(UpdateTaskRequestDto task){
        ExtractableResponse<Response> response = RestAssured.given().spec(defaultRequestSpec)
                .body(task)
                .when()
                .post(TaskEndPoint.UPDATE)
                .then()
                .statusCode(200).extract();
        checkResponseError(response);
        return response.as(UpdateTaskResponseDto.class);
    }
}

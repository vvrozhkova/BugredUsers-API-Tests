package io.vvrozhkova.bugredusers_api.api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.vvrozhkova.bugredusers_api.api.authorization.AuthorizationApi;
import io.vvrozhkova.bugredusers_api.helpers.AllureRestAssuredFilter;

import static io.restassured.http.ContentType.JSON;

public class BaseApi {
    protected final static RequestSpecification defaultRequestSpec =
            new RequestSpecBuilder()
                    .addFilter(AllureRestAssuredFilter.withCustomTemplates())
                    .addCookies(AuthorizationApi.getAuthorizationCookie())
                    .setContentType(JSON)
                    .build();

    protected void checkResponseError(ExtractableResponse<Response> response){
        String responseType = response.jsonPath().getString("type");
        if (responseType.equalsIgnoreCase("error")) {
            throw new RuntimeException(response.jsonPath().getString("message"));
        }
    }
}

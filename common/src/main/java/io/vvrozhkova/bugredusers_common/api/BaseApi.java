package io.vvrozhkova.bugredusers_common.api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.vvrozhkova.bugredusers_common.api.authorization.AuthorizationApi;
import io.vvrozhkova.bugredusers_common.helpers.AllureRestAssuredFilter;

public class BaseApi {
    protected final static RequestSpecification defaultRequestSpec =
            new RequestSpecBuilder()
                    .addFilter(AllureRestAssuredFilter.withCustomTemplates())
                    .addCookies(AuthorizationApi.getAuthorizationCookie())
                    .setContentType(ContentType.JSON)
                    .build();

    protected void checkResponseError(ExtractableResponse<Response> response){
        System.out.println(response.asString());
        String responseType = response.jsonPath().getString("type");
        if ("error".equalsIgnoreCase(responseType)) {
            throw new RuntimeException(response.jsonPath().getString("message"));
        }
    }
}

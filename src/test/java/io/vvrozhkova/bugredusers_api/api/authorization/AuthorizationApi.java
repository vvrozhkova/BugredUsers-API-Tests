package io.vvrozhkova.bugredusers_api.api.authorization;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.http.Cookies;
import io.restassured.response.Response;
import io.vvrozhkova.bugredusers_api.config.App;
import io.vvrozhkova.bugredusers_api.helpers.AllureRestAssuredFilter;

import static io.restassured.RestAssured.given;
import static io.vvrozhkova.bugredusers_api.api.endpoint.AuthorizationEndPoint.DO_LOGIN;

public class AuthorizationApi {

    public static Cookies getAuthorizationCookie() {
        return doLoginAsDefaultUser().getDetailedCookies();
    }

    @Step
    public static Response doLoginAsDefaultUser() {
        return doLoginAs(App.config.userEmail(), App.config.userPassword());
    }

    public static Response doLoginAs(String email, String password) {
        return given()
                .filter(AllureRestAssuredFilter.withCustomTemplates())
                .contentType(ContentType.JSON)
                .formParam("login", email)
                .formParam("password", password)
                .when()
                .post(DO_LOGIN);
    }
}

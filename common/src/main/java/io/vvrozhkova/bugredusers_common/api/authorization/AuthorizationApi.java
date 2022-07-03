package io.vvrozhkova.bugredusers_common.api.authorization;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.http.Cookies;
import io.restassured.response.Response;
import io.vvrozhkova.bugredusers_common.config.App;
import io.vvrozhkova.bugredusers_common.helpers.AllureRestAssuredFilter;

import static io.restassured.RestAssured.given;
import static io.vvrozhkova.bugredusers_common.api.endpoint.AuthorizationEndPoint.DO_LOGIN;

public class AuthorizationApi {

    public static Cookies getAuthorizationCookie() {
        return doUiLoginAsDefaultUser().getDetailedCookies();
    }

    @Step
    public static Response doLoginAsDefaultUser() {
        return doLoginAs(App.config.userEmail(), App.config.userPassword());
    }

    public static Response doUiLoginAsDefaultUser() {
        return doUiLoginAs(App.config.userEmail(), App.config.userPassword());
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

    public static Response doUiLoginAs(String email, String password) {
        return given()
                .baseUri("http://users.bugred.ru")
                .contentType(ContentType.URLENC)
                .param("login", email)
                .param("password", password)
                .when()
                .post("/user/login/index.html");
    }


}

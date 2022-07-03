package io.vvrozhkova.bugredusers_ui.helpers;

import io.vvrozhkova.bugredusers_common.api.authorization.AuthorizationApi;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.Cookie;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class LoginExtension implements BeforeEachCallback {

    @Override
    public void beforeEach(ExtensionContext context) {
        io.restassured.http.Cookies appCookie = AuthorizationApi.getAuthorizationCookie();
        open("/");
        for (io.restassured.http.Cookie cookie : appCookie) {
            getWebDriver().manage().addCookie(new Cookie(cookie.getName(), cookie.getValue()));
        }
    }

}

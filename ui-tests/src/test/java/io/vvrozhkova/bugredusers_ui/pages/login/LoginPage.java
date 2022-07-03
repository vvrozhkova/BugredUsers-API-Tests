package io.vvrozhkova.bugredusers_ui.pages.login;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import io.vvrozhkova.bugredusers_ui.pages.common.PageWithNavbar;

import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byValue;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends PageWithNavbar {

    @Step("Open login page")
    public void open() {
        Selenide.open("/user/login/index.html");
    }

    @Step("Log in to account by email {email}")
    public void signIn(String email, String password) {
        $(byName("login")).setValue(email);
        $(byName("password")).setValue(password);
        $(byValue("Авторизоваться")).click();
    }


}

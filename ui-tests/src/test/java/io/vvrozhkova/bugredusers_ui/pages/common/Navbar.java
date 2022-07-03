package io.vvrozhkova.bugredusers_ui.pages.common;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class Navbar {

    private final SelenideElement signIn = $(byText("Войти"));

    private final SelenideElement userInfo = $("#fat-menu a");
    private final ElementsCollection userInfoItems = $$(".newlink");

    @Step("Verify user successful authorization as [{email}]")
    public void checkThatUserAuthorizedAs(String email) {
        userInfo.shouldHave(text(email));
        signIn.shouldNotBe(visible);
    }

    @Step("Sign out from account")
    public void signOut() {
        userInfo.click();
        $(byLinkText("Выход")).click();
    }

    @Step("Verify user successful sign out")
    public void checkThatUserSignOut() {
        signIn.shouldBe(visible);
    }

}
